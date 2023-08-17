package easy.mind.com.api.service;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.DTO.conversion.BeckDepressionToDTO;
import easy.mind.com.api.DTO.conversion.TestQuestionsToDto;
import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.exception.RateLimitExceededException;
import easy.mind.com.api.facade.TestsFacade;
import easy.mind.com.api.repository.TestsQuestionsRepository;
import easy.mind.com.api.service.Impl.TestsQuestionsServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestsQuestionsServiceImplTest {

    @Mock
    private TestsQuestionsRepository repository;

    @Mock
    private TestsFacade testsFacade;

    @InjectMocks
    private TestsQuestionsServiceImpl service;

    @Test
    public void create_successTestsQuestions() {
        //given
        TestsQuestionsDTO expectedTestsQuestionsDTO = createTestsQuestionsDTOForTesting();
        TestsQuestionsDTO expectedTestsQuestionsForReturnDTO = createTestsQuestionsDTOForTesting();
        Mockito.when(repository.save(TestQuestionsToDto.convert(expectedTestsQuestionsDTO))).thenReturn(TestQuestionsToDto.convert(expectedTestsQuestionsForReturnDTO));

        //when
        TestsQuestionsDTO actualTestsQuestions = service.create(expectedTestsQuestionsDTO);

        //then
        assertEquals(actualTestsQuestions, expectedTestsQuestionsForReturnDTO);
        verify(repository).save(TestQuestionsToDto.convert(expectedTestsQuestionsDTO));
    }

    @Test
    public void get_successTestsQuestionById() {
        //given
        Mockito.when(testsFacade.hasExceededRateLimit(1)).thenReturn(false);
        TestsQuestionsDTO expectedTestsQuestionsDTO = createTestsQuestionsDTOForTesting();
        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(TestQuestionsToDto.convert(expectedTestsQuestionsDTO)));

        //when
        TestsQuestionsDTO actualTestsQuestionsDTO = service.readById(1, 1);

        //then
        assertEquals(actualTestsQuestionsDTO, expectedTestsQuestionsDTO, "Test questions not exist");
        verify(testsFacade).hasExceededRateLimit(1);
        verify(repository).findById(1L);
    }

    @Test
    public void get_withWrongTimeLimit() {
        //given
        Mockito.when(testsFacade.hasExceededRateLimit(1)).thenThrow(new RateLimitExceededException("You can pass test only once a day"));

        //when
        RateLimitExceededException thrown = assertThrows(
                RateLimitExceededException.class,
                () -> service.readById(1, 1),
                "Expected findById() to throw, but it didn't"
        );
        // then
        assertTrue(thrown.getMessage().contains("You can pass test only once a day"));
        //then
        verify(testsFacade).hasExceededRateLimit(1);
        verify(repository, never()).findById(any());
    }

    @Test
    public void get_byNotExistedId() {
        //given
        Mockito.when(testsFacade.hasExceededRateLimit(1)).thenReturn(false);
        Mockito.when(repository.findById(1L)).thenThrow(new EntityNotFoundException("Questions with id 1 not found"));

        //when
        EntityNotFoundException thrown = assertThrows(
                EntityNotFoundException.class,
                () -> service.readById(1, 1),
                "Expected findById() to throw, but it didn't"
        );
        //then
        assertTrue(thrown.getMessage().contains("Questions with id 1 not found"));
        verify(testsFacade).hasExceededRateLimit(1);
    }

    @Test
    public void delete_successful() {
        //given
        TestsQuestionsDTO expectedTestsQuestionsDTO = createTestsQuestionsDTOForTesting();
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(TestQuestionsToDto.convert(expectedTestsQuestionsDTO)));

        // when
        service.delete(1, 1);

        // then
        verify(repository).findById(1L);
        verify(repository).delete(TestQuestionsToDto.convert(expectedTestsQuestionsDTO));

    }

    @Test
    public void delete_notExistingId() {
        //given
        when(repository.findById(1L)).thenThrow(new  EntityNotFoundException("Questions with id 1 not found"));

        //when
        EntityNotFoundException thrown = assertThrows(
                EntityNotFoundException.class,
                () -> service.delete(1, 1),
                "Expected delete() to throw, but it didn't"
        );

        //then
        assertTrue(thrown.getMessage().contains("Questions with id 1 not found"));
        verify(repository).findById(1L);
        verify(repository, never()).delete(any());
    }

    @Test
    public void getAll(){
        //given
        TestsQuestionsDTO expectedTestsQuestionsDTO = createTestsQuestionsDTOForTesting();
        when(repository.findAll()).thenReturn(List.of(TestQuestionsToDto.convert(expectedTestsQuestionsDTO)));

        //when
        List<TestsQuestionsDTO> actualListForReturn = service.getAll();

        //then
        assertEquals(actualListForReturn, List.of(expectedTestsQuestionsDTO));
        verify(repository).findAll();

    }

    public TestsQuestionsDTO createTestsQuestionsDTOForTesting(){
        TestsQuestionsDTO.Question questionForList = new TestsQuestionsDTO.Question(1, new HashMap<>());

        return  TestsQuestionsDTO.builder()
                .id(1)
                .name("testName")
                .language("UA")
                .questions(List.of(questionForList))
                .build();
    }
}

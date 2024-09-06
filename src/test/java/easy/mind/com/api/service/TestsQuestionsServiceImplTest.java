package easy.mind.com.api.service;

import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.entity.TestsQuestions.Question;
import easy.mind.com.api.repository.TestsQuestionsRepository;
import easy.mind.com.api.service.Impl.TestsQuestionsServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
    @InjectMocks
    private TestsQuestionsServiceImpl service;

    @Test
    public void create_successTestsQuestions() {
        //given
        TestsQuestions expectedTestsQuestions = createTestsQuestionsForTesting();
        TestsQuestions expectedTestsQuestionsForReturn = createTestsQuestionsForTesting();
        Mockito.when(repository.save(expectedTestsQuestions)).thenReturn(expectedTestsQuestionsForReturn);

        //when
        TestsQuestions actualTestsQuestions = service.create(expectedTestsQuestions);

        //then
        assertEquals(actualTestsQuestions, expectedTestsQuestionsForReturn);
        verify(repository).save(expectedTestsQuestions);
    }

    @Test
    public void get_successTestsQuestionById() {
        //given
        TestsQuestions expectedTestsQuestions = createTestsQuestionsForTesting();
        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(expectedTestsQuestions));

        //when
        TestsQuestions actualTestsQuestions = service.getById(1);

        //then
        assertEquals(actualTestsQuestions, expectedTestsQuestions, "Test questions not exist");
        verify(repository).findById(1L);
    }

    @Test
    public void get_byNotExistedId() {
        //given
        Mockito.when(repository.findById(1L)).thenThrow(new EntityNotFoundException("Questions with id 1 not found"));

        //when
        EntityNotFoundException thrown = assertThrows(
                EntityNotFoundException.class,
                () -> service.getById(1),
                "Expected findById() to throw, but it didn't"
        );
        //then
        assertTrue(thrown.getMessage().contains("Questions with id 1 not found"));
    }

    @Test
    public void delete_successful() {
        //given
        TestsQuestions expectedTestsQuestions = createTestsQuestionsForTesting();
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(expectedTestsQuestions));

        // when
        service.delete(1);

        // then
        verify(repository).findById(1L);
        verify(repository).delete(expectedTestsQuestions);

    }

    @Test
    public void delete_notExistingId() {
        //given
        when(repository.findById(1L)).thenThrow(new  EntityNotFoundException("Questions with id 1 not found"));

        //when
        EntityNotFoundException thrown = assertThrows(
                EntityNotFoundException.class,
                () -> service.delete(1),
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
        TestsQuestions expectedTestsQuestions = createTestsQuestionsForTesting();
        when(repository.findAll()).thenReturn(List.of(expectedTestsQuestions));

        //when
        List<TestsQuestions> actualListForReturn = service.getAll();

        //then
        assertEquals(actualListForReturn, List.of(expectedTestsQuestions));
        verify(repository).findAll();

    }

    public TestsQuestions createTestsQuestionsForTesting(){
        Question questionForList = new Question(1, "testName",new HashMap<>());

        return  TestsQuestions.builder()
                .id(1)
                .name("testName")
                .language("UA")
                .questions(List.of(questionForList))
                .build();
    }
}

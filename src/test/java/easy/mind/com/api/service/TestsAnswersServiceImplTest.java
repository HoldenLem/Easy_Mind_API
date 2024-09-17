package easy.mind.com.api.service;


import easy.mind.com.api.entity.TestsAnswers;
import easy.mind.com.api.repository.TestsAnswerRepository;
import easy.mind.com.api.service.Impl.TestsAnswersServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestsAnswersServiceImplTest {

    @Mock
    private TestsAnswerRepository repository;
    @InjectMocks
    private TestsAnswersServiceImpl service;

    @Test
    public void create_successTestsAnswers() {
        //given
        TestsAnswers expectedTestsAnswers = createTestsAnswersForTesting();
        TestsAnswers expectedTestsAnswersForReturn = createTestsAnswersForTesting();
        Mockito.when(repository.save(expectedTestsAnswers)).thenReturn(expectedTestsAnswersForReturn);

        //when
        TestsAnswers actualTestsAnswers = service.create(expectedTestsAnswers, 1, 1);

        //then
        assertEquals(actualTestsAnswers, expectedTestsAnswersForReturn);
        verify(repository).save(expectedTestsAnswers);
    }

    @Test
    public void get_successTestsAnswersByUserId() {
        //given
        TestsAnswers expectedTestsAnswers = createTestsAnswersForTesting();
        Mockito.when(repository.getByUserId(1)).thenReturn(List.of(expectedTestsAnswers));

        //when
       List<TestsAnswers> actualTestsAnswers = service.getByUserId(1);

        //then
        assertEquals(actualTestsAnswers, List.of(expectedTestsAnswers), "Test answers not exist");
        verify(repository).getByUserId(1);
    }

    @Test
    public void get_byNotExistedUserId() {
        //given
        Mockito.when(repository.getByUserId(1)).thenThrow(new EntityNotFoundException("The user with id " + 1 + " has not passed any test yet"));

        //when
        EntityNotFoundException thrown = assertThrows(
                EntityNotFoundException.class,
                () -> service.getByUserId(1),
                "Expected getByUserId() to throw, but it didn't"
        );
        //then
        assertTrue(thrown.getMessage().contains("The user with id " + 1 + " has not passed any test yet"));
    }

    @Test
    public void getAll(){
        //given
        TestsAnswers expectedTestsAnswers = createTestsAnswersForTesting();
        when(repository.findAll()).thenReturn(List.of(expectedTestsAnswers));

        //when
        List<TestsAnswers> actualListForReturn = service.getAll();

        //then
        assertEquals(actualListForReturn, List.of(expectedTestsAnswers));
        verify(repository).findAll();

    }

    public TestsAnswers createTestsAnswersForTesting(){
        TestsAnswers.Answers answersForList = new TestsAnswers.Answers(new HashMap<>());
        Instant instant = Instant.now();

        return  TestsAnswers.builder()
                .id(1)
                .createdAt(instant)
                .questionsId(1)
                .userId(1)
                .answer(List.of(answersForList))
                .build();
    }

}

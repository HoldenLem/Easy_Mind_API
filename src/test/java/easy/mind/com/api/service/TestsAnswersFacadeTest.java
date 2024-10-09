package easy.mind.com.api.service;


import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.DTO.mapper.TestsQuestionsMapper;
import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.facade.TestsQuestionsFacade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestsAnswersFacadeTest {

    @Mock
    private TestsQuestionsService service;

    @Mock
    private TestsQuestionsMapper mapper;

    @InjectMocks
    private TestsQuestionsFacade facade;


    @Test
    void create_success() {
        TestsQuestionsDTO expectedTestsQuestionsDTO = createTestsQuestionsDTOForTesting();
        TestsQuestions expectedTestsQuestionsForReturn = mapper.of(expectedTestsQuestionsDTO);
        Mockito.when(service.create(mapper.of(expectedTestsQuestionsDTO))).thenReturn(expectedTestsQuestionsForReturn);

        TestsQuestionsDTO actualTestsQuestions = facade.create(expectedTestsQuestionsDTO);

        assertEquals(actualTestsQuestions, expectedTestsQuestionsDTO);
        verify(service).create(expectedTestsQuestionsForReturn);
    }


    @Test
    void get_successTestsQuestionById() {
        TestsQuestions expectedTestsQuestions =mapper.of(createTestsQuestionsDTOForTesting());
        Mockito.when(service.getById(1L)).thenReturn(expectedTestsQuestions);

        TestsQuestionsDTO actualTestsQuestions = facade.getBy(1);

        assertEquals(actualTestsQuestions,mapper.of(expectedTestsQuestions) , "Test questions not exist");
        verify(service).getById(1L);
    }

    @Test
    public void delete_successful() {
        // when
        facade.delete(1);

        // then
        verify(service).delete(1);

    }

    @Test
    void getAll(){
        //given
        TestsQuestions expectedTestsQuestions = mapper.of(createTestsQuestionsDTOForTesting());
        when(service.getAll()).thenReturn(List.of(expectedTestsQuestions));

        //when
        List<TestsQuestionsDTO> actualListForReturn = facade.getAll();

        //then
        assertEquals(actualListForReturn, List.of((expectedTestsQuestions)));
        verify(service).getAll();

    }
    public TestsQuestionsDTO createTestsQuestionsDTOForTesting(){
        TestsQuestionsDTO.QuestionDTO questionForList = new TestsQuestionsDTO.QuestionDTO(1, "testName",new HashMap<>());

        return  TestsQuestionsDTO.builder()
                .id(1)
                .name("testName")
                .language("UA")
                .questions(List.of(questionForList))
                .build();
    }
}

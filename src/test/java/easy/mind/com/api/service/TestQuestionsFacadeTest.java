package easy.mind.com.api.service;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.facade.TestsQuestionsFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestQuestionsFacadeTest {
    
    @Mock
    private TestsQuestionsService service;
    
    @InjectMocks
    private TestsQuestionsFacade facade;

    @Autowired
    ModelMapper modelMapper;

    @Test
    public void create_successTestsQuestions() {
        //given
        TestsQuestionsDTO expectedTestsQuestionsDTO = createTestsQuestionsDTOForTesting();
        TestsQuestionsDTO expectedTestsQuestionsDTOForReturn = createTestsQuestionsDTOForTesting();
        when(service.create(modelMapper.map(expectedTestsQuestionsDTO, TestsQuestions.class)))
                .thenReturn(modelMapper.map(expectedTestsQuestionsDTOForReturn, TestsQuestions.class));

        //when
        TestsQuestionsDTO actualTestsQuestions = facade.create(expectedTestsQuestionsDTO);

        //then
        assertEquals(actualTestsQuestions, expectedTestsQuestionsDTOForReturn);
        verify(service).create(modelMapper.map(expectedTestsQuestionsDTO, TestsQuestions.class));
    }


    @Test
    public void get_successTestsQuestionById() {
        //given
        TestsQuestions expectedTestsQuestions = modelMapper.map(
                createTestsQuestionsDTOForTesting(),
                TestsQuestions.class);
        Mockito.when(service.getById(1L)).thenReturn(expectedTestsQuestions);

        //when
        TestsQuestionsDTO actualTestsQuestions = facade.getById(1);

        //then
        assertEquals(actualTestsQuestions, modelMapper.map(expectedTestsQuestions, TestsQuestionsDTO.class) , "Test questions not exist");
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
    public void getAll(){
        //given
        TestsQuestions expectedTestsQuestions = modelMapper.map(createTestsQuestionsDTOForTesting(), TestsQuestions.class);
        when(service.getAll()).thenReturn(List.of(expectedTestsQuestions));

        //when
        List<TestsQuestionsDTO> actualListForReturn = facade.getAll();

        //then
        assertEquals(actualListForReturn, List.of(modelMapper.map(expectedTestsQuestions, TestsQuestionsDTO.class)));
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

package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.entity.TestsQuestions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        Converter<TestsQuestionsDTO.QuestionDTO, TestsQuestions.Question> dtoToEntityConverter =
                context -> new TestsQuestions.Question(
                        context.getSource().order(),
                        context.getSource().description(),
                        context.getSource().answers()
                );
        modelMapper.typeMap(TestsQuestionsDTO.QuestionDTO.class, TestsQuestions.Question.class)
                .setConverter(dtoToEntityConverter);
        Converter<TestsQuestions.Question, TestsQuestionsDTO.QuestionDTO> entityToDtoConverter =
                context -> new TestsQuestionsDTO.QuestionDTO(
                        context.getSource().order(),
                        context.getSource().description(),
                        context.getSource().answers()
                );
        modelMapper.typeMap(TestsQuestions.Question.class, TestsQuestionsDTO.QuestionDTO.class)
                .setConverter(entityToDtoConverter);
        return modelMapper;
    }
}

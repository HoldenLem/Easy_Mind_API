package easy.mind.com.api.repository;

import easy.mind.com.api.entity.TestsAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestsAnswerRepository extends JpaRepository<TestsAnswers, Long> {

    List<TestsAnswers> getByUserId(int userId);
    List<TestsAnswers> getByTestsId(long testsId);
}

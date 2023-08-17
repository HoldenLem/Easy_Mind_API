package easy.mind.com.api.repository;

import easy.mind.com.api.entity.TestsQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsQuestionsRepository extends JpaRepository<TestsQuestions,Long> {
}

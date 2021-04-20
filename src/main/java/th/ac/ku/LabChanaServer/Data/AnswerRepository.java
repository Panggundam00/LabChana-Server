package th.ac.ku.LabChanaServer.Data;

import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.LabChanaServer.Models.Answer;
import th.ac.ku.LabChanaServer.Models.User;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
//    List<Answer> findByAnswerId(int answerId);
}
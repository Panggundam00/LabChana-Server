package th.ac.ku.LabChanaServer.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import th.ac.ku.LabChanaServer.Models.Lab;
import th.ac.ku.LabChanaServer.Models.Problem;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {
//    List<Problem> findByProblemId(int problemId);
}

package th.ac.ku.LabChanaServer.Data;

import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.LabChanaServer.Models.Lab;
import th.ac.ku.LabChanaServer.Models.Testcase;

import java.util.List;

@Repository
public interface TestcaseRepository extends JpaRepository<Testcase, Integer> {
//    List<Testcase> findByProblemId(int problemId);
    List<Testcase> findByPId(int problemId);
}
package th.ac.ku.LabChanaServer.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.LabChanaServer.Models.Lab;

import java.util.List;

@Repository
public interface LabRepository extends JpaRepository<Lab, Integer> {
//    List<Lab> findByLabId(int labId);
}

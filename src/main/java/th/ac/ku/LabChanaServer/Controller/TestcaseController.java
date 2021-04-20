package th.ac.ku.LabChanaServer.Controller;

//import junit.framework.TestCase;
import org.aspectj.weaver.ast.Test;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.LabChanaServer.Data.LabRepository;
import th.ac.ku.LabChanaServer.Data.TestcaseRepository;
//import th.ac.ku.LabChanaServer.Models.Lab;
import th.ac.ku.LabChanaServer.Models.Testcase;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/testcase")
public class TestcaseController {
    private TestcaseRepository repository;

    public TestcaseController(TestcaseRepository repository) {
        this.repository = repository ;
    }

    @GetMapping
    public List<Testcase> getAll() {
        return repository.findAll();
    }

    @GetMapping("{/id}")
    public Testcase getOne(@PathVariable int id) {
        try {
            return repository.findById(id).get() ;
        } catch (NoSuchElementException e){
            return null ;
        }

    }

//    @GetMapping("/testcase/{problemId}")
//    public List<Testcase> getByProblemId(@PathVariable int ProblemId) {
//        return repository.findByProblemId(ProblemId);
//    }

    public List<Testcase> getByPId(int id){
        List<Testcase> testcasesData = repository.findAll();
        List<Testcase> outData = null;
        for (Testcase d : testcasesData) {
            if(d.getProblem_id() == id) {
                outData.add(d) ;
            }
        }
        return outData ;
    }


    @PostMapping
    public Testcase create(@RequestBody Testcase testCase) {
        Testcase record = repository.save(testCase);
        repository.flush();
        return record;
    }

    @PutMapping("/{id}")
    public Testcase update(@PathVariable int id,
                      @RequestBody Testcase testCase) {
        Testcase record = repository.findById(id).get();
        record.setInput(testCase.getInput());
        record.setOutput(testCase.getOutput());
        repository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public Testcase delete(@PathVariable int id) {
        Testcase record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }




}

package th.ac.ku.LabChanaServer.Controller;

import org.springframework.web.bind.annotation.*;
import th.ac.ku.LabChanaServer.Data.AnswerRepository;
import th.ac.ku.LabChanaServer.Models.Answer;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    private AnswerRepository repository;

    public AnswerController(AnswerRepository repository) {
        this.repository = repository ;
    }

    @GetMapping
    public List<Answer> getAll() {
        return repository.findAll();
    }

    @GetMapping("{/id}")
    public Answer getOne(@PathVariable int id) {
        try {
            return repository.findById(id).get() ;
        } catch (NoSuchElementException e){
            return null ;
        }

    }

//    @GetMapping("/answer/{answerId}")
//    public List<Answer> getByAnswerId(@PathVariable int AnswerId) {
//        return repository.findByAnswerId(AnswerId);
//    }


    @PostMapping
    public Answer create(@RequestBody Answer answer) {
        Answer record = repository.save(answer);
        repository.flush();
        return record;
    }

    @PutMapping("/{id}")
    public Answer update(@PathVariable int id,
                      @RequestBody Answer answer) {
        Answer record = repository.findById(id).get();
        record.setIs_pass(answer.getIs_pass());
//        record.setStatus(lab.getStatus());
        repository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public Answer delete(@PathVariable int id) {
        Answer record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }




}

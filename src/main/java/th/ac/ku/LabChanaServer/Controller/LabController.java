package th.ac.ku.LabChanaServer.Controller;

import org.springframework.web.bind.annotation.*;
import th.ac.ku.LabChanaServer.Data.LabRepository;
import th.ac.ku.LabChanaServer.Models.Lab;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/lab")
public class LabController {
    private LabRepository repository;

    public LabController(LabRepository repository) {
       this.repository = repository ;
    }

    @GetMapping
    public List<Lab> getAll() {
        return repository.findAll();
    }

    @GetMapping("{/id}")
    public Lab getOne(@PathVariable int id) {
        try {
            return repository.findById(id).get() ;
        } catch (NoSuchElementException e){
            return null ;
        }

    }

//    @GetMapping("/lab/{labId}")
//    public List<Lab> getByLabId(@PathVariable int LabId) {
//        return repository.findByLabId(LabId);
//    }


    @PostMapping
    public Lab create(@RequestBody Lab lab) {
        Lab record = repository.save(lab);
        repository.flush();
        return record;
    }

    @PutMapping("/{id}")
    public Lab update(@PathVariable int id,
                              @RequestBody Lab lab) {
        Lab record = repository.findById(id).get();
        record.setTitle(lab.getTitle());
        record.setStatus(lab.getStatus());
        repository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public Lab delete(@PathVariable int id) {
        Lab record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }




}

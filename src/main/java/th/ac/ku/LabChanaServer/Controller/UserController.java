package th.ac.ku.LabChanaServer.Controller;

import org.springframework.web.bind.annotation.*;
import th.ac.ku.LabChanaServer.Data.UserRepository;
import th.ac.ku.LabChanaServer.Models.Lab;
import th.ac.ku.LabChanaServer.Models.User;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository ;
    }

    @GetMapping
    public List<User> getAll() {
        return repository.findAll();
    }

    @GetMapping("{/id}")
    public User getOne(@PathVariable int id) {
        try {
            return repository.findById(id).get() ;
        } catch (NoSuchElementException e){
            return null ;
        }

    }

//    @GetMapping("/user/{userId}")
//    public List<User> getByUserId(@PathVariable int UserId) {
//        return repository.findByUserId(UserId);
//    }


    @PostMapping
    public User create(@RequestBody User user) {
        User record = repository.save(user);
        repository.flush();
        return record;
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id,
                      @RequestBody User user) {
        User record = repository.findById(id).get();
        record.setName(user.getName());
//        record.setStatus(lab.getStatus());
        repository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable int id) {
        User record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }

}

package th.ac.ku.LabChanaServer.Controller;

import org.springframework.web.bind.annotation.*;
import th.ac.ku.LabChanaServer.Data.LabRepository;
import th.ac.ku.LabChanaServer.Data.ProblemRepository;
import th.ac.ku.LabChanaServer.Data.TestcaseRepository;
import th.ac.ku.LabChanaServer.Models.Lab;
import th.ac.ku.LabChanaServer.Models.Problem;
import th.ac.ku.LabChanaServer.Models.Testcase;

import java.util.List;
import java.util.NoSuchElementException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/api/problem")
public class ProblemController {
    private ProblemRepository repository;
    private Object TestcaseController;

    public ProblemController(ProblemRepository repository) {
        this.repository = repository ;
    }

    @GetMapping
    public List<Problem> getAll() {
        return repository.findAll();
    }

    @GetMapping("{/id}")
    public Problem getOne(@PathVariable int id) {
        try {
            return repository.findById(id).get() ;
        } catch (NoSuchElementException e){
            return null ;
        }

    }

//    @GetMapping("/problem/{problemId}")
//    public List<Problem> getByProblemId(@PathVariable int ProblemId) {
//        return repository.findByProblemId(ProblemId);
//    }

//    @PostMapping("/problem/{/problemId}")
//    public void send(@PathVariable int problemId, @RequestBody String inputCode) {
//        TestcaseRepository testcaseRepository = (TestcaseRepository) TestcaseController;
//        List<Testcase> testcases = testcaseRepository.findByPId(problemId) ;
//        for(Testcase t: testcases){
//            String in = t.getInput() ;
//            String clientId = "72761a2dc83ae3deaf00808e49f7a958"; //Replace with your client ID
//            String clientSecret = "40181a54ecde8043c34a3483c4ba09f54c8b195f153e944d81f44568c9e094bf"; //Replace with your client Secret
//            String script = in;
//            String language = "python3";
//            String versionIndex = "3";
//
//            try {
//                URL url = new URL("https://api.jdoodle.com/v1/execute");
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setDoOutput(true);
//                connection.setRequestMethod("POST");
//                connection.setRequestProperty("Content-Type", "application/json");
//
//                String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + script +
//                        "\",\"language\":\"" + language + "\",\"versionIndex\":\"" + versionIndex + "\"} ";
//
//                System.out.println(input);
//
//                OutputStream outputStream = connection.getOutputStream();
//                outputStream.write(input.getBytes());
//                outputStream.flush();
//
//                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                    throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
//                }
//
//                BufferedReader bufferedReader;
//                bufferedReader = new BufferedReader(new InputStreamReader(
//                        (connection.getInputStream())));
//
//                String output;
//                System.out.println("Output from JDoodle .... \n");
//                while ((output = bufferedReader.readLine()) != null) {
//                    System.out.println(output);
//                }
//
//                connection.disconnect();
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        }
//    }


    @PostMapping
    public Problem create(@RequestBody Problem problem) {
        Problem record = repository.save(problem);
        repository.flush();
        return record;
    }

    @PutMapping("/{id}")
    public Problem update(@PathVariable int id,
                      @RequestBody Problem problem) {
        Problem record = repository.findById(id).get();
        record.setTitle(problem.getTitle());
        record.setContent(problem.getContent());
        repository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public Problem delete(@PathVariable int id) {
        Problem record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }




}

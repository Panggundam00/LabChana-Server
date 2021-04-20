package th.ac.ku.LabChanaServer.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Testcase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int problem_id;
    private String input;
    private String output;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(int problem_id) {
        this.problem_id = problem_id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Testcase{" +
                "id=" + id +
                ", problem_id=" + problem_id +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }
}

package th.ac.ku.LabChanaServer.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int student_id;
    private int testcase_id;
    private int is_pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getTestcase_id() {
        return testcase_id;
    }

    public void setTestcase_id(int testcase_id) {
        this.testcase_id = testcase_id;
    }

    public int getIs_pass() {
        return is_pass;
    }

    public void setIs_pass(int is_pass) {
        this.is_pass = is_pass;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", testcase_id=" + testcase_id +
                ", is_pass=" + is_pass +
                '}';
    }
}

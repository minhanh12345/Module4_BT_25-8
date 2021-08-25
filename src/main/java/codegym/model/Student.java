package codegym.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long student_id;
    private String student_name;
    private Date student_birthday;
    private String student_address;
    private int student_phone;
    private String student_email;
    @ManyToOne
    private Classroom classroom;
    public Student(){}

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Student(long student_id, String student_name, Date student_birthday, String student_address, int student_phone, String email, Classroom classroom) {
        this.student_id = student_id;
        this.student_name=student_name;
        this.student_birthday = student_birthday;
        this.student_address = student_address;
        this.student_phone = student_phone;
        this.student_email = email;
        this.classroom = classroom;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public Date getStudent_birthday() {
        return student_birthday;
    }

    public void setStudent_birthday(Date student_birthday) {
        this.student_birthday = student_birthday;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public int getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(int student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}

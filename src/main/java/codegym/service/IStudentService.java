package codegym.service;

import codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IStudentService  {
    Page<Student> findAllPage(Pageable pageable);
    Student save(Student student);
    Student findById(long id);
    ArrayList<Student> findAll();
    void Delete(Student student);
    ArrayList<Student> findByName(String name);
}

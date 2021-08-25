package codegym.service;

import codegym.model.Student;
import codegym.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public class StudentService implements IStudentService {
    @Autowired
    IStudentRepo iStudentRepo;

    @Override
    public Page<Student> findAllPage(Pageable pageable) {
        return iStudentRepo.findAll(pageable);
    }

    @Override
    public Student save(Student student) {
        return iStudentRepo.save(student);
    }

    @Override
    public Student findById(long id) {
        return iStudentRepo.findById(id).get();
    }

    @Override
    public ArrayList<Student> findAll() {
        return (ArrayList<Student>) iStudentRepo.findAll();
    }

    @Override
    public void Delete(Student student) {
        iStudentRepo.delete(student);
    }

    @Override
    public ArrayList<Student> findByName(String name) {
        return iStudentRepo.findAllByName(name);
    }
}

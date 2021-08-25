package codegym.service;

import codegym.model.Classroom;
import codegym.repository.IClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ClassroomService implements IClassroomService{
    @Autowired
    IClassroomRepo iClassroomRepo;
    @Override
    public ArrayList<Classroom> findAll() {
        return (ArrayList<Classroom>) iClassroomRepo.findAll();
    }

    @Override
    public Classroom findById(long id) {
        return iClassroomRepo.findById(id).get();
    }
}

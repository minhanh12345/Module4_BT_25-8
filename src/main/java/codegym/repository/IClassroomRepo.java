package codegym.repository;

import codegym.model.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface IClassroomRepo extends CrudRepository<Classroom,Long> {
}

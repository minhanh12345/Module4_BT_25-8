package codegym.repository;

import codegym.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IStudentRepo extends PagingAndSortingRepository<Student,Long> {
    @Query(value = "select c from Student  c where c.student_name like concat('%',:name,'%')")
    ArrayList<Student> findAllByName(@Param("name") String name);
}

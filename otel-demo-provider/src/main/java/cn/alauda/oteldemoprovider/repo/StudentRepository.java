package cn.alauda.oteldemoprovider.repo;

import cn.alauda.oteldemoprovider.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(int id);
    Student findByName(String name);
}

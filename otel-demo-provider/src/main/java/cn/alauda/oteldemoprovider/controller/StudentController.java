package cn.alauda.oteldemoprovider.controller;

import cn.alauda.oteldemoprovider.entity.Student;
import cn.alauda.oteldemoprovider.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class StudentController {

    StudentRepository studentRepository;
    RedisTemplate<String, Serializable> redisTemplate;

    public StudentController(StudentRepository stuRepo, RedisTemplate<String, Serializable> redisTemplate) {
        this.studentRepository = stuRepo;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/stu/{id}")
    public Student getStudentById(@PathVariable int id) {
        redisTemplate.opsForValue().set("redis", "hello");
        return studentRepository.findById(id);
    }
}
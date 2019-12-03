package com.consumer.myribbon.feign;

import com.test.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName StudentController
 * @Description 对feign的调用
 * @Author Neal
 * @Date 2019/4/29 14:47
 * @Version 1.0
 */
@RestController
public class StudentController implements StudentService{

    @Autowired
    private StudentService studentService;


    @Override
    public String getAllStudent() {
        return studentService.getAllStudent();
    }

    @Override
    public String saveStudent(Student student) {
        return studentService.saveStudent(student);
    }
}


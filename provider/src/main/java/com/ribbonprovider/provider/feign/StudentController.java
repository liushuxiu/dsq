package com.ribbonprovider.provider.feign;

import com.test.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author Neal
 * @Date 2019/4/29 14:58
 * @Version 1.0
 */
@RestController
public class StudentController implements  StudentService{

    @Autowired
    @Qualifier("iStudentServiceImp")
    StudentService studentService;

    @Override
    public String getAllStudent() {
        return studentService.getAllStudent();
    }

    @Override
    public String saveStudent(Student student) {
        return studentService.saveStudent(student);
    }
}

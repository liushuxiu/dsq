package com.ribbonprovider.provider.feign;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentServiceImp
 * @Description StudentService实现类
 * @Author Neal
 * @Date 2019/4/29 17:10
 * @Version 1.0
 */
@Service("iStudentServiceImp")
public class StudentServiceImpl implements StudentService {

    private static List<Student> studentList = new ArrayList<>();

    @Override
    public String getAllStudent() {
        return studentList.toString();
    }

    @Override
    public String saveStudent(Student student) {
        studentList.add(student);
        return "ok";
    }
}

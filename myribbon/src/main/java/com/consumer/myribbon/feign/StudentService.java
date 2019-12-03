package com.consumer.myribbon.feign;

import com.uestc.miaoshi.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName StudentService
 * @Description feign API接口
 * @Author Neal
 * @Date 2019/4/29 14:36
 * @Version 1.0
 */
//服务端ID,我们的服务端，也就是provider项目的项目ID就是RIBBON-SERVICE
//下面有提及
@FeignClient(name = "RIBBON-SERVICE")
@Component
public interface StudentService {

    /**
     * 获取所有学生列表
     * @return
     */
    @GetMapping(value = "/myfeign/student")
    String getAllStudent();

    /**
     * 添加学生
     * @param student
     * @return
     */
    @PostMapping(value = "/myfeign/student")
    String saveStudent(@RequestBody Student student);
}

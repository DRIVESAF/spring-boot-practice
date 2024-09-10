package io.drivesaf.springboot.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/09 13:54
 * @description:
 **/

@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @GetMapping
    public String hellp(String name){
        String greeting = "hello，" + name;
        return greeting;
    }

    @GetMapping("/sum")
    public static int Waytwo(int num) {
        int sum=1;
        if(num<0) {
            throw new IllegalArgumentException("需要计算的参数必须为正数！");//抛出不合理参数异常
        }
        if(num==1) {
            return 1;//跳出循环
        }else {
            sum=num*Waytwo(num-1);//递归
            return sum;
        }
    }

}

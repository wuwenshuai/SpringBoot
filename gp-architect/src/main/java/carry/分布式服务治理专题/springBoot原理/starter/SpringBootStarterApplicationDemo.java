package carry.分布式服务治理专题.springBoot原理.starter;


import carry.分布式服务治理专题.springBoot原理.imort.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootStarterApplicationDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApplicationDemo.class, args);
    }
}

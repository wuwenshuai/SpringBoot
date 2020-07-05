package carry.分布式服务治理专题.springBoot原理;


import carry.分布式服务治理专题.springBoot原理.bean.ImportBean;
import carry.分布式服务治理专题.springBoot原理.imort.SpringConfig;
import carry.分布式服务治理专题.springBoot原理.importselect.EnableDefineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootApplicationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object loggerService = context.getBean("carry.分布式服务治理专题.springBoot原理.bean.ImportBean");
        System.out.println(loggerService);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("--------------------------------------------------------");
        for (String beanDefinitionName: beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}

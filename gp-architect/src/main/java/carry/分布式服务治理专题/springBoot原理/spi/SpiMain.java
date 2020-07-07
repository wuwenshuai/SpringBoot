package carry.分布式服务治理专题.springBoot原理.spi;


// import com.carry.CarryCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpiMain {

    public static void main(String[] args) {

        ConfigurableApplicationContext ca= SpringApplication.run(SpiMain.class,args);
       // ca.getBean(CarryCore.class).study();
    }
}

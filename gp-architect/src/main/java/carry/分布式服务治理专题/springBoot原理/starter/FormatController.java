package carry.分布式服务治理专题.springBoot原理.starter;


import com.carry.starter.HelloFormatTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormatController {

    @Autowired
    private HelloFormatTemplate helloFormatTemplate;

    @GetMapping("/formart")
    public String format(){
        User user=new User();
        user.setAge(18);
        user.setName("Mic");
        return helloFormatTemplate.doFormat(user);
    }

}

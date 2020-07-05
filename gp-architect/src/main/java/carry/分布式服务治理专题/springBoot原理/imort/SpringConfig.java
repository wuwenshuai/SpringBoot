package carry.分布式服务治理专题.springBoot原理.imort;


import carry.分布式服务治理专题.springBoot原理.bean.ImportBean;
import carry.分布式服务治理专题.springBoot原理.importselect.CacheImportSelector;
import carry.分布式服务治理专题.springBoot原理.importselect.LoggerDefinitionRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

@Import({ImportBean.class, CacheImportSelector.class, LoggerDefinitionRegistrar.class})
@Configuration
public class SpringConfig {
}

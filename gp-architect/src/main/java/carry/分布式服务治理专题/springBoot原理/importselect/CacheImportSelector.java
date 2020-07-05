package carry.分布式服务治理专题.springBoot原理.importselect;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class CacheImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //动态注入bean： 自己去实现判断逻辑，实现动态配置
        return new String[]{CacheService.class.getName()};
    }
}

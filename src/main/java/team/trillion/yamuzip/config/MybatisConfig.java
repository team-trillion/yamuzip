package team.trillion.yamuzip.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "team.trillion.yamuzip",
            annotationClass = Mapper.class,
            nameGenerator = CustomBeanNameGenerator.class
)
public class MybatisConfig {
}

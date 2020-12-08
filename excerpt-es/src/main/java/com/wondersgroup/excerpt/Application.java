package com.wondersgroup.excerpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2020/12/2 14:54
 * @description: 项目启动类
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableSwagger2
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 3600*24, redisFlushMode = RedisFlushMode.ON_SAVE, redisNamespace = "aurora-web")
@MapperScan("com.wondersgroup.excerpt.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

package org.dracula.test.dubbo.aop;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author dk
 */
@SpringBootApplication
@DubboComponentScan("org.dracula.test.dubbo.aop.provider")
@EnableAspectJAutoProxy
public class ProviderMain {

    public static void main(String[] args){
        SpringApplication.run(ProviderMain.class, args);
    }

}

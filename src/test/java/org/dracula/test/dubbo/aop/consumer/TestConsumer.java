package org.dracula.test.dubbo.aop.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.dracula.test.dubbo.aop.TestInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dk
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConsumer.TmpConfig.class)
@DubboComponentScan("org.dracula.test.dubbo.aop.consumer")
public class TestConsumer {

    private static Logger logger = LoggerFactory.getLogger(TestConsumer.class);

    @Reference
    private TestInterface testInterface;

    @Test
    public void test(){
        logger.info(testInterface.sayHello("world"));
    }

    @Configuration
    public static class TmpConfig{

        @Bean
        public ApplicationConfig applicationConfig(){
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("test-consumer");
            return applicationConfig;
        }

        @Bean
        public RegistryConfig registryConfig(){
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            return registryConfig;
        }

    }

}

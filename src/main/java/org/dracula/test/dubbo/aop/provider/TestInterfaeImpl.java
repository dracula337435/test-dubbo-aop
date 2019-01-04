package org.dracula.test.dubbo.aop.provider;

import com.alibaba.dubbo.config.annotation.Service;
import org.dracula.test.dubbo.aop.TestInterface;
import org.dracula.test.dubbo.aop.aop.ForwardAway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dk
 */
@Service
public class TestInterfaeImpl implements TestInterface {

    private static Logger logger = LoggerFactory.getLogger(TestInterfaeImpl.class);

    @Override
    @ForwardAway("")
    public String sayHelloWithAspect(String name) {
        logger.info("期望这个有切面");
        return "with aspect, hello "+name;
    }

    @Override
    public String sayHelloWithOUTAspect(String name) {
        logger.info("期望这个【没】有切面");
        return "without aspect, hello "+name;
    }
}

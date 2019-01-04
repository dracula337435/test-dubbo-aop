package org.dracula.test.dubbo.aop.provider;

import com.alibaba.dubbo.config.annotation.Service;
import org.dracula.test.dubbo.aop.TestInterface;
import org.dracula.test.dubbo.aop.TestReqBO;
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
    @ForwardAway("some-info")
    public String sayHelloWithAspect(TestReqBO reqBO) {
        logger.info("期望这个有切面");
        return "with aspect, hello "+reqBO.getName();
    }

    @Override
    public String sayHelloWithOUTAspect(TestReqBO reqBO) {
        logger.info("期望这个【没】有切面");
        return "without aspect, hello "+reqBO.getName();
    }
}

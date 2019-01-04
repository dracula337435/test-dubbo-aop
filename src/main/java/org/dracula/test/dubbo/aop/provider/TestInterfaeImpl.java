package org.dracula.test.dubbo.aop.provider;

import com.alibaba.dubbo.config.annotation.Service;
import org.dracula.test.dubbo.aop.TestInterface;

/**
 * @author dk
 */
@Service
public class TestInterfaeImpl implements TestInterface {

    @Override
    public String sayHello(String name) {
        return "hello "+name;
    }

}

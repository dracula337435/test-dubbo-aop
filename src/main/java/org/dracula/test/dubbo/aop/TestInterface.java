package org.dracula.test.dubbo.aop;

/**
 * @author dk
 */
public interface TestInterface {

    /**
     *
     * @param name
     * @return
     */
    String sayHelloWithAspect(String name);

    /**
     *
     * @param name
     * @return
     */
    String sayHelloWithOUTAspect(String name);

}

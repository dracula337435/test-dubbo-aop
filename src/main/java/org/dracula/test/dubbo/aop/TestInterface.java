package org.dracula.test.dubbo.aop;

/**
 * @author dk
 */
public interface TestInterface {

    /**
     *
     * @param reqBO
     * @return
     */
    String sayHelloWithAspect(TestReqBO reqBO);

    /**
     *
     * @param reqBO
     * @return
     */
    String sayHelloWithOUTAspect(TestReqBO reqBO);

}

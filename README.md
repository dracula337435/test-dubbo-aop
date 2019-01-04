# 试验dubbo

提供者上加aop，问题在于怎么加

```TestInterfaceImpl```作为提供者，其中两个方法对比，
```sayHelloWithAspect```，有注解```@ForwardAway```；
```sayHelloWithOUTAspect```，无此注解

效果，见测试类```TestConsumer```，
1. 启动提供者```ProviderMain```
1. 跑```testWithAspect```，调用```sayHelloWithAspect```，可见切面```AopForDubbo```被调用
1. 跑```testWithOUTAspect```，调用```sayHelloWithOUTAspect```，不过切面
1. 切面中可得到方法信息，传入参数，注解

使用步骤
1. 在```@Configuraion```类上加```@EnableAspectJAutoProxy```
1. 将类```AopForDubbo```声明为```bean```，
1. 在需要的函数上加注解```@ForwardAway```


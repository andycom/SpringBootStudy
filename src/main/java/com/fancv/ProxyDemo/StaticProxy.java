package com.fancv.ProxyDemo;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/8/10 16:27
 * @Description
 *
 * 静态代理 代码中编辑代理关系，被代理的对象作为参数传入代理对象，调用代理对象的对应方法，实际上执行的还是被代理对象的逻辑
 */
public class StaticProxy {


    static class RealService implements IService {
        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class TraceProxy implements IService {
        private IService realService;

        public TraceProxy(IService realService) {
            this.realService = realService;
        }

        @Override
        public void sayHello() {
            System.out.println("entering sayHello");
            this.realService.sayHello();
            System.out.println("leaving sayHello");
        }
    }

    public static void main(String[] args) {
        IService realService = new StaticProxy.RealService();
        IService proxyService = new StaticProxy.TraceProxy(realService);
        proxyService.sayHello();
    }

}

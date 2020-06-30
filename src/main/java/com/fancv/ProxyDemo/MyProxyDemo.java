package com.fancv.ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/30 9:36
 * @Description
 */
public class MyProxyDemo {

    public static void main(String args[]) {

        // 方法一
        System.out.println("============ 方法一 ==============");
        AdminService adminService = new AdminServiceImpl();
        System.out.println("代理的目标对象：" + adminService.getClass());

        MyProxyHanndler adminServiceInvocation = new MyProxyHanndler(adminService);

        //类型强制转换，后续调用find方法
        AdminService proxy = (AdminService) Proxy.newProxyInstance(adminService.getClass().getClassLoader(), adminService.getClass().getInterfaces(), adminServiceInvocation);


        System.out.println("代理对象：" + proxy.getClass());
        Object obj = proxy.find("代理入参 我的名字");
        System.out.println("find 返回对象：" + obj.getClass());

        proxy.toString();
        System.out.println("----------------------------------");
        proxy.update();
    }

}


class MyProxyHanndler implements InvocationHandler {

    private Object target;

    public MyProxyHanndler(Object t) {
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==被代理对象：" + target.getClass().getName());
        System.out.println("==被代理方法：" + method.getName());
        if (null != args) {
            for (Object o : args) {
                System.out.println("==代理参数：" + o);
            }
        }
        return method.invoke(target, args);

    }
}

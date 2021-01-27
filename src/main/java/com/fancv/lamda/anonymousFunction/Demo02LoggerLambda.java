package com.fancv.lamda.anonymousFunction;

public class Demo02LoggerLambda {
    private static void log(int level, MessageBuilder builder) {
        if (level == 1) {
            // 实际上利用内部类 延迟的原理,代码不相关 无需进入到启动代理执行
            System.out.println(builder.buildMessage());
        }
    }

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        log(2, () -> {
            System.out.println("lambda 是否执行了");
            return msgA + msgB + msgC;
        });
        /**
         * lambda 一次性使用的方法，java便捷写法，同时不方便调试
         */
        log(1, () -> {
            System.out.println("lambda 是否执行了");
            new Thread(() -> {
                System.out.println("这里还能起一个线程打印数据");
            }).start();
            return new StringBuilder(msgA).append(msgB).append(msgC).toString();
        });
    }
}

package com.fancv.MyInterface;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/22 15:20
 * @Description
 */
public class MyStart {

    public static void main(String args[]) {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(3000, listener);
        t.start();


        InterfaceDemo.printfdd("接口内实现方法");
        JOptionPane.showMessageDialog(null, "quit?");
        System.exit(0);


    }
}

package com.fancv.MyInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/6/22 15:16
 * @Description
 */
public class TimePrinter implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("the time is " + LocalDate.now().toString());
        Toolkit.getDefaultToolkit().beep();
    }
}

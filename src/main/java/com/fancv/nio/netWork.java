package com.fancv.nio;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/12/9 10:02
 * @Description
 */
public class netWork {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
            while (networkInterface.hasMoreElements()) {
                NetworkInterface eachNetworkInterface = networkInterface.nextElement();
                System.out.println("■getName获得网络设备名称=" + eachNetworkInterface.getName());
                System.out.println("■getDisplayName获得网络设备显示名称=" + eachNetworkInterface.getDisplayName());
                System.out.println("■isPointToPoint是不是点对点设备=" + eachNetworkInterface.isPointToPoint());
                System.out.println();
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}

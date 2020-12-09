package com.fancv.nio;



import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @version 1.0
 * @Author hamish-wu
 * @create 2020/12/8 19:40
 * @Description
 */
public class MynetNIO {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        InetAddress myAddress = InetAddress.getByName("www.fancv.com");
        InetAddress baiduAddress = InetAddress.getByName("www.baidu.com");
        // 192.168.0.100是本地的IP地址
        InetAddress ipStringAddress = InetAddress.getByName("192.168.0.100");
        InetAddress localhostAddress = InetAddress.getByName("localhost");
        System.out.println(localhostAddress.getClass().getName() + " " + localhostAddress.getHostAddress());
        System.out.println(myAddress.getClass().getName() + " " + myAddress.getHostAddress());
        System.out.println(baiduAddress.getClass().getName() + " " + baiduAddress.getHostAddress());
        System.out.println(ipStringAddress.getClass().getName() + " " + ipStringAddress.getHostAddress());
        // 以下2个示例为错误的情况：
        // 没有192.168.0.777这个IP地址
        InetAddress notIPAddress = InetAddress.getByName("192.168.0.777");
        System.out.println(notIPAddress.getClass().getName() + " " + notIPAddress.
                getHostAddress());
        // 不存在的域名
        InetAddress notDomainAddress = InetAddress.getByName("www.123123452345- 23451234234234134123412342412341234.com ");
        System.out.println(notDomainAddress.getClass().getName() + " " + notDomainAddress.getHostAddress());
    }
}

/*
 *  Copyright(c)2002-2020,  www.fancv.com
 *  项目名称:SpringBootStudy   SpringBootStudy
 *  文件名称:Car.java
 *  Date:20-6-21 下午4:15
 *  Author: xixin
 */

package com.fancv.Myreflective;

import com.fancv.MyObject.Person;

import java.util.List;
import java.util.Map;

public class Car {

    /**
     * 品牌
     */
    private String banch;


    private Integer length;


    private List<Integer> slist;


    private Person p;

    private Map mp;


    public String getBanch() {
        return banch;
    }

    public void setBanch(String banch) {
        this.banch = banch;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Integer> getSlist() {
        return slist;
    }

    public void setSlist(List<Integer> slist) {
        this.slist = slist;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Map getMp() {
        return mp;
    }

    public void setMp(Map mp) {
        this.mp = mp;
    }
}

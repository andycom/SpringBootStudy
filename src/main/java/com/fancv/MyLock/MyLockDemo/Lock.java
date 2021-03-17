package com.fancv.MyLock.MyLockDemo;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface Lock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void  unlock();

    Boolean TryLock() throws InterruptedException;

    List<Thread> getBlockedThread();




}

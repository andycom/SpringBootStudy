package com.fancv.MyLock.WaitNotify;

import java.util.LinkedList;

/**
 * @author hamish-wu
 */
public class EventQueue {

    private final int max;

    static class Event {
    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    public void offer(Event event) {

        synchronized (eventQueue) {
//            while (eventQueue.size() >= max) {
            if (eventQueue.size() >= max) {
                try {
                    console("the queue is full !");
                    eventQueue.wait();
                    System.out.println("offer:" + Thread.currentThread().getName() + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("the new event is submitted ");
            eventQueue.add(event);
//            eventQueue.notifyAll();
            eventQueue.notify();
        }
    }

    public Event task() {
        synchronized (eventQueue) {
//            while (eventQueue.isEmpty()) {
            if (eventQueue.isEmpty()) {
                try {
                    console("the queue is empty !");
                    System.out.println("task: " + Thread.currentThread().getName() + Thread.currentThread().getState());
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
//            eventQueue.notifyAll();
            eventQueue.notify();
            console("the event " + event + " is handled.");
            return event;
        }
    }

    private void console(String message) {

        System.out.printf("%s:%s\n", Thread.currentThread().getName(), message);
    }


}

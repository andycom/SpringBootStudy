package com.fancv.javaCpu;

public class CPUPrint {

    public static void main(String args[]) throws InterruptedException {
        final int SAMPLING_COUNT = 600;
        final double PI = 3.1415926535;
        final int TOTAL_AMPLITUDE = 900;

        int[] busySpan = new int[SAMPLING_COUNT];
        int amplitude = TOTAL_AMPLITUDE / 2;
        double radian = 0.0;
        double radianIncrement = 2.0 / (double) SAMPLING_COUNT;
        for (int i = 0; i < SAMPLING_COUNT; i++) {
            busySpan[i] = (int) (amplitude + Math.sin(PI * radian) * amplitude);
            radian += radianIncrement;
        }

        long startTime = 0;
        for (int j = 0; ; j = (j + 1) % SAMPLING_COUNT) {
            startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) <= busySpan[j]) {
                ;
            }
            Thread.sleep(TOTAL_AMPLITUDE - busySpan[j]);
        }
    }
}

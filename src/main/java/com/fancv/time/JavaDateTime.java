package com.fancv.time;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author hamish-wu
 */
public class JavaDateTime {

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now(ZoneId.of("America/Montreal")));

        System.out.println(Clock.system(ZoneId.of("Asia/Shanghai")).instant());
        System.out.println(Date.from(Clock.system(ZoneId.of("Asia/Shanghai")).instant()));
    }
}

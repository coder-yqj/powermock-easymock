package com.study.powermock.staticmocking;

/**
 * Created by Administrator on 2018/7/15/015.
 * The purpose of the IdGenerator is to generate ID's based on the system time.
 */
public class IdGenerator {

    /**
     * @return A new ID based on the current time.
     */
    public static long generateNewId() {
        return System.currentTimeMillis();
    }

}

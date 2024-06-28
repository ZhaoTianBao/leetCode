package com.myjava.offer.design;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {

        String res = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();

        System.out.println(res);

        //EXCHANGE

    }
}

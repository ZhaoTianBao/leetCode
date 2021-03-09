package com.myjava.offer;

import java.util.ArrayList;

public class JVMTest {
    /**
     *
     * 诸葛面试 测试
     */


    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<JVMTest> list = new ArrayList<>();
        while (true){
            list.add(new JVMTest());
            Thread.sleep(10);
        }
    }



}

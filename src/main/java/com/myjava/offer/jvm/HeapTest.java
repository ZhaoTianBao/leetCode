package com.myjava.offer.jvm;

import java.util.ArrayList;

public class HeapTest {

    // 100k
    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<>();
        while (true){
            heapTests.add(new HeapTest());
            Thread.sleep(10);
        }
    }

    /**
     *  jvisualvm
     *  最终oom
     */
}

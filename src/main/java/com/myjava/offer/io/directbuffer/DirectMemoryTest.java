package com.myjava.offer.io.directbuffer;

import java.nio.ByteBuffer;

public class DirectMemoryTest {
    public static void heapAccess(){
        long startTime = System.currentTimeMillis();
        //分配内存 capacity 容量  缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        for (int i = 0; i < 100000; i++){
            for (int j = 0; j < 200 ; j++){
                buffer.putInt(j);
            }
            buffer.flip();
            for (int j = 0; j < 200 ; j++){
                buffer.getInt();
            }
            buffer.clear();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("堆内存 heap 访问时间 "+(endTime - startTime)+"ms");


    }



    public static void directAccess(){

        long startTime = System.currentTimeMillis();
        //分配直接内存
        ByteBuffer buffer = ByteBuffer.allocateDirect(1000);
        for (int i = 0; i < 100000; i++){
            for (int j = 0; j < 200 ; j++){

                buffer.putInt(j);
            }
            buffer.flip();
            for (int j = 0; j < 200 ; j++){
                buffer.getInt();
            }
            buffer.clear();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("直接内存 direct 访问时间 "+(endTime - startTime)+"ms");

    }






    public static void main(String[] args) {
        heapAccess();
        directAccess();
    }
}

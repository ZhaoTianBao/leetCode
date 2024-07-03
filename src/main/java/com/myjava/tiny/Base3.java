package com.myjava.tiny;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Base3 {
    public static void main(String[] args) {


        List<Integer> list= new ArrayList<Integer>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(0,4);
        list.remove(1);
        System.out.println(list);
        System.out.println("1111");

    }




    class F implements Serializable{
        private T t = new T();
    }


    class T{}




}

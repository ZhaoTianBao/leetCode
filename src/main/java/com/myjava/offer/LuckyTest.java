package com.myjava.offer;

import java.security.SecureRandom;
import java.util.*;

public class LuckyTest {

    /**
     *
     * 图灵学院 诸葛老师抽奖程序
     *
     */

//    private static List qq = Arrays.asList(new String[]{"t1-1", "t2-1"});

    private static String[] qq = new String[]{
            "t1-1", "t1-2","t1-3","t1-4","t1-5","t1-6","t1-7","t1-8","t1-9","t1-10",
            "t2-1", "t2-2","t2-3","t2-4","t2-5","t2-6","t2-7","t2-8","t2-9","t2-10",
            "t3-1"

    };


    private static int num = 10;


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (;;){
            if(set.size() == num){
                break;
            }
            int random = new SecureRandom().nextInt(qq.length);
            set.add(qq[random]);
        }
        Iterator<String> iterator = set.iterator();
        System.out.println("================>");
        System.out.println("================>");
        while (iterator.hasNext()){
            System.out.println("======>中奖: "+iterator.next());
        }
        System.out.println("================>");

    }

}

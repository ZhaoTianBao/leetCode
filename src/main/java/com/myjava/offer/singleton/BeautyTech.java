package com.myjava.offer.singleton;

public class BeautyTech {

    private static BeautyTech beautyTech;

    public BeautyTech() {
    }


//    public static BeautyTech BeautyTech(){
//        if (null == beautyTech){
//            beautyTech = new BeautyTech();
//        }
//        return beautyTech;
//    }

    public static synchronized BeautyTech BeautyTech(){
        if (null == beautyTech){
            beautyTech = new BeautyTech();
        }
        return beautyTech;
    }

}

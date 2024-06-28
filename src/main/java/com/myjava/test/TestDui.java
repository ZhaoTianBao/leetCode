package com.myjava.test;

import java.util.HashMap;
import java.util.Map;

public class TestDui {


    public static void main(String[] args) {
        Map signMap = new HashMap();
        String url = "http://www.baidu.com";
        String res = DuiUtils.httpsPostWithJson(url, signMap);
        System.out.println(res);
    }
}

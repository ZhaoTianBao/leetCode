package com.myjava.test;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DuiUtils {



    public static String httpsPostWithJson(String url, Map<String, String> paramsMap) {
        String resData = null;
        try {
            HttpPost post = new HttpPost(url);
            post.setHeader("Content-Type", "application/x-www-form-urlencoded");
            //json
            List<BasicNameValuePair> pairList = new ArrayList<>();
            for (String key : paramsMap.keySet()) {
                pairList.add(new BasicNameValuePair(key, paramsMap.get(key)));
            }
            UrlEncodedFormEntity u = new UrlEncodedFormEntity(pairList, "utf-8");
            post.setEntity(u);
            CloseableHttpClient httpClient = new SSLClient();
            CloseableHttpResponse response = httpClient.execute(post);
            resData = EntityUtils.toString(response.getEntity(), "UTF-8");
            return resData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resData;
    }





}

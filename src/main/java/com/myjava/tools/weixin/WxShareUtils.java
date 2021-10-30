package com.myjava.tools.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WxShareUtils {

    private static final Logger logger = LoggerFactory.getLogger(WxShareUtils.class);

    //获取access_token填写client_credential
    private static final String GRANT_TYPE = "client_credential";

    //第三方用户唯一凭证
    private static final String APP_ID = "wx22501ce7b221393c";

    //第三方用户唯一凭证密钥，即appsecret
    private static final String SECRET = "bb2dea26483af4befd6afcaf60e255d8";



    public static Map<String, String> sign(String url){
        String accessToken = getAccessToken();
        logger.info(accessToken);
        String ticket = getTicket(accessToken);
        logger.info(ticket);
        Map<String, String> ret = createSign(ticket, url);
        logger.info(ret.toString());
        return ret;
    }


    public static Map<String, String> createSign(String jsApiTicket, String url) {
        Map<String, String> ret = new HashMap<>();
        String nonceStr = createNonceStr();
        String timestamp = createTimestamp();
        String tmpStr = "";
        String signature = "";
        // 注意这里参数名必须全部小写，且必须有序
        tmpStr = "jsapi_ticket=" + jsApiTicket + "&noncestr=" + nonceStr + "&timestamp="
                + timestamp + "&url="
                + url;
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(tmpStr.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (Exception e){
            e.printStackTrace();
        }
        ret.put("url", url);
        ret.put("jsapi_ticket", jsApiTicket);
        ret.put("nonceStr",  nonceStr);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        ret.put("appid", APP_ID);
        return ret;
    }


    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }


    // 生成nonce_str
    private static String createNonceStr() {
        return UUID.randomUUID().toString();
    }

    // 生成timestamp
    private static String createTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }


    // 获取token
    private static String getAccessToken() {
        String accessToken = "";
        //这个url链接地址和参数皆不能变
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=" + GRANT_TYPE
                + "&appid=" + APP_ID + "&secret=" + SECRET;
        String tokenResponse = httpGet(url);
        System.out.println(tokenResponse);
        logger.info(tokenResponse);
        //判断 http 返回信息 及 异常
        JSONObject jsonObject = JSON.parseObject(tokenResponse);
        accessToken = (String) jsonObject.get("access_token");
        return accessToken;
    }

    // 获取ticket
    private static String getTicket(String accessToken) {
        if (StringUtils.isBlank(accessToken)){
            return "";
        }
        String ticket = "";
        // 这个url链接和参数不能变
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken
                + "&type=jsapi";
        String response = httpGet(url);
        System.out.println(response);
        logger.info(response);
        //判断 http 返回信息 及 异常
        JSONObject jsonObject = JSON.parseObject(response);
        ticket = (String) jsonObject.get("ticket");
        return ticket;
    }


    public static String httpGet(String targetUrl){
        if (StringUtils.isBlank(targetUrl)){
            return "";
        }
        try {
            URL urlGet = new URL(targetUrl);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            // 必须是get方式请求
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            // 连接超时30秒
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
            // 读取超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000");
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String response = new String(jsonBytes, "UTF-8");
            is.close();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        sign(url);
    }



}

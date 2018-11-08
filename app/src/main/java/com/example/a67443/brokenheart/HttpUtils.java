package com.example.a67443.brokenheart;

import com.google.gson.Gson;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpUtils {

    public static ChatMessage sendMessage(String message) {

        String url = Config.URL_KEY;
        String data="{\"perception\": {\"inputText\": {\"text\": \""+message+"\"}},\"userInfo\": {\"apiKey\": \""+Config.API_KEY+"\",\"userId\": \""+Config.USER_ID+"\"}}";

        ChatMessage chatMessage = new ChatMessage();
//        String gsonResult = sendPost(url,data);
        String json_result = sendPost(url,data);
        System.out.println("---------------");
        System.out.println(json_result);


//        Gson gson = new Gson();
//        Result result = null;
        if (json_result != null) {
            try {
//                result = gson.fromJson(gsonResult, Result.class);
                JSONObject jsonObject  = JSON.parseObject(json_result);
                String temp = jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("values").getString("text");
                chatMessage.setMessage(temp);
            } catch (Exception e) {
                chatMessage.setMessage("服务器繁忙，请稍候再试...");
            }
        }
        chatMessage.setData(new Date());
        chatMessage.setType(ChatMessage.Type.INCOUNT);
        return chatMessage;
    }

    /**
     * get请求
     *
     * @param message ：发送的话
     * @return：数据
     */
//    public static String doGet(String message) {
////        String result = "";
//
////        String url = setParmat(message);
//
//        try {
//            String result = sendPost(url,data);
//            JSONObject jsonObject  = JSON.parseObject(result);
//
//
//        }catch (IOException e){
//
//        }
//
//
//
//
//
//
//
//        System.out.println("------------url = " + url);
//        InputStream is = null;
//        ByteArrayOutputStream baos = null;
//        try {
//            URL urls = new URL(url);
//            HttpURLConnection connection = (HttpURLConnection) urls
//                    .openConnection();
//            connection.setReadTimeout(5 * 1000);
//            connection.setConnectTimeout(5 * 1000);
//            connection.setRequestMethod("GET");
//
//            is = connection.getInputStream();
//            baos = new ByteArrayOutputStream();
//            int len = -1;
//            byte[] buff = new byte[1024];
//            while ((len = is.read(buff)) != -1) {
//                baos.write(buff, 0, len);
//            }
//            baos.flush();
//            result = new String(baos.toByteArray());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if (baos != null) {
//                try {
//                    baos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }

    /**
     * 设置参数
     *
//     * @param message : 信息
//     * @return ： url
     */
//    private static String setParmat(String message) {
//        String url = "";
//        try {
//            url = Config.URL_KEY + "?" + "key=" + Config.APP_KEY + "&info="
//                    + URLEncoder.encode(message, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return url;
//    }

    public static String sendPost(String url,String Params){
        OutputStreamWriter out  = null;
        BufferedReader reader = null;
        String result = "";
        try{
            URL httpUrl = null;
            httpUrl = new URL(url);
            //建立连接
            HttpURLConnection con = (HttpURLConnection)httpUrl.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-type","application/json");
            con.setRequestProperty("connection","keep-alive");
            con.setUseCaches(false);
            con.setInstanceFollowRedirects(true);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.connect();
            out = new OutputStreamWriter(con.getOutputStream());
            out.write(Params);
            out.flush();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));          //读取响应
            String lines;
            while ((lines = reader.readLine()) != null){
                lines = new String(lines.getBytes(),"utf-8");
                result +=lines;
            }
            reader.close();
            con.disconnect();           //断开连接
        }catch (Exception e){
            //
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        finally {
            try {
                if(out!=null){
                    out.close();
                }
                if(reader!=null){
                    reader.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }


}

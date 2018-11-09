package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.service.PostDataService;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-04-27
 */

@Service
public class PostDataServiceImpl implements PostDataService {

    Logger log = Logger.getLogger(PostDataServiceImpl.class);

    @Override
    public void postJsonData(String URL, JSONObject jsonObject) throws IOException {
        HttpURLConnection connection = null;
        try {
            // 创建连接
            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();

            // 设置http连接属性
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST"); // 可以根据需要 提交 GET、POST、DELETE、INPUT等http提供的功能
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);

            // 设置http头 消息
            connection.setRequestProperty("Content-Type", "application/json");  //设定 请求格式 json，也可以设定xml格式的
            // connection.setRequestProperty("Content-Type", "text/xml");   //设定 请求格式 xml，
            connection.setRequestProperty("Accept", "application/json");//设定响应的信息的格式为 json，也可以设定xml格式的
            // connection.setRequestProperty("X-Auth-Token","xx");  //特定http服务器需要的信息，根据服务器所需要求添加
            connection.connect();


            // 传递 fastjson数据
            OutputStream out = connection.getOutputStream();    // 获取(写)数据流
            out.write(jsonObject.toJSONString().getBytes());    // 向数据流写数据
            out.flush();
            out.close();                                        // 关闭数据流

            // 请求返回的状态 connection.getResponseCode()

            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            reader.close();

            // 断开连接
            connection.disconnect();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public StringBuffer postHttpJsonData(String URL, JSONObject jsonObject, JSONObject responseJsonMap, int... timeoutArrays) throws Exception {

        // setConnectTimeout: 从客户端到url建立连接的超时时间
        // setSocketTimeout: 连接上一个url后，获取response的返回等待时间
        RequestConfig requestConfig = null;
        if (timeoutArrays.length == 0) {
            requestConfig = RequestConfig.custom().setConnectTimeout(30 * 1000).setSocketTimeout(3600 * 1000).build();
        } else if (timeoutArrays.length == 2) {
            requestConfig = RequestConfig.custom().setConnectTimeout(timeoutArrays[0]).setSocketTimeout(timeoutArrays[1]).build();
        } else {
            throw new Exception("post 超时参数SocketTimeout和ConnectTimeout不符合要求");
        }

        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
        try {
            HttpPost post = new HttpPost(URL);
            // UTF-8 解决中文乱码
            StringEntity params = new StringEntity(jsonObject.toJSONString(), "UTF-8");
            post.addHeader("content-type", "application/json; charset=UTF-8");
            post.addHeader("Accept", "application/json");
            post.addHeader("Accept-Encoding", "UTF-8");
            post.setEntity(params);

            // 发送 post 请求
            HttpResponse response = httpClient.execute(post);

            if (response != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                InputStream in = response.getEntity().getContent(); //Get the data in the entity
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String lines;
                StringBuffer sb = new StringBuffer("");
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), "utf-8");
                    sb.append(lines);
                }
                reader.close();
                in.close();
                log.info(sb.toString());
                responseJsonMap.put("status", "success");
                responseJsonMap.put("message", sb.toString());
            } else if (response != null) {
                InputStream in = response.getEntity().getContent(); //Get the data in the entity
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String lines;
                StringBuffer sb = new StringBuffer("");
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), "utf-8");
                    sb.append(lines);
                }
                reader.close();
                in.close();
                responseJsonMap.put("status", "error");
                responseJsonMap.put("message", "异常, 请联系管理员." + "error:" + sb.toString());
            } else {
                responseJsonMap.put("status", "error");
                responseJsonMap.put("message", "异常, 请联系管理员.");
            }

        } catch (Exception ex) {
            responseJsonMap.put("status", "error");
            responseJsonMap.put("message", "异常, 请联系管理员.");
            ex.printStackTrace();
        } finally {
            httpClient.close();
        }
        return new StringBuffer("finish post");
    }


}

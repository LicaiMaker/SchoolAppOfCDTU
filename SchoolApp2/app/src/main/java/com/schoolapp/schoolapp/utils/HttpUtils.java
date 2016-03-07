package com.schoolapp.schoolapp.utils;

import com.schoolapp.schoolapp.dao.HttpCallBackListener;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by LiCai on 2016/3/6.
 */
public class HttpUtils {

    /**
     * 发送一个object对象到服务器端
     * @param UpLoadURL--上传的服务器路径
     * @param method--提交方式（post和get）
     * @param file--上传的对象
     * @param listener--回调接口
     */
    public static void SendObject(final String UpLoadURL,final String method ,final File file,final HttpCallBackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(UpLoadURL);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod(method);
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    //可传送序列化对象
                    connection.setRequestProperty("Content-type", "application/x-java-serialized-object");
                    connection.connect();//建立一个TCP连接
                    OutputStream os=connection.getOutputStream();
                    DataOutputStream dos=new DataOutputStream(os);
                    //创建输入流，用于读取文件的内容
                    InputStream is = new FileInputStream(file);


                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while ((len = is.read(bytes)) != -1) {
                        dos.write(bytes, 0, len);
                    }

                    os.flush();
                    dos.flush();

                    dos.close();
                    os.close();
                    is.close();

                    InputStream istream=connection.getInputStream();
                    BufferedReader br=new BufferedReader(new InputStreamReader(istream));
                    StringBuilder sb=new StringBuilder();
                    String s="";
                    while((s=br.readLine())!=null){
                        sb.append(s);
                    }
                    if(listener!=null){
                        listener.OnFinish(sb.toString());
                    }
                } catch (Exception e) {
                    if(listener!=null){
                        listener.OnError(e);
                    }
                    e.printStackTrace();
                }finally{
                    connection.disconnect();
                }
            }

        }).start();
    }
    public static void sendStr(final String UpLoadURL,final String method ,final String str,final HttpCallBackListener listener){

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(UpLoadURL);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod(method);
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    //可传送序列化对象
                    connection.setRequestProperty("Content-type", "application/x-java-serialized-object");
                    connection.connect();//建立一个TCP连接
                    OutputStream os=connection.getOutputStream();
                    DataOutputStream dos=new DataOutputStream(os);
                    //创建输入流，用于读取文件的内容
                    dos.write((str.toString()).getBytes());

                    os.flush();
                    dos.flush();

                    dos.close();
                    os.close();
                    //获取服务器的参数
                    InputStream istream=connection.getInputStream();
                    BufferedReader br=new BufferedReader(new InputStreamReader(istream));
                    StringBuilder sb=new StringBuilder();
                    String s="";
                    while((s=br.readLine())!=null){
                        sb.append(s);
                    }
                    if(listener!=null){
                        listener.OnFinish(sb.toString());
                    }
                } catch (Exception e) {
                    if(listener!=null){
                        listener.OnError(e);
                    }
                    e.printStackTrace();
                }
                finally{
                    connection.disconnect();
                }
            }

        }).start();

    }

    public static void getJsonStr(final String DownLoadURL,final String method ,final HttpCallBackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(DownLoadURL);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod(method);
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.connect();//建立一个TCP连接

                    //获取服务器的参数
                    InputStream istream=connection.getInputStream();
                    BufferedReader br=new BufferedReader(new InputStreamReader(istream));
                    StringBuilder sb=new StringBuilder();
                    String s="";
                    while((s=br.readLine())!=null){
                        sb.append(s);
                    }
                    if(listener!=null){
                        listener.OnFinish(sb.toString());
                    }
                } catch (Exception e) {
                    if(listener!=null){
                        listener.OnError(e);
                    }
                    e.printStackTrace();
                }finally{
                    connection.disconnect();
                }
            }

        }).start();
    }

}

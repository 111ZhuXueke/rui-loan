package com.rui.web.controller.robot.util;

import java.io.*;
import java.net.Socket;

/**
 * @author : zhuxueke
 * @since : 2018-01-17 13:25
 **/
public class SocketClient {
    //应用的唯一标识
    private static String mac = null;
    private static int port = 0;
    public SocketClient(String mac, int port){
        mac = mac;
        port = port;
    }

    /**
     * 返回服务端的信息
     * @author : zhuxueke
     * @since : 2018/1/17 13:26
     */
    public static String backMsg(){
        String msg = "";

        return msg;
    }
    /**
     * 创建socket客户端，用于连接服务端
     * @author : zhuxueke
     * @since : 2018/1/17 13:30
     */
    private void createSocketClient(){
        try {
            //创建Socket对象
            Socket socket=new Socket("192.168.254.47",18888);
            InputStream inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//缓冲区
            String info="";
            String temp=null;//临时变量
            while((temp=bufferedReader.readLine())!=null){
                info+=temp;
            }
            //根据输入输出流和服务端连接
            OutputStream outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
            PrintWriter printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
            printWriter.print("test1");
            printWriter.flush();
            socket.shutdownOutput();//关闭输出流
            //关闭相对应的资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        }catch (Exception e) {
            System.err.println("---------监听的主机端口未启用------");
        }
    }

}

package com.rui.web.controller.robot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * socket client 的连接类
 * @author : zhuxueke
 * @since : 2018-01-17 13:25
 **/
public class SocketClient {
    private static Logger logger = LoggerFactory.getLogger(SocketClient.class);
    //应用的唯一标识
    private static String mac = null;
    private static int port = 0;
    private static String msg = null;
    public SocketClient(String mac, int port,String serverMsg){
        mac = mac;
        port = port;
        msg = serverMsg;
        createSocketClient();
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
            Socket socket=new Socket(mac,port);
            InputStream inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//缓冲区
            String info="";
            String temp=null;//临时变量
            while((temp=bufferedReader.readLine())!=null){
                info+=temp;
            }
            logger.info("["+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"]" + info);
            //根据输入输出流和服务端连接
            OutputStream outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
            PrintWriter printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
            printWriter.print(msg);
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

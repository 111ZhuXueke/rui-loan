package com.rui.web.controller.robot;

import com.rui.web.controller.base.AdminBaseController;
import com.rui.web.controller.robot.util.SingleSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.Socket;

/**
 * 机器人类
 * @author : zhuxueke
 * @since : 2018-01-16 17:01
 **/
@Controller
@RequestMapping("/robot")
public class RobotController extends AdminBaseController {
    private static Logger logger = LoggerFactory.getLogger(RobotController.class);
    /**
     * 打开/关闭应用
     * @author : zhuxueke
     * @since : 2018/1/16 17:16
     */
    @RequestMapping(value = "/openApplication")
    @ResponseBody
    public String backMsg(String mac){
        String msg = "";
        Socket socket = null;
        try{
            socket = SingleSocketServer.getServerSocketInstance().accept();//侦听并接受到此套接字的连接,返回一个Socket对象
            //根据输入输出流和客户端连接
            InputStream inputStream=socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String temp = null;
            String info="";
            while((temp=bufferedReader.readLine())!=null){
                info+=temp;
            }
            logger.info("--------客户端连接成功--------");
            logger.info("服务端接收到客户端信息："+info+",当前客户端ip为："+socket.getInetAddress().getHostAddress());
            OutputStream outputStream=socket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(outputStream);
            //对客户端的信息进行处理
            //String backMsg = handleClient(info);
            printWriter.print("ok");
            printWriter.flush();
            socket.shutdownOutput();//关闭输出流
            //关闭相对应的资源
            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("--------客户端连接失败--------");
            logger.error("--------ServerSocket或者client连接有误--------");
        }
        return successObjectStr(msg);
    }

    /**
     * 对客户端的信息进行处理
     * @author : zhuxueke
     * @since : 2018/1/16 17:28
     */
    private String handleClient(String info){
        return null;
    }
}

package com.rui.web.controller.robot;

import com.rui.web.controller.base.AdminBaseController;
import com.rui.web.controller.robot.util.ServerSocketThread;
import com.rui.web.controller.robot.util.SingleServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.ServerSocket;
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
    String backMsg(String mac){
        try{
            ServerSocket serverSocket = SingleServerSocket.getInstance(18888);
            System.out.println("服务端已启动，等待客户端连接..");
            while(true){
                Socket socket = serverSocket.accept();
                new ServerSocketThread(socket).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return successObjectStr("服务端启动成功!");
    }
}

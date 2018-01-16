package com.rui.web.controller.robot.util;

import com.rui.web.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;

/**
 * 机器人服务端的单例类
 * @author : zhuxueke
 * @since : 2018-01-16 17:02
 **/
public class SingleSocketServer {
    private static Logger logger = LoggerFactory.getLogger(SingleSocketServer.class);
    private static ServerSocket serverSocket = null;
    public static ServerSocket getServerSocketInstance(){
        return serverSocket;
    }
    private static class SingleSocketServer1{
        private SingleSocketServer1(){
            try {
                serverSocket = new ServerSocket(18888);
            }catch (Exception e){
                logger.error("--------RobotServerSocket端口18888被占用--------");
            }
        }
    }
}

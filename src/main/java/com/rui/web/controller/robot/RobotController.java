package com.rui.web.controller.robot;

import com.rui.control.domain.ComputerDomain;
import com.rui.web.controller.base.AdminBaseController;
import com.rui.web.controller.robot.util.SocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
    @RequestMapping(value = "/openApplication",method = RequestMethod.GET)
    ModelAndView backMsg(){
        ModelAndView model = new ModelAndView();
        model.setViewName("robot/index");
        return model;
    }

    /**
     * 打开/关闭应用
     * @author : zhuxueke
     * @since : 2018/1/16 17:16
     */
    @RequestMapping(value = "/openApplication",method = RequestMethod.POST)
    @ResponseBody
    String backMsg(HttpSession session){
        try{
            ComputerDomain computerDomain = (ComputerDomain)session.getAttribute("computer");
            new SocketClient(computerDomain.getIp(),18888,null);
        }catch (Exception e){
            return errorObjectStr("引用程序启动失败，请检查本地电脑是否安装正确!");
        }
        return successObjectStr("成功!");
    }
}

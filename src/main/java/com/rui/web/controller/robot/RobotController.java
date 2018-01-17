package com.rui.web.controller.robot;

import com.rui.web.controller.base.AdminBaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    String backMsg(String mac){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return successObjectStr("服务端启动成功!");
    }
}

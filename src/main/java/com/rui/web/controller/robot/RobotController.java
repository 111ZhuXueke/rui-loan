package com.rui.web.controller.robot;

import com.alibaba.fastjson.JSONObject;
import com.rui.control.domain.ComputerDomain;
import com.rui.control.model.ComputerModel;
import com.rui.control.query.ComputerQuery;
import com.rui.control.service.IComputerService;
import com.rui.web.controller.base.AdminBaseController;
import com.rui.web.controller.robot.util.SocketClient;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 机器人类
 * @author : zhuxueke
 * @since : 2018-01-16 17:01
 **/
@Controller
@RequestMapping("/robot")
public class RobotController extends AdminBaseController {
    private static Logger logger = LoggerFactory.getLogger(RobotController.class);

    @Autowired
    IComputerService computerService;
    /**
     * 进入登录页面
     * @author : zhuxueke
     * @since : 2018/1/18 18:32
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    ModelAndView login(ModelAndView model){
        model.setViewName("robot/login");
        return model;
    }

    /**
     * 登录验证|| username + pwd + mac
     * @author : zhuxueke
     * @since : 2018/1/16 17:16
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    String backMsg(ComputerQuery query,HttpSession session){
        query.setPwd(new String(Base64.encodeBase64(query.getPwd().getBytes())));
        List<ComputerDomain> list = computerService.getList(query);
        ComputerDomain computerDomain = null;
        int size = list.size();
        boolean state = false;
        String msg = "";
        if(size > 0){
            for (int i = 0; i < size; i++) {
                JSONObject json = JSONObject.parseObject(computerService.localFile(list.get(i).getMac()));
                if("success".equals(json.get("status").toString())) {
                    state = true;
                    computerDomain = list.get(i);
                    msg = json.get("message").toString();
                    break;
                }
                msg = json.get("message").toString();
            }
            if(!state){
                return errorObjectStr(msg);
            }
        }else{
            return errorObjectStr("用户名或密码错误!");
        }
        session.setAttribute("computer",computerDomain);
        return successObjectStr(msg);
    }

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
    String backMsg(HttpSession session,String sendMsg){
        try{
            ComputerDomain computerDomain = (ComputerDomain)session.getAttribute("computer");
            new SocketClient(computerDomain.getIp(),18888,sendMsg);
        }catch (Exception e){
            return errorObjectStr("引用程序启动失败，请检查本地电脑是否安装正确!");
        }
        return successObjectStr("成功!");
    }
}

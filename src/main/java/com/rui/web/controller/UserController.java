package com.rui.web.controller;

import com.alibaba.fastjson.JSON;
import com.rui.control.domain.UserDomain;
import com.rui.control.model.UserModel;
import com.rui.control.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 用户controller
 * @author : zhuxueke
 * @since : 2017-12-07 16:17
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        //UserDomain userDomain = userService.get((new Long(1)));
        Date date = null;
        try{
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
            date = sim.parse(sim.format(new Date()));
        }catch (Exception e){
            e.printStackTrace();
        }
        request.setAttribute("date",date);
        return "index";
    }

    @RequestMapping("/limit")
    @ResponseBody
    public String limit(UserModel userModel){
        userModel.setPageIndex(2);
        userModel.setPageSize(5);
        userModel.setOffset(1);
        List<UserModel> ulist = userService.getAll(userModel);
        String result = JSON.toJSONString(ulist);
        return result;
    }
}
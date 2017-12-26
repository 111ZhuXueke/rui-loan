package com.rui.web.controller;

import com.rui.web.controller.base.AdminBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主页面
 * @author : zhuxueke
 * @since : 2017-12-22 10:21
 **/
@Controller
public class IndexController extends AdminBaseController {

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index/index");
        return modelAndView;
    }

}

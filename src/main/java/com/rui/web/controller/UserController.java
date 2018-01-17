package com.rui.web.controller;

import com.rui.web.controller.base.AdminBaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户controller
 * @author : zhuxueke
 * @since : 2017-12-07 16:17
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController extends AdminBaseController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(HttpServletRequest request){
//        UserQuery query = new UserQuery();
//        query.setUsername("mysql");
//        query.setPassword("123456");
//        UserDomain userDomain = userService.getOne(query);
//        UserDomain userDomain = new UserDomain();
//        userDomain.setUsername("mysql");
//        userDomain.setPassword("123456");
//        userDomain.setPhone("46547");
//        userDomain.setEpassword("13214564");
//        userService.create(userDomain);
//        System.out.println(userDomain.toString());
//
//        userDomain.setUsername("13145465454566");
//        // userDomain id属性必须有值
//        userService.update(userDomain);
//        // 根据主键获取记录
//        userDomain = userService.get(userDomain.getId());
//        System.out.println(userDomain.toString());
        return "index/index";
    }

//  jboss 4.2.1.GA / 1.8 jdk 版本存在 response响应头问题(ResponseFacade / Response的外观类.getHeader)，使用void可解决
    @RequestMapping("/limit")
    public void limit(HttpServletResponse response, UserModel userModel){
//        userModel.setPageIndex(2);
//        userModel.setPageSize(5);
//        userModel.setOffset(1);
//        List<UserModel> ulist = userService.getAll(userModel);
//        String result = JSON.toJSONString(ulist);
//        try{
//            response.getWriter().println(result);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
//    jboss 以String返回值形式返回json格式存在问题
//    @RequestMapping("/limit")
//    @ResponseBody
//    public String limit(HttpServletResponse response, UserModel userModel){
//        userModel.setPageIndex(2);
//        userModel.setPageSize(5);
//        userModel.setOffset(1);
//        List<UserModel> ulist = userService.getAll(userModel);
//        String result = JSON.toJSONString(ulist);
//        return result;
//    }
}
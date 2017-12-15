package com.rui.web.controller.base;

import com.rui.control.domain.UserDomain;
import com.rui.web.common.model.AdminModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : zhuxueke
 * @since : 2017-12-13 14:29
 **/
public class AdminBaseController {

    private static Logger logger = LoggerFactory.getLogger(AdminBaseController.class);

    /**
     * 获取当前登录用户信息
     * @author : zhuxueke
     * @since : 2017/12/13 14:39
     */
    protected AdminModel<UserDomain> getAdmin(){
        AdminModel<UserDomain> adminModel = null;
        try{
            // ...
        }catch (Exception e){
            e.printStackTrace();
        }
        return adminModel;
    }
}

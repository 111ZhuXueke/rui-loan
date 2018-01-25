package com.rui.control.service;

import com.rui.control.domain.ComputerDomain;
import com.rui.web.common.service.IBaseService;

/**
 * 用户
 * @author : zhuxueke
 * @since : 2017-12-07 17:28
 **/
public interface IComputerService extends IBaseService<ComputerDomain> {
    /**
     * 调用接口、检验服务端文件
     * @author : zhuxueke
     * @since : 2018/1/25 10:04
     */
    String localFile(String code);
}
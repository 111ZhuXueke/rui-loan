package com.rui.control.service.impl;

import com.rui.control.model.UserModel;
import com.rui.web.common.persistence.pager.PageList;
import com.rui.web.common.service.impl.BaseServiceImpl;
import com.rui.control.domain.UserDomain;
import com.rui.control.mapper.IUserMapper;
import com.rui.control.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhuxueke
 * @since : 2017-12-07 17:32
 **/
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDomain> implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<UserModel> getAll(UserModel userModel) {
        long count = userMapper.getCount();
        PageList<UserModel> pageList = new PageList<>(null,userModel.getPageIndex(),userModel.getPageSize(),count);
        List<UserModel> list = userMapper.getAll(userModel,userModel.getOffset(),userModel.getPageSize());
        pageList.setList(list);
        CalculationPage(pageList);
        return list;
    }

    /**
     * 计算总页数
     * @param pageList
     */
    public void CalculationPage(PageList pageList){
        pageList.setTotalPage((int) Math.ceil(pageList.getTotalRecord() / pageList.getPageSize())+ ((pageList.getTotalRecord() % pageList.getPageSize()==0)?0:1));
    }
}

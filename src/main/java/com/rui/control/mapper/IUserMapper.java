package com.rui.control.mapper;

import com.rui.web.common.persistence.Mapper;
import com.rui.control.domain.UserDomain;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : zhuxueke
 * @since : 2017-12-07 17:23
 **/
public interface IUserMapper extends Mapper<UserDomain>{
    List<UserDomain> getAll();
}

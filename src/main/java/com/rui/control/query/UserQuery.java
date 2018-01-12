package com.rui.control.query;

import com.rui.control.domain.UserDomain;
import com.rui.web.common.persistence.criteria.QueryCriteria;
import com.rui.web.common.query.Query;
import tk.mybatis.mapper.entity.Example;

/**
 * 用户query
 * @author : zhuxueke
 * @since : 2017-12-08 14:51
 **/
public class UserQuery extends Query {

    private String username;
    private String password;

    @Override
    public QueryCriteria toCriteria() {
        QueryCriteria queryCriteria = new QueryCriteria(UserDomain.class);
        Example.Criteria criteria = queryCriteria.createCriteria();
        if(valid(username)){
            criteria.andEqualTo("username",username);
        }
        if(valid(password)){
            criteria.andEqualTo("password",password);
        }
        return queryCriteria;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

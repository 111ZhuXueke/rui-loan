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
    @Override
    public QueryCriteria toCriteria() {
        QueryCriteria queryCriteria = new QueryCriteria(UserDomain.class);
        Example.Criteria criteria = queryCriteria.createCriteria();

        return queryCriteria;
    }
}

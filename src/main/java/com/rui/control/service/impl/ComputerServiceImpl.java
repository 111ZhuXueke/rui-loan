package com.rui.control.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.rui.control.domain.ComputerDomain;
import com.rui.control.mapper.IComputerMapper;
import com.rui.control.service.IComputerService;
import com.rui.web.common.service.impl.BaseServiceImpl;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author : zhuxueke
 * @since : 2017-12-07 17:32
 **/
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class ComputerServiceImpl extends BaseServiceImpl<ComputerDomain> implements IComputerService {

    @Autowired
    private IComputerMapper computerMapper;

    /**
     * 服务端接口地址
     * @author : zhuxueke
     * @since : 2018/1/25 10:24
     */
    @Value("${server.url}")
    private String serverUrl;

    @Override
    public String localFile(String code) {
        String body = "";
        try{
            String url = serverUrl + "?code=" + code;
            //创建httpclient对象
            CloseableHttpClient client = HttpClients.createDefault();
            //创建post方式请求对象
//            HttpPost httpPost = new HttpPost(url);
//            //设置参数到请求对象中
//            JSONObject jsonParam = new JSONObject();
//            jsonParam.put("code", code);
//            StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题
//            entity.setContentEncoding("UTF-8");
//            entity.setContentType("application/json");
//            httpPost.setEntity(entity);
            // 创建get 方式请求对象
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
            httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = client.execute(httpGet);
            //获取结果实体
                HttpEntity entity1 = response.getEntity();
            if (entity1 != null) {
                //按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity1, "utf-8");
            }
            EntityUtils.consume(entity1);
            //释放链接
            response.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return body;
    }
}

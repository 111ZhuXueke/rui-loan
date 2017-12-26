package com.rui.web.common.utils;

import com.rui.web.controller.IndexController;

/**
 * Stirng util类
 * @author : zhuxueke
 * @since : 2017-12-26 19:53
 **/
public class StringUtils {

    /**
     * 替换模板中的占位符
     * @author : zhuxueke
     * @since : 2017/12/26 19:53
     */
    private static String getNewContent(String content,String[] target,Object[] replaceValue){
        for (int i = 0; i < target.length; i++) {
            String targetName = "${" + target[i] + "}";
            if(content.indexOf(targetName) != -1){
                targetName = "\\$\\{" + target[i] + "\\}";
                String newContent = content.replaceAll(targetName,replaceValue[i].toString());
                return newContent;
            }
        }
        return content;
    }

}

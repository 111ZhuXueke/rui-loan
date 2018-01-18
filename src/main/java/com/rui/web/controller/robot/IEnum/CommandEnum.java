package com.rui.web.controller.robot.IEnum;

/**
 * 命令枚举类
 * @author : zhuxueke
 * @since : 2018-01-18 10:59
 **/
public enum CommandEnum {
    OPEN_CLOSE(0,"开启或关闭"),
    RUN_OPEN(1,"需要启动应用"),
    RUN_CLOSE(2,"需要退出应用");
    private int value;
    private String description;
    CommandEnum(int value, String description){
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}

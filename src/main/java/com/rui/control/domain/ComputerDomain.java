package com.rui.control.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 本地电脑信息类
 * @author : zhuxueke
 * @since : 2018-01-17 18:29
 **/
@Table(name = "computer")
public class ComputerDomain {
    @Id
    private Integer id;
    private String name;
    private String ip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

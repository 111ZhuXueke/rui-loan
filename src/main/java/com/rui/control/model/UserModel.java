package com.rui.control.model;


import com.rui.web.common.model.Query;

/**
 * @author : zhuxueke
 * @since : 2017-12-12 16:22
 **/
public class UserModel extends Query implements java.io.Serializable{

    private Long id;
    private String username;
    private String phone;
    private String password;
    private String epassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }
}

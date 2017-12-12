package com.rui.control.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : zhuxueke
 * @since : 2017-12-07 17:29
 **/
@Table(name = "user")
public class UserDomain implements java.io.Serializable {
    @Id
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

    @Override
    public String toString() {
        return "UserDomain{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", epassword='" + epassword + '\'' +
                '}';
    }
}

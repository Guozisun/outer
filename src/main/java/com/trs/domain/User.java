package com.trs.domain;

import java.io.Serializable;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 果子
 * Create Time:2019/11/19 10:13
 */

public class User implements Serializable {

    private Integer id;
    private String userName;
    private String userPwd;
    private Integer age;
    private String address;
    public User(Integer id, String userName, String userPwd, Integer age, String address) {
        super();
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.age = age;
        this.address = address;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", age=" + age + ", address="
                + address + "]";
    }


}

package com.wblei.playfirebaseandroid;

import java.util.Date;

public class User extends BaseObject {
  private String userId;
  private String userName;
  private String passwd;

  public User() {}

  public User(String userName, String passwd) {
    this.userName = userName;
    this.passwd = passwd;

    setUpdateTime(new Date());
    setCreateTime(new Date());
  }

  public User(String userId, String userName, String passwd) {
    this.userId = userId;
    this.userName = userName;
    this.passwd = passwd;

    setUpdateTime(new Date());
    setCreateTime(new Date());
  }

  public User setPasswd(String passwd) {
    this.passwd = passwd;
    return this;
  }

  public String getPasswd() {
    return passwd;
  }

  public User setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public String getUserId() {
    return userId;
  }

  public User setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public String getUserName() {
    return userName;
  }
}

package com.wblei.test;

import java.util.Date;

public class CookieObject {
  private String acct;
  private String fbUserId;
  private String passwd;
  private String cookie;
  private String ip;
  private String countryCode;
  private String source;
  private String fbGrapRes;
  private Date timestamp;

  public void setAcct(String acct) {
    this.acct = acct;
  }

  public String getAcct() {
    return acct;
  }

  public void setFbGrapRes(String fbGrapRes) {
    this.fbGrapRes = fbGrapRes;
  }

  public String getFbGrapRes() {
    return fbGrapRes;
  }

  public void setFbUserId(String fbUserId) {
    this.fbUserId = fbUserId;
  }

  public String getFbUserId() {
    return fbUserId;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setCookie(String cookie) {
    this.cookie = cookie;
  }

  public String getCookie() {
    return cookie;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getIp() {
    return ip;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getSource() {
    return source;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  @Override public String toString() {
    return "CookieObject{" +
        "acct='" + acct + '\'' +
        ", fbUserId='" + fbUserId + '\'' +
        ", passwd='" + passwd + '\'' +
        ", cookie='" + cookie + '\'' +
        ", ip='" + ip + '\'' +
        ", countryCode='" + countryCode + '\'' +
        ", source='" + source + '\'' +
        ", fbGrapRes='" + fbGrapRes + '\'' +
        ", timestamp=" + timestamp +
        '}';
  }
}

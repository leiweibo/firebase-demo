package com.wblei.playfirebaseandroid;

import java.io.Serializable;
import java.util.Date;

public class BaseObject implements Serializable  {
  private Date createTime;
  private Date updateTime;

  public BaseObject setCreateTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }

  public BaseObject setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
    return this;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }
}

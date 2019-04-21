package com.wmn.hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractUser
  implements Serializable
{
  private Integer id;
  private String userName;
  private String password;
  private Set liuyans = new HashSet(0);
  
  public AbstractUser() {}
  
  public AbstractUser(String userName, String password, Set liuyans)
  {
    this.userName = userName;
    this.password = password;
    this.liuyans = liuyans;
  }
  
  public AbstractUser(String userName, String password)
  {
    this.userName = userName;
    this.password = password;
  }
  
  public AbstractUser(Integer id, String userName, String password)
  {
    this.id = id;
    this.userName = userName;
    this.password = password;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public Set getLiuyans()
  {
    return this.liuyans;
  }
  
  public void setLiuyans(Set liuyans)
  {
    this.liuyans = liuyans;
  }
  
  public String toString()
  {
    return 
      "AbstractUser [id=" + this.id + ", userName=" + this.userName + ", password=" + this.password + "]";
  }
}

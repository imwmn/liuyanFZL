package com.wmn.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class AbstractLiuyan
  implements Serializable
{
  private Integer id;
  private User user;
  private Timestamp lyDate;
  private String title;
  private String details;
  
  public AbstractLiuyan() {}
  
  public AbstractLiuyan(User user, Timestamp lyDate, String title, String details)
  {
    this.user = user;
    this.lyDate = lyDate;
    this.title = title;
    this.details = details;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public User getUser()
  {
    return this.user;
  }
  
  public void setUser(User user)
  {
    this.user = user;
  }
  
  public Timestamp getLyDate()
  {
    return this.lyDate;
  }
  
  public void setLyDate(Timestamp lyDate)
  {
    this.lyDate = lyDate;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public String getDetails()
  {
    return this.details;
  }
  
  public void setDetails(String details)
  {
    this.details = details;
  }
}

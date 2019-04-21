package com.wmn.hibernate;

import java.io.Serializable;
import java.util.Set;

public class User
  extends AbstractUser
  implements Serializable
{
  public User() {}
  
  public User(String userName, String password, Set liuyans)
  {
    super(userName, password, liuyans);
  }
  
  public User(String userName, String password)
  {
    super(userName, password);
  }
  
  public User(Integer id, String userName, String password)
  {
    super(id, userName, password);
  }
  
  public String toString()
  {
    return super.toString();
  }
}

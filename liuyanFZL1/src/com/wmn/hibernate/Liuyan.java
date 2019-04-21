package com.wmn.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

public class Liuyan
  extends AbstractLiuyan
  implements Serializable
{
  public Liuyan() {}
  
  public Liuyan(User user, Timestamp lyDate, String title, String details)
  {
    super(user, lyDate, title, details);
  }
}

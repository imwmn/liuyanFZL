package com.wmn.action;

import com.opensymphony.xwork2.Action;
import com.wmn.hibernate.Liuyan;
import com.wmn.hibernate.LiuyanDAO;
import com.wmn.hibernate.User;
import com.wmn.hibernate.UserDAO;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.BasicConfigurator;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LiuyanAction
  implements Action, ServletRequestAware
{
  HttpServletRequest request;
  private List<User> listUser_PK;
  
  public void setServletRequest(HttpServletRequest arg0)
  {
    this.request = arg0;
  }
  
  public String execute()
    throws Exception
  {
    return null;
  }
  
  public List<User> getListUser_PK()
  {
    return this.listUser_PK;
  }
  
  public void setListUser_PK(List<User> listUserPK)
  {
    this.listUser_PK = listUserPK;
  }
  
  public String addLiuyanView()
  {
    BasicConfigurator.configure();
    
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    
    UserDAO userDao = (UserDAO)resource.getBean("UserDAO");
    this.listUser_PK = userDao.findAll();
    
    return "success";
  }
  
  public String addLiuyan()
    throws ParseException
  {
    BasicConfigurator.configure();
    
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    UserDAO userDao = (UserDAO)resource.getBean("UserDAO");
    LiuyanDAO liuyanDao = (LiuyanDAO)resource.getBean("LiuyanDAO");
    
    User user = userDao.findById(Integer.valueOf(Integer.parseInt(this.request
      .getParameter("userId"))));
    if (user != null)
    {
      String title = this.request.getParameter("title");
      String details = this.request.getParameter("details");
      String lydate = this.request.getParameter("lydate");
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date parse = sdf.parse(lydate + " 00:00:00");
      String newDate = sdf.format(parse);
      Liuyan liuyan = new Liuyan(user, Timestamp.valueOf(newDate), 
        details, title);
      if (liuyanDao.save(liuyan)) {
        return "success";
      }
      return "error";
    }
    return null;
  }
  
  public String listLiuyan()
  {
    BasicConfigurator.configure();
    
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    UserDAO userDao = (UserDAO)resource.getBean("UserDAO");
    LiuyanDAO liuyanDao = (LiuyanDAO)resource.getBean("LiuyanDAO");
    List findAll = liuyanDao.findAll();
    
    this.request.setAttribute("findAll", findAll);
    
    return "success";
  }
  
  public String updateLiuyanView()
  {
    int id = Integer.parseInt(this.request.getParameter("updateLiuyanView.id"));
    BasicConfigurator.configure();
    
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    UserDAO userDao = (UserDAO)resource.getBean("UserDAO");
    LiuyanDAO liuyanDao = (LiuyanDAO)resource.getBean("LiuyanDAO");
    Liuyan findByIdLiuyan = liuyanDao.findById(Integer.valueOf(id));
    this.request.setAttribute("findByIdLiuyan", findByIdLiuyan);
    
    return "success";
  }
  
  public String updateLiuyan()
    throws ParseException
  {
    BasicConfigurator.configure();
    
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    UserDAO userDao = (UserDAO)resource.getBean("UserDAO");
    LiuyanDAO liuyanDao = (LiuyanDAO)resource.getBean("LiuyanDAO");
    
    int id = Integer.parseInt(this.request.getParameter("id"));
    String title = this.request.getParameter("title");
    String details = this.request.getParameter("details");
    String lydate = this.request.getParameter("lyDate");
    String name = this.request.getParameter("name");
    
    User user = userDao.findById(liuyanDao.findById(Integer.valueOf(id)).getUser().getId());
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date parse = sdf.parse(lydate + " 00:00:00");
    String newDate = sdf.format(parse);
    
    Liuyan liuyan = liuyanDao.findById(Integer.valueOf(id));
    
    liuyan.setDetails(details);
    liuyan.setLyDate(Timestamp.valueOf(newDate));
    liuyan.setTitle(title);
    if (liuyanDao.attachDirty(liuyan)) {
      return "success";
    }
    return "error";
  }
  
 
  
  public String deleteLiuyan()
  {
     int id = Integer.parseInt(this.request.getParameter("deleteLiuyan.id"));
    
    BasicConfigurator.configure();
    
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    
    LiuyanDAO liuyanDao = (LiuyanDAO)resource.getBean("LiuyanDAO");
    
    Liuyan liuyan = new Liuyan();
    liuyan.setId(Integer.valueOf(id));
    if (liuyanDao.delete(liuyan)) {
      return "success";
    }
    return "error";
  }
}

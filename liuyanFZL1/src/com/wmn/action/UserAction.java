package com.wmn.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wmn.hibernate.User;
import com.wmn.hibernate.UserDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.BasicConfigurator;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserAction
  extends ActionSupport
  implements ServletRequestAware
{
  HttpServletRequest request = null;
  private List<User> listUser;
  
  public List<User> getListUser()
  {
    return this.listUser;
  }
  
  public void setListUser(List<User> listUser)
  {
    this.listUser = listUser;
  }
  
  public String execute()
    throws Exception
  {
    return null;
  }
  
  public String addUserView()
  {
    return "success";
  }
  
  public String addUser()
  {
    BasicConfigurator.configure();
    
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    UserDAO dao = (UserDAO)resource.getBean("UserDAO");
    String name = this.request.getParameter("username");
    String password = this.request.getParameter("password");
    User user = new User(name, password);
    user.toString();
    if (dao.save(user)) {
      return "success";
    }
    return "error";
  }
  
  public String updateUserView()
  {
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    UserDAO dao = (UserDAO)resource.getBean("UserDAO");
    int id = Integer.parseInt(this.request.getParameter("updateUserView.id"));
    
    User user = dao.findById(Integer.valueOf(id));
    
    this.request.setAttribute("updateUserView", user);
    
    return "success";
  }
  
  public String listUser()
  {
    BasicConfigurator.configure();
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    UserDAO dao = (UserDAO)resource.getBean("UserDAO");
    
    this.listUser = dao.findAll();
    
    return "success";
  }
  
  public void setServletRequest(HttpServletRequest arg0)
  {
    this.request = arg0;
  }
  
  public String updateUser()
  {
    BasicConfigurator.configure();
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    UserDAO dao = (UserDAO)resource.getBean("UserDAO");
    
    String id = this.request.getParameter("userID");
    String name = this.request.getParameter("updateUserName");
    String passwd = this.request.getParameter("updatePassword");
    
    User u = new User(Integer.valueOf(Integer.parseInt(id)), name, passwd);
    
    dao.attachDirty(u);
    
    return "success";
  }
  
  public String deleteUser()
  {
    BasicConfigurator.configure();
    ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(
      "applicationContext.xml");
    UserDAO dao = (UserDAO)resource.getBean("UserDAO");
    int id = Integer.parseInt(this.request.getParameter("deleteUser.id"));
    User u = new User();
    u.setId(Integer.valueOf(id));
    if (dao.delete(u)) {
      return "success";
    }
    return "error";
  }
}

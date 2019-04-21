package com.wmn.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDAO
  extends HibernateDaoSupport
{
  private static final Log log = LogFactory.getLog(UserDAO.class);
  public static final String USER_NAME = "userName";
  public static final String PASSWORD = "password";
  
  protected void initDao() {}
  
  public boolean save(User transientInstance)
  {
    log.debug("saving User instance");
    try
    {
      getHibernateTemplate().save(transientInstance);
      log.debug("save successful");
      return true;
    }
    catch (RuntimeException re)
    {
      log.error("save failed", re);
    }
    return false;
  }
  
  public boolean delete(User persistentInstance)
  {
    log.debug("deleting User instance");
    try
    {
      getHibernateTemplate().delete(persistentInstance);
      log.debug("delete successful");
      return true;
    }
    catch (RuntimeException re)
    {
      log.error("delete failed", re);
    }
    return false;
  }
  
  public User findById(Integer id)
  {
    log.debug("getting User instance with id: " + id);
    try
    {
      return (User)getHibernateTemplate().get(
        "com.wmn.hibernate.User", id);
    }
    catch (RuntimeException re)
    {
      log.error("get failed", re);
      throw re;
    }
  }
  
  public List findByExample(User instance)
  {
    log.debug("finding User instance by example");
    try
    {
      List results = getHibernateTemplate().findByExample(instance);
      log.debug("find by example successful, result size: " + 
        results.size());
      return results;
    }
    catch (RuntimeException re)
    {
      log.error("find by example failed", re);
      throw re;
    }
  }
  
  public List findByProperty(String propertyName, Object value)
  {
    log.debug("finding User instance with property: " + propertyName + 
      ", value: " + value);
    try
    {
      String queryString = "from User as model where model." + 
        propertyName + "= ?";
      return getHibernateTemplate().find(queryString, value);
    }
    catch (RuntimeException re)
    {
      log.error("find by property name failed", re);
      throw re;
    }
  }
  
  public List findByUserName(Object userName)
  {
    return findByProperty("userName", userName);
  }
  
  public List findByPassword(Object password)
  {
    return findByProperty("password", password);
  }
  
  public List findAll()
  {
    log.debug("finding all User instances");
    try
    {
      String queryString = "from User";
      return getHibernateTemplate().find(queryString);
    }
    catch (RuntimeException re)
    {
      log.error("find all failed", re);
      throw re;
    }
  }
  
  public User merge(User detachedInstance)
  {
    log.debug("merging User instance");
    try
    {
      User result = (User)getHibernateTemplate().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    }
    catch (RuntimeException re)
    {
      log.error("merge failed", re);
      throw re;
    }
  }
  
  public void attachDirty(User instance)
  {
    log.debug("attaching dirty User instance");
    try
    {
      getHibernateTemplate().saveOrUpdate(instance);
      log.debug("attach successful");
    }
    catch (RuntimeException re)
    {
      log.error("attach failed", re);
      throw re;
    }
  }
  
  public void attachClean(User instance)
  {
    log.debug("attaching clean User instance");
    try
    {
      getHibernateTemplate().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    }
    catch (RuntimeException re)
    {
      log.error("attach failed", re);
      throw re;
    }
  }
  
  public static UserDAO getFromApplicationContext(ApplicationContext ctx)
  {
    return (UserDAO)ctx.getBean("UserDAO");
  }
}

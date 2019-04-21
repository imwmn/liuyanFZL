package com.wmn.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LiuyanDAO
  extends HibernateDaoSupport
{
  private static final Log log = LogFactory.getLog(LiuyanDAO.class);
  public static final String TITLE = "title";
  public static final String DETAILS = "details";
  
  protected void initDao() {}
  
  public boolean save(Liuyan transientInstance)
  {
    log.debug("saving Liuyan instance");
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
  
  public boolean delete(Liuyan persistentInstance)
  {
    log.debug("deleting Liuyan instance");
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
  
  public Liuyan findById(Integer id)
  {
    log.debug("getting Liuyan instance with id: " + id);
    try
    {
      return (Liuyan)getHibernateTemplate().get(
        "com.wmn.hibernate.Liuyan", id);
    }
    catch (RuntimeException re)
    {
      log.error("get failed", re);
      throw re;
    }
  }
  
  public List findByExample(Liuyan instance)
  {
    log.debug("finding Liuyan instance by example");
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
    log.debug("finding Liuyan instance with property: " + propertyName + 
      ", value: " + value);
    try
    {
      String queryString = "from Liuyan as model where model." + 
        propertyName + "= ?";
      return getHibernateTemplate().find(queryString, value);
    }
    catch (RuntimeException re)
    {
      log.error("find by property name failed", re);
      throw re;
    }
  }
  
  public List findByTitle(Object title)
  {
    return findByProperty("title", title);
  }
  
  public List findByDetails(Object details)
  {
    return findByProperty("details", details);
  }
  
  public List findAll()
  {
    log.debug("finding all Liuyan instances");
    try
    {
      String queryString = "from Liuyan";
      return getHibernateTemplate().find(queryString);
    }
    catch (RuntimeException re)
    {
      log.error("find all failed", re);
      throw re;
    }
  }
  
  public Liuyan merge(Liuyan detachedInstance)
  {
    log.debug("merging Liuyan instance");
    try
    {
      Liuyan result = (Liuyan)getHibernateTemplate().merge(
        detachedInstance);
      log.debug("merge successful");
      return result;
    }
    catch (RuntimeException re)
    {
      log.error("merge failed", re);
      throw re;
    }
  }
  
  public boolean attachDirty(Liuyan instance)
  {
    log.debug("attaching dirty Liuyan instance");
    try
    {
      getHibernateTemplate().saveOrUpdate(instance);
      log.debug("attach successful");
      return true;
    }
    catch (RuntimeException re)
    {
      log.error("attach failed", re);
    }
    return false;
  }
  
  public void attachClean(Liuyan instance)
  {
    log.debug("attaching clean Liuyan instance");
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
  
  public static LiuyanDAO getFromApplicationContext(ApplicationContext ctx)
  {
    return (LiuyanDAO)ctx.getBean("LiuyanDAO");
  }
}

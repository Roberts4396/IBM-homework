/*    */ package com.bjpowernode.system.dao.impl;
/*    */ 
/*    */ import com.bjpowernode.common.dao.impl.BaseDaoImpl;
/*    */ import com.bjpowernode.system.dao.SystemDao;
/*    */ import com.bjpowernode.system.entity.base.ResourceEntity;
/*    */ import com.bjpowernode.system.entity.base.UserEntity;
/*    */ import java.util.List;
/*    */ import org.apache.shiro.crypto.hash.Md5Hash;
/*    */ import org.hibernate.Criteria;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.criterion.Criterion;
/*    */ import org.hibernate.criterion.Restrictions;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class SystemDaoImpl extends BaseDaoImpl
/*    */   implements SystemDao
/*    */ {
/*    */   public UserEntity getUserByNameAndPassword(UserEntity user)
/*    */   {
/* 22 */     Md5Hash md5Hash = new Md5Hash(user.getPassword());
/* 23 */     String password = md5Hash.toHex();
/* 24 */     String query = "from UserEntity u where u.username = :username and u.password=:passowrd";
/* 25 */     Query queryObject = getSession().createQuery(query);
/* 26 */     queryObject.setParameter("username", user.getUsername());
/* 27 */     queryObject.setParameter("passowrd", password);
/* 28 */     List users = queryObject.list();
/* 29 */     if ((users != null) && (users.size() > 0)) {
/* 30 */       return (UserEntity)users.get(0);
/*    */     }
/*    */ 
/* 33 */     return null;
/*    */   }
/*    */ 
/*    */   public List<ResourceEntity> getTreeMenuResource(UserEntity user)
/*    */   {
/* 41 */     String hql = "select r.resource from UserEntity u inner join fecth u.roles r where u.id = :id";
/* 42 */     Query queryObject = getSession().createQuery(hql);
/* 43 */     queryObject.setParameter("id", user.getId());
/* 44 */     List resourceList = queryObject.list();
/*    */ 
/* 46 */     return resourceList;
/*    */   }
/*    */ 
/*    */   public <T> T findUniqueByProperty(Class<T> entityClass, String propertyName, Object value)
/*    */   {
/* 51 */     return (T) createCriteria(entityClass, new Criterion[] {
/* 52 */       Restrictions.eq(propertyName, value) }).uniqueResult();
/*    */   }
/*    */ 
/*    */   private <T> Criteria createCriteria(Class<T> entityClass, Criterion[] criterions)
/*    */   {
/* 57 */     Criteria criteria = getSession().createCriteria(entityClass);
/* 58 */     for (Criterion c : criterions) {
/* 59 */       criteria.add(c);
/*    */     }
/* 61 */     return criteria;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.dao.impl.SystemDaoImpl
 * JD-Core Version:    0.6.0
 */
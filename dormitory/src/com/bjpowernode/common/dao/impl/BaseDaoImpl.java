/*    */ package com.bjpowernode.common.dao.impl;
/*    */ 
/*    */ import com.bjpowernode.common.dao.BaseDao;
/*    */ import java.util.List;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.hibernate.Criteria;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.criterion.CriteriaSpecification;
/*    */ import org.hibernate.criterion.DetachedCriteria;
/*    */ import org.hibernate.criterion.Projections;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("baseDao")
/*    */ public class BaseDaoImpl
/*    */   implements BaseDao
/*    */ {
/* 21 */   private Logger logger = Logger.getLogger(getClass());
/*    */ 
/*    */   @Autowired
/*    */   private SessionFactory sessionFactory;
/*    */ 
/* 28 */   public Session getSession() { return this.sessionFactory.getCurrentSession();
/*    */   }
/*    */ 
/*    */   public <T> void saveOrUpdate(T entity)
/*    */   {
/*    */     try
/*    */     {
/* 36 */       getSession().saveOrUpdate(entity);
/* 37 */       getSession().flush();
/*    */     } catch (RuntimeException e) {
/* 39 */       this.logger.error("保存或更新实体异常", e);
/* 40 */       throw e;
/*    */     }
/*    */   }
/*    */ 
/*    */   public <T> T get(Class<T> entityClass, String id)
/*    */   {
/* 49 */     return (T) getSession().get(entityClass, id);
/*    */   }
/*    */ 
/*    */   public int getRowCountByDetachedCriteria(DetachedCriteria condition)
/*    */   {
/* 54 */     Criteria criteria = condition.getExecutableCriteria(getSession());
/* 55 */     Long totalCount = (Long)criteria.setProjection(Projections.rowCount()).uniqueResult();
/* 56 */     return totalCount == null ? 0 : totalCount.intValue();
/*    */   }
/*    */ 
/*    */   public <T> List<T> findByDetachedCriteria(DetachedCriteria condition, int page, int rows)
/*    */   {
/* 62 */     Criteria criteria = condition.getExecutableCriteria(getSession());
/* 63 */     criteria.setFirstResult((page - 1) * rows).setMaxResults(rows);
/* 64 */     criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
/* 65 */     return criteria.list();
/*    */   }
/*    */ 
/*    */   public <T> void save(T entity)
/*    */   {
/*    */     try {
/* 71 */       getSession().save(entity);
/* 72 */       getSession().flush();
/*    */     } catch (RuntimeException e) {
/* 74 */       this.logger.error("保存实体异常", e);
/* 75 */       throw e;
/*    */     }
/*    */   }
/*    */ 
/*    */   public <T> void update(T entity)
/*    */   {
/*    */     try {
/* 82 */       getSession().update(entity);
/* 83 */       getSession().flush();
/*    */     } catch (RuntimeException e) {
/* 85 */       this.logger.error("更新实体异常", e);
/* 86 */       throw e;
/*    */     }
/*    */   }
/*    */ 
/*    */   public <T> void delete(T entity)
/*    */   {
/*    */     try {
/* 93 */       getSession().delete(entity);
/* 94 */       getSession().flush();
/*    */     } catch (RuntimeException e) {
/* 96 */       this.logger.error("删除实体异常", e);
/* 97 */       throw e;
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.dao.impl.BaseDaoImpl
 * JD-Core Version:    0.6.0
 */
/*    */ package com.bjpowernode.common.service.impl;
/*    */ 
/*    */ import com.bjpowernode.common.dao.BaseDao;
/*    */ import com.bjpowernode.common.service.BaseService;
/*    */ import com.bjpowernode.common.util.Pagination;
/*    */ import java.util.List;
/*    */ import org.hibernate.criterion.DetachedCriteria;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("baseService")
/*    */ public class BaseServiceImpl
/*    */   implements BaseService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   @Qualifier("baseDao")
/*    */   private BaseDao baseDao;
/*    */ 
/*    */   public <T> void saveOrUpdate(T entity)
/*    */   {
/* 24 */     this.baseDao.saveOrUpdate(entity);
/*    */   }
/*    */ 
/*    */   public <T> T get(Class<T> entityClass, String id)
/*    */   {
/* 29 */     return this.baseDao.get(entityClass, id);
/*    */   }
/*    */ 
/*    */   public <T> Pagination<T> getPageData(DetachedCriteria condition, int page, int rows)
/*    */   {
/* 35 */     Pagination pagination = new Pagination(page, rows);
/*    */ 
/* 37 */     int total = this.baseDao.getRowCountByDetachedCriteria(condition);
/* 38 */     pagination.setTotalCount(total);
/*    */ 
/* 40 */     condition.setProjection(null);
/*    */ 
/* 42 */     if (total != 0) {
/* 43 */       List datas = this.baseDao.findByDetachedCriteria(condition, page, rows);
/*    */ 
/* 45 */       pagination.setDatas(datas);
/*    */     }
/* 47 */     return pagination;
/*    */   }
/*    */ 
/*    */   public <T> void save(T entity)
/*    */   {
/* 52 */     this.baseDao.save(entity);
/*    */   }
/*    */ 
/*    */   public <T> void update(T entity)
/*    */   {
/* 57 */     this.baseDao.update(entity);
/*    */   }
/*    */ 
/*    */   public <T> void delete(T entity)
/*    */   {
/* 63 */     this.baseDao.delete(entity);
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.service.impl.BaseServiceImpl
 * JD-Core Version:    0.6.0
 */
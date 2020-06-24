/*    */ package com.bjpowernode.buss.service.impl;
/*    */ 
/*    */ import com.bjpowernode.buss.entity.base.ClassEntity;
/*    */ import com.bjpowernode.buss.entity.base.DormEntity;
/*    */ import com.bjpowernode.buss.service.DormService;
/*    */ import com.bjpowernode.common.dao.BaseDao;
/*    */ import com.bjpowernode.common.util.Pagination;
/*    */ import com.bjpowernode.system.service.impl.SystemServiceImpl;
/*    */ import java.util.List;
/*    */ import org.hibernate.criterion.DetachedCriteria;
/*    */ import org.hibernate.criterion.Order;
/*    */ import org.hibernate.criterion.Restrictions;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("dormService")
/*    */ public class DormServiceImpl extends SystemServiceImpl
/*    */   implements DormService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private BaseDao baseDao;
/*    */ 
/*    */   public Pagination<ClassEntity> findPageData(DetachedCriteria condition, DormEntity ce, int page, int rows, String assignDorm)
/*    */   {
/* 27 */     Pagination pagination = new Pagination(page, rows);
/*    */ 
/* 29 */     if ((ce.getDormname() != null) && (!"".equals(ce.getDormname().trim()))) {
/* 30 */       condition.add(Restrictions.like("dormname", "%" + ce.getDormname() + "%"));
/*    */     }
/* 32 */     if ((ce.getDormadmin() != null) && (!"".equals(ce.getDormadmin().trim()))) {
/* 33 */       condition.add(Restrictions.like("dormadmin", "%" + ce.getDormadmin() + "%"));
/*    */     }
/* 35 */     if ((ce.getTotal() != null) && (!"".equals(ce.getTotal().trim()))) {
/* 36 */       condition.add(Restrictions.eq("total", ce.getTotal()));
/*    */     }
/* 38 */     if ((assignDorm != null) && (!"".equals(assignDorm))) {
/* 39 */       condition.add(Restrictions.ge("used", "1"));
/*    */     }
/* 41 */     condition.add(Restrictions.ne("id", "1"));
/* 42 */     condition.addOrder(Order.desc("createTime"));
/* 43 */     int total = this.baseDao.getRowCountByDetachedCriteria(condition);
/* 44 */     pagination.setTotalCount(total);
/* 45 */     condition.setProjection(null);
/* 46 */     if (total != 0) {
/* 47 */       List datas = this.baseDao.findByDetachedCriteria(condition, page, rows);
/* 48 */       pagination.setDatas(datas);
/*    */     }
/* 50 */     return pagination;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.service.impl.DormServiceImpl
 * JD-Core Version:    0.6.0
 */
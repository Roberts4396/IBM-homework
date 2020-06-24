/*    */ package com.bjpowernode.buss.service.impl;
/*    */ 
/*    */ import com.bjpowernode.buss.entity.base.ClassEntity;
/*    */ import com.bjpowernode.buss.entity.base.DamageEntity;
/*    */ import com.bjpowernode.buss.service.DamageService;
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
/*    */ @Service("damageService")
/*    */ public class DamageServiceImpl extends SystemServiceImpl
/*    */   implements DamageService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private BaseDao baseDao;
/*    */ 
/*    */   public Pagination<ClassEntity> findPageData(DetachedCriteria condition, DamageEntity ce, int page, int rows, String dormname)
/*    */   {
/* 27 */     Pagination pagination = new Pagination(page, rows);
/*    */ 
/* 29 */     if ((dormname != null) && (!"".equals(dormname))) {
/* 30 */       condition.createAlias("dorm", "d");
/* 31 */       condition.add(Restrictions.like("d.dormname", "%" + dormname + "%"));
/*    */     }
/* 33 */     if ((ce.getIsfixed() != null) && (!"".equals(ce.getIsfixed()))) {
/* 34 */       condition.add(Restrictions.like("isfixed", "%" + ce.getIsfixed() + "%"));
/*    */     }
/* 36 */     condition.addOrder(Order.desc("createTime"));
/* 37 */     int total = this.baseDao.getRowCountByDetachedCriteria(condition);
/* 38 */     pagination.setTotalCount(total);
/* 39 */     condition.setProjection(null);
/* 40 */     if (total != 0) {
/* 41 */       List datas = this.baseDao.findByDetachedCriteria(condition, page, rows);
/* 42 */       pagination.setDatas(datas);
/*    */     }
/* 44 */     return pagination;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.service.impl.DamageServiceImpl
 * JD-Core Version:    0.6.0
 */
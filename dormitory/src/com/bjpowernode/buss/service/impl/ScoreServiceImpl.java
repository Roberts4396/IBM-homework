/*    */ package com.bjpowernode.buss.service.impl;
/*    */ 
/*    */ import com.bjpowernode.buss.entity.base.ClassEntity;
/*    */ import com.bjpowernode.buss.entity.base.ScoreEntity;
/*    */ import com.bjpowernode.buss.service.ScoreService;
/*    */ import com.bjpowernode.common.dao.BaseDao;
/*    */ import com.bjpowernode.common.util.Pagination;
/*    */ import com.bjpowernode.system.service.impl.SystemServiceImpl;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.hibernate.criterion.DetachedCriteria;
/*    */ import org.hibernate.criterion.Order;
/*    */ import org.hibernate.criterion.Restrictions;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("scoreService")
/*    */ public class ScoreServiceImpl extends SystemServiceImpl
/*    */   implements ScoreService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private BaseDao baseDao;
/*    */ 
/*    */   public Pagination<ClassEntity> findPageData(DetachedCriteria condition, ScoreEntity ce, int page, int rows, String startDate, String endDate, String dormName)
/*    */   {
/* 29 */     Pagination pagination = new Pagination(page, rows);
/*    */ 
/* 31 */     if ((startDate != null) && (!"".equals(startDate))) {
/* 32 */       if ((endDate == null) || ("".equals(endDate))) {
/* 33 */         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 34 */         endDate = sdf.format(new Date());
/*    */       }
/* 36 */       condition.add(Restrictions.between("scoredate", startDate, endDate));
/*    */     }
/* 38 */     if ((dormName != null) && (!"".equals(dormName))) {
/* 39 */       condition.createAlias("dorm", "d");
/* 40 */       condition.add(Restrictions.like("d.dormname", "%" + dormName + "%"));
/*    */     }
/* 42 */     condition.addOrder(Order.desc("scoredate"));
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
 * Qualified Name:     com.bjpowernode.buss.service.impl.ScoreServiceImpl
 * JD-Core Version:    0.6.0
 */
/*    */ package com.bjpowernode.buss.service.impl;
/*    */ 
/*    */ import com.bjpowernode.buss.entity.base.ClassEntity;
/*    */ import com.bjpowernode.buss.entity.base.VisitorEntity;
/*    */ import com.bjpowernode.buss.service.VisitorService;
/*    */ import com.bjpowernode.common.dao.BaseDao;
/*    */ import com.bjpowernode.common.util.Pagination;
/*    */ import com.bjpowernode.system.service.impl.SystemServiceImpl;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.hibernate.criterion.DetachedCriteria;
/*    */ import org.hibernate.criterion.Order;
/*    */ import org.hibernate.criterion.Restrictions;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("visitorService")
/*    */ public class VisitorServiceImpl extends SystemServiceImpl
/*    */   implements VisitorService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private BaseDao baseDao;
/*    */ 
/*    */   public Pagination<ClassEntity> findPageData(DetachedCriteria condition, VisitorEntity ce, int page, int rows, String studentname)
/*    */   {
/* 30 */     Pagination pagination = new Pagination(page, rows);
/* 31 */     if ((ce.getStarttime() != null) && (!"".equals(ce.getStarttime()))) {
/* 32 */       if ((ce.getEndtime() == null) || ("".equals(ce.getEndtime()))) {
/* 33 */         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
/*    */         try {
/* 35 */           ce.setEndtime(sdf.parse(sdf.format(new Date())));
/*    */         } catch (ParseException e) {
/* 37 */           e.printStackTrace();
/*    */         }
/*    */       }
/* 40 */       condition.add(Restrictions.between("starttime", ce.getStarttime(), ce.getEndtime()));
/* 41 */       condition.add(Restrictions.between("endtime", ce.getStarttime(), ce.getEndtime()));
/*    */     }
/* 43 */     if ((ce.getVisitorname() != null) && (!"".equals(ce.getVisitorname()))) {
/* 44 */       condition.add(Restrictions.like("visitorname", "%" + ce.getVisitorname() + "%"));
/*    */     }
/*    */ 
/* 47 */     if ((studentname != null) && (!"".equals(studentname))) {
/* 48 */       condition.createAlias("student", "stu");
/* 49 */       condition.add(Restrictions.like("stu.name", "%" + studentname + "%"));
/*    */     }
/* 51 */     condition.addOrder(Order.desc("createTime"));
/* 52 */     int total = this.baseDao.getRowCountByDetachedCriteria(condition);
/* 53 */     pagination.setTotalCount(total);
/* 54 */     condition.setProjection(null);
/* 55 */     if (total != 0) {
/* 56 */       List datas = this.baseDao.findByDetachedCriteria(condition, page, rows);
/* 57 */       pagination.setDatas(datas);
/*    */     }
/* 59 */     return pagination;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.service.impl.VisitorServiceImpl
 * JD-Core Version:    0.6.0
 */
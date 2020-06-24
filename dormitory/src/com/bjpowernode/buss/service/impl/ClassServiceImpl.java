/*    */ package com.bjpowernode.buss.service.impl;
/*    */ 
/*    */ import com.bjpowernode.buss.entity.base.ClassEntity;
/*    */ import com.bjpowernode.buss.service.ClassService;
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
/*    */ @Service("classService")
/*    */ public class ClassServiceImpl extends SystemServiceImpl
/*    */   implements ClassService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private BaseDao baseDao;
/*    */ 
/*    */   public Pagination<ClassEntity> findPageData(DetachedCriteria condition, ClassEntity ce, int page, int rows)
/*    */   {
/* 26 */     Pagination pagination = new Pagination(page, rows);
/*    */ 
/* 28 */     if ((ce.getClassname() != null) && (!"".equals(ce.getClassname()))) {
/* 29 */       condition.add(Restrictions.like("classname", "%" + ce.getClassname() + "%"));
/*    */     }
/* 31 */     if ((ce.getTeachername() != null) && (!"".equals(ce.getTeachername()))) {
/* 32 */       condition.add(Restrictions.like("teachername", "%" + ce.getTeachername() + "%"));
/*    */     }
/* 34 */     condition.addOrder(Order.desc("createTime"));
/* 35 */     int total = this.baseDao.getRowCountByDetachedCriteria(condition);
/* 36 */     pagination.setTotalCount(total);
/* 37 */     condition.setProjection(null);
/* 38 */     if (total != 0) {
/* 39 */       List datas = this.baseDao.findByDetachedCriteria(condition, page, rows);
/* 40 */       pagination.setDatas(datas);
/*    */     }
/* 42 */     return pagination;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.service.impl.ClassServiceImpl
 * JD-Core Version:    0.6.0
 */
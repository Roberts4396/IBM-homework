/*    */ package com.bjpowernode.buss.service.impl;
/*    */ 
/*    */ import com.bjpowernode.buss.entity.base.ClassEntity;
/*    */ import com.bjpowernode.buss.entity.base.StudentEntity;
/*    */ import com.bjpowernode.buss.service.StudentService;
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
/*    */ @Service("studentService")
/*    */ public class StudentServiceImpl extends SystemServiceImpl
/*    */   implements StudentService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private BaseDao baseDao;
/*    */ 
/*    */   public Pagination<ClassEntity> findPageData(DetachedCriteria condition, StudentEntity ce, int page, int rows, String dormName)
/*    */   {
/* 27 */     Pagination pagination = new Pagination(page, rows);
/*    */ 
/* 29 */     if ((ce.getName() != null) && (!"".equals(ce.getName()))) {
/* 30 */       condition.add(Restrictions.like("name", "%" + ce.getName() + "%"));
/*    */     }
/* 32 */     if ((ce.getQq() != null) && (!"".equals(ce.getQq()))) {
/* 33 */       condition.add(Restrictions.like("qq", "%" + ce.getQq() + "%"));
/*    */     }
/* 35 */     if ((ce.getMobile() != null) && (!"".equals(ce.getMobile()))) {
/* 36 */       condition.add(Restrictions.like("mobile", "%" + ce.getMobile() + "%"));
/*    */     }
/* 38 */     if ((dormName != null) && (!"".equals(dormName))) {
/* 39 */       condition.createAlias("dorm", "d");
/* 40 */       condition.add(Restrictions.like("d.dormname", "%" + dormName + "%"));
/*    */     }
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
 * Qualified Name:     com.bjpowernode.buss.service.impl.StudentServiceImpl
 * JD-Core Version:    0.6.0
 */
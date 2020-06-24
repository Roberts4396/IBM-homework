/*    */ package com.bjpowernode.buss.entity.base;
/*    */ 
/*    */ import com.bjpowernode.common.entity.base.BaseEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="T_B_DORM")
/*    */ public class DormEntity extends BaseEntity
/*    */ {
/*    */   private static final long serialVersionUID = -5644928520712333315L;
/*    */ 
/*    */   @Column(length=30)
/*    */   private String dormname;
/*    */ 
/*    */   @Column(length=2)
/*    */   private String total;
/*    */ 
/*    */   @Column(length=2)
/*    */   private String used;
/*    */ 
/*    */   @Column(length=10)
/*    */   private String dormadmin;
/*    */ 
/*    */   @Column(length=300)
/*    */   private String remark;
/*    */ 
/*    */   public String getDormname()
/*    */   {
/* 56 */     return this.dormname;
/*    */   }
/*    */ 
/*    */   public void setDormname(String dormname) {
/* 60 */     this.dormname = dormname;
/*    */   }
/*    */ 
/*    */   public String getTotal()
/*    */   {
/* 66 */     return this.total;
/*    */   }
/*    */ 
/*    */   public void setTotal(String total) {
/* 70 */     this.total = total;
/*    */   }
/*    */ 
/*    */   public String getUsed() {
/* 74 */     return this.used;
/*    */   }
/*    */ 
/*    */   public void setUsed(String used) {
/* 78 */     this.used = used;
/*    */   }
/*    */ 
/*    */   public String getDormadmin() {
/* 82 */     return this.dormadmin;
/*    */   }
/*    */ 
/*    */   public void setDormadmin(String dormadmin) {
/* 86 */     this.dormadmin = dormadmin;
/*    */   }
/*    */ 
/*    */   public String getRemark() {
/* 90 */     return this.remark;
/*    */   }
/*    */ 
/*    */   public void setRemark(String remark) {
/* 94 */     this.remark = remark;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.entity.base.DormEntity
 * JD-Core Version:    0.6.0
 */
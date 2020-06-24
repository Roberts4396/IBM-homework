/*    */ package com.bjpowernode.buss.entity.base;
/*    */ 
/*    */ import com.bjpowernode.common.entity.base.BaseEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="T_B_CLASS")
/*    */ public class ClassEntity extends BaseEntity
/*    */ {
/*    */   private static final long serialVersionUID = 420646872754846899L;
/*    */ 
/*    */   @Column(length=45)
/*    */   private String classname;
/*    */ 
/*    */   @Column(length=10)
/*    */   private String teachername;
/*    */ 
/*    */   public String getClassname()
/*    */   {
/* 38 */     return this.classname;
/*    */   }
/*    */ 
/*    */   public void setClassname(String classname) {
/* 42 */     this.classname = classname;
/*    */   }
/*    */ 
/*    */   public String getTeachername() {
/* 46 */     return this.teachername;
/*    */   }
/*    */ 
/*    */   public void setTeachername(String teachername) {
/* 50 */     this.teachername = teachername;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.entity.base.ClassEntity
 * JD-Core Version:    0.6.0
 */
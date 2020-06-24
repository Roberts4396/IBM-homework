/*    */ package com.bjpowernode.buss.entity.base;
/*    */ 
/*    */ import com.bjpowernode.common.entity.base.BaseEntity;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.FetchType;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="T_B_SCORE")
/*    */ public class ScoreEntity extends BaseEntity
/*    */ {
/*    */   private static final long serialVersionUID = -2716114568767828561L;
/*    */ 
/*    */   @Column
/*    */   private String score;
/*    */ 
/*    */   @Column(length=20)
/*    */   private Date scoredate;
/*    */ 
/*    */   @ManyToOne(fetch=FetchType.EAGER)
/*    */   @JoinColumn(name="dormid")
/*    */   private DormEntity dorm;
/*    */ 
/*    */   public String getScore()
/*    */   {
/* 51 */     return this.score;
/*    */   }
/*    */ 
/*    */   public void setScore(String score) {
/* 55 */     this.score = score;
/*    */   }
/*    */ 
/*    */   public Date getScoredate() {
/* 59 */     return this.scoredate;
/*    */   }
/*    */ 
/*    */   public void setScoredate(Date scoredate) {
/* 63 */     this.scoredate = scoredate;
/*    */   }
/*    */ 
/*    */   public DormEntity getDorm() {
/* 67 */     return this.dorm;
/*    */   }
/*    */ 
/*    */   public void setDorm(DormEntity dorm) {
/* 71 */     this.dorm = dorm;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.entity.base.ScoreEntity
 * JD-Core Version:    0.6.0
 */
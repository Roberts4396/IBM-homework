/*     */ package com.bjpowernode.buss.entity.base;
/*     */ 
/*     */ import com.bjpowernode.common.entity.base.BaseEntity;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="T_B_VISITOR")
/*     */ public class VisitorEntity extends BaseEntity
/*     */ {
/*     */   private static final long serialVersionUID = 3493122928615586987L;
/*     */ 
/*     */   @Column(length=10)
/*     */   private String visitorname;
/*     */ 
/*     */   @Column(length=10)
/*     */   private String relationship;
/*     */ 
/*     */   @Column(length=20)
/*     */   private Date starttime;
/*     */ 
/*     */   @Column(length=20)
/*     */   private Date endtime;
/*     */ 
/*     */   @ManyToOne(fetch=FetchType.EAGER)
/*     */   @JoinColumn(name="studentid")
/*     */   private StudentEntity student;
/*     */ 
/*     */   @Column(length=200)
/*     */   private String remark;
/*     */ 
/*     */   public String getVisitorname()
/*     */   {
/*  64 */     return this.visitorname;
/*     */   }
/*     */ 
/*     */   public void setVisitorname(String visitorname) {
/*  68 */     this.visitorname = visitorname;
/*     */   }
/*     */ 
/*     */   public String getRelationship() {
/*  72 */     return this.relationship;
/*     */   }
/*     */ 
/*     */   public void setRelationship(String relationship) {
/*  76 */     this.relationship = relationship;
/*     */   }
/*     */ 
/*     */   public Date getStarttime() {
/*  80 */     return this.starttime;
/*     */   }
/*     */ 
/*     */   public void setStarttime(Date starttime) {
/*  84 */     this.starttime = starttime;
/*     */   }
/*     */ 
/*     */   public Date getEndtime() {
/*  88 */     return this.endtime;
/*     */   }
/*     */ 
/*     */   public void setEndtime(Date endtime) {
/*  92 */     this.endtime = endtime;
/*     */   }
/*     */ 
/*     */   public StudentEntity getStudent() {
/*  96 */     return this.student;
/*     */   }
/*     */ 
/*     */   public void setStudent(StudentEntity student) {
/* 100 */     this.student = student;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 104 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 108 */     this.remark = remark;
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.entity.base.VisitorEntity
 * JD-Core Version:    0.6.0
 */
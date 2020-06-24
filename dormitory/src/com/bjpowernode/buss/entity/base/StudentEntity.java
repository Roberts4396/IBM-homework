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
/*     */ import org.codehaus.jackson.annotate.JsonIgnore;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="T_B_STUDENT")
/*     */ public class StudentEntity extends BaseEntity
/*     */ {
/*     */   private static final long serialVersionUID = 5227037654348493858L;
/*     */ 
/*     */   @Column(length=10)
/*     */   private String name;
/*     */ 
/*     */   @Column(length=1)
/*     */   private String sex;
/*     */ 
/*     */   @Column(length=20)
/*     */   private Date birthday;
/*     */ 
/*     */   @Column(length=15)
/*     */   private String qq;
/*     */ 
/*     */   @Column(length=15)
/*     */   private String mobile;
/*     */ 
/*     */   @ManyToOne(fetch=FetchType.EAGER)
/*     */   @JoinColumn(name="classid")
/*     */   @JsonIgnore
/*     */   private ClassEntity classes;
/*     */ 
/*     */   @ManyToOne(fetch=FetchType.EAGER)
/*     */   @JoinColumn(name="dormid")
/*     */   @JsonIgnore
/*     */   private DormEntity dorm;
/*     */ 
/*     */   public String getName()
/*     */   {
/*  79 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  83 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getSex() {
/*  87 */     return this.sex;
/*     */   }
/*     */ 
/*     */   public void setSex(String sex) {
/*  91 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */   public Date getBirthday() {
/*  95 */     return this.birthday;
/*     */   }
/*     */ 
/*     */   public void setBirthday(Date birthday) {
/*  99 */     this.birthday = birthday;
/*     */   }
/*     */ 
/*     */   public String getQq() {
/* 103 */     return this.qq;
/*     */   }
/*     */ 
/*     */   public void setQq(String qq) {
/* 107 */     this.qq = qq;
/*     */   }
/*     */ 
/*     */   public String getMobile() {
/* 111 */     return this.mobile;
/*     */   }
/*     */ 
/*     */   public void setMobile(String mobile) {
/* 115 */     this.mobile = mobile;
/*     */   }
/*     */ 
/*     */   public ClassEntity getClasses() {
/* 119 */     return this.classes;
/*     */   }
/*     */ 
/*     */   public void setClasses(ClassEntity classes) {
/* 123 */     this.classes = classes;
/*     */   }
/*     */ 
/*     */   public DormEntity getDorm() {
/* 127 */     return this.dorm;
/*     */   }
/*     */ 
/*     */   public void setDorm(DormEntity dorm) {
/* 131 */     this.dorm = dorm;
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.entity.base.StudentEntity
 * JD-Core Version:    0.6.0
 */
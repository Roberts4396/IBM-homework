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
/*     */ @Table(name="T_B_DAMAGE")
/*     */ public class DamageEntity extends BaseEntity
/*     */ {
/*     */   private static final long serialVersionUID = 8818811192026269127L;
/*     */ 
/*     */   @Column(length=200)
/*     */   private String damagestation;
/*     */ 
/*     */   @Column(length=300)
/*     */   private String remark;
/*     */ 
/*     */   @Column(length=1)
/*     */   private String isfixed;
/*     */ 
/*     */   @Column(length=20)
/*     */   private Date damagetime;
/*     */ 
/*     */   @Column(length=20)
/*     */   private Date fixtime;
/*     */ 
/*     */   @ManyToOne(fetch=FetchType.EAGER)
/*     */   @JoinColumn(name="dormid")
/*     */   private DormEntity dorm;
/*     */ 
/*     */   public String getDamagestation()
/*     */   {
/*  68 */     return this.damagestation;
/*     */   }
/*     */ 
/*     */   public void setDamagestation(String damagestation) {
/*  72 */     this.damagestation = damagestation;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/*  77 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/*  81 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Date getDamagetime() {
/*  85 */     return this.damagetime;
/*     */   }
/*     */ 
/*     */   public void setDamagetime(Date damagetime) {
/*  89 */     this.damagetime = damagetime;
/*     */   }
/*     */ 
/*     */   public Date getFixtime() {
/*  93 */     return this.fixtime;
/*     */   }
/*     */ 
/*     */   public void setFixtime(Date fixtime) {
/*  97 */     this.fixtime = fixtime;
/*     */   }
/*     */ 
/*     */   public DormEntity getDorm() {
/* 101 */     return this.dorm;
/*     */   }
/*     */ 
/*     */   public void setDorm(DormEntity dorm) {
/* 105 */     this.dorm = dorm;
/*     */   }
/*     */ 
/*     */   public String getIsfixed() {
/* 109 */     return this.isfixed;
/*     */   }
/*     */ 
/*     */   public void setIsfixed(String isfixed) {
/* 113 */     this.isfixed = isfixed;
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.entity.base.DamageEntity
 * JD-Core Version:    0.6.0
 */
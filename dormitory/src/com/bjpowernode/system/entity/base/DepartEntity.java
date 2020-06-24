/*    */ package com.bjpowernode.system.entity.base;
/*    */ 
/*    */ import com.bjpowernode.common.entity.base.BaseEntity;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.FetchType;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="T_S_DEPART")
/*    */ public class DepartEntity extends BaseEntity
/*    */ {
/*    */   private static final long serialVersionUID = 3493122928615586987L;
/*    */ 
/*    */   @Column(length=45)
/*    */   private String departname;
/*    */ 
/*    */   @Column(length=100)
/*    */   private String description;
/*    */ 
/*    */   @ManyToOne(fetch=FetchType.LAZY)
/*    */   @JoinColumn(name="parentid")
/*    */   private DepartEntity parentDepart;
/*    */ 
/*    */   @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="parentDepart")
/* 52 */   private List<DepartEntity> Departs = new ArrayList();
/*    */ 
/*    */   public String getDepartname() {
/* 55 */     return this.departname;
/*    */   }
/*    */ 
/*    */   public void setDepartname(String departname) {
/* 59 */     this.departname = departname;
/*    */   }
/*    */ 
/*    */   public String getDescription() {
/* 63 */     return this.description;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description) {
/* 67 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public List<DepartEntity> getDeparts()
/*    */   {
/* 72 */     return this.Departs;
/*    */   }
/*    */ 
/*    */   public void setDeparts(List<DepartEntity> departs) {
/* 76 */     this.Departs = departs;
/*    */   }
/*    */ 
/*    */   public DepartEntity getParentDepart() {
/* 80 */     return this.parentDepart;
/*    */   }
/*    */ 
/*    */   public void setParentDepart(DepartEntity parentDepart) {
/* 84 */     this.parentDepart = parentDepart;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.entity.base.DepartEntity
 * JD-Core Version:    0.6.0
 */
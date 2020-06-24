/*    */ package com.bjpowernode.system.entity.base;
/*    */ 
/*    */ import com.bjpowernode.common.entity.base.BaseEntity;
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinTable;
/*    */ import javax.persistence.ManyToMany;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="T_S_ROLE")
/*    */ public class RoleEntity extends BaseEntity
/*    */ {
/*    */   private static final long serialVersionUID = 87642784845062235L;
/*    */ 
/*    */   @Column(nullable=false, length=50)
/*    */   private String name;
/*    */ 
/*    */   @Column(length=200)
/*    */   private String description;
/*    */ 
/*    */   @ManyToMany(cascade={javax.persistence.CascadeType.ALL})
/*    */   @JoinTable(name="T_S_ROLE_RESOURCE", joinColumns={@javax.persistence.JoinColumn(name="role_id")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="resource_id")})
/*    */   private List<ResourceEntity> resource;
/*    */ 
/*    */   public String getName()
/*    */   {
/* 45 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 49 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getDescription() {
/* 53 */     return this.description;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description) {
/* 57 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public List<ResourceEntity> getResource() {
/* 61 */     return this.resource;
/*    */   }
/*    */ 
/*    */   public void setResource(List<ResourceEntity> resource) {
/* 65 */     this.resource = resource;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 70 */     return super.getId();
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.entity.base.RoleEntity
 * JD-Core Version:    0.6.0
 */
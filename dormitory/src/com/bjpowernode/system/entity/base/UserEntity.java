/*     */ package com.bjpowernode.system.entity.base;
/*     */ 
/*     */ import com.bjpowernode.common.entity.base.BaseEntity;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="T_S_USER")
/*     */ public class UserEntity extends BaseEntity
/*     */ {
/*     */   private static final long serialVersionUID = 6455189720167859325L;
/*  29 */   public static int STATUS_NORMAL = 1;
/*  30 */   public static int STATUS_FORBIDDEN = 2;
/*     */ 
/*     */   @Column(nullable=false, length=50)
/*     */   private String username;
/*     */ 
/*     */   @Column(nullable=false, length=32)
/*     */   private String password;
/*     */ 
/*     */   @Column(name="real_name", length=10)
/*     */   private String realName;
/*     */ 
/*     */   @Column(length=50)
/*     */   private String email;
/*     */ 
/*     */   @Column(length=20)
/*     */   private String phone;
/*     */ 
/*     */   @Column(length=20)
/*     */   private String position;
/*     */ 
/*     */   @Column(name="position_desc", length=100)
/*     */   private String positonDesc;
/*     */ 
/*     */   @ManyToMany(cascade={javax.persistence.CascadeType.ALL})
/*     */   @JoinTable(name="T_S_USER_ROLE", joinColumns={@JoinColumn(name="user_id")}, inverseJoinColumns={@JoinColumn(name="role_id")})
/*     */   private List<RoleEntity> roles;
/*     */ 
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   @JoinColumn(name="departid")
/*     */   private DepartEntity departEntity;
/*     */   private Integer status;
/*     */ 
/*     */   public String getUsername()
/*     */   {
/*  87 */     return this.username;
/*     */   }
/*     */ 
/*     */   public void setUsername(String username) {
/*  91 */     this.username = username;
/*     */   }
/*     */ 
/*     */   public String getPassword() {
/*  95 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password) {
/*  99 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getRealName()
/*     */   {
/* 104 */     return this.realName;
/*     */   }
/*     */ 
/*     */   public void setRealName(String realName) {
/* 108 */     this.realName = realName;
/*     */   }
/*     */ 
/*     */   public String getEmail() {
/* 112 */     return this.email;
/*     */   }
/*     */ 
/*     */   public void setEmail(String email) {
/* 116 */     this.email = email;
/*     */   }
/*     */ 
/*     */   public String getPhone() {
/* 120 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone) {
/* 124 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getPosition() {
/* 128 */     return this.position;
/*     */   }
/*     */ 
/*     */   public void setPosition(String position) {
/* 132 */     this.position = position;
/*     */   }
/*     */ 
/*     */   public String getPositonDesc() {
/* 136 */     return this.positonDesc;
/*     */   }
/*     */ 
/*     */   public void setPositonDesc(String positonDesc) {
/* 140 */     this.positonDesc = positonDesc;
/*     */   }
/*     */ 
/*     */   public List<RoleEntity> getRoles() {
/* 144 */     return this.roles;
/*     */   }
/*     */ 
/*     */   public void setRoles(List<RoleEntity> roles) {
/* 148 */     this.roles = roles;
/*     */   }
/*     */ 
/*     */   public Integer getStatus() {
/* 152 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Integer status) {
/* 156 */     this.status = status;
/*     */   }
/*     */   public DepartEntity getDepartEntity() {
/* 159 */     return this.departEntity;
/*     */   }
/*     */ 
/*     */   public void setDepartEntity(DepartEntity departEntity) {
/* 163 */     this.departEntity = departEntity;
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.entity.base.UserEntity
 * JD-Core Version:    0.6.0
 */
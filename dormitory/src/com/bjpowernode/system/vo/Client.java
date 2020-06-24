/*    */ package com.bjpowernode.system.vo;
/*    */ 
/*    */ import com.bjpowernode.system.entity.base.ResourceEntity;
/*    */ import com.bjpowernode.system.entity.base.UserEntity;
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Client
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private UserEntity user;
/*    */   private String ip;
/*    */   private Date logindatetime;
/*    */   private List<ResourceEntity> menuList;
/*    */ 
/*    */   public UserEntity getUser()
/*    */   {
/* 34 */     return this.user;
/*    */   }
/*    */ 
/*    */   public void setUser(UserEntity user) {
/* 38 */     this.user = user;
/*    */   }
/*    */ 
/*    */   public String getIp() {
/* 42 */     return this.ip;
/*    */   }
/*    */ 
/*    */   public void setIp(String ip) {
/* 46 */     this.ip = ip;
/*    */   }
/*    */ 
/*    */   public Date getLogindatetime() {
/* 50 */     return this.logindatetime;
/*    */   }
/*    */ 
/*    */   public void setLogindatetime(Date logindatetime) {
/* 54 */     this.logindatetime = logindatetime;
/*    */   }
/*    */ 
/*    */   public List<ResourceEntity> getMenuList() {
/* 58 */     return this.menuList;
/*    */   }
/*    */ 
/*    */   public void setMenuList(List<ResourceEntity> menuList) {
/* 62 */     this.menuList = menuList;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.vo.Client
 * JD-Core Version:    0.6.0
 */
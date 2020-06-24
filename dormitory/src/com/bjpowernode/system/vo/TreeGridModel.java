/*    */ package com.bjpowernode.system.vo;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class TreeGridModel
/*    */   implements Serializable
/*    */ {
/*    */   private String idField;
/*    */   private String textField;
/*    */   private String childList;
/*    */   private String parentId;
/*    */   private String parentText;
/*    */   private String code;
/*    */   private String src;
/*    */   private String roleid;
/*    */   private String icon;
/*    */   private String order;
/*    */ 
/*    */   public String getOrder()
/*    */   {
/* 22 */     return this.order;
/*    */   }
/*    */   public void setOrder(String order) {
/* 25 */     this.order = order;
/*    */   }
/*    */   public String getIcon() {
/* 28 */     return this.icon;
/*    */   }
/*    */   public void setIcon(String icon) {
/* 31 */     this.icon = icon;
/*    */   }
/*    */   public String getRoleid() {
/* 34 */     return this.roleid;
/*    */   }
/*    */   public void setRoleid(String roleid) {
/* 37 */     this.roleid = roleid;
/*    */   }
/*    */   public String getParentText() {
/* 40 */     return this.parentText;
/*    */   }
/*    */   public void setParentText(String parentText) {
/* 43 */     this.parentText = parentText;
/*    */   }
/*    */   public String getCode() {
/* 46 */     return this.code;
/*    */   }
/*    */   public void setCode(String code) {
/* 49 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getSrc() {
/* 53 */     return this.src;
/*    */   }
/*    */   public void setSrc(String src) {
/* 56 */     this.src = src;
/*    */   }
/*    */   public String getParentId() {
/* 59 */     return this.parentId;
/*    */   }
/*    */   public void setParentId(String parentId) {
/* 62 */     this.parentId = parentId;
/*    */   }
/*    */   public String getIdField() {
/* 65 */     return this.idField;
/*    */   }
/*    */   public void setIdField(String idField) {
/* 68 */     this.idField = idField;
/*    */   }
/*    */   public String getTextField() {
/* 71 */     return this.textField;
/*    */   }
/*    */   public void setTextField(String textField) {
/* 74 */     this.textField = textField;
/*    */   }
/*    */   public String getChildList() {
/* 77 */     return this.childList;
/*    */   }
/*    */   public void setChildList(String childList) {
/* 80 */     this.childList = childList;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.vo.TreeGridModel
 * JD-Core Version:    0.6.0
 */
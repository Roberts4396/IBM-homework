/*    */ package com.bjpowernode.system.vo;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class TreeGrid
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -776305556228690050L;
/*    */   private String id;
/*    */   private String text;
/*    */   private String parentId;
/*    */   private String parentText;
/*    */   private String code;
/*    */   private String src;
/*    */   private String note;
/*    */   private Map<String, String> attributes;
/*    */   private String operations;
/* 22 */   private String state = "open";
/*    */   private String order;
/*    */ 
/*    */   public String getOrder()
/*    */   {
/* 26 */     return this.order;
/*    */   }
/*    */   public void setOrder(String order) {
/* 29 */     this.order = order;
/*    */   }
/*    */   public String getOperations() {
/* 32 */     return this.operations;
/*    */   }
/*    */   public void setOperations(String operations) {
/* 35 */     this.operations = operations;
/*    */   }
/*    */   public Map<String, String> getAttributes() {
/* 38 */     return this.attributes;
/*    */   }
/*    */   public void setAttributes(Map<String, String> attributes) {
/* 41 */     this.attributes = attributes;
/*    */   }
/*    */   public String getParentText() {
/* 44 */     return this.parentText;
/*    */   }
/*    */   public void setParentText(String parentText) {
/* 47 */     this.parentText = parentText;
/*    */   }
/*    */   public String getCode() {
/* 50 */     return this.code;
/*    */   }
/*    */   public void setCode(String code) {
/* 53 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getSrc() {
/* 57 */     return this.src;
/*    */   }
/*    */   public void setSrc(String src) {
/* 60 */     this.src = src;
/*    */   }
/*    */   public String getNote() {
/* 63 */     return this.note;
/*    */   }
/*    */   public void setNote(String note) {
/* 66 */     this.note = note;
/*    */   }
/*    */ 
/*    */   public String getId() {
/* 70 */     return this.id;
/*    */   }
/*    */   public void setId(String id) {
/* 73 */     this.id = id;
/*    */   }
/*    */   public String getText() {
/* 76 */     return this.text;
/*    */   }
/*    */   public void setText(String text) {
/* 79 */     this.text = text;
/*    */   }
/*    */   public String getParentId() {
/* 82 */     return this.parentId;
/*    */   }
/*    */   public void setParentId(String parentId) {
/* 85 */     this.parentId = parentId;
/*    */   }
/*    */   public String getState() {
/* 88 */     return this.state;
/*    */   }
/*    */   public void setState(String state) {
/* 91 */     this.state = state;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.vo.TreeGrid
 * JD-Core Version:    0.6.0
 */
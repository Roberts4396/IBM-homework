/*    */ package com.bjpowernode.system.vo;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class TreeNode
/*    */ {
/*    */   private String id;
/*    */   private String text;
/*    */   private boolean isLeaf;
/*    */   private String iconCls;
/*    */   private String state;
/*    */   private List<TreeNode> children;
/*    */   private Map<String, Object> attributes;
/*    */ 
/*    */   public String getId()
/*    */   {
/* 29 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(String id) {
/* 33 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getText() {
/* 37 */     return this.text;
/*    */   }
/*    */ 
/*    */   public void setText(String text) {
/* 41 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public boolean isLeaf() {
/* 45 */     return this.isLeaf;
/*    */   }
/*    */ 
/*    */   public void setLeaf(boolean isLeaf) {
/* 49 */     this.isLeaf = isLeaf;
/*    */   }
/*    */ 
/*    */   public String getIconCls() {
/* 53 */     return this.iconCls;
/*    */   }
/*    */ 
/*    */   public void setIconCls(String iconCls) {
/* 57 */     this.iconCls = iconCls;
/*    */   }
/*    */ 
/*    */   public String getState() {
/* 61 */     return this.state;
/*    */   }
/*    */ 
/*    */   public void setState(String state) {
/* 65 */     this.state = state;
/*    */   }
/*    */ 
/*    */   public List<TreeNode> getChildren() {
/* 69 */     return this.children;
/*    */   }
/*    */ 
/*    */   public void setChildren(List<TreeNode> children) {
/* 73 */     this.children = children;
/*    */   }
/*    */ 
/*    */   public Map<String, Object> getAttributes()
/*    */   {
/* 78 */     if (this.attributes == null) {
/* 79 */       this.attributes = new HashMap();
/*    */     }
/* 81 */     this.attributes.put("isLeaf", Boolean.valueOf(this.isLeaf));
/* 82 */     return this.attributes;
/*    */   }
/*    */ 
/*    */   public void setAttributes(Map<String, Object> attributes) {
/* 86 */     this.attributes = attributes;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.vo.TreeNode
 * JD-Core Version:    0.6.0
 */
/*    */ package com.bjpowernode.common.util;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class AjaxJson
/*    */ {
/* 13 */   private boolean success = true;
/* 14 */   private String msg = "操作成功";
/* 15 */   private Object obj = null;
/*    */   private Map<String, Object> attributes;
/*    */ 
/*    */   public Map<String, Object> getAttributes()
/*    */   {
/* 18 */     return this.attributes;
/*    */   }
/*    */ 
/*    */   public void setAttributes(Map<String, Object> attributes) {
/* 22 */     this.attributes = attributes;
/*    */   }
/*    */ 
/*    */   public String getMsg() {
/* 26 */     return this.msg;
/*    */   }
/*    */ 
/*    */   public void setMsg(String msg) {
/* 30 */     this.msg = msg;
/*    */   }
/*    */ 
/*    */   public Object getObj() {
/* 34 */     return this.obj;
/*    */   }
/*    */ 
/*    */   public void setObj(Object obj) {
/* 38 */     this.obj = obj;
/*    */   }
/*    */ 
/*    */   public boolean isSuccess() {
/* 42 */     return this.success;
/*    */   }
/*    */ 
/*    */   public void setSuccess(boolean success) {
/* 46 */     this.success = success;
/*    */   }
/*    */   public String getJsonStr() {
/* 49 */     JSONObject obj = new JSONObject();
/* 50 */     obj.put("success", Boolean.valueOf(isSuccess()));
/* 51 */     obj.put("msg", getMsg());
/* 52 */     obj.put("obj", this.obj);
/* 53 */     obj.put("attributes", this.attributes);
/* 54 */     return obj.toJSONString();
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.util.AjaxJson
 * JD-Core Version:    0.6.0
 */
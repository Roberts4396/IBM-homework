/*    */ package com.bjpowernode.common.controller;
/*    */ 
/*    */ import com.bjpowernode.common.util.DateConvertEditor;
/*    */ import java.util.Date;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.ServletRequestDataBinder;
/*    */ import org.springframework.web.bind.annotation.InitBinder;
/*    */ 
/*    */ @Controller
/*    */ public class BaseController
/*    */ {
/*    */   @InitBinder
/*    */   public void initBinder(ServletRequestDataBinder binder)
/*    */   {
/* 28 */     binder.registerCustomEditor(Date.class, new DateConvertEditor());
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.controller.BaseController
 * JD-Core Version:    0.6.0
 */
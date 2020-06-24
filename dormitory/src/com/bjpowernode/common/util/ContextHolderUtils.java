/*    */ package com.bjpowernode.common.util;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.web.context.request.RequestContextHolder;
/*    */ import org.springframework.web.context.request.ServletRequestAttributes;
/*    */ 
/*    */ public class ContextHolderUtils
/*    */ {
/*    */   public static HttpServletRequest getRequest()
/*    */   {
/* 17 */     HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
/* 18 */     return request;
/*    */   }
/*    */ 
/*    */   public static HttpSession getSession()
/*    */   {
/* 27 */     HttpSession session = getRequest().getSession();
/* 28 */     return session;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.util.ContextHolderUtils
 * JD-Core Version:    0.6.0
 */
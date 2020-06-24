/*    */ package com.bjpowernode.common.util;
/*    */ 
/*    */ import com.bjpowernode.system.entity.base.UserEntity;
/*    */ import com.bjpowernode.system.manager.ClientManager;
/*    */ import com.bjpowernode.system.vo.Client;
/*    */ import java.lang.reflect.ParameterizedType;
/*    */ import java.lang.reflect.Type;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class ResourceUtil
/*    */ {
/*    */   public static String getRequestPath(HttpServletRequest request)
/*    */   {
/* 27 */     String requestPath = request.getRequestURI() + "?" + request.getQueryString();
/* 28 */     if (requestPath.indexOf("&") > -1) {
/* 29 */       requestPath = requestPath.substring(0, requestPath.indexOf("&"));
/*    */     }
/* 31 */     requestPath = requestPath.substring(request.getContextPath().length() + 1);
/* 32 */     return requestPath;
/*    */   }
/*    */ 
/*    */   public static String getIpAddr(HttpServletRequest request)
/*    */   {
/* 42 */     String ip = request.getHeader("x-forwarded-for");
/* 43 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 44 */       ip = request.getHeader("Proxy-Client-IP");
/*    */     }
/* 46 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 47 */       ip = request.getHeader("WL-Proxy-Client-IP");
/*    */     }
/* 49 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 50 */       ip = request.getRemoteAddr();
/*    */     }
/* 52 */     if (ip.equals("0:0:0:0:0:0:0:1")) {
/* 53 */       ip = "本地";
/*    */     }
/* 55 */     return ip;
/*    */   }
/*    */ 
/*    */   public static final UserEntity getSessionUser()
/*    */   {
/* 63 */     HttpSession session = ContextHolderUtils.getSession();
/* 64 */     if (ClientManager.getInstance().getClient(session.getId()) != null) {
/* 65 */       return ClientManager.getInstance().getClient(session.getId()).getUser();
/*    */     }
/* 67 */     return null;
/*    */   }
/*    */ 
/*    */   public static final Client getClient()
/*    */   {
/* 75 */     HttpSession session = ContextHolderUtils.getSession();
/* 76 */     if (ClientManager.getInstance().getClient(session.getId()) != null) {
/* 77 */       return ClientManager.getInstance().getClient(session.getId());
/*    */     }
/* 79 */     return null;
/*    */   }
/*    */ 
/*    */   public static Class getActualClass(Class clazz, int index)
/*    */   {
/* 88 */     Type type = clazz.getGenericSuperclass();
/* 89 */     if (!(type instanceof ParameterizedType)) {
/* 90 */       return getActualClass(clazz.getSuperclass(), index);
/*    */     }
/* 92 */     Type[] types = ((ParameterizedType)type).getActualTypeArguments();
/* 93 */     if ((index >= types.length) || (index < 0)) {
/* 94 */       return Object.class;
/*    */     }
/* 96 */     if ((types[index] instanceof Class)) {
/* 97 */       return (Class)types[index];
/*    */     }
/* 99 */     return Object.class;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.util.ResourceUtil
 * JD-Core Version:    0.6.0
 */
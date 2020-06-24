/*    */ package com.bjpowernode.system.interceptor;
/*    */ 
/*    */ import com.bjpowernode.common.util.ContextHolderUtils;
/*    */ import com.bjpowernode.common.util.ResourceUtil;
/*    */ import com.bjpowernode.system.manager.ClientManager;
/*    */ import com.bjpowernode.system.service.SystemService;
/*    */ import com.bjpowernode.system.vo.Client;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ import org.springframework.web.servlet.view.RedirectView;
/*    */ 
/*    */ public class AuthInterceptor
/*    */   implements HandlerInterceptor
/*    */ {
/* 31 */   private static final Logger logger = Logger.getLogger(AuthInterceptor.class);
/*    */   private SystemService systemService;
/*    */   private List<String> excludeUrls;
/*    */ 
/*    */   public List<String> getExcludeUrls()
/*    */   {
/* 36 */     return this.excludeUrls;
/*    */   }
/*    */ 
/*    */   public void setExcludeUrls(List<String> excludeUrls) {
/* 40 */     this.excludeUrls = excludeUrls;
/*    */   }
/*    */ 
/*    */   public SystemService getSystemService() {
/* 44 */     return this.systemService;
/*    */   }
/*    */   @Autowired
/*    */   public void setSystemService(SystemService systemService) {
/* 49 */     this.systemService = systemService;
/*    */   }
/*    */ 
/*    */   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object)
/*    */     throws Exception
/*    */   {
/* 66 */     String requestPath = ResourceUtil.getRequestPath(request);
/* 67 */     HttpSession session = ContextHolderUtils.getSession();
/* 68 */     Client client = ClientManager.getInstance().getClient(session.getId());
/* 69 */     if (this.excludeUrls.contains(requestPath)) {
/* 70 */       return true;
/*    */     }
/* 72 */     if ((client != null) && (client.getUser() != null)) {
/* 73 */       return true;
/*    */     }
/* 75 */     forward(request, response);
/* 76 */     return false;
/*    */   }
/*    */ 
/*    */   @RequestMapping(params={"forword"})
/*    */   public ModelAndView forword(HttpServletRequest request)
/*    */   {
/* 89 */     return new ModelAndView(new RedirectView("loginController.do?login"));
/*    */   }
/*    */ 
/*    */   private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 93 */     request.getRequestDispatcher("pages/common/timeout.jsp").forward(request, response);
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.interceptor.AuthInterceptor
 * JD-Core Version:    0.6.0
 */
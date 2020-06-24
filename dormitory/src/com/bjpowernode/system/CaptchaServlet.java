/*    */ package com.bjpowernode.system;
/*    */ 
/*    */ import com.bjpowernode.common.util.CaptchaUtil;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class CaptchaServlet extends HttpServlet
/*    */ {
/* 25 */   private static final Logger LOGGER = Logger.getLogger(CaptchaServlet.class);
/*    */   private static final long serialVersionUID = -124247581620199710L;
/*    */ 
/*    */   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
/*    */     throws ServletException, IOException
/*    */   {
/* 32 */     resp.setContentType("image/jpeg");
/* 33 */     resp.setHeader("Pragma", "No-cache");
/* 34 */     resp.setHeader("Cache-Control", "no-cache");
/* 35 */     resp.setDateHeader("Expire", 0L);
/*    */     try
/*    */     {
/* 38 */       HttpSession session = req.getSession();
/* 39 */       CaptchaUtil tool = new CaptchaUtil();
/* 40 */       StringBuffer code = new StringBuffer();
/* 41 */       BufferedImage image = tool.genRandomCodeImage(code);
/* 42 */       session.removeAttribute("SE_KEY_MM_CODE");
/* 43 */       session.setAttribute("SE_KEY_MM_CODE", code.toString());
/* 44 */       LOGGER.debug("验证码生成");
/* 45 */       ImageIO.write(image, "JPEG", resp.getOutputStream());
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 49 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
/*    */     throws ServletException, IOException
/*    */   {
/* 57 */     doGet(req, resp);
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.CaptchaServlet
 * JD-Core Version:    0.6.0
 */
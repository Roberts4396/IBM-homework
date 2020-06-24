/*     */ package com.bjpowernode.common.util;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ 
/*     */ public class BrowserUtils
/*     */ {
/*     */   private static final String IE11 = "rv:11.0";
/*     */   private static final String IE10 = "MSIE 10.0";
/*     */   private static final String IE9 = "MSIE 9.0";
/*     */   private static final String IE8 = "MSIE 8.0";
/*     */   private static final String IE7 = "MSIE 7.0";
/*     */   private static final String IE6 = "MSIE 6.0";
/*     */   private static final String MAXTHON = "Maxthon";
/*     */   private static final String QQ = "QQBrowser";
/*     */   private static final String GREEN = "GreenBrowser";
/*     */   private static final String SE360 = "360SE";
/*     */   private static final String FIREFOX = "Firefox";
/*     */   private static final String OPERA = "Opera";
/*     */   private static final String CHROME = "Chrome";
/*     */   private static final String SAFARI = "Safari";
/*     */   private static final String OTHER = "其它";
/*     */ 
/*     */   public static boolean isIE(HttpServletRequest request)
/*     */   {
/*  15 */     return (request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0) || 
/*  16 */       (request.getHeader("USER-AGENT").toLowerCase().indexOf("rv:11.0") > 0);
/*     */   }
/*     */ 
/*     */   public static Double getIEversion(HttpServletRequest request)
/*     */   {
/*  26 */     Double version = Double.valueOf(0.0D);
/*  27 */     if (getBrowserType(request, "rv:11.0"))
/*  28 */       version = Double.valueOf(11.0D);
/*  29 */     else if (getBrowserType(request, "MSIE 10.0"))
/*  30 */       version = Double.valueOf(10.0D);
/*  31 */     else if (getBrowserType(request, "MSIE 9.0"))
/*  32 */       version = Double.valueOf(9.0D);
/*  33 */     else if (getBrowserType(request, "MSIE 8.0"))
/*  34 */       version = Double.valueOf(8.0D);
/*  35 */     else if (getBrowserType(request, "MSIE 7.0"))
/*  36 */       version = Double.valueOf(7.0D);
/*  37 */     else if (getBrowserType(request, "MSIE 6.0")) {
/*  38 */       version = Double.valueOf(6.0D);
/*     */     }
/*  40 */     return version;
/*     */   }
/*     */ 
/*     */   public static BrowserType getBrowserType(HttpServletRequest request)
/*     */   {
/*  50 */     BrowserType browserType = null;
/*  51 */     if (getBrowserType(request, "rv:11.0")) {
/*  52 */       browserType = BrowserType.IE11;
/*     */     }
/*  54 */     if (getBrowserType(request, "MSIE 10.0")) {
/*  55 */       browserType = BrowserType.IE10;
/*     */     }
/*  57 */     if (getBrowserType(request, "MSIE 9.0")) {
/*  58 */       browserType = BrowserType.IE9;
/*     */     }
/*  60 */     if (getBrowserType(request, "MSIE 8.0")) {
/*  61 */       browserType = BrowserType.IE8;
/*     */     }
/*  63 */     if (getBrowserType(request, "MSIE 7.0")) {
/*  64 */       browserType = BrowserType.IE7;
/*     */     }
/*  66 */     if (getBrowserType(request, "MSIE 6.0")) {
/*  67 */       browserType = BrowserType.IE6;
/*     */     }
/*  69 */     if (getBrowserType(request, "Firefox")) {
/*  70 */       browserType = BrowserType.Firefox;
/*     */     }
/*  72 */     if (getBrowserType(request, "Safari")) {
/*  73 */       browserType = BrowserType.Safari;
/*     */     }
/*  75 */     if (getBrowserType(request, "Chrome")) {
/*  76 */       browserType = BrowserType.Chrome;
/*     */     }
/*  78 */     if (getBrowserType(request, "Opera")) {
/*  79 */       browserType = BrowserType.Opera;
/*     */     }
/*  81 */     if (getBrowserType(request, "Camino")) {
/*  82 */       browserType = BrowserType.Camino;
/*     */     }
/*  84 */     return browserType;
/*     */   }
/*     */ 
/*     */   private static boolean getBrowserType(HttpServletRequest request, String brosertype) {
/*  88 */     return request.getHeader("USER-AGENT").toLowerCase().indexOf(brosertype) > 0;
/*     */   }
/*     */ 
/*     */   public static String checkBrowse(HttpServletRequest request)
/*     */   {
/* 107 */     String userAgent = request.getHeader("USER-AGENT");
/* 108 */     if (regex("Opera", userAgent))
/* 109 */       return "Opera";
/* 110 */     if (regex("Chrome", userAgent))
/* 111 */       return "Chrome";
/* 112 */     if (regex("Firefox", userAgent))
/* 113 */       return "Firefox";
/* 114 */     if (regex("Safari", userAgent))
/* 115 */       return "Safari";
/* 116 */     if (regex("360SE", userAgent))
/* 117 */       return "360SE";
/* 118 */     if (regex("GreenBrowser", userAgent))
/* 119 */       return "GreenBrowser";
/* 120 */     if (regex("QQBrowser", userAgent))
/* 121 */       return "QQBrowser";
/* 122 */     if (regex("Maxthon", userAgent))
/* 123 */       return "Maxthon";
/* 124 */     if (regex("rv:11.0", userAgent))
/* 125 */       return "rv:11.0";
/* 126 */     if (regex("MSIE 10.0", userAgent))
/* 127 */       return "MSIE 10.0";
/* 128 */     if (regex("MSIE 9.0", userAgent))
/* 129 */       return "MSIE 9.0";
/* 130 */     if (regex("MSIE 8.0", userAgent))
/* 131 */       return "MSIE 8.0";
/* 132 */     if (regex("MSIE 7.0", userAgent))
/* 133 */       return "MSIE 7.0";
/* 134 */     if (regex("MSIE 6.0", userAgent))
/* 135 */       return "MSIE 6.0";
/* 136 */     return "其它";
/*     */   }
/*     */ 
/*     */   public static boolean regex(String regex, String str) {
/* 140 */     Pattern p = Pattern.compile(regex, 8);
/* 141 */     Matcher m = p.matcher(str);
/* 142 */     return m.find();
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.util.BrowserUtils
 * JD-Core Version:    0.6.0
 */
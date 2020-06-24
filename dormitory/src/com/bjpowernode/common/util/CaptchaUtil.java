/*     */ package com.bjpowernode.common.util;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import javax.imageio.ImageIO;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class CaptchaUtil
/*     */ {
/*  21 */   private static final Logger LOGGER = Logger.getLogger(CaptchaUtil.class);
/*     */   private static final String RANDOM_STRS = "0123456789";
/*     */   private static final String FONT_NAME = "Fixedsys";
/*     */   private static final int FONT_SIZE = 18;
/*  29 */   private Random random = new Random();
/*     */ 
/*  31 */   private int width = 80;
/*  32 */   private int height = 25;
/*  33 */   private int lineNum = 50;
/*  34 */   private int strNum = 4;
/*     */ 
/*     */   public BufferedImage genRandomCodeImage(StringBuffer randomCode)
/*     */   {
/*  41 */     BufferedImage image = new BufferedImage(this.width, this.height, 
/*  42 */       4);
/*     */ 
/*  44 */     Graphics g = image.getGraphics();
/*     */ 
/*  46 */     g.setColor(getRandColor(200, 250));
/*  47 */     g.fillRect(0, 0, this.width, this.height);
/*     */ 
/*  50 */     g.setColor(getRandColor(110, 120));
/*     */ 
/*  53 */     for (int i = 0; i <= this.lineNum; i++) {
/*  54 */       drowLine(g);
/*     */     }
/*     */ 
/*  57 */     g.setFont(new Font("Fixedsys", 0, 18));
/*  58 */     for (int i = 1; i <= this.strNum; i++) {
/*  59 */       randomCode.append(drowString(g, i));
/*     */     }
/*  61 */     g.dispose();
/*  62 */     return image;
/*     */   }
/*     */ 
/*     */   private Color getRandColor(int fc, int bc)
/*     */   {
/*  69 */     if (fc > 255)
/*  70 */       fc = 255;
/*  71 */     if (bc > 255)
/*  72 */       bc = 255;
/*  73 */     int r = fc + this.random.nextInt(bc - fc);
/*  74 */     int g = fc + this.random.nextInt(bc - fc);
/*  75 */     int b = fc + this.random.nextInt(bc - fc);
/*  76 */     return new Color(r, g, b);
/*     */   }
/*     */ 
/*     */   private String drowString(Graphics g, int i)
/*     */   {
/*  83 */     g.setColor(
/*  84 */       new Color(this.random.nextInt(101), this.random.nextInt(111), this.random
/*  84 */       .nextInt(121)));
/*  85 */     String rand = String.valueOf(getRandomString(this.random.nextInt("0123456789"
/*  86 */       .length())));
/*  87 */     g.translate(this.random.nextInt(3), this.random.nextInt(3));
/*  88 */     g.drawString(rand, 13 * i, 16);
/*  89 */     return rand;
/*     */   }
/*     */ 
/*     */   private void drowLine(Graphics g)
/*     */   {
/*  96 */     int x = this.random.nextInt(this.width);
/*  97 */     int y = this.random.nextInt(this.height);
/*  98 */     int x0 = this.random.nextInt(16);
/*  99 */     int y0 = this.random.nextInt(16);
/* 100 */     g.drawLine(x, y, x + x0, y + y0);
/*     */   }
/*     */ 
/*     */   private String getRandomString(int num)
/*     */   {
/* 107 */     return String.valueOf("0123456789".charAt(num));
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 111 */     CaptchaUtil tool = new CaptchaUtil();
/* 112 */     StringBuffer code = new StringBuffer();
/* 113 */     BufferedImage image = tool.genRandomCodeImage(code);
/* 114 */     System.out.println(">>> random code =: " + code);
/*     */     try
/*     */     {
/* 117 */       ImageIO.write(image, "JPEG", 
/* 118 */         new FileOutputStream(new File("random-code.jpg")));
/*     */     } catch (Exception e) {
/* 120 */       LOGGER.info("context", e);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.util.CaptchaUtil
 * JD-Core Version:    0.6.0
 */
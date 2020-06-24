/*     */ package com.bjpowernode.buss.controller;
/*     */ 
/*     */ import com.bjpowernode.buss.entity.base.DamageEntity;
/*     */ import com.bjpowernode.buss.entity.base.DormEntity;
/*     */ import com.bjpowernode.buss.service.DamageService;
/*     */ import com.bjpowernode.common.controller.BaseController;
/*     */ import com.bjpowernode.common.util.AjaxJson;
/*     */ import com.bjpowernode.common.util.Pagination;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.hibernate.criterion.DetachedCriteria;
/*     */ import org.json.JSONObject;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/damageController"})
/*     */ public class DamageController extends BaseController
/*     */ {
/*  27 */   private static final Logger logger = Logger.getLogger(DamageController.class);
/*     */ 
/*     */   @Autowired
/*     */   private DamageService damageService;
/*     */ 
/*     */   @RequestMapping(params={"goDamage"})
/*     */   public ModelAndView goDamage(HttpServletRequest request)
/*     */   {
/*  40 */     return new ModelAndView("buss/damage");
/*     */   }
/*  46 */   @RequestMapping(params={"save"})
/*     */   @ResponseBody
/*     */   public AjaxJson save(HttpServletRequest request, HttpServletResponse response, DamageEntity damageEntity, String dormid) throws Exception { AjaxJson j = new AjaxJson();
/*  47 */     j.setMsg("保存成功！");
/*  48 */     j.setSuccess(true);
/*  49 */     DormEntity de = (DormEntity)this.damageService.get(DormEntity.class, dormid);
/*  50 */     damageEntity.setDorm(de);
/*     */     try {
/*  52 */       this.damageService.save(damageEntity);
/*     */     } catch (Exception e) {
/*  54 */       j.setMsg("保存失败！");
/*  55 */       j.setSuccess(false);
/*     */     }
/*  57 */     return j; }
/*     */ 
/*     */   @RequestMapping(params={"update"})
/*     */   @ResponseBody
/*     */   public AjaxJson update(HttpServletRequest request, HttpServletResponse response, DamageEntity damageEntity, String dormid) throws Exception {
/*  64 */     AjaxJson j = new AjaxJson();
/*  65 */     j.setMsg("更新成功！");
/*  66 */     j.setSuccess(true);
/*     */     try {
/*  68 */       DormEntity de = (DormEntity)this.damageService.get(DormEntity.class, dormid);
/*  69 */       damageEntity.setDorm(de);
/*  70 */       this.damageService.update(damageEntity);
/*     */     } catch (Exception e) {
/*  72 */       j.setMsg("更新失败！");
/*  73 */       j.setSuccess(false);
/*     */     }
/*  75 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxJson delete(HttpServletRequest request, HttpServletResponse response, String ids) throws Exception {
/*  82 */     AjaxJson j = new AjaxJson();
/*  83 */     j.setMsg("删除成功！");
/*  84 */     j.setSuccess(true);
/*     */     try {
/*  86 */       for (String id : ids.split(",")) {
/*  87 */         DamageEntity damageEntity = new DamageEntity();
/*  88 */         damageEntity.setId(id);
/*  89 */         this.damageService.delete(damageEntity);
/*     */       }
/*     */     } catch (Exception e) {
/*  92 */       j.setMsg("删除失败！");
/*  93 */       j.setSuccess(false);
/*     */     }
/*  95 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"datagrid"})
/*     */   @ResponseBody
/*     */   public void datagrid(HttpServletRequest request, HttpServletResponse response, DamageEntity ve, String dormname) throws Exception {
/* 102 */     String page = request.getParameter("page");
/* 103 */     String rows = request.getParameter("rows");
/* 104 */     if (page == null) {
/* 105 */       page = "0";
/*     */     }
/* 107 */     if (rows == null) {
/* 108 */       rows = "0";
/*     */     }
/* 110 */     DetachedCriteria condition = DetachedCriteria.forClass(DamageEntity.class);
/* 111 */     Pagination pagination = this.damageService.findPageData(condition, ve, Integer.parseInt(page), Integer.parseInt(rows), dormname);
/*     */ 
/* 113 */     JSONObject jobj = new JSONObject();
/* 114 */     jobj.put("total", pagination.getTotalCount());
/* 115 */     jobj.put("rows", pagination.getDatas());
/*     */ 
/* 117 */     response.setCharacterEncoding("utf-8");
/* 118 */     response.getWriter().write(jobj.toString());
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.controller.DamageController
 * JD-Core Version:    0.6.0
 */
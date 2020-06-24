/*     */ package com.bjpowernode.buss.controller;
/*     */ 
/*     */ import com.bjpowernode.buss.entity.base.DormEntity;
/*     */ import com.bjpowernode.buss.entity.base.ScoreEntity;
/*     */ import com.bjpowernode.buss.service.ScoreService;
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
/*     */ @RequestMapping({"/scoreController"})
/*     */ public class ScoreController extends BaseController
/*     */ {
/*  27 */   private static final Logger logger = Logger.getLogger(ScoreController.class);
/*     */ 
/*     */   @Autowired
/*     */   private ScoreService scoreService;
/*     */ 
/*     */   @RequestMapping(params={"goScore"})
/*     */   public ModelAndView goScore(HttpServletRequest request)
/*     */   {
/*  40 */     return new ModelAndView("buss/score");
/*     */   }
/*  46 */   @RequestMapping(params={"save"})
/*     */   @ResponseBody
/*     */   public AjaxJson save(HttpServletRequest request, HttpServletResponse response, ScoreEntity scoreEntity, String dormid) throws Exception { AjaxJson j = new AjaxJson();
/*  47 */     j.setMsg("保存成功！");
/*  48 */     j.setSuccess(true);
/*     */     try {
/*  50 */       DormEntity de = (DormEntity)this.scoreService.get(DormEntity.class, dormid);
/*  51 */       scoreEntity.setDorm(de);
/*  52 */       this.scoreService.save(scoreEntity);
/*     */     } catch (Exception e) {
/*  54 */       j.setMsg("保存失败！");
/*  55 */       j.setSuccess(false);
/*     */     }
/*  57 */     return j; }
/*     */ 
/*     */   @RequestMapping(params={"update"})
/*     */   @ResponseBody
/*     */   public AjaxJson update(HttpServletRequest request, HttpServletResponse response, ScoreEntity scoreEntity, String dormid) throws Exception {
/*  64 */     AjaxJson j = new AjaxJson();
/*  65 */     j.setMsg("更新成功！");
/*  66 */     j.setSuccess(true);
/*     */     try {
/*  68 */       DormEntity de = (DormEntity)this.scoreService.get(DormEntity.class, dormid);
/*  69 */       scoreEntity.setDorm(de);
/*  70 */       this.scoreService.update(scoreEntity);
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
/*  87 */         ScoreEntity scoreEntity = new ScoreEntity();
/*  88 */         scoreEntity.setId(id);
/*  89 */         this.scoreService.delete(scoreEntity);
/*     */       }
/*     */     } catch (Exception e) {
/*  92 */       j.setMsg("删除失败！");
/*  93 */       j.setSuccess(false);
/*     */     }
/*  95 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"datagrid"})
/*     */   @ResponseBody
/*     */   public void datagrid(HttpServletRequest request, HttpServletResponse response, ScoreEntity ve, String startDate, String endDate, String paramDorm) throws Exception {
/* 102 */     String page = request.getParameter("page");
/* 103 */     String rows = request.getParameter("rows");
/* 104 */     if (page == null) {
/* 105 */       page = "0";
/*     */     }
/* 107 */     if (rows == null) {
/* 108 */       rows = "0";
/*     */     }
/*     */ 
/* 111 */     DetachedCriteria condition = DetachedCriteria.forClass(ScoreEntity.class);
/* 112 */     Pagination pagination = this.scoreService.findPageData(condition, ve, Integer.parseInt(page), Integer.parseInt(rows), startDate, endDate, paramDorm);
/*     */ 
/* 114 */     JSONObject jobj = new JSONObject();
/* 115 */     jobj.put("total", pagination.getTotalCount());
/* 116 */     jobj.put("rows", pagination.getDatas());
/*     */ 
/* 118 */     response.setCharacterEncoding("utf-8");
/* 119 */     response.getWriter().write(jobj.toString());
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.controller.ScoreController
 * JD-Core Version:    0.6.0
 */
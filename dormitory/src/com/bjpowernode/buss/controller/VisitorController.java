/*     */ package com.bjpowernode.buss.controller;
/*     */ 
/*     */ import com.bjpowernode.buss.entity.base.StudentEntity;
/*     */ import com.bjpowernode.buss.entity.base.VisitorEntity;
/*     */ import com.bjpowernode.buss.service.VisitorService;
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
/*     */ @RequestMapping({"/visitorController"})
/*     */ public class VisitorController extends BaseController
/*     */ {
/*  27 */   private static final Logger logger = Logger.getLogger(VisitorController.class);
/*     */ 
/*     */   @Autowired
/*     */   private VisitorService visitorService;
/*     */ 
/*     */   @RequestMapping(params={"goVisitor"})
/*     */   public ModelAndView goVisitor(HttpServletRequest request)
/*     */   {
/*  40 */     return new ModelAndView("buss/visitor");
/*     */   }
/*  46 */   @RequestMapping(params={"save"})
/*     */   @ResponseBody
/*     */   public AjaxJson save(HttpServletRequest request, HttpServletResponse response, VisitorEntity visitorEntity, String studentid) throws Exception { AjaxJson j = new AjaxJson();
/*  47 */     j.setMsg("保存成功！");
/*  48 */     j.setSuccess(true);
/*     */     try {
/*  50 */       StudentEntity se = (StudentEntity)this.visitorService.get(StudentEntity.class, studentid);
/*  51 */       visitorEntity.setStudent(se);
/*  52 */       this.visitorService.save(visitorEntity);
/*     */     } catch (Exception e) {
/*  54 */       j.setMsg("保存失败！");
/*  55 */       j.setSuccess(false);
/*     */     }
/*  57 */     return j; }
/*     */ 
/*     */   @RequestMapping(params={"update"})
/*     */   @ResponseBody
/*     */   public AjaxJson update(HttpServletRequest request, HttpServletResponse response, VisitorEntity visitorEntity, String studentid) throws Exception {
/*  64 */     AjaxJson j = new AjaxJson();
/*  65 */     j.setMsg("更新成功！");
/*  66 */     j.setSuccess(true);
/*     */     try {
/*  68 */       StudentEntity se = (StudentEntity)this.visitorService.get(StudentEntity.class, studentid);
/*  69 */       visitorEntity.setStudent(se);
/*  70 */       this.visitorService.update(visitorEntity);
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
/*  87 */         VisitorEntity visitorEntity = new VisitorEntity();
/*  88 */         visitorEntity.setId(id);
/*  89 */         this.visitorService.delete(visitorEntity);
/*     */       }
/*     */     } catch (Exception e) {
/*  92 */       j.setMsg("删除失败！");
/*  93 */       j.setSuccess(false);
/*     */     }
/*  95 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"datagrid"})
/*     */   @ResponseBody
/*     */   public void datagrid(HttpServletRequest request, HttpServletResponse response, VisitorEntity ve, String studentname) throws Exception {
/* 102 */     String page = request.getParameter("page");
/* 103 */     String rows = request.getParameter("rows");
/* 104 */     if (page == null) {
/* 105 */       page = "0";
/*     */     }
/* 107 */     if (rows == null) {
/* 108 */       rows = "0";
/*     */     }
/* 110 */     DetachedCriteria condition = DetachedCriteria.forClass(VisitorEntity.class);
/* 111 */     Pagination pagination = this.visitorService.findPageData(condition, ve, Integer.parseInt(page), Integer.parseInt(rows), studentname);
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
 * Qualified Name:     com.bjpowernode.buss.controller.VisitorController
 * JD-Core Version:    0.6.0
 */
/*     */ package com.bjpowernode.buss.controller;
/*     */ 
/*     */ import com.bjpowernode.buss.entity.base.ClassEntity;
/*     */ import com.bjpowernode.buss.service.ClassService;
/*     */ import com.bjpowernode.common.controller.BaseController;
/*     */ import com.bjpowernode.common.util.AjaxJson;
/*     */ import com.bjpowernode.common.util.Pagination;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.hibernate.criterion.DetachedCriteria;
/*     */ import org.hibernate.exception.ConstraintViolationException;
/*     */ import org.json.JSONObject;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/classController"})
/*     */ public class ClassController extends BaseController
/*     */ {
/*  27 */   private static final Logger logger = Logger.getLogger(ClassController.class);
/*     */ 
/*     */   @Autowired
/*     */   private ClassService classService;
/*     */ 
/*     */   @RequestMapping(params={"goClass"})
/*     */   public ModelAndView goClass(HttpServletRequest request)
/*     */   {
/*  40 */     return new ModelAndView("buss/classmanage");
/*     */   }
/*  46 */   @RequestMapping(params={"save"})
/*     */   @ResponseBody
/*     */   public AjaxJson save(HttpServletRequest request, HttpServletResponse response, ClassEntity classEntity) throws Exception { AjaxJson j = new AjaxJson();
/*  47 */     j.setMsg("保存成功！");
/*  48 */     j.setSuccess(true);
/*     */     try {
/*  50 */       this.classService.save(classEntity);
/*     */     } catch (Exception e) {
/*  52 */       j.setMsg("保存失败！");
/*  53 */       j.setSuccess(false);
/*     */     }
/*  55 */     return j; }
/*     */ 
/*     */   @RequestMapping(params={"update"})
/*     */   @ResponseBody
/*     */   public AjaxJson update(HttpServletRequest request, HttpServletResponse response, ClassEntity classEntity) throws Exception {
/*  62 */     AjaxJson j = new AjaxJson();
/*  63 */     j.setMsg("更新成功！");
/*  64 */     j.setSuccess(true);
/*     */     try {
/*  66 */       this.classService.update(classEntity);
/*     */     } catch (Exception e) {
/*  68 */       j.setMsg("更新失败！");
/*  69 */       j.setSuccess(false);
/*     */     }
/*  71 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxJson delete(HttpServletRequest request, HttpServletResponse response, String ids) throws Exception {
/*  78 */     AjaxJson j = new AjaxJson();
/*  79 */     j.setMsg("删除成功！");
/*  80 */     j.setSuccess(true);
/*     */     try {
/*  82 */       for (String id : ids.split(",")) {
/*  83 */         ClassEntity classEntity = new ClassEntity();
/*  84 */         classEntity.setId(id);
/*  85 */         this.classService.delete(classEntity);
/*     */       }
/*     */     } catch (ConstraintViolationException ce) {
/*  88 */       ce.printStackTrace();
/*  89 */       j.setMsg("删除失败,存在外键引用，请查看其它数据项中是否有与当前数据有关的信息!");
/*  90 */       j.setSuccess(false);
/*     */     } catch (Exception e) {
/*  92 */       j.setMsg("删除失败！");
/*  93 */       j.setSuccess(false);
/*     */     }
/*  95 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"datagrid"})
/*     */   @ResponseBody
/*     */   public void datagrid(HttpServletRequest request, HttpServletResponse response, ClassEntity ce) throws Exception {
/* 102 */     String page = request.getParameter("page");
/* 103 */     String rows = request.getParameter("rows");
/* 104 */     if (page == null) {
/* 105 */       page = "0";
/*     */     }
/* 107 */     if (rows == null) {
/* 108 */       rows = "0";
/*     */     }
/* 110 */     DetachedCriteria condition = DetachedCriteria.forClass(ClassEntity.class);
/* 111 */     Pagination pagination = this.classService.findPageData(condition, ce, Integer.parseInt(page), Integer.parseInt(rows));
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
 * Qualified Name:     com.bjpowernode.buss.controller.ClassController
 * JD-Core Version:    0.6.0
 */
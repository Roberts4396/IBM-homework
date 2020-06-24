/*     */ package com.bjpowernode.buss.controller;
/*     */ 
/*     */ import com.bjpowernode.buss.entity.base.DormEntity;
/*     */ import com.bjpowernode.buss.service.DormService;
/*     */ import com.bjpowernode.common.controller.BaseController;
/*     */ import com.bjpowernode.common.util.AjaxJson;
/*     */ import com.bjpowernode.common.util.MyBeanUtils;
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
/*     */ @RequestMapping({"/dormController"})
/*     */ public class DormController extends BaseController
/*     */ {
/*  28 */   private static final Logger logger = Logger.getLogger(DormController.class);
/*     */ 
/*     */   @Autowired
/*     */   private DormService dormService;
/*     */ 
/*     */   @RequestMapping(params={"goDorm"})
/*     */   public ModelAndView goDorm(HttpServletRequest request)
/*     */   {
/*  41 */     return new ModelAndView("buss/dorm");
/*     */   }
/*  47 */   @RequestMapping(params={"save"})
/*     */   @ResponseBody
/*     */   public AjaxJson save(HttpServletRequest request, HttpServletResponse response, DormEntity dormEntity) throws Exception { AjaxJson j = new AjaxJson();
/*  48 */     j.setMsg("保存成功！");
/*  49 */     j.setSuccess(true);
/*     */     try {
/*  51 */       dormEntity.setUsed(dormEntity.getTotal());
/*  52 */       this.dormService.save(dormEntity);
/*     */     } catch (Exception e) {
/*  54 */       j.setMsg("保存失败！");
/*  55 */       j.setSuccess(false);
/*     */     }
/*  57 */     return j; }
/*     */ 
/*     */   @RequestMapping(params={"update"})
/*     */   @ResponseBody
/*     */   public AjaxJson update(HttpServletRequest request, HttpServletResponse response, DormEntity dormEntity) throws Exception {
/*  64 */     AjaxJson j = new AjaxJson();
/*  65 */     j.setMsg("更新成功！");
/*  66 */     j.setSuccess(true);
/*     */     try {
/*  68 */       DormEntity dorm = (DormEntity)this.dormService.get(DormEntity.class, dormEntity.getId());
/*  69 */       MyBeanUtils.copyBeanNotNull2Bean(dormEntity, dorm);
/*  70 */       this.dormService.update(dorm);
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
/*  87 */         DormEntity dormEntity = new DormEntity();
/*  88 */         dormEntity.setId(id);
/*  89 */         this.dormService.delete(dormEntity);
/*     */       }
/*     */     } catch (ConstraintViolationException ce) {
/*  92 */       ce.printStackTrace();
/*  93 */       j.setMsg("删除失败,存在外键引用，请查看其它数据项中是否有与当前数据有关的信息!");
/*  94 */       j.setSuccess(false);
/*     */     } catch (Exception e) {
/*  96 */       j.setMsg("删除失败！");
/*  97 */       j.setSuccess(false);
/*     */     }
/*  99 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"datagrid"})
/*     */   @ResponseBody
/*     */   public void datagrid(HttpServletRequest request, HttpServletResponse response, DormEntity ve, String assignDorm) throws Exception {
/* 106 */     String page = request.getParameter("page");
/* 107 */     String rows = request.getParameter("rows");
/* 108 */     if (page == null) {
/* 109 */       page = "0";
/*     */     }
/* 111 */     if (rows == null) {
/* 112 */       rows = "0";
/*     */     }
/* 114 */     DetachedCriteria condition = DetachedCriteria.forClass(DormEntity.class);
/* 115 */     Pagination pagination = this.dormService.findPageData(condition, ve, Integer.parseInt(page), Integer.parseInt(rows), assignDorm);
/*     */ 
/* 117 */     JSONObject jobj = new JSONObject();
/* 118 */     jobj.put("total", pagination.getTotalCount());
/* 119 */     jobj.put("rows", pagination.getDatas());
/*     */ 
/* 121 */     response.setCharacterEncoding("utf-8");
/* 122 */     response.getWriter().write(jobj.toString());
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.controller.DormController
 * JD-Core Version:    0.6.0
 */
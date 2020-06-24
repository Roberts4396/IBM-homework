/*     */ package com.bjpowernode.system.controller;
/*     */ 
/*     */ import com.bjpowernode.common.controller.BaseController;
/*     */ import com.bjpowernode.common.util.AjaxJson;
/*     */ import com.bjpowernode.common.util.Pagination;
/*     */ import com.bjpowernode.system.entity.base.ResourceEntity;
/*     */ import com.bjpowernode.system.service.SystemService;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.hibernate.criterion.DetachedCriteria;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/resourceController"})
/*     */ public class ResourceController extends BaseController
/*     */ {
/*  27 */   private static final Logger logger = Logger.getLogger(ResourceController.class);
/*     */ 
/*     */   @Autowired
/*     */   private SystemService systemService;
/*     */ 
/*     */   @RequestMapping(params={"goResource"})
/*     */   public ModelAndView goResource(HttpServletRequest request)
/*     */   {
/*  41 */     return new ModelAndView("system/resource");
/*     */   }
/*  47 */   @RequestMapping(params={"save"})
/*     */   @ResponseBody
/*     */   public AjaxJson save(HttpServletRequest request, HttpServletResponse response, ResourceEntity resource, String parentid) throws Exception { AjaxJson j = new AjaxJson();
/*  48 */     j.setMsg("保存成功！");
/*  49 */     j.setSuccess(true);
/*     */     try {
/*  51 */       ResourceEntity patentRes = new ResourceEntity();
/*  52 */       patentRes.setId(parentid);
/*  53 */       resource.setParentResource(patentRes);
/*  54 */       this.systemService.save(resource);
/*     */     } catch (Exception e) {
/*  56 */       j.setMsg("保存失败！");
/*  57 */       j.setSuccess(false);
/*     */     }
/*  59 */     return j; }
/*     */ 
/*     */   @RequestMapping(params={"update"})
/*     */   @ResponseBody
/*     */   public AjaxJson update(HttpServletRequest request, HttpServletResponse response, ResourceEntity resource, String parentid) throws Exception {
/*  66 */     AjaxJson j = new AjaxJson();
/*  67 */     j.setMsg("更新成功！");
/*  68 */     j.setSuccess(true);
/*     */     try {
/*  70 */       ResourceEntity patentRes = new ResourceEntity();
/*  71 */       patentRes.setId(parentid);
/*  72 */       resource.setParentResource(patentRes);
/*  73 */       this.systemService.update(resource);
/*     */     } catch (Exception e) {
/*  75 */       j.setMsg("更新失败！");
/*  76 */       j.setSuccess(false);
/*     */     }
/*  78 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxJson delete(HttpServletRequest request, HttpServletResponse response, String ids) throws Exception {
/*  85 */     AjaxJson j = new AjaxJson();
/*  86 */     j.setMsg("删除成功！");
/*  87 */     j.setSuccess(true);
/*     */     try {
/*  89 */       for (String id : ids.split(",")) {
/*  90 */         ResourceEntity resource = new ResourceEntity();
/*  91 */         resource.setId(id);
/*  92 */         this.systemService.delete(resource);
/*     */       }
/*     */     } catch (Exception e) {
/*  95 */       j.setMsg("删除失败！");
/*  96 */       j.setSuccess(false);
/*     */     }
/*  98 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"datagrid"})
/*     */   @ResponseBody
/*     */   public void datagrid(HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 105 */     String page = request.getParameter("page");
/* 106 */     String rows = request.getParameter("rows");
/* 107 */     if (page == null) {
/* 108 */       page = "0";
/*     */     }
/* 110 */     if (rows == null) {
/* 111 */       rows = "0";
/*     */     }
/* 113 */     DetachedCriteria condition = DetachedCriteria.forClass(ResourceEntity.class);
/* 114 */     Pagination pagination = this.systemService.getPageData(condition, Integer.parseInt(page), Integer.parseInt(rows));
/* 115 */     List list = pagination.getDatas();
/* 116 */     String resourceJson = this.systemService.getTreeJson(list);
/*     */ 
/* 118 */     response.setCharacterEncoding("utf-8");
/* 119 */     response.getWriter().write(resourceJson);
/*     */   }
/*     */   @RequestMapping(params={"treeDropdown"})
/*     */   @ResponseBody
/*     */   public void treeDropdown(HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 126 */     String page = request.getParameter("page");
/* 127 */     String rows = request.getParameter("rows");
/* 128 */     if (page == null) {
/* 129 */       page = "0";
/*     */     }
/* 131 */     if (rows == null) {
/* 132 */       rows = "0";
/*     */     }
/* 134 */     DetachedCriteria condition = DetachedCriteria.forClass(ResourceEntity.class);
/* 135 */     Pagination pagination = this.systemService.getPageData(condition, Integer.parseInt(page), Integer.parseInt(rows));
/* 136 */     List list = pagination.getDatas();
/* 137 */     String retJson = this.systemService.getTreeJson(list);
/* 138 */     String resourceJson = retJson.replaceAll("\"name\"", "\"text\"");
/* 139 */     response.setCharacterEncoding("utf-8");
/* 140 */     response.getWriter().write(resourceJson);
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.controller.ResourceController
 * JD-Core Version:    0.6.0
 */
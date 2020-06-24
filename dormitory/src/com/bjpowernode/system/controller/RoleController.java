/*     */ package com.bjpowernode.system.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.bjpowernode.common.controller.BaseController;
/*     */ import com.bjpowernode.common.util.AjaxJson;
/*     */ import com.bjpowernode.common.util.Pagination;
/*     */ import com.bjpowernode.system.entity.base.ResourceEntity;
/*     */ import com.bjpowernode.system.entity.base.RoleEntity;
/*     */ import com.bjpowernode.system.service.SystemService;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
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
/*     */ @RequestMapping({"/roleController"})
/*     */ public class RoleController extends BaseController
/*     */ {
/*  30 */   private static final Logger logger = Logger.getLogger(RoleController.class);
/*     */ 
/*     */   @Autowired
/*     */   private SystemService systemService;
/*     */ 
/*     */   @RequestMapping(params={"goRole"})
/*     */   public ModelAndView goRole(HttpServletRequest request)
/*     */   {
/*  44 */     return new ModelAndView("system/role");
/*     */   }
/*     */ 
/*     */   private List<ResourceEntity> getResources(String resourceids) {
/*  48 */     if (resourceids == null) {
/*  49 */       return null;
/*     */     }
/*  51 */     String[] resources = resourceids.split(",");
/*  52 */     List resList = new ArrayList();
/*  53 */     for (int i = 0; i < resources.length; i++) {
/*  54 */       ResourceEntity res = new ResourceEntity();
/*  55 */       res = (ResourceEntity)this.systemService.get(ResourceEntity.class, resources[i]);
/*  56 */       resList.add(res);
/*     */     }
/*  58 */     return resList;
/*     */   }
/*  64 */   @RequestMapping(params={"save"})
/*     */   @ResponseBody
/*     */   public AjaxJson save(HttpServletRequest request, HttpServletResponse response, RoleEntity role, String resourceids) throws Exception { AjaxJson j = new AjaxJson();
/*     */ 
/*  66 */     role.setResource(getResources(resourceids));
/*  67 */     j.setMsg("保存成功！");
/*  68 */     j.setSuccess(true);
/*     */     try {
/*  70 */       this.systemService.save(role);
/*     */     } catch (Exception e) {
/*  72 */       j.setMsg("保存失败！");
/*  73 */       j.setSuccess(false);
/*     */     }
/*  75 */     return j; }
/*     */ 
/*     */   @RequestMapping(params={"update"})
/*     */   @ResponseBody
/*     */   public AjaxJson update(HttpServletRequest request, HttpServletResponse response, RoleEntity role, String resourceids) throws Exception {
/*  82 */     AjaxJson j = new AjaxJson();
/*  83 */     j.setMsg("更新成功！");
/*  84 */     j.setSuccess(true);
/*     */     try {
/*  86 */       role.setResource(getResources(resourceids));
/*  87 */       this.systemService.update(role);
/*     */     } catch (Exception e) {
/*  89 */       j.setMsg("更新失败！");
/*  90 */       j.setSuccess(false);
/*     */     }
/*  92 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxJson delete(HttpServletRequest request, HttpServletResponse response, String ids) throws Exception {
/*  99 */     AjaxJson j = new AjaxJson();
/* 100 */     j.setMsg("删除成功！");
/* 101 */     j.setSuccess(true);
/*     */     try {
/* 103 */       for (String id : ids.split(",")) {
/* 104 */         RoleEntity role = new RoleEntity();
/* 105 */         role.setId(id);
/* 106 */         this.systemService.delete(role);
/*     */       }
/*     */     } catch (Exception e) {
/* 109 */       j.setMsg("删除失败！");
/* 110 */       j.setSuccess(false);
/*     */     }
/* 112 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"queryResource"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxJson queryResource(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
/* 119 */     AjaxJson j = new AjaxJson();
/* 120 */     j.setMsg("成功！");
/* 121 */     j.setSuccess(true);
/*     */     try {
/* 123 */       RoleEntity re = (RoleEntity)this.systemService.get(RoleEntity.class, id);
/* 124 */       String resourceId = "";
/* 125 */       for (ResourceEntity res : re.getResource()) {
/* 126 */         if ((res.getResources() == null) || (res.getResources().size() == 0)) {
/* 127 */           resourceId = resourceId + res.getId() + ",";
/*     */         }
/*     */       }
/*     */ 
/* 131 */       if (resourceId.length() > 0) {
/* 132 */         resourceId = resourceId.substring(0, resourceId.length() - 1);
/*     */       }
/* 134 */       j.setObj(resourceId);
/*     */     } catch (Exception e) {
/* 136 */       j.setMsg("失败！");
/* 137 */       j.setSuccess(false);
/*     */     }
/* 139 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"dropdown"})
/*     */   @ResponseBody
/*     */   public void dropdown(HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 146 */     DetachedCriteria condition = DetachedCriteria.forClass(RoleEntity.class);
/* 147 */     Pagination pagination = this.systemService.getPageData(condition, 0, 0);
/* 148 */     List<RoleEntity> list = pagination.getDatas();
/* 149 */     StringBuffer sb = new StringBuffer();
/* 150 */     sb.append("[");
/* 151 */     for (RoleEntity re : list) {
/* 152 */       sb.append("{");
/* 153 */       sb.append("\"id\":");
/* 154 */       sb.append("\"");
/* 155 */       sb.append(re.getId());
/* 156 */       sb.append("\"");
/* 157 */       sb.append(",");
/* 158 */       sb.append("\"text\":");
/* 159 */       sb.append("\"");
/* 160 */       sb.append(re.getName());
/* 161 */       sb.append("\"");
/* 162 */       sb.append("},");
/*     */     }
/* 164 */     String dropdown = sb.substring(0, sb.length() - 1);
/* 165 */     dropdown = dropdown + "]";
/* 166 */     response.setCharacterEncoding("utf-8");
/* 167 */     response.getWriter().write(dropdown);
/*     */   }
/*     */   @RequestMapping(params={"datagrid"})
/*     */   @ResponseBody
/*     */   public void datagrid(HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 174 */     String page = request.getParameter("page");
/* 175 */     String rows = request.getParameter("rows");
/* 176 */     if (page == null) {
/* 177 */       page = "0";
/*     */     }
/* 179 */     if (rows == null) {
/* 180 */       rows = "0";
/*     */     }
/* 182 */     DetachedCriteria condition = DetachedCriteria.forClass(RoleEntity.class);
/* 183 */     Pagination pagination = this.systemService.getPageData(condition, Integer.parseInt(page), Integer.parseInt(rows));
/* 184 */     JSONObject jobj = new JSONObject();
/* 185 */     jobj.put("total", Integer.valueOf(pagination.getTotalCount()));
/* 186 */     jobj.put("rows", pagination.getDatas());
/*     */ 
/* 188 */     response.setCharacterEncoding("utf-8");
/* 189 */     response.getWriter().write(jobj.toString());
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.controller.RoleController
 * JD-Core Version:    0.6.0
 */
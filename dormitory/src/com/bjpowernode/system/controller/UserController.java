/*     */ package com.bjpowernode.system.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.bjpowernode.common.controller.BaseController;
/*     */ import com.bjpowernode.common.util.AjaxJson;
/*     */ import com.bjpowernode.common.util.Pagination;
/*     */ import com.bjpowernode.system.entity.base.RoleEntity;
/*     */ import com.bjpowernode.system.entity.base.UserEntity;
/*     */ import com.bjpowernode.system.service.SystemService;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.shiro.crypto.hash.Md5Hash;
/*     */ import org.hibernate.criterion.DetachedCriteria;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/userController"})
/*     */ public class UserController extends BaseController
/*     */ {
/*  32 */   private static final Logger logger = Logger.getLogger(UserController.class);
/*     */ 
/*     */   @Autowired
/*     */   private SystemService systemService;
/*     */ 
/*     */   @RequestMapping(params={"goUser"})
/*     */   public ModelAndView goUser(HttpServletRequest request)
/*     */   {
/*  46 */     return new ModelAndView("system/user");
/*     */   }
/*  52 */   @RequestMapping(params={"checkRemote"})
/*     */   @ResponseBody
/*     */   public void checkRemote(HttpServletRequest request, HttpServletResponse response, String signcode) throws Exception { UserEntity user = (UserEntity)this.systemService.findUniqueByProperty(UserEntity.class, "username", signcode);
/*  53 */     String flag = "true";
/*  54 */     if (user != null) {
/*  55 */       flag = "false";
/*     */     }
/*  57 */     response.setCharacterEncoding("utf-8");
/*  58 */     response.getWriter().write(flag); }
/*     */ 
/*     */   @RequestMapping(params={"save"})
/*     */   @ResponseBody
/*     */   public AjaxJson save(HttpServletRequest request, HttpServletResponse response, UserEntity user, String roleid) throws Exception {
/*  65 */     AjaxJson j = new AjaxJson();
/*  66 */     j.setMsg("保存成功！");
/*  67 */     j.setSuccess(true);
/*     */     try {
/*  69 */       Md5Hash md5Hash = new Md5Hash(user.getPassword());
/*  70 */       user.setPassword(md5Hash.toHex());
/*  71 */       user.setRoles(getRoleList(roleid));
/*  72 */       this.systemService.save(user);
/*     */     } catch (Exception e) {
/*  74 */       j.setMsg("保存失败！");
/*  75 */       j.setSuccess(false);
/*     */     }
/*  77 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"update"})
/*     */   @ResponseBody
/*     */   public AjaxJson update(HttpServletRequest request, HttpServletResponse response, UserEntity user, String roleid) throws Exception {
/*  84 */     AjaxJson j = new AjaxJson();
/*  85 */     j.setMsg("更新成功！");
/*  86 */     j.setSuccess(true);
/*     */     try {
/*  88 */       UserEntity t = (UserEntity)this.systemService.get(UserEntity.class, user.getId());
/*  89 */       user.setRoles(getRoleList(roleid));
/*  90 */       user.setPassword(t.getPassword());
/*  91 */       user.setUsername(t.getUsername());
/*  92 */       BeanUtils.copyProperties(t, user);
/*  93 */       this.systemService.update(t);
/*     */     } catch (Exception e) {
/*  95 */       j.setMsg("更新失败！");
/*  96 */       j.setSuccess(false);
/*     */     }
/*  98 */     return j;
/*     */   }
/*     */ 
/*     */   private List<RoleEntity> getRoleList(String roleid)
/*     */   {
/* 103 */     if (roleid == null) {
/* 104 */       return null;
/*     */     }
/* 106 */     String[] ids = roleid.split(",");
/* 107 */     List roleList = new ArrayList();
/* 108 */     for (String id : ids) {
/* 109 */       RoleEntity re = (RoleEntity)this.systemService.get(RoleEntity.class, id);
/* 110 */       roleList.add(re);
/*     */     }
/* 112 */     return roleList;
/*     */   }
/* 118 */   @RequestMapping(params={"delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxJson delete(HttpServletRequest request, HttpServletResponse response, String ids) throws Exception { AjaxJson j = new AjaxJson();
/* 119 */     j.setMsg("删除成功！");
/* 120 */     j.setSuccess(true);
/*     */     try {
/* 122 */       for (String id : ids.split(",")) {
/* 123 */         UserEntity user = new UserEntity();
/* 124 */         user.setId(id);
/* 125 */         this.systemService.delete(user);
/*     */       }
/*     */     } catch (Exception e) {
/* 128 */       j.setMsg("删除失败！");
/* 129 */       j.setSuccess(false);
/*     */     }
/* 131 */     return j; }
/*     */ 
/*     */   @RequestMapping(params={"queryRole"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxJson queryRole(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
/* 138 */     AjaxJson j = new AjaxJson();
/* 139 */     j.setMsg("成功！");
/* 140 */     j.setSuccess(true);
/*     */     try {
/* 142 */       UserEntity user = (UserEntity)this.systemService.get(UserEntity.class, id);
/* 143 */       String roleId = "";
/* 144 */       for (RoleEntity re : user.getRoles()) {
/* 145 */         roleId = roleId + re.getId() + ",";
/*     */       }
/* 147 */       if (roleId.length() > 0) {
/* 148 */         roleId = roleId.substring(0, roleId.length() - 1);
/*     */       }
/* 150 */       j.setObj(roleId);
/*     */     } catch (Exception e) {
/* 152 */       j.setMsg("失败！");
/* 153 */       j.setSuccess(false);
/*     */     }
/* 155 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"datagrid"})
/*     */   @ResponseBody
/*     */   public void datagrid(HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 162 */     String page = request.getParameter("page");
/* 163 */     String rows = request.getParameter("rows");
/* 164 */     if (page == null) {
/* 165 */       page = "0";
/*     */     }
/* 167 */     if (rows == null) {
/* 168 */       rows = "0";
/*     */     }
/* 170 */     DetachedCriteria condition = DetachedCriteria.forClass(UserEntity.class);
/* 171 */     Pagination pagination = this.systemService.getPageData(condition, Integer.parseInt(page), Integer.parseInt(rows));
/*     */ 
/* 173 */     JSONObject jobj = new JSONObject();
/* 174 */     jobj.put("total", Integer.valueOf(pagination.getTotalCount()));
/* 175 */     jobj.put("rows", pagination.getDatas());
/*     */ 
/* 177 */     response.setCharacterEncoding("utf-8");
/* 178 */     response.getWriter().write(jobj.toString());
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.controller.UserController
 * JD-Core Version:    0.6.0
 */
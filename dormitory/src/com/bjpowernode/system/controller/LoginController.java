/*     */ package com.bjpowernode.system.controller;
/*     */ 
/*     */ import com.bjpowernode.common.util.AjaxJson;
/*     */ import com.bjpowernode.common.util.ContextHolderUtils;
/*     */ import com.bjpowernode.common.util.ResourceUtil;
/*     */ import com.bjpowernode.system.entity.base.ResourceEntity;
/*     */ import com.bjpowernode.system.entity.base.RoleEntity;
/*     */ import com.bjpowernode.system.entity.base.UserEntity;
/*     */ import com.bjpowernode.system.manager.ClientManager;
/*     */ import com.bjpowernode.system.service.SystemService;
/*     */ import com.bjpowernode.system.vo.Client;
/*     */ import com.bjpowernode.system.vo.TreeNode;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONObject;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ import org.springframework.web.servlet.view.RedirectView;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/loginController"})
/*     */ public class LoginController
/*     */ {
/*  39 */   private static final Logger logger = Logger.getLogger(LoginController.class);
/*     */ 
/*     */   @Autowired
/*     */   private SystemService systemService;
/*     */ 
/*     */   @RequestMapping(params={"login"})
/*     */   public ModelAndView login(HttpServletRequest request)
/*     */   {
/*  52 */     return new ModelAndView("system/login");
/*     */   }
/*     */   @RequestMapping(params={"home"})
/*     */   public ModelAndView home(HttpServletRequest request) {
/*  57 */     return new ModelAndView("system/home");
/*     */   }
/*     */ 
/*     */   @RequestMapping(params={"logout"})
/*     */   public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  68 */     HttpSession session = ContextHolderUtils.getSession();
/*  69 */     ClientManager.getInstance().removeClinet(session.getId());
/*  70 */     session.invalidate();
/*  71 */     ModelAndView modelAndView = new ModelAndView(
/*  72 */       new RedirectView("loginController.do?login"));
/*     */ 
/*  74 */     return modelAndView;
/*     */   }
/*     */   @RequestMapping(params={"doLogin"})
/*     */   public ModelAndView doLogin(HttpServletRequest req) {
/*  79 */     ModelAndView mav = new ModelAndView("system/main");
/*  80 */     HttpSession session = ContextHolderUtils.getSession();
/*  81 */     Client client = ClientManager.getInstance().getClient(session.getId());
/*  82 */     req.setAttribute("username", client.getUser().getUsername());
/*  83 */     return mav;
/*     */   }
/*  89 */   @RequestMapping(params={"doCheck"})
/*     */   @ResponseBody
/*     */   public AjaxJson doCheck(HttpServletRequest req, String username, String password, String captcha) { HttpSession session = ContextHolderUtils.getSession();
/*  90 */     AjaxJson j = new AjaxJson();
/*     */ 
/*  92 */     if (!captcha.equalsIgnoreCase(String.valueOf(session.getAttribute("SE_KEY_MM_CODE")))) {
/*  93 */       j.setSuccess(false);
/*  94 */       j.setMsg("验证码错误!");
/*     */     } else {
/*  96 */       UserEntity user = new UserEntity();
/*  97 */       user.setUsername(username);
/*  98 */       user.setPassword(password);
/*  99 */       user = this.systemService.getUserByNameAndPassword(user);
/* 100 */       if (user == null) {
/* 101 */         j.setSuccess(false);
/* 102 */         j.setMsg("用户名或密码错误！");
/* 103 */         return j;
/*     */       }
/* 105 */       List resourceList = new ArrayList();
/* 106 */       List<RoleEntity> roleList = user.getRoles();
/* 107 */       for (RoleEntity re : roleList) {
/* 108 */         List<ResourceEntity> tempRes = re.getResource();
/* 109 */         for (ResourceEntity res : tempRes) {
/* 110 */           if (!resourceList.contains(res)) {
/* 111 */             resourceList.add(res);
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 116 */       Client client = new Client();
/* 117 */       client.setIp(ResourceUtil.getIpAddr(req));
/* 118 */       client.setLogindatetime(new Date());
/* 119 */       client.setUser(user);
/* 120 */       client.setMenuList(resourceList);
/* 121 */       ClientManager.getInstance().addClinet(session.getId(), 
/* 122 */         client);
/* 123 */       if ((user != null) && (user.getId() != null)) {
/* 124 */         j.setSuccess(true);
/* 125 */         j.setMsg("登陆成功！");
/*     */       } else {
/* 127 */         j.setSuccess(false);
/* 128 */         j.setMsg("用户名或密码错误!");
/*     */       }
/*     */     }
/* 131 */     return j; }
/*     */ 
/*     */   @RequestMapping(params={"getTreeMenu"})
/*     */   @ResponseBody
/*     */   public String getTreeMenu(HttpServletRequest request) {
/* 138 */     Client client = ResourceUtil.getClient();
/* 139 */     List<ResourceEntity> resourceList = new ArrayList();
/* 140 */     if ((client == null) || (client.getUser() == null)) {
/* 141 */       return "system/login";
/*     */     }
/* 143 */     resourceList = client.getMenuList();
/*     */ 
/* 146 */     List resource = new ArrayList();
/* 147 */     for (ResourceEntity re : resourceList) {
/* 148 */       if (resourceList.size() <= 0) {
/*     */         break;
/*     */       }
/* 151 */       if ("1".equals(re.getId())) {
/* 152 */         resource.add(re);
/* 153 */         break;
/*     */       }
/*     */     }
/* 156 */     return JSONObject.valueToString(resourceToTreeNode(resource, resourceList));
/*     */   }
/*     */ 
/*     */   private List<TreeNode> resourceToTreeNode(List<ResourceEntity> resource, List<ResourceEntity> userResource)
/*     */   {
/* 165 */     if ((resource != null) && (!resource.isEmpty()) && (((ResourceEntity)resource.get(0)).getResourceType().intValue() == ResourceEntity.TYPE_MENU)) {
/* 166 */       List ch = new ArrayList();
/* 167 */       for (ResourceEntity rr : resource) {
/* 168 */         TreeNode node = new TreeNode();
/* 169 */         if (userResource.contains(rr)) {
/* 170 */           if (rr.getHref() == null)
/* 171 */             node.setId(rr.getId());
/*     */           else {
/* 173 */             node.setId(rr.getId());
/*     */           }
/* 175 */           node.setId(rr.getId());
/* 176 */           node.setState("open");
/* 177 */           node.setText(rr.getName());
/*     */ 
/* 179 */           Map _temp = new HashMap();
/* 180 */           _temp.put("href", rr.getHref());
/* 181 */           node.setAttributes(_temp);
/*     */ 
/* 183 */           ch.add(node);
/*     */         }
/*     */ 
/* 186 */         node.setChildren(resourceToTreeNode(rr.getResources(), userResource));
/*     */       }
/*     */ 
/* 189 */       return ch;
/*     */     }
/* 191 */     return Collections.emptyList();
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.controller.LoginController
 * JD-Core Version:    0.6.0
 */
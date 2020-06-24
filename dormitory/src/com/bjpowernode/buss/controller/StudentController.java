/*     */ package com.bjpowernode.buss.controller;
/*     */ 
/*     */ import com.bjpowernode.buss.entity.base.ClassEntity;
/*     */ import com.bjpowernode.buss.entity.base.DormEntity;
/*     */ import com.bjpowernode.buss.entity.base.StudentEntity;
/*     */ import com.bjpowernode.buss.service.StudentService;
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
/*     */ @RequestMapping({"/studentController"})
/*     */ public class StudentController extends BaseController
/*     */ {
/*  29 */   private static final Logger logger = Logger.getLogger(StudentController.class);
/*     */ 
/*     */   @Autowired
/*     */   private StudentService studentService;
/*     */ 
/*     */   @RequestMapping(params={"goStudent"})
/*     */   public ModelAndView goStudent(HttpServletRequest request)
/*     */   {
/*  42 */     return new ModelAndView("buss/student");
/*     */   }
/*  48 */   @RequestMapping(params={"save"})
/*     */   @ResponseBody
/*     */   public AjaxJson save(HttpServletRequest request, HttpServletResponse response, StudentEntity student, String dormid, String classid) throws Exception { AjaxJson j = new AjaxJson();
/*  49 */     j.setMsg("保存成功！");
/*  50 */     j.setSuccess(true);
/*     */     try {
/*  52 */       DormEntity de = (DormEntity)this.studentService.get(DormEntity.class, dormid);
/*  53 */       ClassEntity ce = (ClassEntity)this.studentService.get(ClassEntity.class, classid);
/*  54 */       student.setDorm(de);
/*  55 */       student.setClasses(ce);
/*  56 */       int surplus = Integer.parseInt(de.getUsed());
/*  57 */       if (surplus <= 0) {
/*  58 */         j.setMsg("该宿舍床位已满");
/*  59 */         j.setSuccess(false);
/*  60 */         return j;
/*     */       }
/*  62 */       surplus--;
/*  63 */       de.setUsed(String.valueOf(surplus));
/*  64 */       this.studentService.update(de);
/*  65 */       this.studentService.save(student);
/*     */     } catch (Exception e) {
/*  67 */       j.setMsg("保存失败！");
/*  68 */       j.setSuccess(false);
/*     */     }
/*  70 */     return j; }
/*     */ 
/*     */   @RequestMapping(params={"update"})
/*     */   @ResponseBody
/*     */   public AjaxJson update(HttpServletRequest request, HttpServletResponse response, StudentEntity student, String dormid, String classid) throws Exception {
/*  77 */     AjaxJson j = new AjaxJson();
/*  78 */     j.setMsg("更新成功！");
/*  79 */     j.setSuccess(true);
/*     */     try {
/*  81 */       StudentEntity se = (StudentEntity)this.studentService.get(StudentEntity.class, student.getId());
/*  82 */       DormEntity de = (DormEntity)this.studentService.get(DormEntity.class, dormid);
/*  83 */       DormEntity beforeDorm = (DormEntity)this.studentService.get(DormEntity.class, se.getDorm().getId());
/*  84 */       ClassEntity ce = (ClassEntity)this.studentService.get(ClassEntity.class, classid);
/*  85 */       student.setDorm(de);
/*  86 */       student.setClasses(ce);
/*     */ 
/*  88 */       if (!de.getId().equals(beforeDorm.getId())) {
/*  89 */         int surplus = Integer.parseInt(de.getUsed());
/*  90 */         if (surplus <= 0) {
/*  91 */           j.setMsg("该宿舍床位已满");
/*  92 */           j.setSuccess(false);
/*  93 */           return j;
/*     */         }
/*  95 */         int beforeSurplus = Integer.parseInt(beforeDorm.getUsed());
/*  96 */         beforeSurplus++;
/*  97 */         surplus--;
/*  98 */         de.setUsed(String.valueOf(surplus));
/*  99 */         beforeDorm.setUsed(String.valueOf(beforeSurplus));
/* 100 */         this.studentService.update(de);
/* 101 */         this.studentService.update(beforeDorm);
/*     */       }
/*     */ 
/* 104 */       this.studentService.update(student);
/*     */     } catch (Exception e) {
/* 106 */       j.setMsg("更新失败！");
/* 107 */       j.setSuccess(false);
/*     */     }
/* 109 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"checkOut"})
/*     */   @ResponseBody
/*     */   public AjaxJson checkOut(HttpServletRequest request, HttpServletResponse response, String stuId) throws Exception {
/* 116 */     AjaxJson j = new AjaxJson();
/* 117 */     j.setMsg("退宿成功！");
/* 118 */     j.setSuccess(true);
/*     */     try {
/* 120 */       doCheckOut(stuId, true);
/*     */     } catch (Exception e) {
/* 122 */       j.setMsg("退宿失败！");
/* 123 */       j.setSuccess(false);
/*     */     }
/* 125 */     return j;
/*     */   }
/*     */ 
/*     */   private void doCheckOut(String stuId, boolean delete)
/*     */   {
/* 130 */     StudentEntity student = (StudentEntity)this.studentService.get(StudentEntity.class, stuId);
/* 131 */     DormEntity de = (DormEntity)this.studentService.get(DormEntity.class, "1");
/* 132 */     DormEntity beforeDorm = (DormEntity)this.studentService.get(DormEntity.class, student.getDorm().getId());
/* 133 */     student.setDorm(de);
/* 134 */     int surplus = Integer.parseInt(beforeDorm.getUsed());
/* 135 */     surplus++;
/* 136 */     beforeDorm.setUsed(String.valueOf(surplus));
/* 137 */     this.studentService.update(beforeDorm);
/* 138 */     if (!delete)
/* 139 */       this.studentService.update(student);
/*     */   }
/*     */ 
/*     */   @RequestMapping(params={"delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxJson delete(HttpServletRequest request, HttpServletResponse response, String ids) throws Exception {
/* 147 */     AjaxJson j = new AjaxJson();
/* 148 */     j.setMsg("删除成功！");
/* 149 */     j.setSuccess(true);
/*     */     try {
/* 151 */       for (String id : ids.split(",")) {
/* 152 */         StudentEntity student = (StudentEntity)this.studentService.get(StudentEntity.class, id);
/* 153 */         doCheckOut(id, false);
/* 154 */         this.studentService.delete(student);
/*     */       }
/*     */     } catch (ConstraintViolationException ce) {
/* 157 */       ce.printStackTrace();
/* 158 */       j.setMsg("删除失败,存在外键引用，请查看其它数据项中是否有与当前数据有关的信息!");
/* 159 */       j.setSuccess(false);
/*     */     } catch (Exception e) {
/* 161 */       j.setMsg("删除失败！");
/* 162 */       j.setSuccess(false);
/*     */     }
/* 164 */     return j;
/*     */   }
/*     */   @RequestMapping(params={"datagrid"})
/*     */   @ResponseBody
/*     */   public void datagrid(HttpServletRequest request, HttpServletResponse response, StudentEntity student, String dormName) throws Exception {
/* 171 */     String page = request.getParameter("page");
/* 172 */     String rows = request.getParameter("rows");
/* 173 */     if (page == null) {
/* 174 */       page = "0";
/*     */     }
/* 176 */     if (rows == null) {
/* 177 */       rows = "0";
/*     */     }
/* 179 */     DetachedCriteria condition = DetachedCriteria.forClass(StudentEntity.class);
/* 180 */     Pagination pagination = this.studentService.findPageData(condition, student, Integer.parseInt(page), Integer.parseInt(rows), dormName);
/* 181 */     JSONObject jobj = new JSONObject();
/* 182 */     jobj.put("total", pagination.getTotalCount());
/* 183 */     jobj.put("rows", pagination.getDatas());
/*     */ 
/* 185 */     response.setCharacterEncoding("utf-8");
/* 186 */     response.getWriter().write(jobj.toString());
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.controller.StudentController
 * JD-Core Version:    0.6.0
 */
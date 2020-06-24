/*    */ package com.bjpowernode.common.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Pagination<E>
/*    */ {
/*    */   private int start;
/*    */   private int totalCount;
/*    */   private List<E> datas;
/* 42 */   private int pageSize = 10;
/*    */ 
/*    */   public Pagination()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Pagination(int start, int pageSize)
/*    */   {
/* 19 */     this.start = start;
/* 20 */     this.pageSize = pageSize;
/*    */   }
/*    */ 
/*    */   public int getPageSize()
/*    */   {
/* 45 */     return this.pageSize;
/*    */   }
/*    */ 
/*    */   public void setPageSize(int pageSize) {
/* 49 */     this.pageSize = pageSize;
/*    */   }
/*    */ 
/*    */   public int getStart() {
/* 53 */     return this.start;
/*    */   }
/*    */ 
/*    */   public void setStart(int start) {
/* 57 */     this.start = start;
/*    */   }
/*    */ 
/*    */   public int getTotalCount() {
/* 61 */     return this.totalCount;
/*    */   }
/*    */ 
/*    */   public void setTotalCount(int totalCount) {
/* 65 */     this.totalCount = totalCount;
/*    */   }
/*    */ 
/*    */   public List<E> getDatas() {
/* 69 */     return this.datas == null ? new ArrayList() : this.datas;
/*    */   }
/*    */ 
/*    */   public void setDatas(List<E> datas) {
/* 73 */     this.datas = datas;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.util.Pagination
 * JD-Core Version:    0.6.0
 */
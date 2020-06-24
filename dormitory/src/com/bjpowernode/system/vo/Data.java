/*    */ package com.bjpowernode.system.vo;
/*    */ 
/*    */ import com.bjpowernode.common.util.Pagination;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Data<T>
/*    */ {
/*    */   private Pagination<T> pagination;
/*    */   private int total;
/* 18 */   private List<T> rows = new ArrayList();
/*    */ 
/*    */   public Data(Pagination<T> pagination)
/*    */   {
/* 13 */     this.pagination = pagination;
/*    */   }
/*    */ 
/*    */   public int getTotal()
/*    */   {
/* 21 */     return this.pagination.getTotalCount();
/*    */   }
/*    */ 
/*    */   public void setTotal(int total) {
/* 25 */     this.total = total;
/*    */   }
/*    */ 
/*    */   public List<T> getRows() {
/* 29 */     return this.pagination.getDatas();
/*    */   }
/*    */ 
/*    */   public void setRows(List<T> rows) {
/* 33 */     this.rows = rows;
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.vo.Data
 * JD-Core Version:    0.6.0
 */
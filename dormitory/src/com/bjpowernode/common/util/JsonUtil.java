/*    */ package com.bjpowernode.common.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.codehaus.jackson.map.ObjectMapper;
/*    */ import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
/*    */ 
/*    */ public class JsonUtil
/*    */ {
/*    */   public static String object2String(Object data)
/*    */     throws IOException
/*    */   {
/* 17 */     ObjectMapper om = new ObjectMapper();
/* 18 */     SimpleFilterProvider filterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
/* 19 */     om.setFilters(filterProvider);
/* 20 */     return om.writeValueAsString(data);
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.util.JsonUtil
 * JD-Core Version:    0.6.0
 */
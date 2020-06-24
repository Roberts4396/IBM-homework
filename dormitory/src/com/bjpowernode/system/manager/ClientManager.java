/*    */ package com.bjpowernode.system.manager;
/*    */ 
/*    */ import com.bjpowernode.system.vo.Client;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ClientManager
/*    */ {
/* 14 */   private static ClientManager instance = new ClientManager();
/*    */ 
/* 24 */   private Map<String, Client> map = new HashMap();
/*    */ 
/*    */   public static ClientManager getInstance()
/*    */   {
/* 21 */     return instance;
/*    */   }
/*    */ 
/*    */   public void addClinet(String sessionId, Client client)
/*    */   {
/* 32 */     this.map.put(sessionId, client);
/*    */   }
/*    */ 
/*    */   public void removeClinet(String sessionId)
/*    */   {
/* 38 */     this.map.remove(sessionId);
/*    */   }
/*    */ 
/*    */   public Client getClient(String sessionId)
/*    */   {
/* 46 */     return (Client)this.map.get(sessionId);
/*    */   }
/*    */ 
/*    */   public Collection<Client> getAllClient()
/*    */   {
/* 53 */     return this.map.values();
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.manager.ClientManager
 * JD-Core Version:    0.6.0
 */
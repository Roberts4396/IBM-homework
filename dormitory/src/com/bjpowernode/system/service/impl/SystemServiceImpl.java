/*    */ package com.bjpowernode.system.service.impl;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.bjpowernode.common.service.impl.BaseServiceImpl;
/*    */ import com.bjpowernode.system.dao.SystemDao;
/*    */ import com.bjpowernode.system.entity.base.ResourceEntity;
/*    */ import com.bjpowernode.system.entity.base.UserEntity;
/*    */ import com.bjpowernode.system.service.SystemService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("systemService")
/*    */ public class SystemServiceImpl extends BaseServiceImpl
/*    */   implements SystemService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemDao systemDao;
/*    */ 
/*    */   public UserEntity getUserByNameAndPassword(UserEntity user)
/*    */   {
/* 26 */     return this.systemDao.getUserByNameAndPassword(user);
/*    */   }
/*    */ 
/*    */   public List<ResourceEntity> getTreeMenuResource(UserEntity user)
/*    */   {
/* 31 */     return this.systemDao.getTreeMenuResource(user);
/*    */   }
/*    */ 
/*    */   public String getTreeJson(List<ResourceEntity> list)
/*    */   {
/* 37 */     return createTreeJson(list);
/*    */   }
/*    */ 
/*    */   private String createTreeJson(List<ResourceEntity> list) {
/* 41 */     JSONArray rootArray = new JSONArray();
/* 42 */     for (int i = 0; i < list.size(); i++) {
/* 43 */       ResourceEntity resource = (ResourceEntity)list.get(i);
/* 44 */       if (resource.getParentResource() == null) {
/* 45 */         JSONObject rootObj = createBranch(list, resource);
/* 46 */         rootArray.add(rootObj);
/*    */       }
/*    */     }
/*    */ 
/* 50 */     return rootArray.toString();
/*    */   }
/*    */ 
/*    */   private JSONObject createBranch(List<ResourceEntity> list, ResourceEntity currentNode)
/*    */   {
/* 63 */     JSONObject currentObj = JSONObject.parseObject(JSON.toJSONString(currentNode));
/* 64 */     JSONArray childArray = new JSONArray();
/*    */ 
/* 70 */     for (int i = 0; i < list.size(); i++) {
/* 71 */       ResourceEntity newNode = (ResourceEntity)list.get(i);
/* 72 */       if ((newNode.getParentResource() != null) && (currentNode.getId().equals(newNode.getParentResource().getId()))) {
/* 73 */         JSONObject childObj = createBranch(list, newNode);
/* 74 */         childArray.add(childObj);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 81 */     if (!childArray.isEmpty()) {
/* 82 */       currentObj.put("children", childArray);
/*    */     }
/*    */ 
/* 85 */     return currentObj;
/*    */   }
/*    */ 
/*    */   public <T> T findUniqueByProperty(Class<T> entityClass, String propertyName, Object value)
/*    */   {
/* 90 */     return this.systemDao.findUniqueByProperty(entityClass, propertyName, value);
/*    */   }
/*    */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.service.impl.SystemServiceImpl
 * JD-Core Version:    0.6.0
 */
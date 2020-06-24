package com.bjpowernode.system.service;

import com.bjpowernode.common.service.BaseService;
import com.bjpowernode.system.entity.base.ResourceEntity;
import com.bjpowernode.system.entity.base.UserEntity;
import java.util.List;

public abstract interface SystemService extends BaseService
{
  public abstract UserEntity getUserByNameAndPassword(UserEntity paramUserEntity);

  public abstract List<ResourceEntity> getTreeMenuResource(UserEntity paramUserEntity);

  public abstract String getTreeJson(List<ResourceEntity> paramList);

  public abstract <T> T findUniqueByProperty(Class<T> paramClass, String paramString, Object paramObject);
}

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.service.SystemService
 * JD-Core Version:    0.6.0
 */
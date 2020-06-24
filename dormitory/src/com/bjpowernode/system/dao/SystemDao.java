package com.bjpowernode.system.dao;

import com.bjpowernode.common.dao.BaseDao;
import com.bjpowernode.system.entity.base.ResourceEntity;
import com.bjpowernode.system.entity.base.UserEntity;
import java.util.List;

public abstract interface SystemDao extends BaseDao
{
  public abstract UserEntity getUserByNameAndPassword(UserEntity paramUserEntity);

  public abstract List<ResourceEntity> getTreeMenuResource(UserEntity paramUserEntity);

  public abstract <T> T findUniqueByProperty(Class<T> paramClass, String paramString, Object paramObject);
}

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.dao.SystemDao
 * JD-Core Version:    0.6.0
 */
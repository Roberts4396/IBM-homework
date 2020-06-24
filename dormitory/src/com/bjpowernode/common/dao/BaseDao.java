package com.bjpowernode.common.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public abstract interface BaseDao
{
  public abstract <T> void saveOrUpdate(T paramT);

  public abstract <T> T get(Class<T> paramClass, String paramString);

  public abstract int getRowCountByDetachedCriteria(DetachedCriteria paramDetachedCriteria);

  public abstract <T> List<T> findByDetachedCriteria(DetachedCriteria paramDetachedCriteria, int paramInt1, int paramInt2);

  public abstract <T> void save(T paramT);

  public abstract <T> void update(T paramT);

  public abstract <T> void delete(T paramT);
}

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.dao.BaseDao
 * JD-Core Version:    0.6.0
 */
package com.bjpowernode.common.service;

import com.bjpowernode.common.util.Pagination;
import org.hibernate.criterion.DetachedCriteria;

public abstract interface BaseService
{
  public abstract <T> void saveOrUpdate(T paramT);

  public abstract <T> T get(Class<T> paramClass, String paramString);

  public abstract <T> Pagination<T> getPageData(DetachedCriteria paramDetachedCriteria, int paramInt1, int paramInt2);

  public abstract <T> void save(T paramT);

  public abstract <T> void update(T paramT);

  public abstract <T> void delete(T paramT);
}

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.service.BaseService
 * JD-Core Version:    0.6.0
 */
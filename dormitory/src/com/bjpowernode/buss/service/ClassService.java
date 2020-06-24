package com.bjpowernode.buss.service;

import com.bjpowernode.buss.entity.base.ClassEntity;
import com.bjpowernode.common.util.Pagination;
import com.bjpowernode.system.service.SystemService;
import org.hibernate.criterion.DetachedCriteria;

public abstract interface ClassService extends SystemService
{
  public abstract Pagination<ClassEntity> findPageData(DetachedCriteria paramDetachedCriteria, ClassEntity paramClassEntity, int paramInt1, int paramInt2);
}

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.service.ClassService
 * JD-Core Version:    0.6.0
 */
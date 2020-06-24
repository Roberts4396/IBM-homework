package com.bjpowernode.buss.service;

import com.bjpowernode.buss.entity.base.ClassEntity;
import com.bjpowernode.buss.entity.base.StudentEntity;
import com.bjpowernode.common.util.Pagination;
import com.bjpowernode.system.service.SystemService;
import org.hibernate.criterion.DetachedCriteria;

public abstract interface StudentService extends SystemService
{
  public abstract Pagination<ClassEntity> findPageData(DetachedCriteria paramDetachedCriteria, StudentEntity paramStudentEntity, int paramInt1, int paramInt2, String paramString);
}

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.buss.service.StudentService
 * JD-Core Version:    0.6.0
 */
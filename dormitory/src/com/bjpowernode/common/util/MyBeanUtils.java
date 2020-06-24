/*     */ package com.bjpowernode.common.util;
/*     */ 
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ import org.apache.commons.beanutils.DynaBean;
/*     */ import org.apache.commons.beanutils.DynaClass;
/*     */ import org.apache.commons.beanutils.DynaProperty;
/*     */ import org.apache.commons.beanutils.PropertyUtils;
/*     */ 
/*     */ public class MyBeanUtils extends BeanUtils
/*     */ {
/*     */   private static void convert(Object dest, Object orig)
/*     */     throws IllegalAccessException, InvocationTargetException
/*     */   {
/*  19 */     if (dest == null) {
/*  20 */       throw new IllegalArgumentException(
/*  21 */         "No destination bean specified");
/*     */     }
/*  23 */     if (orig == null) {
/*  24 */       throw new IllegalArgumentException("No origin bean specified");
/*     */     }
/*     */ 
/*  28 */     if ((orig instanceof DynaBean)) {
/*  29 */       DynaProperty[] origDescriptors = 
/*  30 */         ((DynaBean)orig).getDynaClass().getDynaProperties();
/*  31 */       for (int i = 0; i < origDescriptors.length; i++) {
/*  32 */         String name = origDescriptors[i].getName();
/*  33 */         if (PropertyUtils.isWriteable(dest, name)) {
/*  34 */           Object value = ((DynaBean)orig).get(name);
/*     */           try {
/*  36 */             copyProperty(dest, name, value);
/*     */           }
/*     */           catch (Exception localException)
/*     */           {
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*  45 */     else if ((orig instanceof Map)) {
/*  46 */       Iterator names = ((Map)orig).keySet().iterator();
/*  47 */       while (names.hasNext()) {
/*  48 */         String name = (String)names.next();
/*  49 */         if (PropertyUtils.isWriteable(dest, name)) {
/*  50 */           Object value = ((Map)orig).get(name);
/*     */           try {
/*  52 */             copyProperty(dest, name, value);
/*     */           }
/*     */           catch (Exception localException1)
/*     */           {
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  64 */       PropertyDescriptor[] origDescriptors = 
/*  65 */         PropertyUtils.getPropertyDescriptors(orig);
/*  66 */       for (int i = 0; i < origDescriptors.length; i++) {
/*  67 */         String name = origDescriptors[i].getName();
/*     */ 
/*  69 */         if ("class".equals(name)) {
/*     */           continue;
/*     */         }
/*  72 */         if ((!PropertyUtils.isReadable(orig, name)) || 
/*  73 */           (!PropertyUtils.isWriteable(dest, name))) continue;
/*     */         try {
/*  75 */           Object value = PropertyUtils.getSimpleProperty(orig, name);
/*  76 */           copyProperty(dest, name, value);
/*     */         }
/*     */         catch (IllegalArgumentException localIllegalArgumentException)
/*     */         {
/*     */         }
/*     */         catch (Exception localException2)
/*     */         {
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyBeanNotNull2Bean(Object databean, Object tobean)
/*     */     throws Exception
/*     */   {
/* 103 */     PropertyDescriptor[] origDescriptors = 
/* 104 */       PropertyUtils.getPropertyDescriptors(databean);
/* 105 */     for (int i = 0; i < origDescriptors.length; i++) {
/* 106 */       String name = origDescriptors[i].getName();
/*     */ 
/* 108 */       if ("class".equals(name)) {
/*     */         continue;
/*     */       }
/* 111 */       if ((!PropertyUtils.isReadable(databean, name)) || 
/* 112 */         (!PropertyUtils.isWriteable(tobean, name))) continue;
/*     */       try {
/* 114 */         Object value = PropertyUtils.getSimpleProperty(databean, name);
/* 115 */         if (value != null)
/* 116 */           copyProperty(tobean, name, value);
/*     */       }
/*     */       catch (IllegalArgumentException localIllegalArgumentException)
/*     */       {
/*     */       }
/*     */       catch (Exception localException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyBean2Bean(Object dest, Object orig)
/*     */     throws Exception
/*     */   {
/* 139 */     convert(dest, orig);
/*     */   }
/*     */ 
/*     */   public static void copyBean2Map(Map map, Object bean) {
/* 143 */     PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(bean);
/* 144 */     for (int i = 0; i < pds.length; i++)
/*     */     {
/* 146 */       PropertyDescriptor pd = pds[i];
/* 147 */       String propname = pd.getName();
/*     */       try {
/* 149 */         Object propvalue = PropertyUtils.getSimpleProperty(bean, propname);
/* 150 */         map.put(propname, propvalue);
/*     */       }
/*     */       catch (IllegalAccessException localIllegalAccessException)
/*     */       {
/*     */       }
/*     */       catch (InvocationTargetException localInvocationTargetException)
/*     */       {
/*     */       }
/*     */       catch (NoSuchMethodException localNoSuchMethodException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyMap2Bean(Object bean, Map properties)
/*     */     throws IllegalAccessException, InvocationTargetException
/*     */   {
/* 171 */     if ((bean == null) || (properties == null)) {
/* 172 */       return;
/*     */     }
/*     */ 
/* 175 */     Iterator names = properties.keySet().iterator();
/* 176 */     while (names.hasNext()) {
/* 177 */       String name = (String)names.next();
/*     */ 
/* 179 */       if (name == null) {
/*     */         continue;
/*     */       }
/* 182 */       Object value = properties.get(name);
/*     */       try {
/* 184 */         Class clazz = PropertyUtils.getPropertyType(bean, name);
/* 185 */         if (clazz == null) {
/*     */           continue;
/*     */         }
/* 188 */         String className = clazz.getName();
/* 189 */         if ((className.equalsIgnoreCase("java.sql.Timestamp")) && (
/* 190 */           (value == null) || (value.equals(""))))
/*     */         {
/*     */           continue;
/*     */         }
/* 194 */         setProperty(bean, name, value);
/*     */       }
/*     */       catch (NoSuchMethodException localNoSuchMethodException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyMap2Bean_Nobig(Object bean, Map properties)
/*     */     throws IllegalAccessException, InvocationTargetException
/*     */   {
/* 214 */     if ((bean == null) || (properties == null)) {
/* 215 */       return;
/*     */     }
/*     */ 
/* 218 */     Iterator names = properties.keySet().iterator();
/* 219 */     while (names.hasNext()) {
/* 220 */       String name = (String)names.next();
/*     */ 
/* 222 */       if (name == null) {
/*     */         continue;
/*     */       }
/* 225 */       Object value = properties.get(name);
/*     */       try
/*     */       {
/* 229 */         if (value == null) {
/*     */           continue;
/*     */         }
/* 232 */         Class clazz = PropertyUtils.getPropertyType(bean, name);
/* 233 */         if (clazz == null) {
/*     */           continue;
/*     */         }
/* 236 */         String className = clazz.getName();
/*     */ 
/* 238 */         if (className.equalsIgnoreCase("java.util.Date")) {
/* 239 */           value = new Date(((Timestamp)value).getTime());
/*     */         }
/*     */ 
/* 246 */         setProperty(bean, name, value);
/*     */       }
/*     */       catch (NoSuchMethodException localNoSuchMethodException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyMap2Bean(Object bean, Map properties, String defaultValue)
/*     */     throws IllegalAccessException, InvocationTargetException
/*     */   {
/* 266 */     if ((bean == null) || (properties == null)) {
/* 267 */       return;
/*     */     }
/*     */ 
/* 270 */     Iterator names = properties.keySet().iterator();
/* 271 */     while (names.hasNext()) {
/* 272 */       String name = (String)names.next();
/*     */ 
/* 274 */       if (name == null) {
/*     */         continue;
/*     */       }
/* 277 */       Object value = properties.get(name);
/*     */       try {
/* 279 */         Class clazz = PropertyUtils.getPropertyType(bean, name);
/* 280 */         if (clazz == null) {
/*     */           continue;
/*     */         }
/* 283 */         String className = clazz.getName();
/* 284 */         if ((className.equalsIgnoreCase("java.sql.Timestamp")) && (
/* 285 */           (value == null) || (value.equals(""))))
/*     */         {
/*     */           continue;
/*     */         }
/* 289 */         if ((className.equalsIgnoreCase("java.lang.String")) && 
/* 290 */           (value == null)) {
/* 291 */           value = defaultValue;
/*     */         }
/*     */ 
/* 294 */         setProperty(bean, name, value);
/*     */       }
/*     */       catch (NoSuchMethodException localNoSuchMethodException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.common.util.MyBeanUtils
 * JD-Core Version:    0.6.0
 */
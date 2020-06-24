/*     */ package com.bjpowernode.system.entity.base;
/*     */ 
/*     */ import com.bjpowernode.common.entity.base.BaseEntity;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.OrderBy;
/*     */ import javax.persistence.Table;
/*     */ import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="T_S_RESOURCE")
/*     */ @JsonIgnoreProperties({"parent"})
/*     */ public class ResourceEntity extends BaseEntity
/*     */ {
/*     */   private static final long serialVersionUID = -2134869782502357553L;
/*  32 */   public static int TYPE_MENU = 1;
/*     */ 
/*  34 */   public static int TYPE_BTN = 2;
/*     */   private Integer resourceType;
/*     */ 
/*     */   @Column(length=200)
/*     */   private String name;
/*     */ 
/*     */   @Column(length=200)
/*     */   private String description;
/*     */ 
/*     */   @Column(length=3, name="order_no")
/*     */   private Integer orderNo;
/*     */ 
/*     */   @ManyToOne
/*     */   @JoinColumn(name="parentid")
/*     */   private ResourceEntity parentResource;
/*     */ 
/*     */   @OneToMany(mappedBy="parentResource", fetch=FetchType.EAGER)
/*     */   @OrderBy("orderNo")
/*     */   private List<ResourceEntity> resources;
/*     */ 
/*     */   @Column(length=200)
/*     */   private String href;
/*     */ 
/*     */   public Integer getResourceType()
/*     */   {
/*  81 */     return this.resourceType;
/*     */   }
/*     */ 
/*     */   public void setResourceType(Integer resourceType) {
/*  85 */     this.resourceType = resourceType;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  89 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  93 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/*  97 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 101 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public Integer getOrderNo() {
/* 105 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(Integer orderNo) {
/* 109 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getHref() {
/* 113 */     return this.href;
/*     */   }
/*     */ 
/*     */   public void setHref(String href) {
/* 117 */     this.href = href;
/*     */   }
/*     */ 
/*     */   public ResourceEntity getParentResource() {
/* 121 */     return this.parentResource;
/*     */   }
/*     */ 
/*     */   public void setParentResource(ResourceEntity parentResource) {
/* 125 */     this.parentResource = parentResource;
/*     */   }
/*     */ 
/*     */   public List<ResourceEntity> getResources() {
/* 129 */     return this.resources;
/*     */   }
/*     */ 
/*     */   public void setResources(List<ResourceEntity> resources) {
/* 133 */     this.resources = resources;
/*     */   }
/*     */ }

/* Location:           E:\TTT\学生毕业设计-宿舍管理系统（spring mvc+hibernate+spring+easyui）\dormitory\WEB-INF\classes\
 * Qualified Name:     com.bjpowernode.system.entity.base.ResourceEntity
 * JD-Core Version:    0.6.0
 */
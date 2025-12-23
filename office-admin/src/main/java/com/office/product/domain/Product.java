package com.office.product.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.office.common.annotation.Excel;
import com.office.common.core.domain.BaseEntity;

/**
 * 商品基本信息对象 product
 * 
 * @author hucong
 * @date 2025-11-23
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 商品分类 */
    @Excel(name = "商品分类")
    private String productType;

    /** 规格型号 */
    private String specification;

    /** 单位 */
    private String unit;

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    private int currentStock;

    /** 参考价格 */
    @Excel(name = "参考价格")
    private BigDecimal referencePrice;

    /** 安全库存 */
    @Excel(name = "安全库存")
    private Long safetyStock;

    /** 商品图片路径 */
    @Excel(name = "商品图片路径")
    private String productImage;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }

    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }

    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    public void setReferencePrice(BigDecimal referencePrice) 
    {
        this.referencePrice = referencePrice;
    }

    public BigDecimal getReferencePrice() 
    {
        return referencePrice;
    }

    public void setSafetyStock(Long safetyStock) 
    {
        this.safetyStock = safetyStock;
    }

    public Long getSafetyStock() 
    {
        return safetyStock;
    }

    public void setProductImage(String productImage) 
    {
        this.productImage = productImage;
    }

    public String getProductImage() 
    {
        return productImage;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("productType", getProductType())
            .append("specification", getSpecification())
            .append("unit", getUnit())
            .append("referencePrice", getReferencePrice())
            .append("safetyStock", getSafetyStock())
            .append("productImage", getProductImage())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

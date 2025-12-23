package com.office.cart.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.office.common.annotation.Excel;
import com.office.common.core.domain.BaseEntity;

/**
 * 购物车对象 shopping_cart
 * 
 * @author hucong
 * @date 2025-12-03
 */
public class ShoppingCart extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 购物车ID */
    @Excel(name = "购物车ID")
    private Long cartId;

    /** 用户ID（采购员ID） */
    @Excel(name = "用户ID", readConverterExp = "采=购员ID")
    private Long userId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String productImage;

    /** 规格型号 */
    private String specification;

    /** 单位 */
    private String unit;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    /** 商品类型 */
    private String productType;

    /** 购买数量 */
    @Excel(name = "购买数量")
    private Long quantity;

    /** 预估单价 */
    @Excel(name = "预估单价")
    private BigDecimal estimatedPrice;

    /** 预估总价 */
    @Excel(name = "预估总价")
    private BigDecimal totalPrice;

    /** 是否选中（1选中 0未选中） */
    private Long selected;

    /** 商品状态（1有效 2无效 3缺货） */
    private Long itemStatus;

    /** 添加时间 */
    private Date addTime;

    public void setCartId(Long cartId) 
    {
        this.cartId = cartId;
    }

    public Long getCartId() 
    {
        return cartId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

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

    public void setProductImage(String productImage) 
    {
        this.productImage = productImage;
    }

    public String getProductImage() 
    {
        return productImage;
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

    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) 
    {
        this.estimatedPrice = estimatedPrice;
    }

    public BigDecimal getEstimatedPrice() 
    {
        return estimatedPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }

    public void setSelected(Long selected) 
    {
        this.selected = selected;
    }

    public Long getSelected() 
    {
        return selected;
    }

    public void setItemStatus(Long itemStatus) 
    {
        this.itemStatus = itemStatus;
    }

    public Long getItemStatus() 
    {
        return itemStatus;
    }

    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cartId", getCartId())
            .append("userId", getUserId())
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("productImage", getProductImage())
            .append("specification", getSpecification())
            .append("unit", getUnit())
            .append("quantity", getQuantity())
            .append("estimatedPrice", getEstimatedPrice())
            .append("totalPrice", getTotalPrice())
            .append("selected", getSelected())
            .append("itemStatus", getItemStatus())
            .append("addTime", getAddTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

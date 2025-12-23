package com.office.item.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.office.common.annotation.Excel;
import com.office.common.core.domain.BaseEntity;

/**
 * 订单明细对象 order_item
 * 
 * @author hucong
 * @date 2025-12-10
 */
public class OrderItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单明细ID */
    private Long itemId;

    /** 订单ID */
    private Long orderId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNo;

    /** 商品ID */
    private Long productId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String productType;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String productImage;

    /** 规格型号 */
    private String specification;

    /** 单位 */
    private String unit;

    /** 购买数量 */
    @Excel(name = "购买数量")
    private Long quantity;

    /** 预估单价 */
    @Excel(name = "预估单价")
    private BigDecimal estimatedPrice;

    /** 小计金额 */
    @Excel(name = "小计金额")
    private BigDecimal subtotalPrice;

    /** 库存状态（1充足 2部分缺货 3完全缺货） */
    @Excel(name = "库存状态", readConverterExp = "1=充足,2=部分缺货,3=完全缺货")
    private Long stockStatus;

    /** 商品备注 */
    @Excel(name = "商品备注")
    private String productNotes;

    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }

    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
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

    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
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

    public void setSubtotalPrice(BigDecimal subtotalPrice) 
    {
        this.subtotalPrice = subtotalPrice;
    }

    public BigDecimal getSubtotalPrice() 
    {
        return subtotalPrice;
    }

    public void setStockStatus(Long stockStatus) 
    {
        this.stockStatus = stockStatus;
    }

    public Long getStockStatus() 
    {
        return stockStatus;
    }

    public void setProductNotes(String productNotes) 
    {
        this.productNotes = productNotes;
    }

    public String getProductNotes() 
    {
        return productNotes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itemId", getItemId())
            .append("orderId", getOrderId())
            .append("orderNo", getOrderNo())
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("productType", getProductType())
            .append("productImage", getProductImage())
            .append("specification", getSpecification())
            .append("unit", getUnit())
            .append("quantity", getQuantity())
            .append("estimatedPrice", getEstimatedPrice())
            .append("subtotalPrice", getSubtotalPrice())
            .append("stockStatus", getStockStatus())
            .append("productNotes", getProductNotes())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

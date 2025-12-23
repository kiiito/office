package com.office.application.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.office.common.annotation.Excel;
import com.office.common.core.domain.BaseEntity;

/**
 * 采购申请明细对象 purchase_application_detail
 * 
 * @author hucong
 * @date 2025-11-28
 */
public class PurchaseApplicationDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 明细ID */
    private Long detailId;

    /** 申请主表ID */
    @Excel(name = "申请主表ID")
    private Long applicationId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;

    /** 申请数量 */
    @Excel(name = "申请数量")
    private Long applyQuantity;

    /** 申请时当前库存 */
    @Excel(name = "申请时当前库存")
    private Long currentStock;

    /** 申请时安全库存 */
    @Excel(name = "申请时安全库存")
    private Long safetyStock;

    /** 预估单价 */
    @Excel(name = "预估单价")
    private BigDecimal estimatedPrice;

    public void setDetailId(Long detailId) 
    {
        this.detailId = detailId;
    }

    public Long getDetailId() 
    {
        return detailId;
    }
    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setApplyQuantity(Long applyQuantity) 
    {
        this.applyQuantity = applyQuantity;
    }

    public Long getApplyQuantity() 
    {
        return applyQuantity;
    }
    public void setCurrentStock(Long currentStock) 
    {
        this.currentStock = currentStock;
    }

    public Long getCurrentStock() 
    {
        return currentStock;
    }
    public void setSafetyStock(Long safetyStock) 
    {
        this.safetyStock = safetyStock;
    }

    public Long getSafetyStock() 
    {
        return safetyStock;
    }
    public void setEstimatedPrice(BigDecimal estimatedPrice) 
    {
        this.estimatedPrice = estimatedPrice;
    }

    public BigDecimal getEstimatedPrice() 
    {
        return estimatedPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("detailId", getDetailId())
            .append("applicationId", getApplicationId())
            .append("productId", getProductId())
            .append("applyQuantity", getApplyQuantity())
            .append("currentStock", getCurrentStock())
            .append("safetyStock", getSafetyStock())
            .append("estimatedPrice", getEstimatedPrice())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .toString();
    }
}

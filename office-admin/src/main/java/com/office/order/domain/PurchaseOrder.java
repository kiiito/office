package com.office.order.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.office.common.annotation.Excel;
import com.office.common.core.domain.BaseEntity;

/**
 * 采购订单对象 purchase_order
 * 
 * @author hucong
 * @date 2025-12-10
 */
public class PurchaseOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private Long orderId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNo;

    /** 采购员ID */
    @Excel(name = "采购员ID")
    private Long buyerId;

    /** 采购员姓名 */
    @Excel(name = "采购员姓名")
    private String buyerName;

    /** 部门ID */
    private Long departmentId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String departmentName;

    /** 收货地址ID */
    private Long deliveryAddressId;

    /** 订单商品总数量 */
    @Excel(name = "订单商品总数量")
    private Long totalQuantity;

    /** 商品总金额 */
    @Excel(name = "商品总金额")
    private BigDecimal subtotalAmount;

    /** 其他费用 */
    private BigDecimal otherFee;

    /** 订单总金额 */
    @Excel(name = "订单总金额")
    private BigDecimal totalAmount;

    /** 订单状态（1待审批 2已通过 3已拒绝 4已完成） */
    @Excel(name = "订单状态", readConverterExp = "1=待审批,2=已通过,3=已拒绝,4=已完成")
    private Long orderStatus;

    /** 审批人ID */
    private Long approverId;

    /** 审批人姓名 */
    @Excel(name = "审批人姓名")
    private String approverName;

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

    public void setBuyerId(Long buyerId) 
    {
        this.buyerId = buyerId;
    }

    public Long getBuyerId() 
    {
        return buyerId;
    }

    public void setBuyerName(String buyerName) 
    {
        this.buyerName = buyerName;
    }

    public String getBuyerName() 
    {
        return buyerName;
    }

    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }

    public void setDepartmentName(String departmentName) 
    {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() 
    {
        return departmentName;
    }

    public void setDeliveryAddressId(Long deliveryAddressId) 
    {
        this.deliveryAddressId = deliveryAddressId;
    }

    public Long getDeliveryAddressId() 
    {
        return deliveryAddressId;
    }

    public void setTotalQuantity(Long totalQuantity) 
    {
        this.totalQuantity = totalQuantity;
    }

    public Long getTotalQuantity() 
    {
        return totalQuantity;
    }

    public void setSubtotalAmount(BigDecimal subtotalAmount) 
    {
        this.subtotalAmount = subtotalAmount;
    }

    public BigDecimal getSubtotalAmount() 
    {
        return subtotalAmount;
    }

    public void setOtherFee(BigDecimal otherFee) 
    {
        this.otherFee = otherFee;
    }

    public BigDecimal getOtherFee() 
    {
        return otherFee;
    }

    public void setTotalAmount(BigDecimal totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }

    public void setOrderStatus(Long orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public Long getOrderStatus() 
    {
        return orderStatus;
    }

    public void setApproverId(Long approverId) 
    {
        this.approverId = approverId;
    }

    public Long getApproverId() 
    {
        return approverId;
    }

    public void setApproverName(String approverName) 
    {
        this.approverName = approverName;
    }

    public String getApproverName() 
    {
        return approverName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("orderNo", getOrderNo())
            .append("buyerId", getBuyerId())
            .append("buyerName", getBuyerName())
            .append("departmentId", getDepartmentId())
            .append("departmentName", getDepartmentName())
            .append("deliveryAddressId", getDeliveryAddressId())
            .append("totalQuantity", getTotalQuantity())
            .append("subtotalAmount", getSubtotalAmount())
            .append("otherFee", getOtherFee())
            .append("totalAmount", getTotalAmount())
            .append("orderStatus", getOrderStatus())
            .append("approverId", getApproverId())
            .append("approverName", getApproverName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

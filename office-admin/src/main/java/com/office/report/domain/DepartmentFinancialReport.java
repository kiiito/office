package com.office.report.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.office.common.annotation.Excel;
import com.office.common.core.domain.BaseEntity;

/**
 * 部门采购财务报对象 department_financial_report
 * 
 * @author ruoyi
 * @date 2025-12-14
 */
public class DepartmentFinancialReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报表ID */
    private Long reportId;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long departmentId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String departmentName;

    /** 报表日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报表日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reportDate;

    /** 总订单数 */
    @Excel(name = "总订单数")
    private Long totalOrders;

    /** 已完成订单数 */
    @Excel(name = "已完成订单数")
    private Long completedOrders;

    /** 待处理订单数 */
    @Excel(name = "待处理订单数")
    private Long pendingOrders;

    /** 采购总金额 */
    @Excel(name = "采购总金额")
    private BigDecimal totalAmount;

    /** 已完成金额 */
    @Excel(name = "已完成金额")
    private BigDecimal completedAmount;

    /** 待处理金额 */
    @Excel(name = "待处理金额")
    private BigDecimal pendingAmount;

    /** 商品金额 */
    @Excel(name = "商品金额")
    private BigDecimal goodsAmount;

    /** 其他费用 */
    @Excel(name = "其他费用")
    private BigDecimal otherFeeAmount;


    /** 主要订单编号（逗号分隔） */
    @Excel(name = "主要订单编号", readConverterExp = "逗=号分隔")
    private String mainOrderNos;

    public void setReportId(Long reportId) 
    {
        this.reportId = reportId;
    }

    public Long getReportId() 
    {
        return reportId;
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

    public void setReportDate(Date reportDate) 
    {
        this.reportDate = reportDate;
    }

    public Date getReportDate() 
    {
        return reportDate;
    }

    public void setTotalOrders(Long totalOrders) 
    {
        this.totalOrders = totalOrders;
    }

    public Long getTotalOrders() 
    {
        return totalOrders;
    }

    public void setCompletedOrders(Long completedOrders) 
    {
        this.completedOrders = completedOrders;
    }

    public Long getCompletedOrders() 
    {
        return completedOrders;
    }

    public void setPendingOrders(Long pendingOrders) 
    {
        this.pendingOrders = pendingOrders;
    }

    public Long getPendingOrders() 
    {
        return pendingOrders;
    }

    public void setTotalAmount(BigDecimal totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }

    public void setCompletedAmount(BigDecimal completedAmount) 
    {
        this.completedAmount = completedAmount;
    }

    public BigDecimal getCompletedAmount() 
    {
        return completedAmount;
    }

    public void setPendingAmount(BigDecimal pendingAmount) 
    {
        this.pendingAmount = pendingAmount;
    }

    public BigDecimal getPendingAmount() 
    {
        return pendingAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) 
    {
        this.goodsAmount = goodsAmount;
    }

    public BigDecimal getGoodsAmount() 
    {
        return goodsAmount;
    }

    public void setOtherFeeAmount(BigDecimal otherFeeAmount) 
    {
        this.otherFeeAmount = otherFeeAmount;
    }

    public BigDecimal getOtherFeeAmount() 
    {
        return otherFeeAmount;
    }

    public void setMainOrderNos(String mainOrderNos) 
    {
        this.mainOrderNos = mainOrderNos;
    }

    public String getMainOrderNos() 
    {
        return mainOrderNos;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("reportId", getReportId())
            .append("departmentId", getDepartmentId())
            .append("departmentName", getDepartmentName())
            .append("reportDate", getReportDate())
            .append("totalOrders", getTotalOrders())
            .append("completedOrders", getCompletedOrders())
            .append("pendingOrders", getPendingOrders())
            .append("totalAmount", getTotalAmount())
            .append("completedAmount", getCompletedAmount())
            .append("pendingAmount", getPendingAmount())
            .append("goodsAmount", getGoodsAmount())
            .append("otherFeeAmount", getOtherFeeAmount())
            .append("mainOrderNos", getMainOrderNos())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

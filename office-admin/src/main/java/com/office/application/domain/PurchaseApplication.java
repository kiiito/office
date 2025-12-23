package com.office.application.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.office.common.annotation.Excel;
import com.office.common.core.domain.BaseEntity;

/**
 * 采购申请主对象 purchase_application
 * 
 * @author hucong
 * @date 2025-11-28
 */
public class PurchaseApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请ID */
    @Excel(name = "申请ID")
    private Long applicationId;

    /** 申请单号 */
    @Excel(name = "申请单号")
    private String applicationNo;

    /** 申请人ID（仓库管理员） */
    @Excel(name = "申请人ID", readConverterExp = "仓=库管理员")
    private Long applicantId;

    /** 申请事由 */
    @Excel(name = "申请事由")
    private String applyReason;

    /** 状态（1待处理 2已生成订单 3已完成 4已取消） */
    @Excel(name = "状态", readConverterExp = "1=待处理,2=已生成订单,3=已完成,4=已取消")
    private Long applicationStatus;

    /** 紧急程度（1普通 2紧急 3特急） */
    @Excel(name = "紧急程度", readConverterExp = "1=普通,2=紧急,3=特急")
    private Long urgentLevel;

    /** 采购申请明细信息 */
    private List<PurchaseApplicationDetail> purchaseApplicationDetailList;

    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
    }

    public void setApplicationNo(String applicationNo) 
    {
        this.applicationNo = applicationNo;
    }

    public String getApplicationNo() 
    {
        return applicationNo;
    }

    public void setApplicantId(Long applicantId) 
    {
        this.applicantId = applicantId;
    }

    public Long getApplicantId() 
    {
        return applicantId;
    }

    public void setApplyReason(String applyReason) 
    {
        this.applyReason = applyReason;
    }

    public String getApplyReason() 
    {
        return applyReason;
    }

    public void setApplicationStatus(Long applicationStatus) 
    {
        this.applicationStatus = applicationStatus;
    }

    public Long getApplicationStatus() 
    {
        return applicationStatus;
    }

    public void setUrgentLevel(Long urgentLevel) 
    {
        this.urgentLevel = urgentLevel;
    }

    public Long getUrgentLevel() 
    {
        return urgentLevel;
    }

    public List<PurchaseApplicationDetail> getPurchaseApplicationDetailList()
    {
        return purchaseApplicationDetailList;
    }

    public void setPurchaseApplicationDetailList(List<PurchaseApplicationDetail> purchaseApplicationDetailList)
    {
        this.purchaseApplicationDetailList = purchaseApplicationDetailList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applicationId", getApplicationId())
            .append("applicationNo", getApplicationNo())
            .append("applicantId", getApplicantId())
            .append("applyReason", getApplyReason())
            .append("applicationStatus", getApplicationStatus())
            .append("urgentLevel", getUrgentLevel())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("purchaseApplicationDetailList", getPurchaseApplicationDetailList())
            .toString();
    }
}

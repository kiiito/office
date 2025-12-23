package com.office.report.domain.query;

import com.office.common.annotation.Excel;
import com.office.report.domain.DepartmentFinancialReport;

public class DFRQuery extends DepartmentFinancialReport {


    /** 订单状态（1待审批 2已通过 3已拒绝 4已完成） */
    @Excel(name = "订单状态", readConverterExp = "1=待审批,2=已通过,3=已拒绝,4=已完成")
    private Long orderStatus;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }
}

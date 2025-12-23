package com.office.report.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.office.common.core.domain.entity.SysDept;
import com.office.report.domain.query.DFRQuery;
import com.office.system.service.impl.SysDeptServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.office.common.annotation.Log;
import com.office.common.core.controller.BaseController;
import com.office.common.core.domain.AjaxResult;
import com.office.common.enums.BusinessType;
import com.office.report.domain.DepartmentFinancialReport;
import com.office.report.service.IDepartmentFinancialReportService;
import com.office.common.utils.poi.ExcelUtil;
import com.office.common.core.page.TableDataInfo;

/**
 * 部门采购财务报Controller
 *
 * @author ruoyi
 * @date 2025-12-14
 */
@RestController
@RequestMapping("/report/report")
public class DepartmentFinancialReportController extends BaseController {
    @Autowired
    private SysDeptServiceImpl sysDeptService;

    @Autowired
    private IDepartmentFinancialReportService departmentFinancialReportService;

    /**
     * 查询部门采购财务报列表
     */
    @PreAuthorize("@ss.hasPermi('report:report:list')")
    @GetMapping("/list")
    public TableDataInfo list(DepartmentFinancialReport departmentFinancialReport) {
        startPage();
        List<DepartmentFinancialReport> list = departmentFinancialReportService.selectDepartmentFinancialReportList(departmentFinancialReport);
        return getDataTable(list);
    }

    /**
     * 导出部门采购财务报列表
     */
    @PreAuthorize("@ss.hasPermi('report:report:export')")
    @Log(title = "部门采购财务报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DepartmentFinancialReport departmentFinancialReport) {
        List<DepartmentFinancialReport> list = departmentFinancialReportService.selectDepartmentFinancialReportList(departmentFinancialReport);
        ExcelUtil<DepartmentFinancialReport> util = new ExcelUtil<DepartmentFinancialReport>(DepartmentFinancialReport.class);
        util.exportExcel(response, list, "部门采购财务报数据");
    }

    /**
     * 获取部门采购财务报详细信息
     */
    @PreAuthorize("@ss.hasPermi('report:report:query')")
    @GetMapping(value = "/{reportId}")
    public AjaxResult getInfo(@PathVariable("reportId") Long reportId) {
        return success(departmentFinancialReportService.selectDepartmentFinancialReportByReportId(reportId));
    }

    /**
     * 新增部门采购财务报
     */
    @PreAuthorize("@ss.hasPermi('report:report:add')")
    @Log(title = "部门采购财务报", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DepartmentFinancialReport departmentFinancialReport) {
        return toAjax(departmentFinancialReportService.insertDepartmentFinancialReport(departmentFinancialReport));
    }

    /**
     * 修改部门采购财务报
     */
    @PreAuthorize("@ss.hasPermi('report:report:edit')")
    @Log(title = "部门采购财务报", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DepartmentFinancialReport departmentFinancialReport) {
        return toAjax(departmentFinancialReportService.updateDepartmentFinancialReport(departmentFinancialReport));
    }

    /**
     * 删除部门采购财务报
     */
    @PreAuthorize("@ss.hasPermi('report:report:remove')")
    @Log(title = "部门采购财务报", businessType = BusinessType.DELETE)
    @DeleteMapping("/{reportIds}")
    public AjaxResult remove(@PathVariable Long[] reportIds) {
        return toAjax(departmentFinancialReportService.deleteDepartmentFinancialReportByReportIds(reportIds));
    }


    /**
     * 添加部门采购财务报
     */
    @Transactional
    @PostMapping("/addDFRList")
    public AjaxResult addDFRList(@RequestBody
                                 List<DFRQuery> dfrQueryList) {
        System.out.println(dfrQueryList);
        try {
            departmentFinancialReportService.delAll();
            dfrQueryList.forEach(dfrQuery -> {
                if (dfrQuery != null){
                    Long orderStatus = dfrQuery.getOrderStatus();
                    Long departmentId = dfrQuery.getDepartmentId();
                    SysDept sysDept = sysDeptService.selectDeptById(departmentId);
                    String deptName = sysDept.getDeptName();
                    dfrQuery.setDepartmentName(deptName);
                    DepartmentFinancialReport report =
                            departmentFinancialReportService.selectDepartmentFinancialReportByDepartmentId(departmentId);
                    if (report == null) {
                        dfrQuery.setTotalOrders(1L);
                        if (orderStatus == 1) {
                            dfrQuery.setCompletedOrders(0L);
                            dfrQuery.setPendingOrders(1L);
                            dfrQuery.setTotalAmount(dfrQuery.getGoodsAmount());
                            dfrQuery.setCompletedAmount(null);
                            dfrQuery.setPendingAmount(dfrQuery.getGoodsAmount());
                        } else {
                            dfrQuery.setCompletedOrders(1L);
                            dfrQuery.setPendingOrders(0L);
                            dfrQuery.setTotalAmount(dfrQuery.getGoodsAmount());
                            dfrQuery.setCompletedAmount(dfrQuery.getGoodsAmount());
                            dfrQuery.setPendingAmount(null);
                        }
                        dfrQuery.setMainOrderNos(dfrQuery.getOrderNo());
                       departmentFinancialReportService.insertDepartmentFinancialReport(dfrQuery);
                    }else {
                        report.setTotalOrders(report.getTotalOrders() + 1);
                        report.setUpdateTime(dfrQuery.getReportDate());
                        report.setGoodsAmount(report.getGoodsAmount().add(dfrQuery.getGoodsAmount()));
                        report.setTotalAmount(report.getTotalAmount().add(dfrQuery.getGoodsAmount()).add(dfrQuery.getOtherFeeAmount()));
                        StringBuilder sb = new StringBuilder(report.getMainOrderNos());
                        sb.append(",").append(dfrQuery.getOrderNo());
                        report.setMainOrderNos(sb.toString());
                        if (orderStatus == 1) {
                            report.setPendingOrders(report.getPendingOrders() + 1);
                            report.setPendingAmount(report.getPendingAmount().add(dfrQuery.getGoodsAmount()));
                            departmentFinancialReportService.updateDepartmentFinancialReport(report);
                            return;
                        }
                        report.setCompletedAmount(report.getCompletedAmount().add(dfrQuery.getGoodsAmount()));
                        report.setCompletedOrders(report.getCompletedOrders() + 1);
                        departmentFinancialReportService.updateDepartmentFinancialReport(report);
                    }
                }
            });
        } catch (Exception e) {
            return AjaxResult.error("查询失败");
        }
        return success();
    }


    /**
     * 新增部门采购财务报
     */
    @PreAuthorize("@ss.hasPermi('report:report:add')")
    @Log(title = "部门采购财务报", businessType = BusinessType.INSERT)
    @PostMapping("/addDFR")
    public AjaxResult addDFR(@RequestBody DFRQuery dfrQuery) {

        Long orderStatus = dfrQuery.getOrderStatus();
        Long departmentId = dfrQuery.getDepartmentId();
        dfrQuery.setDepartmentName(sysDeptService.selectDeptById(departmentId).getDeptName());
        DepartmentFinancialReport report =
                departmentFinancialReportService.selectDepartmentFinancialReportByDepartmentId(departmentId);
        if (report == null) {
            dfrQuery.setTotalOrders(1L);
            if (orderStatus == 1) {
                dfrQuery.setCompletedOrders(0L);
                dfrQuery.setPendingOrders(1L);
                dfrQuery.setTotalAmount(dfrQuery.getGoodsAmount());
                dfrQuery.setCompletedAmount(null);
                dfrQuery.setPendingAmount(dfrQuery.getGoodsAmount());
            } else {
                dfrQuery.setCompletedOrders(1L);
                dfrQuery.setPendingOrders(0L);
                dfrQuery.setTotalAmount(dfrQuery.getGoodsAmount());
                dfrQuery.setCompletedAmount(dfrQuery.getGoodsAmount());
                dfrQuery.setPendingAmount(null);
            }
            dfrQuery.setMainOrderNos(dfrQuery.getOrderNo());
            return toAjax(departmentFinancialReportService.insertDepartmentFinancialReport(dfrQuery));
        }
        report.setTotalOrders(report.getTotalOrders() + 1);
        report.setUpdateTime(dfrQuery.getReportDate());
        report.setGoodsAmount(report.getGoodsAmount().add(dfrQuery.getGoodsAmount()));
        report.setTotalAmount(report.getTotalAmount().add(dfrQuery.getGoodsAmount()).add(dfrQuery.getOtherFeeAmount()));
        StringBuilder sb = new StringBuilder(report.getMainOrderNos());
        sb.append(",").append(dfrQuery.getOrderNo());
        report.setMainOrderNos(sb.toString());
        if (orderStatus == 1) {
            report.setPendingOrders(report.getPendingOrders() + 1);
            report.setPendingAmount(report.getPendingAmount().add(dfrQuery.getGoodsAmount()));
            return toAjax(departmentFinancialReportService.updateDepartmentFinancialReport(report));
        }
        report.setCompletedAmount(report.getCompletedAmount().add(dfrQuery.getGoodsAmount()));
        report.setCompletedOrders(report.getCompletedOrders() + 1);

        return toAjax(departmentFinancialReportService.updateDepartmentFinancialReport(report));
    }
}

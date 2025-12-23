package com.office.report.service.impl;

import java.util.List;
import com.office.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.office.report.mapper.DepartmentFinancialReportMapper;
import com.office.report.domain.DepartmentFinancialReport;
import com.office.report.service.IDepartmentFinancialReportService;

/**
 * 部门采购财务报Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-14
 */
@Service
public class DepartmentFinancialReportServiceImpl implements IDepartmentFinancialReportService 
{
    @Autowired
    private DepartmentFinancialReportMapper departmentFinancialReportMapper;

    /**
     * 查询部门采购财务报
     * 
     * @param reportId 部门采购财务报主键
     * @return 部门采购财务报
     */
    @Override
    public DepartmentFinancialReport selectDepartmentFinancialReportByReportId(Long reportId)
    {
        return departmentFinancialReportMapper.selectDepartmentFinancialReportByReportId(reportId);
    }

    /**
     * 查询部门采购财务报列表
     * 
     * @param departmentFinancialReport 部门采购财务报
     * @return 部门采购财务报
     */
    @Override
    public List<DepartmentFinancialReport> selectDepartmentFinancialReportList(DepartmentFinancialReport departmentFinancialReport)
    {
        return departmentFinancialReportMapper.selectDepartmentFinancialReportList(departmentFinancialReport);
    }

    /**
     * 新增部门采购财务报
     * 
     * @param departmentFinancialReport 部门采购财务报
     * @return 结果
     */
    @Override
    public int insertDepartmentFinancialReport(DepartmentFinancialReport departmentFinancialReport)
    {
        departmentFinancialReport.setCreateTime(DateUtils.getNowDate());
        return departmentFinancialReportMapper.insertDepartmentFinancialReport(departmentFinancialReport);
    }

    /**
     * 修改部门采购财务报
     * 
     * @param departmentFinancialReport 部门采购财务报
     * @return 结果
     */
    @Override
    public int updateDepartmentFinancialReport(DepartmentFinancialReport departmentFinancialReport)
    {
        departmentFinancialReport.setUpdateTime(DateUtils.getNowDate());
        return departmentFinancialReportMapper.updateDepartmentFinancialReport(departmentFinancialReport);
    }

    /**
     * 批量删除部门采购财务报
     * 
     * @param reportIds 需要删除的部门采购财务报主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentFinancialReportByReportIds(Long[] reportIds)
    {
        return departmentFinancialReportMapper.deleteDepartmentFinancialReportByReportIds(reportIds);
    }

    /**
     * 删除部门采购财务报信息
     * 
     * @param reportId 部门采购财务报主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentFinancialReportByReportId(Long reportId)
    {
        return departmentFinancialReportMapper.deleteDepartmentFinancialReportByReportId(reportId);
    }

    @Override
    public DepartmentFinancialReport selectDepartmentFinancialReportByDepartmentId(Long departmentId) {

        return departmentFinancialReportMapper.selectDepartmentFinancialReportByDepartmentId(departmentId);
    }

    @Override
    public void delAll() {
        departmentFinancialReportMapper.delAll();
    }
}

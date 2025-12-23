package com.office.report.mapper;

import java.util.List;
import com.office.report.domain.DepartmentFinancialReport;
import org.apache.ibatis.annotations.Delete;

/**
 * 部门采购财务报Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-14
 */
public interface DepartmentFinancialReportMapper 
{
    /**
     * 查询部门采购财务报
     * 
     * @param reportId 部门采购财务报主键
     * @return 部门采购财务报
     */
    public DepartmentFinancialReport selectDepartmentFinancialReportByReportId(Long reportId);

    /**
     * 查询部门采购财务报列表
     * 
     * @param departmentFinancialReport 部门采购财务报
     * @return 部门采购财务报集合
     */
    public List<DepartmentFinancialReport> selectDepartmentFinancialReportList(DepartmentFinancialReport departmentFinancialReport);

    /**
     * 新增部门采购财务报
     * 
     * @param departmentFinancialReport 部门采购财务报
     * @return 结果
     */
    public int insertDepartmentFinancialReport(DepartmentFinancialReport departmentFinancialReport);

    /**
     * 修改部门采购财务报
     * 
     * @param departmentFinancialReport 部门采购财务报
     * @return 结果
     */
    public int updateDepartmentFinancialReport(DepartmentFinancialReport departmentFinancialReport);

    /**
     * 删除部门采购财务报
     * 
     * @param reportId 部门采购财务报主键
     * @return 结果
     */
    public int deleteDepartmentFinancialReportByReportId(Long reportId);

    /**
     * 批量删除部门采购财务报
     * 
     * @param reportIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDepartmentFinancialReportByReportIds(Long[] reportIds);

    DepartmentFinancialReport selectDepartmentFinancialReportByDepartmentId(Long departmentId);

    @Delete("delete from department_financial_report  ")
    void delAll();
}

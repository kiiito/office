package com.office.applicationBuyer.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.office.applicationBuyer.domain.PurchasePMApplication;
import com.office.applicationBuyer.service.IPurchasePMApplicationService;
import com.office.common.utils.poi.ExcelUtil;
import com.office.common.core.page.TableDataInfo;

/**
 * 采购申请主Controller
 * 
 * @author hucong
 * @date 2025-11-28
 */
@RestController
@RequestMapping("/applicationBuyer/applicationBuyer")
public class PurchasePMApplicationController extends BaseController
{
    @Autowired
    private IPurchasePMApplicationService purchasePMApplicationService;

    /**
     * 查询采购申请主列表
     */
    @PreAuthorize("@ss.hasPermi('applicationBuyer:applicationBuyer:list')")
    @GetMapping("/list")
    public TableDataInfo list(PurchasePMApplication purchasePMApplication)
    {
        startPage();
        List<PurchasePMApplication> list = purchasePMApplicationService.selectPurchasePMApplicationList(purchasePMApplication);
        return getDataTable(list);
    }

    /**
     * 导出采购申请主列表
     */
    @PreAuthorize("@ss.hasPermi('applicationBuyer:applicationBuyer:export')")
    @Log(title = "采购申请主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PurchasePMApplication purchasePMApplication)
    {
        List<PurchasePMApplication> list = purchasePMApplicationService.selectPurchasePMApplicationList(purchasePMApplication);
        ExcelUtil<PurchasePMApplication> util = new ExcelUtil<PurchasePMApplication>(PurchasePMApplication.class);
        util.exportExcel(response, list, "采购申请主数据");
    }

    /**
     * 获取采购申请主详细信息
     */
    @PreAuthorize("@ss.hasPermi('applicationBuyer:applicationBuyer:query')")
    @GetMapping(value = "/{applicationId}")
    public AjaxResult getInfo(@PathVariable("applicationId") Long applicationId)
    {
        return success(purchasePMApplicationService.selectPurchasePMApplicationByApplicationId(applicationId));
    }

    /**
     * 新增采购申请主
     */
    @PreAuthorize("@ss.hasPermi('applicationBuyer:applicationBuyer:add')")
    @Log(title = "采购申请主", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PurchasePMApplication purchasePMApplication)
    {
        return toAjax(purchasePMApplicationService.insertPurchasePMApplication(purchasePMApplication));
    }

    /**
     * 修改采购申请主
     */
    @PreAuthorize("@ss.hasPermi('applicationBuyer:applicationBuyer:edit')")
    @Log(title = "采购申请主", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PurchasePMApplication purchasePMApplication)
    {
        return toAjax(purchasePMApplicationService.updatePurchasePMApplication(purchasePMApplication));
    }

    /**
     * 删除采购申请主
     */
    @PreAuthorize("@ss.hasPermi('applicationBuyer:applicationBuyer:remove')")
    @Log(title = "采购申请主", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applicationIds}")
    public AjaxResult remove(@PathVariable Long[] applicationIds)
    {
        return toAjax(purchasePMApplicationService.deletePurchasePMApplicationByApplicationIds(applicationIds));
    }
}

package com.office.application.controller;

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
import com.office.application.domain.PurchaseApplication;
import com.office.application.service.IPurchaseApplicationService;
import com.office.common.utils.poi.ExcelUtil;
import com.office.common.core.page.TableDataInfo;

/**
 * 采购申请主Controller
 * 
 * @author hucong
 * @date 2025-11-28
 */
@RestController
@RequestMapping("/application/application")
public class PurchaseApplicationController extends BaseController
{
    @Autowired
    private IPurchaseApplicationService purchaseApplicationService;

    /**
     * 查询采购申请主列表
     */
    @PreAuthorize("@ss.hasPermi('application:application:list')")
    @GetMapping("/list")
    public TableDataInfo list(PurchaseApplication purchaseApplication)
    {
        startPage();
        List<PurchaseApplication> list = purchaseApplicationService.selectPurchaseApplicationList(purchaseApplication);
        return getDataTable(list);
    }

    /**
     * 导出采购申请主列表
     */
    @PreAuthorize("@ss.hasPermi('application:application:export')")
    @Log(title = "采购申请主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PurchaseApplication purchaseApplication)
    {
        List<PurchaseApplication> list = purchaseApplicationService.selectPurchaseApplicationList(purchaseApplication);
        ExcelUtil<PurchaseApplication> util = new ExcelUtil<PurchaseApplication>(PurchaseApplication.class);
        util.exportExcel(response, list, "采购申请主数据");
    }

    /**
     * 获取采购申请主详细信息
     */
    @PreAuthorize("@ss.hasPermi('application:application:query')")
    @GetMapping(value = "/{applicationId}")
    public AjaxResult getInfo(@PathVariable("applicationId") Long applicationId)
    {
        return success(purchaseApplicationService.selectPurchaseApplicationByApplicationId(applicationId));
    }

    /**
     * 新增采购申请主
     */
    @PreAuthorize("@ss.hasPermi('application:application:add')")
    @Log(title = "采购申请主", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PurchaseApplication purchaseApplication)
    {
        return toAjax(purchaseApplicationService.insertPurchaseApplication(purchaseApplication));
    }

    /**
     * 修改采购申请主
     */
    @PreAuthorize("@ss.hasPermi('application:application:edit')")
    @Log(title = "采购申请主", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PurchaseApplication purchaseApplication)
    {
        return toAjax(purchaseApplicationService.updatePurchaseApplication(purchaseApplication));
    }

    /**
     * 删除采购申请主
     */
    @PreAuthorize("@ss.hasPermi('application:application:remove')")
    @Log(title = "采购申请主", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applicationIds}")
    public AjaxResult remove(@PathVariable Long[] applicationIds)
    {
        return toAjax(purchaseApplicationService.deletePurchaseApplicationByApplicationIds(applicationIds));
    }
}

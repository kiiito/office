package com.office.detailBuyer.controller;

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
import com.office.detailBuyer.domain.PurchasePMApplicationDetail;
import com.office.detailBuyer.service.IPurchasePMApplicationDetailService;
import com.office.common.utils.poi.ExcelUtil;
import com.office.common.core.page.TableDataInfo;

/**
 * 采购申请明细Controller
 * 
 * @author hucong
 * @date 2025-11-28
 */
@RestController
@RequestMapping("/detailBuyer/detailBuyer")
public class PurchasePMApplicationDetailController extends BaseController
{
    @Autowired
    private IPurchasePMApplicationDetailService purchasePMApplicationDetailService;

    /**
     * 查询采购申请明细列表
     */
    @PreAuthorize("@ss.hasPermi('detailBuyer:detailBuyer:list')")
    @GetMapping("/list")
    public TableDataInfo list(PurchasePMApplicationDetail purchasePMApplicationDetail)
    {
        startPage();
        List<PurchasePMApplicationDetail> list = purchasePMApplicationDetailService.selectPurchasePMApplicationDetailList(purchasePMApplicationDetail);
        return getDataTable(list);
    }

    /**
     * 导出采购申请明细列表
     */
    @PreAuthorize("@ss.hasPermi('detailBuyer:detailBuyer:export')")
    @Log(title = "采购申请明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PurchasePMApplicationDetail purchasePMApplicationDetail)
    {
        List<PurchasePMApplicationDetail> list = purchasePMApplicationDetailService.selectPurchasePMApplicationDetailList(purchasePMApplicationDetail);
        ExcelUtil<PurchasePMApplicationDetail> util = new ExcelUtil<PurchasePMApplicationDetail>(PurchasePMApplicationDetail.class);
        util.exportExcel(response, list, "采购申请明细数据");
    }

    /**
     * 获取采购申请明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('detailBuyer:detailBuyer:query')")
    @GetMapping(value = "/{detailId}")
    public AjaxResult getInfo(@PathVariable("detailId") Long detailId)
    {
        return success(purchasePMApplicationDetailService.selectPurchasePMApplicationDetailByDetailId(detailId));
    }

    /**
     * 新增采购申请明细
     */
    @PreAuthorize("@ss.hasPermi('detailBuyer:detailBuyer:add')")
    @Log(title = "采购申请明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PurchasePMApplicationDetail purchasePMApplicationDetail)
    {
        return toAjax(purchasePMApplicationDetailService.insertPurchasePMApplicationDetail(purchasePMApplicationDetail));
    }

    /**
     * 修改采购申请明细
     */
    @PreAuthorize("@ss.hasPermi('detailBuyer:detailBuyer:edit')")
    @Log(title = "采购申请明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PurchasePMApplicationDetail purchasePMApplicationDetail)
    {
        return toAjax(purchasePMApplicationDetailService.updatePurchasePMApplicationDetail(purchasePMApplicationDetail));
    }

    /**
     * 删除采购申请明细
     */
    @PreAuthorize("@ss.hasPermi('detailBuyer:detailBuyer:remove')")
    @Log(title = "采购申请明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{detailIds}")
    public AjaxResult remove(@PathVariable Long[] detailIds)
    {
        return toAjax(purchasePMApplicationDetailService.deletePurchasePMApplicationDetailByDetailIds(detailIds));
    }
}

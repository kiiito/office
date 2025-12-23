package com.office.order.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.office.common.core.domain.entity.SysDept;
import com.office.system.service.impl.SysDeptServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.office.common.annotation.Log;
import com.office.common.core.controller.BaseController;
import com.office.common.core.domain.AjaxResult;
import com.office.common.enums.BusinessType;
import com.office.order.domain.PurchaseOrder;
import com.office.order.service.IPurchaseOrderService;
import com.office.common.utils.poi.ExcelUtil;
import com.office.common.core.page.TableDataInfo;

import static com.office.order.utils.OrderNoGenerator.generateOrderNo;

/**
 * 采购订单Controller
 * 
 * @author hucong
 * @date 2025-12-10
 */
@RestController
@RequestMapping("/order/order")
public class PurchaseOrderController extends BaseController
{
    @Autowired
    private IPurchaseOrderService purchaseOrderService;


    @Autowired
    private SysDeptServiceImpl sysDeptService;

    /**
     * 查询采购订单列表
     */
    @PreAuthorize("@ss.hasPermi('order:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(PurchaseOrder purchaseOrder)
    {
        startPage();
        List<PurchaseOrder> list = purchaseOrderService.selectPurchaseOrderList(purchaseOrder);
        return getDataTable(list);
    }

    /**
     * 导出采购订单列表
     */
    @PreAuthorize("@ss.hasPermi('order:order:export')")
    @Log(title = "采购订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PurchaseOrder purchaseOrder)
    {
        List<PurchaseOrder> list = purchaseOrderService.selectPurchaseOrderList(purchaseOrder);
        ExcelUtil<PurchaseOrder> util = new ExcelUtil<PurchaseOrder>(PurchaseOrder.class);
        util.exportExcel(response, list, "采购订单数据");
    }

    /**
     * 获取采购订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:order:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return success(purchaseOrderService.selectPurchaseOrderByOrderId(orderId));
    }

    /**
     * 新增采购订单
     */
    @PreAuthorize("@ss.hasPermi('order:order:add')")
    @Log(title = "采购订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PurchaseOrder purchaseOrder)
    {
        System.out.println(purchaseOrder);
        System.out.println(purchaseOrder.getTotalAmount().getClass());
//        String orderNo = generateOrderNo();
//        System.out.println(orderNo);
//        purchaseOrder.setOrderNo(orderNo);
        SysDept sysDept = sysDeptService.selectDeptById(purchaseOrder.getDepartmentId());
        String deptName = sysDept.getDeptName();
        purchaseOrder.setDepartmentName(deptName);
        return toAjax(purchaseOrderService.insertPurchaseOrder(purchaseOrder));
    }

    /**
     * 修改采购订单
     */
    @PreAuthorize("@ss.hasPermi('order:order:edit')")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PurchaseOrder purchaseOrder)
    {
        return toAjax(purchaseOrderService.updatePurchaseOrder(purchaseOrder));
    }

    /**
     * 删除采购订单
     */
    @PreAuthorize("@ss.hasPermi('order:order:remove')")
    @Log(title = "采购订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(purchaseOrderService.deletePurchaseOrderByOrderIds(orderIds));
    }

    /**
     * 根据订单编号查询订单详情
     */
    @GetMapping(value = "/getOrderNo")
    public PurchaseOrder getOrderInfoByOrderNo(@RequestParam String orderNo)
    {
        System.out.println(orderNo);
        return purchaseOrderService.getOrderInfoByOrderNo(orderNo);
    }
}

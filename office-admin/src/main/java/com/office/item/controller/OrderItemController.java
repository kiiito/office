package com.office.item.controller;

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
import com.office.item.domain.OrderItem;
import com.office.item.service.IOrderItemService;
import com.office.common.utils.poi.ExcelUtil;
import com.office.common.core.page.TableDataInfo;

/**
 * 订单明细Controller
 * 
 * @author hucong
 * @date 2025-12-10
 */
@RestController
@RequestMapping("/item/item")
public class OrderItemController extends BaseController
{
    @Autowired
    private IOrderItemService orderItemService;

    /**
     * 查询订单明细列表
     */
    @PreAuthorize("@ss.hasPermi('item:item:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrderItem orderItem)
    {
        startPage();
        List<OrderItem> list = orderItemService.selectOrderItemList(orderItem);
        return getDataTable(list);
    }

    /**
     * 导出订单明细列表
     */
    @PreAuthorize("@ss.hasPermi('item:item:export')")
    @Log(title = "订单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderItem orderItem)
    {
        List<OrderItem> list = orderItemService.selectOrderItemList(orderItem);
        ExcelUtil<OrderItem> util = new ExcelUtil<OrderItem>(OrderItem.class);
        util.exportExcel(response, list, "订单明细数据");
    }

    /**
     * 获取订单明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('item:item:query')")
    @GetMapping(value = "/{itemId}")
    public AjaxResult getInfo(@PathVariable("itemId") Long itemId)
    {
        return success(orderItemService.selectOrderItemByItemId(itemId));
    }

    /**
     * 新增订单明细
     */
    @PreAuthorize("@ss.hasPermi('item:item:add')")
    @Log(title = "订单明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderItem orderItem)
    {
        return toAjax(orderItemService.insertOrderItem(orderItem));
    }

    /**
     * 修改订单明细
     */
    @PreAuthorize("@ss.hasPermi('item:item:edit')")
    @Log(title = "订单明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderItem orderItem)
    {
        return toAjax(orderItemService.updateOrderItem(orderItem));
    }

    /**
     * 删除订单明细
     */
    @PreAuthorize("@ss.hasPermi('item:item:remove')")
    @Log(title = "订单明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{itemIds}")
    public AjaxResult remove(@PathVariable Long[] itemIds)
    {
        return toAjax(orderItemService.deleteOrderItemByItemIds(itemIds));
    }


    @PostMapping("/addItemList")
    public AjaxResult addItemList(@RequestBody List<OrderItem> orderItemList)
    {
        int count = 0;
        for (OrderItem orderItem : orderItemList) {
            int result = orderItemService.insertOrderItem(orderItem);
            count += result;
        }
        if (count == orderItemList.size()){
            return success();
        }
        return error();
    }
}

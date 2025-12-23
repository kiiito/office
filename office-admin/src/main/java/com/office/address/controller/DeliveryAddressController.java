package com.office.address.controller;

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
import com.office.address.domain.DeliveryAddress;
import com.office.address.service.IDeliveryAddressService;
import com.office.common.utils.poi.ExcelUtil;
import com.office.common.core.page.TableDataInfo;

/**
 * 收货地址Controller
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
@RestController
@RequestMapping("/address/address")
public class DeliveryAddressController extends BaseController
{
    @Autowired
    private IDeliveryAddressService deliveryAddressService;

    /**
     * 查询收货地址列表
     */
    @PreAuthorize("@ss.hasPermi('address:address:list')")
    @GetMapping("/list")
    public TableDataInfo list(DeliveryAddress deliveryAddress)
    {
        startPage();
        List<DeliveryAddress> list = deliveryAddressService.selectDeliveryAddressList(deliveryAddress);
        return getDataTable(list);
    }

    /**
     * 导出收货地址列表
     */
    @PreAuthorize("@ss.hasPermi('address:address:export')")
    @Log(title = "收货地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DeliveryAddress deliveryAddress)
    {
        List<DeliveryAddress> list = deliveryAddressService.selectDeliveryAddressList(deliveryAddress);
        ExcelUtil<DeliveryAddress> util = new ExcelUtil<DeliveryAddress>(DeliveryAddress.class);
        util.exportExcel(response, list, "收货地址数据");
    }

    /**
     * 获取收货地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('address:address:query')")
    @GetMapping(value = "/{addressId}")
    public AjaxResult getInfo(@PathVariable("addressId") Long addressId)
    {
        return success(deliveryAddressService.selectDeliveryAddressByAddressId(addressId));
    }

    /**
     * 新增收货地址
     */
    @PreAuthorize("@ss.hasPermi('address:address:add')")
    @Log(title = "收货地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DeliveryAddress deliveryAddress)
    {
        return toAjax(deliveryAddressService.insertDeliveryAddress(deliveryAddress));
    }

    /**
     * 修改收货地址
     */
    @PreAuthorize("@ss.hasPermi('address:address:edit')")
    @Log(title = "收货地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeliveryAddress deliveryAddress)
    {
        return toAjax(deliveryAddressService.updateDeliveryAddress(deliveryAddress));
    }

    /**
     * 删除收货地址
     */
    @PreAuthorize("@ss.hasPermi('address:address:remove')")
    @Log(title = "收货地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{addressIds}")
    public AjaxResult remove(@PathVariable Long[] addressIds)
    {
        return toAjax(deliveryAddressService.deleteDeliveryAddressByAddressIds(addressIds));
    }
}

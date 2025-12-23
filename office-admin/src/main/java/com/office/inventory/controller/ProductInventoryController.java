package com.office.inventory.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.office.common.constant.HttpStatus;
import com.office.inventory.domain.query.ProductQuery;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.office.common.annotation.Log;
import com.office.common.core.controller.BaseController;
import com.office.common.core.domain.AjaxResult;
import com.office.common.enums.BusinessType;
import com.office.inventory.domain.ProductInventory;
import com.office.inventory.service.IProductInventoryService;
import com.office.common.utils.poi.ExcelUtil;
import com.office.common.core.page.TableDataInfo;

/**
 * 商品库存Controller
 * 
 * @author hucong
 * @date 2025-11-23
 */
@RestController
@RequestMapping("/inventory/inventory")
public class ProductInventoryController extends BaseController
{
    @Autowired
    private  IProductInventoryService productInventoryService;

    /**
     * 查询商品库存列表
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductInventory productInventory)
    {
        startPage();
        List<ProductInventory> list = productInventoryService.selectProductInventoryList(productInventory);
        return getDataTable(list);
    }

    @GetMapping("/list/summary")
    public TableDataInfo getListSummary(){
        List<ProductQuery> listSummary = productInventoryService.getListSummary();
        return getDataTable(listSummary);
    }
    /**
     * 导出商品库存列表
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:export')")
    @Log(title = "商品库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductInventory productInventory)
    {
        List<ProductInventory> list = productInventoryService.selectProductInventoryList(productInventory);
        ExcelUtil<ProductInventory> util = new ExcelUtil<ProductInventory>(ProductInventory.class);
        util.exportExcel(response, list, "商品库存数据");
    }

    /**
     * 获取商品库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:query')")
    @GetMapping(value = "/{inventoryId}")
    public AjaxResult getInfo(@PathVariable("inventoryId") Long inventoryId)
    {
        return success(productInventoryService.selectProductInventoryByInventoryId(inventoryId));
    }


    /**
     * 新增商品库存
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:add')")
    @Log(title = "商品库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductInventory productInventory)
    {
        return toAjax(productInventoryService.insertProductInventory(productInventory));
    }

    /**
     * 修改商品库存
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:edit') or @ss.hasRole('manager')")
    @Log(title = "商品库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductInventory productInventory)
    {
        return toAjax(productInventoryService.updateProductInventory(productInventory));
    }


    /**
     * 在进行入库的时候修改库存
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:edit') or @ss.hasRole('manager')")
    @Log(title = "商品库存", businessType = BusinessType.UPDATE)
    @PutMapping("/updateStock")
    public AjaxResult updateStock(@RequestBody ProductInventory productInventory) {
//        System.out.println(productInventory);
//        System.out.println(productInventory.getCurrentStock());
//        System.out.println(productInventory.getProductId());
//        Long productId = productInventory.getProductId();
//        ProductInventory inventoryByProductId =
//                productInventoryService.getInventoryByProductId(productId);
//        if (inventoryByProductId == null){
//            return toAjax(productInventoryService.insertProductInventory(productInventory));
//
//        }
//        Long currentStock = inventoryByProductId.getCurrentStock();
//        inventoryByProductId.setCurrentStock(currentStock + productInventory.getCurrentStock());
        int update = productInventoryService.updateProductInventoryBY(productInventory);
       return update == 1 ? success() : error();
    }


    /**
     * 删除商品库存
     */
    @PreAuthorize("@ss.hasPermi('inventory:inventory:remove')")
    @Log(title = "商品库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{inventoryIds}")
    public AjaxResult remove(@PathVariable Long[] inventoryIds)
    {
        return toAjax(productInventoryService.deleteProductInventoryByInventoryIds(inventoryIds));
    }


}

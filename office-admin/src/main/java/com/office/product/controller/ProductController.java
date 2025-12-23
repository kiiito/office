package com.office.product.controller;

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
import com.office.product.domain.Product;
import com.office.product.service.IProductService;
import com.office.common.utils.poi.ExcelUtil;
import com.office.common.core.page.TableDataInfo;

/**
 * 商品基本信息Controller
 * 
 * @author hucong
 * @date 2025-11-23
 */
@RestController
@RequestMapping("/product/product")
public class ProductController extends BaseController
{
    @Autowired
    private IProductService productService;

    /**
     * 查询商品基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('product:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(Product product)
    {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 导出商品基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('product:product:export')")
    @Log(title = "商品基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Product product)
    {
        List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        util.exportExcel(response, list, "商品基本信息数据");
    }

    /**
     * 获取商品基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Long productId)
    {
//        return success(productService.selectProductByProductId(productId));
        // 这里返回类型实际上是ProductWithInventory，但由于继承关系，可以向上转型为Product
       Product product = productService.selectProductByProductId(productId);
        return success(product);
    }

    /**
     * 获取商品基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:product:query')")

    @GetMapping(value = "/ByproductName/{productName}")
    public AjaxResult getInfoByName(@PathVariable String productName)
    {
        Product product = productService.selectProductByProductName(productName);
        return success(product);
    }


    /**
     * 新增商品基本信息
     */
    @PreAuthorize("@ss.hasPermi('product:product:add')")
    @Log(title = "商品基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Product product)
    {
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改商品基本信息
     */
    @PreAuthorize("@ss.hasPermi('product:product:edit')")
    @Log(title = "商品基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除商品基本信息
     */
    @PreAuthorize("@ss.hasPermi('product:product:remove')")
    @Log(title = "商品基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(productService.deleteProductByProductIds(productIds));
    }
}

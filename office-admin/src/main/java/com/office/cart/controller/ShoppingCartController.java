package com.office.cart.controller;

import java.math.BigDecimal;
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
import com.office.cart.domain.ShoppingCart;
import com.office.cart.service.IShoppingCartService;
import com.office.common.utils.poi.ExcelUtil;
import com.office.common.core.page.TableDataInfo;

/**
 * 购物车Controller
 * 
 * @author hucong
 * @date 2025-12-03
 */
@RestController
@RequestMapping("/cart/cart")
public class ShoppingCartController extends BaseController
{
    @Autowired
    private IShoppingCartService shoppingCartService;

    /**
     * 查询购物车列表
     */
    @PreAuthorize("@ss.hasPermi('cart:cart:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShoppingCart shoppingCart)
    {
        startPage();
        List<ShoppingCart> list = shoppingCartService.selectShoppingCartList(shoppingCart);
        return getDataTable(list);
    }

    /**
     * 导出购物车列表
     */
    @PreAuthorize("@ss.hasPermi('cart:cart:export')")
    @Log(title = "购物车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShoppingCart shoppingCart)
    {
        List<ShoppingCart> list = shoppingCartService.selectShoppingCartList(shoppingCart);
        ExcelUtil<ShoppingCart> util = new ExcelUtil<ShoppingCart>(ShoppingCart.class);
        util.exportExcel(response, list, "购物车数据");
    }

    /**
     * 获取购物车详细信息
     */
    @PreAuthorize("@ss.hasPermi('cart:cart:query')")
    @GetMapping(value = "/{cartId}")
    public AjaxResult getInfo(@PathVariable("cartId") Long cartId)
    {
        return success(shoppingCartService.selectShoppingCartByCartId(cartId));
    }

    /**
     * 新增购物车
     */
    @PreAuthorize("@ss.hasPermi('cart:cart:add')")
    @Log(title = "购物车", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShoppingCart shoppingCart)
    {
        //判断是否已经存在相同人购买相同商品
        List<ShoppingCart> shoppingCarts = shoppingCartService.selectShoppingCartList(shoppingCart);
//        System.out.println(shoppingCarts);
        if (shoppingCarts.size() > 0){
            //存在 如果存在，则更新数量和总价
            shoppingCart.setQuantity(shoppingCart.getQuantity() + shoppingCarts.get(0).getQuantity());
            shoppingCart.setTotalPrice(new BigDecimal(shoppingCart.getQuantity()).multiply(shoppingCart.getEstimatedPrice()));
            shoppingCart.setCartId(shoppingCarts.get(0).getCartId());
            return toAjax(shoppingCartService.updateShoppingCart(shoppingCart));
        }
        return toAjax(shoppingCartService.insertShoppingCart(shoppingCart));
    }

    /**
     * 修改购物车
     */
    @PreAuthorize("@ss.hasPermi('cart:cart:edit')")
    @Log(title = "购物车", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShoppingCart shoppingCart)
    {
        return toAjax(shoppingCartService.updateShoppingCart(shoppingCart));
    }

    /**
     * 删除购物车
     */
    @PreAuthorize("@ss.hasPermi('cart:cart:remove')")
    @Log(title = "购物车", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cartIds}")
    public AjaxResult remove(@PathVariable Long[] cartIds)
    {
        return toAjax(shoppingCartService.deleteShoppingCartByCartIds(cartIds));
    }


}

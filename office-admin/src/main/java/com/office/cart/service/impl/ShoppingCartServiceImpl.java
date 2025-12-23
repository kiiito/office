package com.office.cart.service.impl;

import java.util.List;
import com.office.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.office.cart.mapper.ShoppingCartMapper;
import com.office.cart.domain.ShoppingCart;
import com.office.cart.service.IShoppingCartService;

/**
 * 购物车Service业务层处理
 * 
 * @author hucong
 * @date 2025-12-03
 */
@Service
public class ShoppingCartServiceImpl implements IShoppingCartService 
{
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 查询购物车
     * 
     * @param cartId 购物车主键
     * @return 购物车
     */
    @Override
    public ShoppingCart selectShoppingCartByCartId(Long cartId)
    {
        return shoppingCartMapper.selectShoppingCartByCartId(cartId);
    }

    /**
     * 查询购物车列表
     * 
     * @param shoppingCart 购物车
     * @return 购物车
     */
    @Override
    public List<ShoppingCart> selectShoppingCartList(ShoppingCart shoppingCart)
    {
        return shoppingCartMapper.selectShoppingCartList(shoppingCart);
    }

    /**
     * 新增购物车
     * 
     * @param shoppingCart 购物车
     * @return 结果
     */
    @Override
    public int insertShoppingCart(ShoppingCart shoppingCart)
    {
        return shoppingCartMapper.insertShoppingCart(shoppingCart);
    }

    /**
     * 修改购物车
     * 
     * @param shoppingCart 购物车
     * @return 结果
     */
    @Override
    public int updateShoppingCart(ShoppingCart shoppingCart)
    {
        shoppingCart.setUpdateTime(DateUtils.getNowDate());
        return shoppingCartMapper.updateShoppingCart(shoppingCart);
    }

    /**
     * 批量删除购物车
     * 
     * @param cartIds 需要删除的购物车主键
     * @return 结果
     */
    @Override
    public int deleteShoppingCartByCartIds(Long[] cartIds)
    {
        return shoppingCartMapper.deleteShoppingCartByCartIds(cartIds);
    }

    /**
     * 删除购物车信息
     * 
     * @param cartId 购物车主键
     * @return 结果
     */
    @Override
    public int deleteShoppingCartByCartId(Long cartId)
    {
        return shoppingCartMapper.deleteShoppingCartByCartId(cartId);
    }
}

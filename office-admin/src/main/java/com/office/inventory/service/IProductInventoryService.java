package com.office.inventory.service;

import java.util.List;
import com.office.inventory.domain.ProductInventory;
import com.office.inventory.domain.query.ProductQuery;

/**
 * 商品库存Service接口
 * 
 * @author hucong
 * @date 2025-11-23
 */
public interface IProductInventoryService 
{
    /**
     * 查询商品库存
     *
     * @param inventoryId 商品库存主键
     * @return 商品库存
     */
    public ProductInventory selectProductInventoryByInventoryId(Long inventoryId);

    /**
     * 查询商品库存列表
     * 
     * @param productInventory 商品库存
     * @return 商品库存集合
     */
    public List<ProductInventory> selectProductInventoryList(ProductInventory productInventory);

    /**
     * 新增商品库存
     * 
     * @param productInventory 商品库存
     * @return 结果
     */
    public int insertProductInventory(ProductInventory productInventory);

    /**
     * 修改商品库存
     * 
     * @param productInventory 商品库存
     * @return 结果
     */
    public int updateProductInventory(ProductInventory productInventory);

    /**
     * 批量删除商品库存
     * 
     * @param inventoryIds 需要删除的商品库存主键集合
     * @return 结果
     */
    public int deleteProductInventoryByInventoryIds(Long[] inventoryIds);

    /**
     * 删除商品库存信息
     * 
     * @param inventoryId 商品库存主键
     * @return 结果
     */
    public int deleteProductInventoryByInventoryId(Long inventoryId);

    List<ProductQuery> getListSummary();


    /**
     * 根据商品id获取库存信息
     */
    ProductInventory getInventoryByProductId(Long productId);

    int updateProductInventoryBY(ProductInventory productInventory);
}


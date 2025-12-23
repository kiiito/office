package com.office.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.office.common.utils.DateUtils;
import com.office.inventory.domain.query.ProductQuery;
import com.office.product.domain.Product;
import com.office.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.office.inventory.mapper.ProductInventoryMapper;
import com.office.inventory.domain.ProductInventory;
import com.office.inventory.service.IProductInventoryService;

/**
 * 商品库存Service业务层处理
 * 
 * @author hucong
 * @date 2025-11-23
 */
@Service
public class ProductInventoryServiceImpl implements IProductInventoryService 
{
    @Autowired
    private ProductInventoryMapper productInventoryMapper;
    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询商品库存
     * 
     * @param inventoryId 商品库存主键
     * @return 商品库存
     */
    @Override
    public ProductInventory selectProductInventoryByInventoryId(Long inventoryId)
    {
        return productInventoryMapper.selectProductInventoryByInventoryId(inventoryId);
    }

    /**
     * 查询商品库存列表
     * 
     * @param productInventory 商品库存
     * @return 商品库存
     */
    @Override
    public List<ProductInventory> selectProductInventoryList(ProductInventory productInventory)
    {
        List<ProductInventory> productInventories = productInventoryMapper.selectProductInventoryList(productInventory);
        productInventories.forEach(item -> {
            Product product = productMapper.selectProductByProductId(item.getProductId());
            int oldStatus = item.getStockStatus(); // 保存旧状态

            if (product != null && product.getSafetyStock() != null) {
                if (item.getCurrentStock() < product.getSafetyStock()) {
                    item.setStockStatus(1);
                } else {
                    item.setStockStatus(0);
                }
            } else {
                item.setStockStatus(0);
            }
            // 只有状态发生变化时才更新数据库
            if (oldStatus != item.getStockStatus()) {
                productInventoryMapper.updateProductInventory(item); // 更新单个item
            }
        });
        return productInventories;
    }

    /**
     * 新增商品库存
     * 
     * @param productInventory 商品库存
     * @return 结果
     */
    @Override
    public int insertProductInventory(ProductInventory productInventory)
    {
        productInventory.setCreateTime(DateUtils.getNowDate());
        return productInventoryMapper.insertProductInventory(productInventory);
    }

    /**
     * 修改商品库存
     * 
     * @param productInventory 商品库存
     * @return 结果
     */
    @Override
    public int updateProductInventory(ProductInventory productInventory)
    {
//        productInventory.setUpdateTime(DateUtils.getNowDate());
//        return productInventoryMapper.updateProductInventory(productInventory);
        productInventory.setUpdateTime(DateUtils.getNowDate());

        // 根据商品ID查询产品的安全库存
        Product product = productMapper.selectProductByProductId(productInventory.getProductId());

        if (product != null) {
            // 使用更新后的库存(current_stock)与产品的安全库存进行对比
            if (productInventory.getCurrentStock() < product.getSafetyStock()) {
                productInventory.setStockStatus(1); // 低于安全库存，状态设为1(缺货)
            } else {
                productInventory.setStockStatus(0); // 正常库存状态
            }
        } else {
            // 如果没有找到对应的产品，可以设置默认状态或抛出异常
            productInventory.setStockStatus(0);
        }

        return productInventoryMapper.updateProductInventory(productInventory);
    }

    /**
     * 批量删除商品库存
     * 
     * @param inventoryIds 需要删除的商品库存主键
     * @return 结果
     */
    @Override
    public int deleteProductInventoryByInventoryIds(Long[] inventoryIds)
    {
        return productInventoryMapper.deleteProductInventoryByInventoryIds(inventoryIds);
    }

    /**
     * 删除商品库存信息
     * 
     * @param inventoryId 商品库存主键
     * @return 结果
     */
    @Override
    public int deleteProductInventoryByInventoryId(Long inventoryId)
    {
        return productInventoryMapper.deleteProductInventoryByInventoryId(inventoryId);
    }

    @Override
    public List<ProductQuery> getListSummary() {
        List<ProductQuery> productQueries = productInventoryMapper.selectProductInventorySummaryList();
        // 创建新列表存储库存不足的商品
        List<ProductQuery> lowStockProducts = new ArrayList<>();

        // 遍历列表，筛选当前库存低于安全库存的商品
        productQueries.forEach(item -> {
            if (item != null && item.getCurrentStock() != null && item.getSafetyStock() != null) {
                // 判断当前库存是否小于安全库存
                if (item.getCurrentStock() < item.getSafetyStock()) {
                    lowStockProducts.add(item);
                    //todo//更新数据库商品库存状态
                    ProductInventory updateEntity = new ProductInventory();
                    updateEntity.setProductName(item.getProductName()); // 使用商品名称
                    updateEntity.setStockStatus(1);
                    productInventoryMapper.updateProductInventoryStatus(updateEntity);
                }else {
                    ProductInventory updateEntity = new ProductInventory();
                    updateEntity.setProductName(item.getProductName()); // 使用商品名称
                    updateEntity.setStockStatus(0);
                    productInventoryMapper.updateProductInventoryStatus(updateEntity);
                }
            }
        });
        return lowStockProducts;
    }

    @Override
    public ProductInventory getInventoryByProductId(Long productId) {
        return productInventoryMapper.getInventoryByProductId(productId);
    }

    @Override
    public int updateProductInventoryBY(ProductInventory productInventory) {
        productInventory.setUpdateTime(DateUtils.getNowDate());
        // 根据商品ID查询产品的安全库存
        Product product = productMapper.selectProductByProductId(productInventory.getProductId());
        ProductInventory inventory = productInventoryMapper.getInventoryByProductId(productInventory.getProductId());
        if (inventory == null){
            inventory.setCurrentStock(0L);
            inventory.setSafetyStock(Math.toIntExact(product.getSafetyStock()));
            inventory.setReferencePrice(product.getReferencePrice());
            inventory.setStockStatus(1);
          return   productInventoryMapper.insertProductInventory(inventory);
        }
        inventory.setPreInStockQuantity(productInventory.getPreInStockQuantity());

        return productInventoryMapper.updateProductInventory(inventory);
    }
}

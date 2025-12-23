package com.office.product.service;

import java.util.List;
import com.office.product.domain.Product;

/**
 * 商品基本信息Service接口
 * 
 * @author hucong
 * @date 2025-11-23
 */
public interface IProductService 
{
    /**
     * 查询商品基本信息
     * 
     * @param productId 商品基本信息主键
     * @return 商品基本信息
     */
    public Product selectProductByProductId(Long productId);

    /**
     * 查询商品基本信息列表
     * 
     * @param product 商品基本信息
     * @return 商品基本信息集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增商品基本信息
     * 
     * @param product 商品基本信息
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改商品基本信息
     * 
     * @param product 商品基本信息
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 批量删除商品基本信息
     * 
     * @param productIds 需要删除的商品基本信息主键集合
     * @return 结果
     */
    public int deleteProductByProductIds(Long[] productIds);

    /**
     * 删除商品基本信息信息
     * 
     * @param productId 商品基本信息主键
     * @return 结果
     */
    public int deleteProductByProductId(Long productId);

    Product selectProductByProductName(String productName);
}

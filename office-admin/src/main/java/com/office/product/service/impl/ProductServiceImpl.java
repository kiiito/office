package com.office.product.service.impl;

import java.util.List;
import com.office.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.office.product.mapper.ProductMapper;
import com.office.product.domain.Product;
import com.office.product.service.IProductService;

/**
 * 商品基本信息Service业务层处理
 * 
 * @author hucong
 * @date 2025-11-23
 */
@Service
public class ProductServiceImpl implements IProductService 
{
    @Autowired
    private ProductMapper productMapper;

    /**
     * 查询商品基本信息
     * 
     * @param productId 商品基本信息主键
     * @return 商品基本信息
     */
    @Override
    public Product selectProductByProductId(Long productId)
    {
        return productMapper.selectProductByProductId(productId);
    }

    /**
     * 查询商品基本信息列表
     * 
     * @param product 商品基本信息
     * @return 商品基本信息
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增商品基本信息
     * 
     * @param product 商品基本信息
     * @return 结果
     */
    @Override
    public int insertProduct(Product product)
    {
        product.setCreateTime(DateUtils.getNowDate());
        return productMapper.insertProduct(product);
    }

    /**
     * 修改商品基本信息
     * 
     * @param product 商品基本信息
     * @return 结果
     */
    @Override
    public int updateProduct(Product product)
    {
        product.setUpdateTime(DateUtils.getNowDate());
        return productMapper.updateProduct(product);
    }

    /**
     * 批量删除商品基本信息
     * 
     * @param productIds 需要删除的商品基本信息主键
     * @return 结果
     */
    @Override
    public int deleteProductByProductIds(Long[] productIds)
    {
        return productMapper.deleteProductByProductIds(productIds);
    }

    /**
     * 删除商品基本信息信息
     * 
     * @param productId 商品基本信息主键
     * @return 结果
     */
    @Override
    public int deleteProductByProductId(Long productId)
    {
        return productMapper.deleteProductByProductId(productId);
    }

    @Override
    public Product selectProductByProductName(String productName) {
        return productMapper.selectProductByProductName(productName);
    }
}

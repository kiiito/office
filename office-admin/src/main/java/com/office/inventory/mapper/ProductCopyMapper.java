package com.office.inventory.mapper;

import com.office.product.domain.Product;
import org.apache.ibatis.annotations.Select;

public interface ProductCopyMapper {
    /**
     * 根据产品ID查询产品信息
     */
    @Select("SELECT product_id, product_name, safety_stock, status " +
            "FROM product " +
            "WHERE product_id = #{productId}")
    Product selectProductById(Long productId);
}

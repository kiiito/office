package com.office.inventory.domain.query;

import com.office.common.annotation.Excel;
import com.office.inventory.domain.ProductInventory;

public class ProductQuery {
    private static final long serialVersionUID = 1L;



    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 当前库存 */
    @Excel(name = "当前库存")
    private Long currentStock;

    @Excel(name = "安全库存")
    private Long safetyStock;

    public Long getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(Long safetyStock) {
        this.safetyStock = safetyStock;
    }

    public Long getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Long currentStock) {
        this.currentStock = currentStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}

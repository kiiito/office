package com.office.inventory.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.office.common.annotation.Excel;
import com.office.common.core.domain.BaseEntity;

/**
 * 商品库存对象 product_inventory
 * 
 * @author hucong
 * @date 2025-11-23
 */
public class ProductInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存ID */
    @Excel(name = "库存ID")
    private Long inventoryId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long productId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 商品分类 */
    @Excel(name = "商品分类")
    private String productType;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specification;

    /** 单位 */
    private String unit;

    /** 商品图片路径 */
    @Excel(name = "商品图片路径")
    private String productImage;

    /** 当前库存 */
    @Excel(name = "当前库存")
    private Long currentStock;

    /** 仓库位置 */
    @Excel(name = "仓库位置")
    private String warehouseLocation;

    /** 最后盘点时间 */
    private Date lastCheckTime;


    /** 预入库数量 */
    private int preInStockQuantity;

    /** 库存状态（正常/不足/缺货） */
    @Excel(name = "库存状态", readConverterExp = "正=常/不足/缺货")
    private int  stockStatus;


    /** 安全库存 */
    private int  safetyStock;
    /** 参考价格 */
    @Excel(name = "参考价格")
    private BigDecimal referencePrice;

    public BigDecimal getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(BigDecimal referencePrice) {
        this.referencePrice = referencePrice;
    }

    public void setInventoryId(Long inventoryId)
    {
        this.inventoryId = inventoryId;
    }

    public Long getInventoryId() 
    {
        return inventoryId;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public int getPreInStockQuantity() {
        return preInStockQuantity;
    }

    public void setPreInStockQuantity(int preInStockQuantity) {
        this.preInStockQuantity = preInStockQuantity;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }

    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }

    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    public void setProductImage(String productImage) 
    {
        this.productImage = productImage;
    }

    public int getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(int safetyStock) {
        this.safetyStock = safetyStock;
    }
    public String getProductImage() 
    {
        return productImage;
    }

    public void setCurrentStock(Long currentStock) 
    {
        this.currentStock = currentStock;
    }

    public Long getCurrentStock() 
    {
        return currentStock;
    }

    public void setWarehouseLocation(String warehouseLocation) 
    {
        this.warehouseLocation = warehouseLocation;
    }

    public String getWarehouseLocation() 
    {
        return warehouseLocation;
    }

    public void setLastCheckTime(Date lastCheckTime) 
    {
        this.lastCheckTime = lastCheckTime;
    }

    public Date getLastCheckTime() 
    {
        return lastCheckTime;
    }

    public void setStockStatus(int stockStatus)
    {
        this.stockStatus = stockStatus;
    }

    public int getStockStatus()
    {
        return stockStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inventoryId", getInventoryId())
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("productType", getProductType())
            .append("specification", getSpecification())
            .append("unit", getUnit())
            .append("productImage", getProductImage())
            .append("currentStock", getCurrentStock())
            .append("warehouseLocation", getWarehouseLocation())
            .append("lastCheckTime", getLastCheckTime())
            .append("stockStatus", getStockStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
                .append("preInStockQuantity", getPreInStockQuantity())
            .toString();
    }
}

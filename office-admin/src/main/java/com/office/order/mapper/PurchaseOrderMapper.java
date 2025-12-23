package com.office.order.mapper;

import java.util.List;
import com.office.order.domain.PurchaseOrder;

/**
 * 采购订单Mapper接口
 * 
 * @author hucong
 * @date 2025-12-10
 */
public interface PurchaseOrderMapper 
{
    /**
     * 查询采购订单
     * 
     * @param orderId 采购订单主键
     * @return 采购订单
     */
    public PurchaseOrder selectPurchaseOrderByOrderId(Long orderId);

    /**
     * 查询采购订单列表
     * 
     * @param purchaseOrder 采购订单
     * @return 采购订单集合
     */
    public List<PurchaseOrder> selectPurchaseOrderList(PurchaseOrder purchaseOrder);

    /**
     * 新增采购订单
     * 
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    public int insertPurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * 修改采购订单
     * 
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    public int updatePurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * 删除采购订单
     * 
     * @param orderId 采购订单主键
     * @return 结果
     */
    public int deletePurchaseOrderByOrderId(Long orderId);

    /**
     * 批量删除采购订单
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchaseOrderByOrderIds(Long[] orderIds);
    /**
     * 根据订单编号查询订单详情
     */
    PurchaseOrder getOrderInfoByOrderNo(String orderNo);
}

package com.office.order.service.impl;

import java.util.List;
import com.office.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.office.order.mapper.PurchaseOrderMapper;
import com.office.order.domain.PurchaseOrder;
import com.office.order.service.IPurchaseOrderService;

/**
 * 采购订单Service业务层处理
 * 
 * @author hucong
 * @date 2025-12-10
 */
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService 
{
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    /**
     * 查询采购订单
     * 
     * @param orderId 采购订单主键
     * @return 采购订单
     */
    @Override
    public PurchaseOrder selectPurchaseOrderByOrderId(Long orderId)
    {
        return purchaseOrderMapper.selectPurchaseOrderByOrderId(orderId);
    }

    /**
     * 查询采购订单列表
     * 
     * @param purchaseOrder 采购订单
     * @return 采购订单
     */
    @Override
    public List<PurchaseOrder> selectPurchaseOrderList(PurchaseOrder purchaseOrder)
    {
        return purchaseOrderMapper.selectPurchaseOrderList(purchaseOrder);
    }

    /**
     * 新增采购订单
     * 
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    @Override
    public int insertPurchaseOrder(PurchaseOrder purchaseOrder)
    {
        purchaseOrder.setCreateTime(DateUtils.getNowDate());
        return purchaseOrderMapper.insertPurchaseOrder(purchaseOrder);
    }

    /**
     * 修改采购订单
     * 
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    @Override
    public int updatePurchaseOrder(PurchaseOrder purchaseOrder)
    {
        purchaseOrder.setUpdateTime(DateUtils.getNowDate());
        return purchaseOrderMapper.updatePurchaseOrder(purchaseOrder);
    }

    /**
     * 批量删除采购订单
     * 
     * @param orderIds 需要删除的采购订单主键
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderByOrderIds(Long[] orderIds)
    {
        return purchaseOrderMapper.deletePurchaseOrderByOrderIds(orderIds);
    }

    /**
     * 删除采购订单信息
     * 
     * @param orderId 采购订单主键
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderByOrderId(Long orderId)
    {
        return purchaseOrderMapper.deletePurchaseOrderByOrderId(orderId);
    }

    /**
     * 根据订单编号查询订单详情
     */
    @Override
    public PurchaseOrder getOrderInfoByOrderNo(String orderNo) {
        PurchaseOrder result = purchaseOrderMapper.getOrderInfoByOrderNo(orderNo);

        // 调试：查看结果对象
        if (result != null) {
            System.out.println("查询成功，订单号：" + result.getOrderNo());
        } else {
            System.out.println("查询返回null，检查字段映射");
        }

        return result;
    }
}

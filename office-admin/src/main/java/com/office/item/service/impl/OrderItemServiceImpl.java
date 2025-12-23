package com.office.item.service.impl;

import java.util.List;
import com.office.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.office.item.mapper.OrderItemMapper;
import com.office.item.domain.OrderItem;
import com.office.item.service.IOrderItemService;

/**
 * 订单明细Service业务层处理
 * 
 * @author hucong
 * @date 2025-12-10
 */
@Service
public class OrderItemServiceImpl implements IOrderItemService 
{
    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * 查询订单明细
     * 
     * @param itemId 订单明细主键
     * @return 订单明细
     */
    @Override
    public OrderItem selectOrderItemByItemId(Long itemId)
    {
        return orderItemMapper.selectOrderItemByItemId(itemId);
    }

    /**
     * 查询订单明细列表
     * 
     * @param orderItem 订单明细
     * @return 订单明细
     */
    @Override
    public List<OrderItem> selectOrderItemList(OrderItem orderItem)
    {
        return orderItemMapper.selectOrderItemList(orderItem);
    }

    /**
     * 新增订单明细
     * 
     * @param orderItem 订单明细
     * @return 结果
     */
    @Override
    public int insertOrderItem(OrderItem orderItem)
    {
        orderItem.setCreateTime(DateUtils.getNowDate());
        return orderItemMapper.insertOrderItem(orderItem);
    }

    /**
     * 修改订单明细
     * 
     * @param orderItem 订单明细
     * @return 结果
     */
    @Override
    public int updateOrderItem(OrderItem orderItem)
    {
        orderItem.setUpdateTime(DateUtils.getNowDate());
        return orderItemMapper.updateOrderItem(orderItem);
    }

    /**
     * 批量删除订单明细
     * 
     * @param itemIds 需要删除的订单明细主键
     * @return 结果
     */
    @Override
    public int deleteOrderItemByItemIds(Long[] itemIds)
    {
        return orderItemMapper.deleteOrderItemByItemIds(itemIds);
    }

    /**
     * 删除订单明细信息
     * 
     * @param itemId 订单明细主键
     * @return 结果
     */
    @Override
    public int deleteOrderItemByItemId(Long itemId)
    {
        return orderItemMapper.deleteOrderItemByItemId(itemId);
    }
}

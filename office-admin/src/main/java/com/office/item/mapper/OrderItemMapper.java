package com.office.item.mapper;

import java.util.List;
import com.office.item.domain.OrderItem;

/**
 * 订单明细Mapper接口
 * 
 * @author hucong
 * @date 2025-12-10
 */
public interface OrderItemMapper 
{
    /**
     * 查询订单明细
     * 
     * @param itemId 订单明细主键
     * @return 订单明细
     */
    public OrderItem selectOrderItemByItemId(Long itemId);

    /**
     * 查询订单明细列表
     * 
     * @param orderItem 订单明细
     * @return 订单明细集合
     */
    public List<OrderItem> selectOrderItemList(OrderItem orderItem);

    /**
     * 新增订单明细
     * 
     * @param orderItem 订单明细
     * @return 结果
     */
    public int insertOrderItem(OrderItem orderItem);

    /**
     * 修改订单明细
     * 
     * @param orderItem 订单明细
     * @return 结果
     */
    public int updateOrderItem(OrderItem orderItem);

    /**
     * 删除订单明细
     * 
     * @param itemId 订单明细主键
     * @return 结果
     */
    public int deleteOrderItemByItemId(Long itemId);

    /**
     * 批量删除订单明细
     * 
     * @param itemIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderItemByItemIds(Long[] itemIds);
}

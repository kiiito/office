package com.office.address.service.impl;

import java.util.List;
import com.office.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.office.address.mapper.DeliveryAddressMapper;
import com.office.address.domain.DeliveryAddress;
import com.office.address.service.IDeliveryAddressService;

/**
 * 收货地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-11
 */
@Service
public class DeliveryAddressServiceImpl implements IDeliveryAddressService 
{
    @Autowired
    private DeliveryAddressMapper deliveryAddressMapper;

    /**
     * 查询收货地址
     * 
     * @param addressId 收货地址主键
     * @return 收货地址
     */
    @Override
    public DeliveryAddress selectDeliveryAddressByAddressId(Long addressId)
    {
        return deliveryAddressMapper.selectDeliveryAddressByAddressId(addressId);
    }

    /**
     * 查询收货地址列表
     * 
     * @param deliveryAddress 收货地址
     * @return 收货地址
     */
    @Override
    public List<DeliveryAddress> selectDeliveryAddressList(DeliveryAddress deliveryAddress)
    {
        return deliveryAddressMapper.selectDeliveryAddressList(deliveryAddress);
    }

    /**
     * 新增收货地址
     * 
     * @param deliveryAddress 收货地址
     * @return 结果
     */
    @Override
    public int insertDeliveryAddress(DeliveryAddress deliveryAddress)
    {
        System.out.println(deliveryAddress.getUserId());
        deliveryAddress.setCreateTime(DateUtils.getNowDate());
        // 如果默认地址已存在，则将默认地址改为非默认
        if (deliveryAddress.getIsDefault() == 1) {
            deliveryAddressMapper.updateDeliveryAddressByUserId(deliveryAddress.getUserId(),0);
        }
        return deliveryAddressMapper.insertDeliveryAddress(deliveryAddress);
    }

    /**
     * 修改收货地址
     * 
     * @param deliveryAddress 收货地址
     * @return 结果
     */
    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress)
    {
        deliveryAddress.setUpdateTime(DateUtils.getNowDate());

        System.out.println(deliveryAddress.getUserId());

        // 如果默认地址已存在，则将默认地址改为非默认
        if (deliveryAddress.getIsDefault() == 1) {
            // 如果默认地址已存在，则将默认地址改为非默认
            if (deliveryAddress.getIsDefault() == 1) {
                deliveryAddressMapper.updateDeliveryAddressByUserId(deliveryAddress.getUserId(),0);
            }

        }
        return deliveryAddressMapper.updateDeliveryAddress(deliveryAddress);
    }

    /**
     * 批量删除收货地址
     * 
     * @param addressIds 需要删除的收货地址主键
     * @return 结果
     */
    @Override
    public int deleteDeliveryAddressByAddressIds(Long[] addressIds)
    {
        return deliveryAddressMapper.deleteDeliveryAddressByAddressIds(addressIds);
    }

    /**
     * 删除收货地址信息
     * 
     * @param addressId 收货地址主键
     * @return 结果
     */
    @Override
    public int deleteDeliveryAddressByAddressId(Long addressId)
    {
        return deliveryAddressMapper.deleteDeliveryAddressByAddressId(addressId);
    }
}

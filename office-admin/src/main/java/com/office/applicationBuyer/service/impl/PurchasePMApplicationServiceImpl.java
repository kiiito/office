package com.office.applicationBuyer.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.office.common.utils.DateUtils;
import com.office.inventory.domain.query.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.office.applicationBuyer.mapper.PurchasePMApplicationMapper;
import com.office.applicationBuyer.domain.PurchasePMApplication;
import com.office.applicationBuyer.service.IPurchasePMApplicationService;

import static com.office.enums.PurchaseRequestStatusEnum.PENDING;
import static com.office.enums.PurchaseRequestStatusEnum.PUBLIC;

/**
 * 采购申请主Service业务层处理
 * 
 * @author hucong
 * @date 2025-11-28
 */
@Service
public class PurchasePMApplicationServiceImpl implements IPurchasePMApplicationService 
{
    @Autowired
    private PurchasePMApplicationMapper purchasePMApplicationMapper;

    /**
     * 查询采购申请主
     * 
     * @param applicationId 采购申请主主键
     * @return 采购申请主
     */
    @Override
    public PurchasePMApplication selectPurchasePMApplicationByApplicationId(Long applicationId)
    {
        return purchasePMApplicationMapper.selectPurchasePMApplicationByApplicationId(applicationId);
    }

    /**
     * 查询采购申请主列表
     * 
     * @param purchasePMApplication 采购申请主
     * @return 采购申请主
     */
    @Override
    public List<PurchasePMApplication> selectPurchasePMApplicationList(PurchasePMApplication purchasePMApplication)
    {
//        List<PurchasePMApplication> purchasePMApplications = purchasePMApplicationMapper.selectPurchasePMApplicationList(purchasePMApplication);
//        System.out.println(purchasePMApplications.size());
//        List<PurchasePMApplication> pendingList = new ArrayList<>();
//        for (PurchasePMApplication item : purchasePMApplications) {
//            if (item.getApplicationStatus().equals(PENDING.getValue())
//                    || item.getApplicationStatus().equals(PUBLIC.getValue())
//                    && item.getApplicationStatus() != null){
//
//                pendingList.add(item);
//
//            }
//        }
//        System.out.println(pendingList.size());
//        return pendingList;
       return purchasePMApplicationMapper.selectPurchasePMApplicationList(purchasePMApplication);
    }

    /**
     * 新增采购申请主
     * 
     * @param purchasePMApplication 采购申请主
     * @return 结果
     */
    @Override
    public int insertPurchasePMApplication(PurchasePMApplication purchasePMApplication)
    {
        purchasePMApplication.setCreateTime(DateUtils.getNowDate());
        return purchasePMApplicationMapper.insertPurchasePMApplication(purchasePMApplication);
    }

    /**
     * 修改采购申请主
     * 
     * @param purchasePMApplication 采购申请主
     * @return 结果
     */
    @Override
    public int updatePurchasePMApplication(PurchasePMApplication purchasePMApplication)
    {
        purchasePMApplication.setUpdateTime(DateUtils.getNowDate());
        return purchasePMApplicationMapper.updatePurchasePMApplication(purchasePMApplication);
    }

    /**
     * 批量删除采购申请主
     * 
     * @param applicationIds 需要删除的采购申请主主键
     * @return 结果
     */
    @Override
    public int deletePurchasePMApplicationByApplicationIds(Long[] applicationIds)
    {
        return purchasePMApplicationMapper.deletePurchasePMApplicationByApplicationIds(applicationIds);
    }

    /**
     * 删除采购申请主信息
     * 
     * @param applicationId 采购申请主主键
     * @return 结果
     */
    @Override
    public int deletePurchasePMApplicationByApplicationId(Long applicationId)
    {
        return purchasePMApplicationMapper.deletePurchasePMApplicationByApplicationId(applicationId);
    }
}

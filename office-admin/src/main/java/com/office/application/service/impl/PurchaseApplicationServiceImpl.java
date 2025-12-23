package com.office.application.service.impl;

import java.util.List;
import com.office.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.office.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.office.application.domain.PurchaseApplicationDetail;
import com.office.application.mapper.PurchaseApplicationMapper;
import com.office.application.domain.PurchaseApplication;
import com.office.application.service.IPurchaseApplicationService;

/**
 * 采购申请主Service业务层处理
 * 
 * @author hucong
 * @date 2025-11-28
 */
@Service
public class PurchaseApplicationServiceImpl implements IPurchaseApplicationService 
{
    @Autowired
    private PurchaseApplicationMapper purchaseApplicationMapper;

    /**
     * 查询采购申请主
     * 
     * @param applicationId 采购申请主主键
     * @return 采购申请主
     */
    @Override
    public PurchaseApplication selectPurchaseApplicationByApplicationId(Long applicationId)
    {
        return purchaseApplicationMapper.selectPurchaseApplicationByApplicationId(applicationId);
    }

    /**
     * 查询采购申请主列表
     * 
     * @param purchaseApplication 采购申请主
     * @return 采购申请主
     */
    @Override
    public List<PurchaseApplication> selectPurchaseApplicationList(PurchaseApplication purchaseApplication)
    {
        return purchaseApplicationMapper.selectPurchaseApplicationList(purchaseApplication);
    }

    /**
     * 新增采购申请主
     * 
     * @param purchaseApplication 采购申请主
     * @return 结果
     */
    @Transactional
    @Override
    public int insertPurchaseApplication(PurchaseApplication purchaseApplication)
    {
        purchaseApplication.setCreateTime(DateUtils.getNowDate());
        int rows = purchaseApplicationMapper.insertPurchaseApplication(purchaseApplication);
        insertPurchaseApplicationDetail(purchaseApplication);
        return rows;
    }

    /**
     * 修改采购申请主
     * 
     * @param purchaseApplication 采购申请主
     * @return 结果
     */
    @Transactional
    @Override
    public int updatePurchaseApplication(PurchaseApplication purchaseApplication)
    {
        purchaseApplication.setUpdateTime(DateUtils.getNowDate());
        purchaseApplicationMapper.deletePurchaseApplicationDetailByApplicationId(purchaseApplication.getApplicationId());
        insertPurchaseApplicationDetail(purchaseApplication);
        return purchaseApplicationMapper.updatePurchaseApplication(purchaseApplication);
    }

    /**
     * 批量删除采购申请主
     * 
     * @param applicationIds 需要删除的采购申请主主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePurchaseApplicationByApplicationIds(Long[] applicationIds)
    {
        purchaseApplicationMapper.deletePurchaseApplicationDetailByApplicationIds(applicationIds);
        return purchaseApplicationMapper.deletePurchaseApplicationByApplicationIds(applicationIds);
    }

    /**
     * 删除采购申请主信息
     * 
     * @param applicationId 采购申请主主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePurchaseApplicationByApplicationId(Long applicationId)
    {
        purchaseApplicationMapper.deletePurchaseApplicationDetailByApplicationId(applicationId);
        return purchaseApplicationMapper.deletePurchaseApplicationByApplicationId(applicationId);
    }

    /**
     * 新增采购申请明细信息
     * 
     * @param purchaseApplication 采购申请主对象
     */
    public void insertPurchaseApplicationDetail(PurchaseApplication purchaseApplication)
    {
        List<PurchaseApplicationDetail> purchaseApplicationDetailList = purchaseApplication.getPurchaseApplicationDetailList();
        Long applicationId = purchaseApplication.getApplicationId();
        if (StringUtils.isNotNull(purchaseApplicationDetailList))
        {
            List<PurchaseApplicationDetail> list = new ArrayList<PurchaseApplicationDetail>();
            for (PurchaseApplicationDetail purchaseApplicationDetail : purchaseApplicationDetailList)
            {
                purchaseApplicationDetail.setApplicationId(applicationId);
                list.add(purchaseApplicationDetail);
            }
            if (list.size() > 0)
            {
                purchaseApplicationMapper.batchPurchaseApplicationDetail(list);
            }
        }
    }
}

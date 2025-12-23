package com.office.application.service;

import java.util.List;
import com.office.application.domain.PurchaseApplication;

/**
 * 采购申请主Service接口
 * 
 * @author hucong
 * @date 2025-11-28
 */
public interface IPurchaseApplicationService 
{
    /**
     * 查询采购申请主
     * 
     * @param applicationId 采购申请主主键
     * @return 采购申请主
     */
    public PurchaseApplication selectPurchaseApplicationByApplicationId(Long applicationId);

    /**
     * 查询采购申请主列表
     * 
     * @param purchaseApplication 采购申请主
     * @return 采购申请主集合
     */
    public List<PurchaseApplication> selectPurchaseApplicationList(PurchaseApplication purchaseApplication);

    /**
     * 新增采购申请主
     * 
     * @param purchaseApplication 采购申请主
     * @return 结果
     */
    public int insertPurchaseApplication(PurchaseApplication purchaseApplication);

    /**
     * 修改采购申请主
     * 
     * @param purchaseApplication 采购申请主
     * @return 结果
     */
    public int updatePurchaseApplication(PurchaseApplication purchaseApplication);

    /**
     * 批量删除采购申请主
     * 
     * @param applicationIds 需要删除的采购申请主主键集合
     * @return 结果
     */
    public int deletePurchaseApplicationByApplicationIds(Long[] applicationIds);

    /**
     * 删除采购申请主信息
     * 
     * @param applicationId 采购申请主主键
     * @return 结果
     */
    public int deletePurchaseApplicationByApplicationId(Long applicationId);
}

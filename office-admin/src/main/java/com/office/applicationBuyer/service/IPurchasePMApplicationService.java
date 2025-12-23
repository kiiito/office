package com.office.applicationBuyer.service;

import java.util.List;
import com.office.applicationBuyer.domain.PurchasePMApplication;

/**
 * 采购申请主Service接口
 * 
 * @author hucong
 * @date 2025-11-28
 */
public interface IPurchasePMApplicationService 
{
    /**
     * 查询采购申请主
     * 
     * @param applicationId 采购申请主主键
     * @return 采购申请主
     */
    public PurchasePMApplication selectPurchasePMApplicationByApplicationId(Long applicationId);

    /**
     * 查询采购申请主列表
     * 
     * @param purchasePMApplication 采购申请主
     * @return 采购申请主集合
     */
    public List<PurchasePMApplication> selectPurchasePMApplicationList(PurchasePMApplication purchasePMApplication);

    /**
     * 新增采购申请主
     * 
     * @param purchasePMApplication 采购申请主
     * @return 结果
     */
    public int insertPurchasePMApplication(PurchasePMApplication purchasePMApplication);

    /**
     * 修改采购申请主
     * 
     * @param purchasePMApplication 采购申请主
     * @return 结果
     */
    public int updatePurchasePMApplication(PurchasePMApplication purchasePMApplication);

    /**
     * 批量删除采购申请主
     * 
     * @param applicationIds 需要删除的采购申请主主键集合
     * @return 结果
     */
    public int deletePurchasePMApplicationByApplicationIds(Long[] applicationIds);

    /**
     * 删除采购申请主信息
     * 
     * @param applicationId 采购申请主主键
     * @return 结果
     */
    public int deletePurchasePMApplicationByApplicationId(Long applicationId);
}

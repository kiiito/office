package com.office.application.mapper;

import java.util.List;
import com.office.application.domain.PurchaseApplication;
import com.office.application.domain.PurchaseApplicationDetail;

/**
 * 采购申请主Mapper接口
 * 
 * @author hucong
 * @date 2025-11-28
 */
public interface PurchaseApplicationMapper 
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
     * 删除采购申请主
     * 
     * @param applicationId 采购申请主主键
     * @return 结果
     */
    public int deletePurchaseApplicationByApplicationId(Long applicationId);

    /**
     * 批量删除采购申请主
     * 
     * @param applicationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchaseApplicationByApplicationIds(Long[] applicationIds);

    /**
     * 批量删除采购申请明细
     * 
     * @param applicationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchaseApplicationDetailByApplicationIds(Long[] applicationIds);
    
    /**
     * 批量新增采购申请明细
     * 
     * @param purchaseApplicationDetailList 采购申请明细列表
     * @return 结果
     */
    public int batchPurchaseApplicationDetail(List<PurchaseApplicationDetail> purchaseApplicationDetailList);
    

    /**
     * 通过采购申请主主键删除采购申请明细信息
     * 
     * @param applicationId 采购申请主ID
     * @return 结果
     */
    public int deletePurchaseApplicationDetailByApplicationId(Long applicationId);
}

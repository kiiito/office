package com.office.applicationBuyer.mapper;

import java.util.List;
import com.office.applicationBuyer.domain.PurchasePMApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 采购申请主Mapper接口
 * 
 * @author hucong
 * @date 2025-11-28
 */
@Mapper
public interface PurchasePMApplicationMapper 
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
//    @Select("select * from purchase_application")
//    public List<PurchasePMApplication> selectPurchasePMApplicationListOne();
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
     * 删除采购申请主
     * 
     * @param applicationId 采购申请主主键
     * @return 结果
     */
    public int deletePurchasePMApplicationByApplicationId(Long applicationId);

    /**
     * 批量删除采购申请主
     * 
     * @param applicationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchasePMApplicationByApplicationIds(Long[] applicationIds);
}

package com.office.detailBuyer.mapper;

import java.util.List;
import com.office.detailBuyer.domain.PurchasePMApplicationDetail;

/**
 * 采购申请明细Mapper接口
 * 
 * @author hucong
 * @date 2025-11-28
 */
public interface PurchasePMApplicationDetailMapper 
{
    /**
     * 查询采购申请明细
     * 
     * @param detailId 采购申请明细主键
     * @return 采购申请明细
     */
    public PurchasePMApplicationDetail selectPurchasePMApplicationDetailByDetailId(Long detailId);

    /**
     * 查询采购申请明细列表
     * 
     * @param purchasePMApplicationDetail 采购申请明细
     * @return 采购申请明细集合
     */
    public List<PurchasePMApplicationDetail> selectPurchasePMApplicationDetailList(PurchasePMApplicationDetail purchasePMApplicationDetail);

    /**
     * 新增采购申请明细
     * 
     * @param purchasePMApplicationDetail 采购申请明细
     * @return 结果
     */
    public int insertPurchasePMApplicationDetail(PurchasePMApplicationDetail purchasePMApplicationDetail);

    /**
     * 修改采购申请明细
     * 
     * @param purchasePMApplicationDetail 采购申请明细
     * @return 结果
     */
    public int updatePurchasePMApplicationDetail(PurchasePMApplicationDetail purchasePMApplicationDetail);

    /**
     * 删除采购申请明细
     * 
     * @param detailId 采购申请明细主键
     * @return 结果
     */
    public int deletePurchasePMApplicationDetailByDetailId(Long detailId);

    /**
     * 批量删除采购申请明细
     * 
     * @param detailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchasePMApplicationDetailByDetailIds(Long[] detailIds);
}

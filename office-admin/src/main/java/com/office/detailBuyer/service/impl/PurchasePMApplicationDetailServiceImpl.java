package com.office.detailBuyer.service.impl;

import java.util.List;
import com.office.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.office.detailBuyer.mapper.PurchasePMApplicationDetailMapper;
import com.office.detailBuyer.domain.PurchasePMApplicationDetail;
import com.office.detailBuyer.service.IPurchasePMApplicationDetailService;

/**
 * 采购申请明细Service业务层处理
 * 
 * @author hucong
 * @date 2025-11-28
 */
@Service
public class PurchasePMApplicationDetailServiceImpl implements IPurchasePMApplicationDetailService 
{
    @Autowired
    private PurchasePMApplicationDetailMapper purchasePMApplicationDetailMapper;

    /**
     * 查询采购申请明细
     * 
     * @param detailId 采购申请明细主键
     * @return 采购申请明细
     */
    @Override
    public PurchasePMApplicationDetail selectPurchasePMApplicationDetailByDetailId(Long detailId)
    {
        return purchasePMApplicationDetailMapper.selectPurchasePMApplicationDetailByDetailId(detailId);
    }

    /**
     * 查询采购申请明细列表
     * 
     * @param purchasePMApplicationDetail 采购申请明细
     * @return 采购申请明细
     */
    @Override
    public List<PurchasePMApplicationDetail> selectPurchasePMApplicationDetailList(PurchasePMApplicationDetail purchasePMApplicationDetail)
    {
        return purchasePMApplicationDetailMapper.selectPurchasePMApplicationDetailList(purchasePMApplicationDetail);
    }

    /**
     * 新增采购申请明细
     * 
     * @param purchasePMApplicationDetail 采购申请明细
     * @return 结果
     */
    @Override
    public int insertPurchasePMApplicationDetail(PurchasePMApplicationDetail purchasePMApplicationDetail)
    {
        purchasePMApplicationDetail.setCreateTime(DateUtils.getNowDate());
        return purchasePMApplicationDetailMapper.insertPurchasePMApplicationDetail(purchasePMApplicationDetail);
    }

    /**
     * 修改采购申请明细
     * 
     * @param purchasePMApplicationDetail 采购申请明细
     * @return 结果
     */
    @Override
    public int updatePurchasePMApplicationDetail(PurchasePMApplicationDetail purchasePMApplicationDetail)
    {
        return purchasePMApplicationDetailMapper.updatePurchasePMApplicationDetail(purchasePMApplicationDetail);
    }

    /**
     * 批量删除采购申请明细
     * 
     * @param detailIds 需要删除的采购申请明细主键
     * @return 结果
     */
    @Override
    public int deletePurchasePMApplicationDetailByDetailIds(Long[] detailIds)
    {
        return purchasePMApplicationDetailMapper.deletePurchasePMApplicationDetailByDetailIds(detailIds);
    }

    /**
     * 删除采购申请明细信息
     * 
     * @param detailId 采购申请明细主键
     * @return 结果
     */
    @Override
    public int deletePurchasePMApplicationDetailByDetailId(Long detailId)
    {
        return purchasePMApplicationDetailMapper.deletePurchasePMApplicationDetailByDetailId(detailId);
    }
}

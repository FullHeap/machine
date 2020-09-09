package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusiProductionMapper;
import com.ruoyi.system.domain.BusiProduction;
import com.ruoyi.system.service.IBusiProductionService;

/**
 * 产品信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@Service
public class BusiProductionServiceImpl implements IBusiProductionService 
{
    @Autowired
    private BusiProductionMapper busiProductionMapper;

    /**
     * 查询产品信息
     * 
     * @param productId 产品信息ID
     * @return 产品信息
     */
    @Override
    public BusiProduction selectBusiProductionById(Long productId)
    {
        return busiProductionMapper.selectBusiProductionById(productId);
    }

    /**
     * 查询产品信息列表
     * 
     * @param busiProduction 产品信息
     * @return 产品信息
     */
    @Override
    public List<BusiProduction> selectBusiProductionList(BusiProduction busiProduction)
    {
        return busiProductionMapper.selectBusiProductionList(busiProduction);
    }

    /**
     * 新增产品信息
     * 
     * @param busiProduction 产品信息
     * @return 结果
     */
    @Override
    public int insertBusiProduction(BusiProduction busiProduction)
    {
        busiProduction.setCreateTime(DateUtils.getNowDate());
        return busiProductionMapper.insertBusiProduction(busiProduction);
    }

    /**
     * 修改产品信息
     * 
     * @param busiProduction 产品信息
     * @return 结果
     */
    @Override
    public int updateBusiProduction(BusiProduction busiProduction)
    {
        busiProduction.setUpdateTime(DateUtils.getNowDate());
        return busiProductionMapper.updateBusiProduction(busiProduction);
    }

    /**
     * 批量删除产品信息
     * 
     * @param productIds 需要删除的产品信息ID
     * @return 结果
     */
    @Override
    public int deleteBusiProductionByIds(Long[] productIds)
    {
        return busiProductionMapper.deleteBusiProductionByIds(productIds);
    }

    /**
     * 删除产品信息信息
     * 
     * @param productId 产品信息ID
     * @return 结果
     */
    @Override
    public int deleteBusiProductionById(Long productId)
    {
        return busiProductionMapper.deleteBusiProductionById(productId);
    }
}

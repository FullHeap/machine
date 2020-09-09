package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusiSellMapper;
import com.ruoyi.system.domain.BusiSell;
import com.ruoyi.system.service.IBusiSellService;

/**
 * 销售信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
@Service
public class BusiSellServiceImpl implements IBusiSellService 
{
    @Autowired
    private BusiSellMapper busiSellMapper;

    /**
     * 查询销售信息
     * 
     * @param sellId 销售信息ID
     * @return 销售信息
     */
    @Override
    public BusiSell selectBusiSellById(Long sellId)
    {
        return busiSellMapper.selectBusiSellById(sellId);
    }

    /**
     * 查询销售信息列表
     * 
     * @param busiSell 销售信息
     * @return 销售信息
     */
    @Override
    public List<BusiSell> selectBusiSellList(BusiSell busiSell)
    {
        return busiSellMapper.selectBusiSellList(busiSell);
    }

    /**
     * 新增销售信息
     * 
     * @param busiSell 销售信息
     * @return 结果
     */
    @Override
    public int insertBusiSell(BusiSell busiSell)
    {
        busiSell.setCreateTime(DateUtils.getNowDate());
        return busiSellMapper.insertBusiSell(busiSell);
    }

    /**
     * 修改销售信息
     * 
     * @param busiSell 销售信息
     * @return 结果
     */
    @Override
    public int updateBusiSell(BusiSell busiSell)
    {
        busiSell.setUpdateTime(DateUtils.getNowDate());
        return busiSellMapper.updateBusiSell(busiSell);
    }

    /**
     * 批量删除销售信息
     * 
     * @param sellIds 需要删除的销售信息ID
     * @return 结果
     */
    @Override
    public int deleteBusiSellByIds(Long[] sellIds)
    {
        return busiSellMapper.deleteBusiSellByIds(sellIds);
    }

    /**
     * 删除销售信息信息
     * 
     * @param sellId 销售信息ID
     * @return 结果
     */
    @Override
    public int deleteBusiSellById(Long sellId)
    {
        return busiSellMapper.deleteBusiSellById(sellId);
    }
}

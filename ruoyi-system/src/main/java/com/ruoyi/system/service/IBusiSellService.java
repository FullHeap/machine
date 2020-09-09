package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BusiSell;

/**
 * 销售信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
public interface IBusiSellService 
{
    /**
     * 查询销售信息
     * 
     * @param sellId 销售信息ID
     * @return 销售信息
     */
    public BusiSell selectBusiSellById(Long sellId);

    /**
     * 查询销售信息列表
     * 
     * @param busiSell 销售信息
     * @return 销售信息集合
     */
    public List<BusiSell> selectBusiSellList(BusiSell busiSell);

    /**
     * 新增销售信息
     * 
     * @param busiSell 销售信息
     * @return 结果
     */
    public int insertBusiSell(BusiSell busiSell);

    /**
     * 修改销售信息
     * 
     * @param busiSell 销售信息
     * @return 结果
     */
    public int updateBusiSell(BusiSell busiSell);

    /**
     * 批量删除销售信息
     * 
     * @param sellIds 需要删除的销售信息ID
     * @return 结果
     */
    public int deleteBusiSellByIds(Long[] sellIds);

    /**
     * 删除销售信息信息
     * 
     * @param sellId 销售信息ID
     * @return 结果
     */
    public int deleteBusiSellById(Long sellId);
}

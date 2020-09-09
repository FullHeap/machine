package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BusiProduction;

/**
 * 产品信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public interface BusiProductionMapper 
{
    /**
     * 查询产品信息
     * 
     * @param productId 产品信息ID
     * @return 产品信息
     */
    public BusiProduction selectBusiProductionById(Long productId);

    /**
     * 查询产品信息列表
     * 
     * @param busiProduction 产品信息
     * @return 产品信息集合
     */
    public List<BusiProduction> selectBusiProductionList(BusiProduction busiProduction);

    /**
     * 新增产品信息
     * 
     * @param busiProduction 产品信息
     * @return 结果
     */
    public int insertBusiProduction(BusiProduction busiProduction);

    /**
     * 修改产品信息
     * 
     * @param busiProduction 产品信息
     * @return 结果
     */
    public int updateBusiProduction(BusiProduction busiProduction);

    /**
     * 删除产品信息
     * 
     * @param productId 产品信息ID
     * @return 结果
     */
    public int deleteBusiProductionById(Long productId);

    /**
     * 批量删除产品信息
     * 
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiProductionByIds(Long[] productIds);
}

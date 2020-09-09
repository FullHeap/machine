package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusiCustomerMapper;
import com.ruoyi.system.domain.BusiCustomer;
import com.ruoyi.system.service.IBusiCustomerService;

/**
 * 客户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@Service
public class BusiCustomerServiceImpl implements IBusiCustomerService 
{
    @Autowired
    private BusiCustomerMapper busiCustomerMapper;

    /**
     * 查询客户信息
     * 
     * @param customerId 客户信息ID
     * @return 客户信息
     */
    @Override
    public BusiCustomer selectBusiCustomerById(Long customerId)
    {
        return busiCustomerMapper.selectBusiCustomerById(customerId);
    }

    /**
     * 查询客户信息列表
     * 
     * @param busiCustomer 客户信息
     * @return 客户信息
     */
    @Override
    public List<BusiCustomer> selectBusiCustomerList(BusiCustomer busiCustomer)
    {
        return busiCustomerMapper.selectBusiCustomerList(busiCustomer);
    }

    /**
     * 新增客户信息
     * 
     * @param busiCustomer 客户信息
     * @return 结果
     */
    @Override
    public int insertBusiCustomer(BusiCustomer busiCustomer)
    {
        busiCustomer.setCreateTime(DateUtils.getNowDate());
        return busiCustomerMapper.insertBusiCustomer(busiCustomer);
    }

    /**
     * 修改客户信息
     * 
     * @param busiCustomer 客户信息
     * @return 结果
     */
    @Override
    public int updateBusiCustomer(BusiCustomer busiCustomer)
    {
        busiCustomer.setUpdateTime(DateUtils.getNowDate());
        return busiCustomerMapper.updateBusiCustomer(busiCustomer);
    }

    /**
     * 批量删除客户信息
     * 
     * @param customerIds 需要删除的客户信息ID
     * @return 结果
     */
    @Override
    public int deleteBusiCustomerByIds(Long[] customerIds)
    {
        return busiCustomerMapper.deleteBusiCustomerByIds(customerIds);
    }

    /**
     * 删除客户信息信息
     * 
     * @param customerId 客户信息ID
     * @return 结果
     */
    @Override
    public int deleteBusiCustomerById(Long customerId)
    {
        return busiCustomerMapper.deleteBusiCustomerById(customerId);
    }
}

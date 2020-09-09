package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BusiCustomer;

/**
 * 客户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public interface BusiCustomerMapper 
{
    /**
     * 查询客户信息
     * 
     * @param customerId 客户信息ID
     * @return 客户信息
     */
    public BusiCustomer selectBusiCustomerById(Long customerId);

    /**
     * 查询客户信息列表
     * 
     * @param busiCustomer 客户信息
     * @return 客户信息集合
     */
    public List<BusiCustomer> selectBusiCustomerList(BusiCustomer busiCustomer);

    /**
     * 新增客户信息
     * 
     * @param busiCustomer 客户信息
     * @return 结果
     */
    public int insertBusiCustomer(BusiCustomer busiCustomer);

    /**
     * 修改客户信息
     * 
     * @param busiCustomer 客户信息
     * @return 结果
     */
    public int updateBusiCustomer(BusiCustomer busiCustomer);

    /**
     * 删除客户信息
     * 
     * @param customerId 客户信息ID
     * @return 结果
     */
    public int deleteBusiCustomerById(Long customerId);

    /**
     * 批量删除客户信息
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiCustomerByIds(Long[] customerIds);
}

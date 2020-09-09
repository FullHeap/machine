package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户信息对象 busi_customer
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public class BusiCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户ID */
    private Long customerId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 公司税号 */
    @Excel(name = "公司税号")
    private String companySh;

    /** 公司地址 */
    @Excel(name = "公司地址")
    private String companyAddress;

    /** 公司电话 */
    @Excel(name = "公司电话")
    private String companyTel;

    /** 公司账户 */
    @Excel(name = "公司账户")
    private String companyAcct;

    /** 开户行 */
    @Excel(name = "开户行")
    private String companyBank;

    /** 联系人 */
    @Excel(name = "联系人")
    private String personName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String personPhone;

    /** 微信号 */
    @Excel(name = "微信号")
    private String personWechat;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String personMail;

    /** 客户等级 */
    @Excel(name = "客户等级")
    private String customerLevel;

    /** 合作时间 */
    @Excel(name = "合作时间")
    private String togeterTime;

    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanySh(String companySh) 
    {
        this.companySh = companySh;
    }

    public String getCompanySh() 
    {
        return companySh;
    }
    public void setCompanyAddress(String companyAddress) 
    {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress() 
    {
        return companyAddress;
    }
    public void setCompanyTel(String companyTel) 
    {
        this.companyTel = companyTel;
    }

    public String getCompanyTel() 
    {
        return companyTel;
    }
    public void setCompanyAcct(String companyAcct) 
    {
        this.companyAcct = companyAcct;
    }

    public String getCompanyAcct() 
    {
        return companyAcct;
    }
    public void setCompanyBank(String companyBank) 
    {
        this.companyBank = companyBank;
    }

    public String getCompanyBank() 
    {
        return companyBank;
    }
    public void setPersonName(String personName) 
    {
        this.personName = personName;
    }

    public String getPersonName() 
    {
        return personName;
    }
    public void setPersonPhone(String personPhone) 
    {
        this.personPhone = personPhone;
    }

    public String getPersonPhone() 
    {
        return personPhone;
    }
    public void setPersonWechat(String personWechat) 
    {
        this.personWechat = personWechat;
    }

    public String getPersonWechat() 
    {
        return personWechat;
    }
    public void setPersonMail(String personMail) 
    {
        this.personMail = personMail;
    }

    public String getPersonMail() 
    {
        return personMail;
    }
    public void setCustomerLevel(String customerLevel) 
    {
        this.customerLevel = customerLevel;
    }

    public String getCustomerLevel() 
    {
        return customerLevel;
    }
    public void setTogeterTime(String togeterTime) 
    {
        this.togeterTime = togeterTime;
    }

    public String getTogeterTime() 
    {
        return togeterTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customerId", getCustomerId())
            .append("customerName", getCustomerName())
            .append("companyName", getCompanyName())
            .append("companySh", getCompanySh())
            .append("companyAddress", getCompanyAddress())
            .append("companyTel", getCompanyTel())
            .append("companyAcct", getCompanyAcct())
            .append("companyBank", getCompanyBank())
            .append("personName", getPersonName())
            .append("personPhone", getPersonPhone())
            .append("personWechat", getPersonWechat())
            .append("personMail", getPersonMail())
            .append("customerLevel", getCustomerLevel())
            .append("togeterTime", getTogeterTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售信息对象 busi_sell
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
public class BusiSell extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 销售ID */
    private Long sellId;

    /** 销售时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "销售时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sellDate;

    /** 预付款/尾款 */
    @Excel(name = "预付款/尾款")
    private String preMoney;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 卖价（单） */
    @Excel(name = "卖价", readConverterExp = "单=")
    private BigDecimal productSell;

    /** 数量 */
    @Excel(name = "数量")
    private Long productNum;

    /** 卖价（总） */
    @Excel(name = "卖价", readConverterExp = "总=")
    private BigDecimal productSumsell;

    /** 采购价（单） */
    @Excel(name = "采购价", readConverterExp = "单=")
    private BigDecimal productPrice;

    /** 采购价（总） */
    @Excel(name = "采购价", readConverterExp = "总=")
    private BigDecimal productSumprice;

    /** 产品供应商 */
    @Excel(name = "产品供应商")
    private String productSupplier;

    /** 快递 */
    @Excel(name = "快递")
    private String productFastmail;

    /** 快递费 */
    @Excel(name = "快递费")
    private String productFastmailfee;

    /** 联系人 */
    @Excel(name = "联系人")
    private String personName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String personPhone;

    /** 销售利润 */
    @Excel(name = "销售利润")
    private BigDecimal sellProfit;

    public void setSellId(Long sellId) 
    {
        this.sellId = sellId;
    }

    public Long getSellId() 
    {
        return sellId;
    }
    public void setSellDate(Date sellDate) 
    {
        this.sellDate = sellDate;
    }

    public Date getSellDate() 
    {
        return sellDate;
    }
    public void setPreMoney(String preMoney) 
    {
        this.preMoney = preMoney;
    }

    public String getPreMoney() 
    {
        return preMoney;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductSell(BigDecimal productSell) 
    {
        this.productSell = productSell;
    }

    public BigDecimal getProductSell() 
    {
        return productSell;
    }
    public void setProductNum(Long productNum) 
    {
        this.productNum = productNum;
    }

    public Long getProductNum() 
    {
        return productNum;
    }
    public void setProductSumsell(BigDecimal productSumsell) 
    {
        this.productSumsell = productSumsell;
    }

    public BigDecimal getProductSumsell() 
    {
        return productSumsell;
    }
    public void setProductPrice(BigDecimal productPrice) 
    {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPrice() 
    {
        return productPrice;
    }
    public void setProductSumprice(BigDecimal productSumprice) 
    {
        this.productSumprice = productSumprice;
    }

    public BigDecimal getProductSumprice() 
    {
        return productSumprice;
    }
    public void setProductSupplier(String productSupplier) 
    {
        this.productSupplier = productSupplier;
    }

    public String getProductSupplier() 
    {
        return productSupplier;
    }
    public void setProductFastmail(String productFastmail) 
    {
        this.productFastmail = productFastmail;
    }

    public String getProductFastmail() 
    {
        return productFastmail;
    }
    public void setProductFastmailfee(String productFastmailfee) 
    {
        this.productFastmailfee = productFastmailfee;
    }

    public String getProductFastmailfee() 
    {
        return productFastmailfee;
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
    public void setSellProfit(BigDecimal sellProfit) 
    {
        this.sellProfit = sellProfit;
    }

    public BigDecimal getSellProfit() 
    {
        return sellProfit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sellId", getSellId())
            .append("sellDate", getSellDate())
            .append("preMoney", getPreMoney())
            .append("customerName", getCustomerName())
            .append("productName", getProductName())
            .append("productSell", getProductSell())
            .append("productNum", getProductNum())
            .append("productSumsell", getProductSumsell())
            .append("productPrice", getProductPrice())
            .append("productSumprice", getProductSumprice())
            .append("productSupplier", getProductSupplier())
            .append("productFastmail", getProductFastmail())
            .append("productFastmailfee", getProductFastmailfee())
            .append("personName", getPersonName())
            .append("personPhone", getPersonPhone())
            .append("sellProfit", getSellProfit())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

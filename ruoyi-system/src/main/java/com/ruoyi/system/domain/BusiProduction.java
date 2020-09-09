package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品信息对象 busi_production
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
public class BusiProduction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品ID */
    private Long productId;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String productCode;

    /** 产品系列 */
    @Excel(name = "产品系列")
    private String productPtype;

    /** 产品规格 */
    @Excel(name = "产品规格")
    private String productNorms;

    /** 产品型号 */
    @Excel(name = "产品型号")
    private String productModel;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品价格 */
    @Excel(name = "产品价格")
    private BigDecimal productPrice;

    /** 产品报价 */
    @Excel(name = "产品报价")
    private BigDecimal productBprice;

    /** 产品重量 */
    @Excel(name = "产品重量")
    private String productWeight;

    /** 产品供应商 */
    @Excel(name = "产品供应商")
    private String productSupplier;

    /** 产品快递 */
    @Excel(name = "产品快递")
    private String productFastmail;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }
    public void setProductPtype(String productPtype) 
    {
        this.productPtype = productPtype;
    }

    public String getProductPtype() 
    {
        return productPtype;
    }
    public void setProductNorms(String productNorms) 
    {
        this.productNorms = productNorms;
    }

    public String getProductNorms() 
    {
        return productNorms;
    }
    public void setProductModel(String productModel) 
    {
        this.productModel = productModel;
    }

    public String getProductModel() 
    {
        return productModel;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductPrice(BigDecimal productPrice) 
    {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPrice() 
    {
        return productPrice;
    }
    public void setProductBprice(BigDecimal productBprice) 
    {
        this.productBprice = productBprice;
    }

    public BigDecimal getProductBprice() 
    {
        return productBprice;
    }
    public void setProductWeight(String productWeight) 
    {
        this.productWeight = productWeight;
    }

    public String getProductWeight() 
    {
        return productWeight;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("productCode", getProductCode())
            .append("productPtype", getProductPtype())
            .append("productNorms", getProductNorms())
            .append("productModel", getProductModel())
            .append("productName", getProductName())
            .append("productPrice", getProductPrice())
            .append("productBprice", getProductBprice())
            .append("productWeight", getProductWeight())
            .append("productSupplier", getProductSupplier())
            .append("productFastmail", getProductFastmail())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

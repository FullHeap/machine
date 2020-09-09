-- ----------------------------
-- 1、产品信息表
-- ----------------------------
drop table if exists busi_production;
create table busi_production
(
  product_id       bigint(20)      not null auto_increment    comment '产品ID',
  product_code     varchar(64)                        comment '产品编码',
  product_ptype     varchar(64)                       comment '产品系列',
  product_norms    varchar(64)                      comment '产品规格',
  product_model    varchar(64)                       comment '产品型号',
  product_name     varchar(50)                        comment '产品名称',
  product_price    DECIMAL(9,2)                       comment '产品价格',
  product_bprice   DECIMAL(9,2)                       comment '产品报价',
  product_weight   varchar(50)                        comment '产品重量',
  product_supplier   varchar(50)                        comment '产品供应商',
  product_fastmail varchar(50)                        comment '产品快递',
  create_by     varchar(64)     default ''                 comment '创建者',
  create_time   datetime                                   comment '创建时间',
  update_by     varchar(64)     default ''			       comment '更新者',
  update_time   datetime                                   comment '更新时间',
  remark        varchar(500)    default null               comment '备注',
  primary key (product_id)
) engine=innodb comment = '产品信息表';

-- ----------------------------
-- 初始化-产品信息表数据
-- ----------------------------




-- ----------------------------
-- 2、客户信息表
-- ----------------------------
drop table if exists busi_customer;
create table busi_customer
(
  customer_id       bigint(20)      not null auto_increment    comment '客户ID',
  customer_name     varchar(64)                        	comment '客户名称',
  company_name		varchar(64)                       	comment '公司名称',
  company_sh   	varchar(64)                      	comment '公司税号',
  company_address  varchar(64)                       	comment '公司地址',
  company_tel   	varchar(50)                        	comment '公司电话',
  company_acct     varchar(50)                        	comment '公司账户',
  company_bank    	varchar(50)                       	comment '开户行',
  person_name   varchar(50)                       	comment '联系人',  
  person_phone   	varchar(50)                        	comment '联系电话',
  person_wechat 	varchar(50)                        	comment '微信号',
  person_mail 	varchar(50)                        	comment '邮箱',
  customer_level 	varchar(50)                        	comment '客户等级',
  togeter_time 	varchar(50)                        	comment '合作时间',
  create_by     	varchar(64)     default ''                 comment '创建者',
  create_time   	datetime                                   comment '创建时间',
  update_by     	varchar(64)     default ''			       comment '更新者',
  update_time   	datetime                                   comment '更新时间',
  remark        	varchar(500)    default null               comment '备注',
  primary key (customer_id)
) engine=innodb comment = '客户信息表';

-- ----------------------------
-- 初始化-客户信息表数据
-- ----------------------------


-- ----------------------------
-- 3、订单信息表
-- ----------------------------
drop table if exists busi_sell;
create table busi_sell
(
  sell_id       bigint(20)      not null auto_increment    comment '销售ID',
  sell_date     datetime                        	comment '销售时间',
  pre_money     varchar(64)                        	comment '预付款/尾款',
  customer_name     varchar(64)                        	comment '客户名称',
  product_name     varchar(50)                        comment '产品名称',
  product_sell    DECIMAL(9,2)                       comment '卖价（单）',
  product_num    DECIMAL(9)                       	comment '数量',
  product_sumsell   DECIMAL(9,2)                       comment '卖价（总）',
  product_price   DECIMAL(9,2)                       comment '采购价（单）',
  product_sumprice   DECIMAL(9,2)                       comment '采购价（总）',
  product_supplier   varchar(50)                        comment '产品供应商',
  product_fastmail varchar(50)                        comment '快递',
  product_fastmailfee varchar(50)                        comment '快递费',
  person_name   varchar(50)                       	comment '联系人',  
  person_phone   	varchar(50)                        	comment '联系电话',
  sell_profit   	DECIMAL(9,2)                          	comment '销售利润',
  create_by     	varchar(64)     default ''                 comment '创建者',
  create_time   	datetime                                   comment '创建时间',
  update_by     	varchar(64)     default ''			       comment '更新者',
  update_time   	datetime                                   comment '更新时间',
  remark        	varchar(500)    default null               comment '备注',
  primary key (sell_id)
) engine=innodb comment = '销售信息表';

-- ----------------------------
-- 初始化-销售信息表数据
-- ----------------------------

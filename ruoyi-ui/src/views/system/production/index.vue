<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="产品编码" prop="productCode">
        <el-input
          v-model="queryParams.productCode"
          placeholder="请输入产品编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品系列" prop="productPtype">
        <el-select v-model="queryParams.productPtype" placeholder="请选择产品系列" clearable size="small">
          <el-option
            v-for="dict in productPtypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="产品规格" prop="productNorms">
        <el-select v-model="queryParams.productNorms" placeholder="请选择产品规格" clearable size="small">
          <el-option
            v-for="dict in productNormsOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="产品型号" prop="productModel">
        <el-select v-model="queryParams.productModel" placeholder="请选择产品型号" clearable size="small">
          <el-option
            v-for="dict in productModelOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="产品名称" prop="productName">
        <el-input
          v-model="queryParams.productName"
          placeholder="请输入产品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品价格" prop="productPrice">
        <el-input
          v-model="queryParams.productPrice"
          placeholder="请输入产品价格"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品报价" prop="productBprice">
        <el-input
          v-model="queryParams.productBprice"
          placeholder="请输入产品报价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品重量" prop="productWeight">
        <el-input
          v-model="queryParams.productWeight"
          placeholder="请输入产品重量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品供应商" prop="productSupplier">
        <el-select v-model="queryParams.productSupplier" placeholder="请选择产品供应商" clearable size="small">
          <el-option
            v-for="dict in productSupplierOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="产品快递" prop="productFastmail">
        <el-select v-model="queryParams.productFastmail" placeholder="请选择产品快递" clearable size="small">
          <el-option
            v-for="dict in productFastmailOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:production:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:production:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:production:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:production:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="productionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="产品ID" align="center" prop="productId" />
      <el-table-column label="产品编码" align="center" prop="productCode" />
      <el-table-column label="产品系列" align="center" prop="productPtype" :formatter="productPtypeFormat" />
      <el-table-column label="产品规格" align="center" prop="productNorms" :formatter="productNormsFormat" />
      <el-table-column label="产品型号" align="center" prop="productModel" :formatter="productModelFormat" />
      <el-table-column label="产品名称" align="center" prop="productName" />
      <el-table-column label="产品价格" align="center" prop="productPrice" />
      <el-table-column label="产品报价" align="center" prop="productBprice" />
      <el-table-column label="产品重量" align="center" prop="productWeight" />
      <el-table-column label="产品供应商" align="center" prop="productSupplier" :formatter="productSupplierFormat" />
      <el-table-column label="产品快递" align="center" prop="productFastmail" :formatter="productFastmailFormat" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:production:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:production:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改产品信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="产品编码" prop="productCode">
          <el-input v-model="form.productCode" placeholder="请输入产品编码" />
        </el-form-item>
        <el-form-item label="产品系列" prop="productPtype">
          <el-select v-model="form.productPtype" placeholder="请选择产品系列">
            <el-option
              v-for="dict in productPtypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产品规格" prop="productNorms">
          <el-select v-model="form.productNorms" placeholder="请选择产品规格">
            <el-option
              v-for="dict in productNormsOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产品型号" prop="productModel">
          <el-select v-model="form.productModel" placeholder="请选择产品型号">
            <el-option
              v-for="dict in productModelOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入产品名称" />
        </el-form-item>
        <el-form-item label="产品价格" prop="productPrice">
          <el-input v-model="form.productPrice" placeholder="请输入产品价格" />
        </el-form-item>
        <el-form-item label="产品报价" prop="productBprice">
          <el-input v-model="form.productBprice" placeholder="请输入产品报价" />
        </el-form-item>
        <el-form-item label="产品重量" prop="productWeight">
          <el-input v-model="form.productWeight" placeholder="请输入产品重量" />
        </el-form-item>
        <el-form-item label="产品供应商" prop="productSupplier">
          <el-select v-model="form.productSupplier" placeholder="请选择产品供应商">
            <el-option
              v-for="dict in productSupplierOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产品快递" prop="productFastmail">
          <el-select v-model="form.productFastmail" placeholder="请选择产品快递">
            <el-option
              v-for="dict in productFastmailOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listProduction, getProduction, delProduction, addProduction, updateProduction, exportProduction } from "@/api/system/production";

export default {
  name: "Production",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 产品信息表格数据
      productionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 产品系列字典
      productPtypeOptions: [],
      // 产品规格字典
      productNormsOptions: [],
      // 产品型号字典
      productModelOptions: [],
      // 产品供应商字典
      productSupplierOptions: [],
      // 产品快递字典
      productFastmailOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productCode: null,
        productPtype: null,
        productNorms: null,
        productModel: null,
        productName: null,
        productPrice: null,
        productBprice: null,
        productWeight: null,
        productSupplier: null,
        productFastmail: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("busi_product_type").then(response => {
      this.productPtypeOptions = response.data;
    });
    this.getDicts("busi_product_norms").then(response => {
      this.productNormsOptions = response.data;
    });
    this.getDicts("product_model").then(response => {
      this.productModelOptions = response.data;
    });
    this.getDicts("busi_product_supplier").then(response => {
      this.productSupplierOptions = response.data;
    });
    this.getDicts("busi_product_fastmail").then(response => {
      this.productFastmailOptions = response.data;
    });
  },
  methods: {
    /** 查询产品信息列表 */
    getList() {
      this.loading = true;
      listProduction(this.queryParams).then(response => {
        this.productionList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 产品系列字典翻译
    productPtypeFormat(row, column) {
      return this.selectDictLabel(this.productPtypeOptions, row.productPtype);
    },
    // 产品规格字典翻译
    productNormsFormat(row, column) {
      return this.selectDictLabel(this.productNormsOptions, row.productNorms);
    },
    // 产品型号字典翻译
    productModelFormat(row, column) {
      return this.selectDictLabel(this.productModelOptions, row.productModel);
    },
    // 产品供应商字典翻译
    productSupplierFormat(row, column) {
      return this.selectDictLabel(this.productSupplierOptions, row.productSupplier);
    },
    // 产品快递字典翻译
    productFastmailFormat(row, column) {
      return this.selectDictLabel(this.productFastmailOptions, row.productFastmail);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        productId: null,
        productCode: null,
        productPtype: null,
        productNorms: null,
        productModel: null,
        productName: null,
        productPrice: null,
        productBprice: null,
        productWeight: null,
        productSupplier: null,
        productFastmail: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.productId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加产品信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const productId = row.productId || this.ids
      getProduction(productId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改产品信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.productId != null) {
            updateProduction(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addProduction(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const productIds = row.productId || this.ids;
      this.$confirm('是否确认删除产品信息编号为"' + productIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delProduction(productIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有产品信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportProduction(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>

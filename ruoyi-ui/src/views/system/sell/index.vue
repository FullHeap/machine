<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="销售时间" prop="sellDate">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.sellDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择销售时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="客户名称" prop="customerName">
        <el-input
          v-model="queryParams.customerName"
          placeholder="请输入客户名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
      <el-form-item label="产品供应商" prop="productSupplier">
        <el-input
          v-model="queryParams.productSupplier"
          placeholder="请输入产品供应商"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系人" prop="personName">
        <el-input
          v-model="queryParams.personName"
          placeholder="请输入联系人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系电话" prop="personPhone">
        <el-input
          v-model="queryParams.personPhone"
          placeholder="请输入联系电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:sell:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:sell:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:sell:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:sell:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="sellList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="销售ID" align="center" prop="sellId" />
      <el-table-column label="销售时间" align="center" prop="sellDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.sellDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="预付款/尾款" align="center" prop="preMoney" />
      <el-table-column label="客户名称" align="center" prop="customerName" />
      <el-table-column label="产品名称" align="center" prop="productName" />
      <el-table-column label="卖价" align="center" prop="productSell" />
      <el-table-column label="数量" align="center" prop="productNum" />
      <el-table-column label="卖价" align="center" prop="productSumsell" />
      <el-table-column label="采购价" align="center" prop="productPrice" />
      <el-table-column label="采购价" align="center" prop="productSumprice" />
      <el-table-column label="产品供应商" align="center" prop="productSupplier" />
      <el-table-column label="快递" align="center" prop="productFastmail" />
      <el-table-column label="快递费" align="center" prop="productFastmailfee" />
      <el-table-column label="联系人" align="center" prop="personName" />
      <el-table-column label="联系电话" align="center" prop="personPhone" />
      <el-table-column label="销售利润" align="center" prop="sellProfit" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:sell:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:sell:remove']"
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

    <!-- 添加或修改销售信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="销售时间" prop="sellDate">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.sellDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择销售时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="预付款/尾款" prop="preMoney">
          <el-input v-model="form.preMoney" placeholder="请输入预付款/尾款" />
        </el-form-item>
        <el-form-item label="客户名称" prop="customerName">
          <el-input v-model="form.customerName" placeholder="请输入客户名称" />
        </el-form-item>
        <el-form-item label="产品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入产品名称" />
        </el-form-item>
        <el-form-item label="卖价" prop="productSell">
          <el-input v-model="form.productSell" placeholder="请输入卖价" />
        </el-form-item>
        <el-form-item label="数量" prop="productNum">
          <el-input v-model="form.productNum" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="卖价" prop="productSumsell">
          <el-input v-model="form.productSumsell" placeholder="请输入卖价" />
        </el-form-item>
        <el-form-item label="采购价" prop="productPrice">
          <el-input v-model="form.productPrice" placeholder="请输入采购价" />
        </el-form-item>
        <el-form-item label="采购价" prop="productSumprice">
          <el-input v-model="form.productSumprice" placeholder="请输入采购价" />
        </el-form-item>
        <el-form-item label="产品供应商" prop="productSupplier">
          <el-input v-model="form.productSupplier" placeholder="请输入产品供应商" />
        </el-form-item>
        <el-form-item label="快递" prop="productFastmail">
          <el-input v-model="form.productFastmail" placeholder="请输入快递" />
        </el-form-item>
        <el-form-item label="快递费" prop="productFastmailfee">
          <el-input v-model="form.productFastmailfee" placeholder="请输入快递费" />
        </el-form-item>
        <el-form-item label="联系人" prop="personName">
          <el-input v-model="form.personName" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系电话" prop="personPhone">
          <el-input v-model="form.personPhone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="销售利润" prop="sellProfit">
          <el-input v-model="form.sellProfit" placeholder="请输入销售利润" />
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
import { listSell, getSell, delSell, addSell, updateSell, exportSell } from "@/api/system/sell";

export default {
  name: "Sell",
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
      // 销售信息表格数据
      sellList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        sellDate: null,
        customerName: null,
        productName: null,
        productSupplier: null,
        personName: null,
        personPhone: null,
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
  },
  methods: {
    /** 查询销售信息列表 */
    getList() {
      this.loading = true;
      listSell(this.queryParams).then(response => {
        this.sellList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        sellId: null,
        sellDate: null,
        preMoney: null,
        customerName: null,
        productName: null,
        productSell: null,
        productNum: null,
        productSumsell: null,
        productPrice: null,
        productSumprice: null,
        productSupplier: null,
        productFastmail: null,
        productFastmailfee: null,
        personName: null,
        personPhone: null,
        sellProfit: null,
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
      this.ids = selection.map(item => item.sellId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加销售信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const sellId = row.sellId || this.ids
      getSell(sellId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改销售信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.sellId != null) {
            updateSell(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addSell(this.form).then(response => {
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
      const sellIds = row.sellId || this.ids;
      this.$confirm('是否确认删除销售信息编号为"' + sellIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delSell(sellIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有销售信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportSell(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>

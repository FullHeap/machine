package com.ruoyi.web.controller.system;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BusiCustomer;
import com.ruoyi.system.service.IBusiCustomerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@RestController
@RequestMapping("/system/customer")
public class BusiCustomerController extends BaseController
{
    @Autowired
    private IBusiCustomerService busiCustomerService;

    /**
     * 查询客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusiCustomer busiCustomer)
    {
        startPage();
        List<BusiCustomer> list = busiCustomerService.selectBusiCustomerList(busiCustomer);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:customer:export')")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusiCustomer busiCustomer)
    {
        List<BusiCustomer> list = busiCustomerService.selectBusiCustomerList(busiCustomer);
        ExcelUtil<BusiCustomer> util = new ExcelUtil<BusiCustomer>(BusiCustomer.class);
        return util.exportExcel(list, "customer");
    }

    /**
     * 获取客户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:customer:query')")
    @GetMapping(value = "/{customerId}")
    public AjaxResult getInfo(@PathVariable("customerId") Long customerId)
    {
        return AjaxResult.success(busiCustomerService.selectBusiCustomerById(customerId));
    }

    /**
     * 新增客户信息
     */
    @PreAuthorize("@ss.hasPermi('system:customer:add')")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusiCustomer busiCustomer)
    {
        return toAjax(busiCustomerService.insertBusiCustomer(busiCustomer));
    }

    /**
     * 修改客户信息
     */
    @PreAuthorize("@ss.hasPermi('system:customer:edit')")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusiCustomer busiCustomer)
    {
        return toAjax(busiCustomerService.updateBusiCustomer(busiCustomer));
    }

    /**
     * 删除客户信息
     */
    @PreAuthorize("@ss.hasPermi('system:customer:remove')")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{customerIds}")
    public AjaxResult remove(@PathVariable Long[] customerIds)
    {
        return toAjax(busiCustomerService.deleteBusiCustomerByIds(customerIds));
    }
}

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
import com.ruoyi.system.domain.BusiProduction;
import com.ruoyi.system.service.IBusiProductionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-04
 */
@RestController
@RequestMapping("/system/production")
public class BusiProductionController extends BaseController
{
    @Autowired
    private IBusiProductionService busiProductionService;

    /**
     * 查询产品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:production:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusiProduction busiProduction)
    {
        startPage();
        List<BusiProduction> list = busiProductionService.selectBusiProductionList(busiProduction);
        return getDataTable(list);
    }

    /**
     * 导出产品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:production:export')")
    @Log(title = "产品信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusiProduction busiProduction)
    {
        List<BusiProduction> list = busiProductionService.selectBusiProductionList(busiProduction);
        ExcelUtil<BusiProduction> util = new ExcelUtil<BusiProduction>(BusiProduction.class);
        return util.exportExcel(list, "production");
    }

    /**
     * 获取产品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:production:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Long productId)
    {
        return AjaxResult.success(busiProductionService.selectBusiProductionById(productId));
    }

    /**
     * 新增产品信息
     */
    @PreAuthorize("@ss.hasPermi('system:production:add')")
    @Log(title = "产品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusiProduction busiProduction)
    {
        return toAjax(busiProductionService.insertBusiProduction(busiProduction));
    }

    /**
     * 修改产品信息
     */
    @PreAuthorize("@ss.hasPermi('system:production:edit')")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusiProduction busiProduction)
    {
        return toAjax(busiProductionService.updateBusiProduction(busiProduction));
    }

    /**
     * 删除产品信息
     */
    @PreAuthorize("@ss.hasPermi('system:production:remove')")
    @Log(title = "产品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(busiProductionService.deleteBusiProductionByIds(productIds));
    }
}

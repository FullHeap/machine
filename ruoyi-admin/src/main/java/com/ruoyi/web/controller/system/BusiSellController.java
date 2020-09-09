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
import com.ruoyi.system.domain.BusiSell;
import com.ruoyi.system.service.IBusiSellService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
@RestController
@RequestMapping("/system/sell")
public class BusiSellController extends BaseController
{
    @Autowired
    private IBusiSellService busiSellService;

    /**
     * 查询销售信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:sell:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusiSell busiSell)
    {
        startPage();
        List<BusiSell> list = busiSellService.selectBusiSellList(busiSell);
        return getDataTable(list);
    }

    /**
     * 导出销售信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:sell:export')")
    @Log(title = "销售信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusiSell busiSell)
    {
        List<BusiSell> list = busiSellService.selectBusiSellList(busiSell);
        ExcelUtil<BusiSell> util = new ExcelUtil<BusiSell>(BusiSell.class);
        return util.exportExcel(list, "sell");
    }

    /**
     * 获取销售信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sell:query')")
    @GetMapping(value = "/{sellId}")
    public AjaxResult getInfo(@PathVariable("sellId") Long sellId)
    {
        return AjaxResult.success(busiSellService.selectBusiSellById(sellId));
    }

    /**
     * 新增销售信息
     */
    @PreAuthorize("@ss.hasPermi('system:sell:add')")
    @Log(title = "销售信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusiSell busiSell)
    {
        return toAjax(busiSellService.insertBusiSell(busiSell));
    }

    /**
     * 修改销售信息
     */
    @PreAuthorize("@ss.hasPermi('system:sell:edit')")
    @Log(title = "销售信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusiSell busiSell)
    {
        return toAjax(busiSellService.updateBusiSell(busiSell));
    }

    /**
     * 删除销售信息
     */
    @PreAuthorize("@ss.hasPermi('system:sell:remove')")
    @Log(title = "销售信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sellIds}")
    public AjaxResult remove(@PathVariable Long[] sellIds)
    {
        return toAjax(busiSellService.deleteBusiSellByIds(sellIds));
    }
}

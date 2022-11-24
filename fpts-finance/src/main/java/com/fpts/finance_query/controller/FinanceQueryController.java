package com.fpts.finance_query.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fpts.common.annotation.Log;
import com.fpts.common.enums.BusinessType;
import com.fpts.finance_query.domain.FinanceQuery;
import com.fpts.finance_query.service.IFinanceQueryService;
import com.fpts.common.core.controller.BaseController;
import com.fpts.common.core.domain.AjaxResult;
import com.fpts.common.utils.poi.ExcelUtil;
import com.fpts.common.core.page.TableDataInfo;

/**
 * 行情查询Controller
 * 
 * @author laybxc
 * @date 2022-11-24
 */
@Controller
@RequestMapping("/finance_query/finance_query")
public class FinanceQueryController extends BaseController
{
    private String prefix = "finance_query/finance_query";

    @Autowired
    private IFinanceQueryService financeQueryService;

    @RequiresPermissions("finance_query:finance_query:view")
    @GetMapping()
    public String finance_query()
    {
        return prefix + "/finance_query";
    }

    /**
     * 查询行情查询列表
     */
    @RequiresPermissions("finance_query:finance_query:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FinanceQuery financeQuery)
    {
        startPage();
        List<FinanceQuery> list = financeQueryService.selectFinanceQueryList(financeQuery);
        return getDataTable(list);
    }

    /**
     * 导出行情查询列表
     */
    @RequiresPermissions("finance_query:finance_query:export")
    @Log(title = "行情查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FinanceQuery financeQuery)
    {
        List<FinanceQuery> list = financeQueryService.selectFinanceQueryList(financeQuery);
        ExcelUtil<FinanceQuery> util = new ExcelUtil<FinanceQuery>(FinanceQuery.class);
        return util.exportExcel(list, "行情查询数据");
    }

    /**
     * 新增行情查询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存行情查询
     */
    @RequiresPermissions("finance_query:finance_query:add")
    @Log(title = "行情查询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FinanceQuery financeQuery)
    {
        return toAjax(financeQueryService.insertFinanceQuery(financeQuery));
    }

    /**
     * 修改行情查询
     */
    @RequiresPermissions("finance_query:finance_query:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        FinanceQuery financeQuery = financeQueryService.selectFinanceQueryById(id);
        mmap.put("financeQuery", financeQuery);
        return prefix + "/edit";
    }

    /**
     * 修改保存行情查询
     */
    @RequiresPermissions("finance_query:finance_query:edit")
    @Log(title = "行情查询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FinanceQuery financeQuery)
    {
        return toAjax(financeQueryService.updateFinanceQuery(financeQuery));
    }

    /**
     * 删除行情查询
     */
    @RequiresPermissions("finance_query:finance_query:remove")
    @Log(title = "行情查询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(financeQueryService.deleteFinanceQueryByIds(ids));
    }
}

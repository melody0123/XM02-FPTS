package com.fpts.finance_warehouse.service;

import java.util.List;
import com.fpts.finance_warehouse.domain.FinanceWarehouse;

/**
 * 数据仓库Service接口
 * 
 * @author laybxc
 * @date 2022-11-23
 */
public interface IFinanceWarehouseService 
{
    /**
     * 查询数据仓库
     * 
     * @param id 数据仓库主键
     * @return 数据仓库
     */
    public FinanceWarehouse selectFinanceWarehouseById(String id);

    /**
     * 查询数据仓库列表
     * 
     * @param financeWarehouse 数据仓库
     * @return 数据仓库集合
     */
    public List<FinanceWarehouse> selectFinanceWarehouseList(FinanceWarehouse financeWarehouse);

    /**
     * 新增数据仓库
     * 
     * @param financeWarehouse 数据仓库
     * @return 结果
     */
    public int insertFinanceWarehouse(FinanceWarehouse financeWarehouse);

    /**
     * 修改数据仓库
     * 
     * @param financeWarehouse 数据仓库
     * @return 结果
     */
    public int updateFinanceWarehouse(FinanceWarehouse financeWarehouse);

    /**
     * 批量删除数据仓库
     * 
     * @param ids 需要删除的数据仓库主键集合
     * @return 结果
     */
    public int deleteFinanceWarehouseByIds(String ids);

    /**
     * 删除数据仓库信息
     * 
     * @param id 数据仓库主键
     * @return 结果
     */
    public int deleteFinanceWarehouseById(String id);
}
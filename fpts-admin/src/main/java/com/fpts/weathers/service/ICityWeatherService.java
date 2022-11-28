package com.fpts.weathers.service;

import java.util.List;
import com.fpts.weathers.domain.CityWeather;

/**
 * 天气管理Service接口
 * 
 * @author Guoxi Zhang
 * @date 2022-11-15
 */
public interface ICityWeatherService 
{
    /**
     * 查询天气管理
     * 
     * @param id 天气管理主键
     * @return 天气管理
     */
    public CityWeather selectCityWeatherById(Long id);

    /**
     * 查询天气管理列表
     * 
     * @param cityWeather 天气管理
     * @return 天气管理集合
     */
    public List<CityWeather> selectCityWeatherList(CityWeather cityWeather);

    /**
     * 新增天气管理
     * 
     * @param cityWeather 天气管理
     * @return 结果
     */
    public int insertCityWeather(CityWeather cityWeather);

    /**
     * 修改天气管理
     * 
     * @param cityWeather 天气管理
     * @return 结果
     */
    public int updateCityWeather(CityWeather cityWeather);

    /**
     * 批量删除天气管理
     * 
     * @param ids 需要删除的天气管理主键集合
     * @return 结果
     */
    public int deleteCityWeatherByIds(String ids);

    /**
     * 删除天气管理信息
     * 
     * @param id 天气管理主键
     * @return 结果
     */
    public int deleteCityWeatherById(Long id);
}

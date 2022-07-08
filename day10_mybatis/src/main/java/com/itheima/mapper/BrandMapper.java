package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Classname UserMapper
 * @Date 2022/7/4 17:52
 * @Created by 李晓阳
 */
public interface BrandMapper {
    List<Brand> selectBrand();

    Brand selectByIdBrand(int id);

    // @Param 注解可以用于向映射中传递参数，指定参数要传递给sql中的哪一个参数，相当于定义了一个占位符的名字
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Map map);

    void add(Brand brand);

    int update(Brand brand);

    void deleteById(int id);

    // 给映射中的默认参数起名字
    void deleteByIds(@Param("ids") int[] ids);

}


















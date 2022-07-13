package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

/**
 * @Classname BrandService
 * @Date 2022/7/13 11:31
 * @Created by 李晓阳
 */
public interface BrandService {
    List<Brand> selectAll();

    void add(Brand brand);

    void deleteByIds(int[] ids);

    PageBean<Brand> selectByPage(int currentPage, int pageSize);


    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}

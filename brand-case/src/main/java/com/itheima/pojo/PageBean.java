package com.itheima.pojo;

import java.util.List;

/**
 * @Classname PageBean
 * @Date 2022/7/13 15:03
 * @Created by 李晓阳
 */
public class PageBean<T> {
    private int totalCount;
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}

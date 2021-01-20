package com.hanbinjava.iexcel.config;

import java.util.List;

/**
 * @author han_bin@outlook.com
 * @Description TODO
 */
public class SheetInfo {
    private String name;
    private List<ColumnInfo> columnInfoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ColumnInfo> getColumnInfoList() {
        return columnInfoList;
    }

    public void setColumnInfoList(List<ColumnInfo> columnInfoList) {
        this.columnInfoList = columnInfoList;
    }
}

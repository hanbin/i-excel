package com.hanbinjava.iexcel.config;

import java.util.List;

/**
 * @Description 解析XML配置
 * @author han_bin@outlook.com
 */
public class ExcelInfo {
    private String name;
    private List<SheetInfo> sheetInfoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SheetInfo> getSheetInfoList() {
        return sheetInfoList;
    }

    public void setSheetInfoList(List<SheetInfo> sheetInfoList) {
        this.sheetInfoList = sheetInfoList;
    }
}

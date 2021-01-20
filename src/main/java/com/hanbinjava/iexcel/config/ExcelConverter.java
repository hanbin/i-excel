package com.hanbinjava.iexcel.config;


import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author han_bin@outlook.com
 * @Description TODO
 */
public class ExcelConverter implements Converter {
    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {
        // 都excel
        ExcelInfo excelInfo = new ExcelInfo();
        excelInfo.setName(reader.getAttribute("name"));
        // 都sheet
        reader.moveDown();
        List<SheetInfo> sheetInfoList = new ArrayList<>();
        while(reader.hasMoreChildren()){
            reader.moveDown();
            SheetInfo sheetInfo = new SheetInfo();
            sheetInfo.setName(reader.getAttribute("name"));
            reader.moveDown();
            List<ColumnInfo> columnInfoList = new ArrayList<>();
            while(reader.hasMoreChildren()){
                reader.moveDown();
                ColumnInfo columnInfo = new ColumnInfo();
                columnInfo.setName(reader.getAttribute("name"));
                columnInfo.setDisplay(reader.getAttribute("display"));
                columnInfoList.add(columnInfo);
                reader.moveUp();
            }
            sheetInfo.setColumnInfoList(columnInfoList);
            sheetInfoList.add(sheetInfo);
        }
        excelInfo.setSheetInfoList(sheetInfoList);
        return excelInfo;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return true;
    }
}

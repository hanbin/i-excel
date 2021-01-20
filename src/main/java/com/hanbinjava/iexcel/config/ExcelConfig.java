package com.hanbinjava.iexcel.config;

import com.hanbinjava.iexcel.util.JsonUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

/**
 * @author han_bin@outlook.com
 * @Description TODO
 */
@Configuration
public class ExcelConfig {
    private static final Logger logger = LoggerFactory.getLogger(ExcelConfig.class);

    @Bean
    public ExcelInfo excelInfo(){
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new ExcelConverter());
        xStream.alias("excel", ExcelInfo.class);
        xStream.alias("sheet", SheetInfo.class);
        xStream.alias("column", ColumnInfo.class);

        InputStream inputStream = this.getClass().getResourceAsStream("/excel/test.import.xml");
        ExcelInfo excelInfo = (ExcelInfo) xStream.fromXML(inputStream);
        logger.info("excelInfo: {}", JsonUtil.toJson(excelInfo));
        return excelInfo;
    }
}

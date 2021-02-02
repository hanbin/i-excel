package com.hanbinjava.iexcel.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.hanbinjava.iexcel.common.CommonConstant;
import com.hanbinjava.iexcel.handler.DefaultImportHandler;
import com.hanbinjava.iexcel.handler.ImportHandler;
import com.hanbinjava.iexcel.listener.ExcelReadListener;
import com.hanbinjava.iexcel.model.ExcelTaskVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author han_bin@outlook.com
 * @Description 任务入口
 */
@Service
public class ExcelTaskService {
    private static final Logger logger = LoggerFactory.getLogger(ExcelTaskService.class);

    private ImportHandler importHandler;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 这里发起异步任务
     * @param file
     * @return
     */
    @Async(CommonConstant.ASYNC_NAME)
    public ExcelTaskVO createImportTask(MultipartFile file) throws IOException {
        logger.info("开始启动异步导入任务");
        importHandler = applicationContext.getBean(DefaultImportHandler.class);
        ExcelReadListener excelListener = new ExcelReadListener(importHandler);
        ExcelReaderBuilder excelReaderBuilder = EasyExcel.read(file.getInputStream(), excelListener);
        excelReaderBuilder.sheet().headRowNumber(2).doRead();
        logger.info("结束启动异步导入任务");
        return new ExcelTaskVO();
    }

    public ExcelTaskVO createExportTask(){
        return new ExcelTaskVO();
    }

}

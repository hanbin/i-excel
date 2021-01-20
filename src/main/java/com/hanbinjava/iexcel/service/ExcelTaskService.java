package com.hanbinjava.iexcel.service;

import com.hanbinjava.iexcel.common.CommonConstant;
import com.hanbinjava.iexcel.model.ExcelTaskVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author han_bin@outlook.com
 * @Description 任务入口
 */
@Service
public class ExcelTaskService {
    private static final Logger logger = LoggerFactory.getLogger(ExcelTaskService.class);

    /**
     * 这里发起异步任务
     * @param file
     * @return
     */
    @Async(CommonConstant.ASYNC_NAME)
    public ExcelTaskVO createImportTask(MultipartFile file){
        logger.info(">>> 创建导入任务");
        return new ExcelTaskVO();
    }

    public ExcelTaskVO createExportTask(){
        return new ExcelTaskVO();
    }

}

package com.hanbinjava.iexcel.controller;

import com.hanbinjava.iexcel.common.CommonConstant;
import com.hanbinjava.iexcel.common.CommonResponse;
import com.hanbinjava.iexcel.model.ExcelTaskVO;
import com.hanbinjava.iexcel.service.ExcelTaskService;
import com.hanbinjava.iexcel.service.FileCheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author han_bin@outlook.com
 * @Description TODO
 */
@Api(tags = "任务发起接口")
@RestController
public class ExcelTaskController {
    private static final Logger logger = LoggerFactory.getLogger(ExcelTaskController.class);

    @Autowired
    private ExcelTaskService excelTaskService;

    @Autowired
    private FileCheckService fileCheckService;

    @ApiOperation("创建导入任务")
    @PostMapping("/createImportTask")
    public CommonResponse<ExcelTaskVO> createImportTask(@RequestParam("file")MultipartFile file){
        ExcelTaskVO excelTaskVO = new ExcelTaskVO();
        fileCheckService.check(file);
        try{
            excelTaskVO = excelTaskService.createImportTask(file);
            return new CommonResponse<>(excelTaskVO);
        }catch(TaskRejectedException taskRejectedException){
            String errorInfo = "导入任务发起失败，队列满了";
            logger.error(errorInfo, taskRejectedException);
            excelTaskVO.setErrorInfo(errorInfo);
            //这里做异常结束
        }
        return new CommonResponse<>(excelTaskVO);
    }
}

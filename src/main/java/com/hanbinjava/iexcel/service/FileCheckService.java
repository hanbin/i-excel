package com.hanbinjava.iexcel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author han_bin@outlook.com
 * @Description TODO
 */
@Service
public class FileCheckService {
    private static final Logger logger = LoggerFactory.getLogger(FileCheckService.class);
    /**
     * 导入文件大小限制，单位:MB
     * 默认2MB
     */
    @Value("${iexcel.import.max_file_size:2}")
    private int maxFileSize;

    /**
     * 导入文件允许的后缀，默认.xlsx
     */
    @Value("${iexcel.import.valid_suffix:.xlsx}")
    private String validSuffix;

    public void check(MultipartFile file){
        logger.info(">>> check file size and suffix");
        long size = file.getSize();
        String originalFilename = file.getOriginalFilename();
        logger.info("originalFilename: {}", originalFilename);
        logger.info("file suffix: {}", originalFilename.substring(originalFilename.lastIndexOf(".")));
    }
}

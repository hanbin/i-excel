package com.hanbinjava.iexcel.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultImportHandler implements ImportHandler{
    private static final Logger logger = LoggerFactory.getLogger(DefaultImportHandler.class);

    @Override
    public void process(List<Object> list) {
        logger.info(list.toString());
    }

}

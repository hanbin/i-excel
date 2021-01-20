package com.hanbinjava.iexcel.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanbinjava.iexcel.common.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author han_bin@outlook.com
 * @Description TODO
 */
public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ApplicationException("对象转Json失败了");
        }
    }
}

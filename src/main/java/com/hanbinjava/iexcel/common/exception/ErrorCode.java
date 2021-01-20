package com.hanbinjava.iexcel.common.exception;

public interface ErrorCode {
    /**
     * 成功
     */
    String SUCCESS_CODE = "0000";

    /**
     * 失败（通用）
     */
    String FAILED_CODE = "1000";

    /**
     * 失败（没有找到对象）
     */
    String NOT_FOUND_CODE = "1001";

    /**
     * 失败（数据库异常）
     */
    String DB_ERROR_CODE = "1002";
}

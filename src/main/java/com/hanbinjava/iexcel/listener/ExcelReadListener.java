package com.hanbinjava.iexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hanbinjava.iexcel.handler.ImportHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;


/**
 * @author han_bin@outlook.com
 * @Description TODO
 */
public class ExcelReadListener extends AnalysisEventListener<Object> {
    private static final Logger logger = LoggerFactory.getLogger(ExcelReadListener.class);

    private final ImportHandler importHandler;

    private List<Object> list = new ArrayList<>();

    public ExcelReadListener(ImportHandler importHandler) {
        this.importHandler = importHandler;
    }

    @Override
    public void invoke(Object data, AnalysisContext context) {
        //读数据 逐条读
        list.add(data);
        logger.info("读取的数据：{}", list);
//        if(list.size() >= 1000){
//            logger.info("读取的数据：{}", list);
//            // 这里分批处理
//            importHandler.process(list);
//            list.clear();
//        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        logger.info("数据读完了...");
    }
}

package com.message.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * describe:
 *
 * @author Liu
 * @since 2018/07/13
 */


public class TimeMetaObjectHandler extends MetaObjectHandler {

    private Logger logger = LoggerFactory.getLogger(TimeMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createDate = getFieldValByName("createDate", metaObject);
        if (createDate == null) {
            setFieldValByName("createDate", new Date(), metaObject);
            setFieldValByName("updateDate", new Date(), metaObject);
        }
        logger.info(metaObject.toString());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateDate", new Date(), metaObject);

    }
}

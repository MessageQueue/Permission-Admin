package com.message.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
public class TimeMetaObjectHandler extends MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        Object createDate = getFieldValByName("createDate", metaObject);
        if (createDate == null) {
            setFieldValByName("createDate", new Date(), metaObject);
            setFieldValByName("updateDate", new Date(), metaObject);
        }
        log.info(metaObject.toString());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateDate", new Date(), metaObject);

    }
}

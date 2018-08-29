package com.message.dto;

import lombok.Data;

/**
 * describe:
 *
 * @author Liu
 * @since 2018/07/12
 */


@Data
public class BaseResponse {
    private String msg;
    private int code;
    private Object object;


    public static BaseResponse onSuccess(Object object){
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setCode(1000);
        baseResponse.setMsg("success");
        baseResponse.setObject(object);
        return baseResponse;
    }
}

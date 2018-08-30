package com.message.common;

import lombok.Data;

import static com.message.common.ConstantValues.*;


@Data
public class BaseResponse {
    private int code;
    private String msg;
    private Object data;



    /**
     * 数据返回成功
     * */
    public static BaseResponse onSuccess(Object object){
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setCode(RESPONSE_SUCCESS_CODE);
        baseResponse.setData(object);
        baseResponse.setMsg(RESPONSE_SUCCESS_MSG);
        return  baseResponse;
    }



    /**
     * 数据返回成功
     * */
    public static BaseResponse onFailure(String msg){
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setCode(RESPONSE_FAIL_CODE);
        baseResponse.setData(msg);
        baseResponse.setMsg(RESPONSE_FAIL_MSG);
        return  baseResponse;
    }



}

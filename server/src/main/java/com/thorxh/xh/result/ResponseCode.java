package com.thorxh.xh.result;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
public enum ResponseCode {

    /**
     * 请求成功
     */
    OK(200),
    BAD_REQUEST(400),
    /**
     * 服务器无法根据客户端的请求找到资源
     */
    NOT_FOUND(404),
    /**
     * 服务器内部错误，无法完成请求
     */
    INTERNAL_SERVER_ERROR(500)
    ;

    public int code;

    ResponseCode(int code) {
        this.code = code;
    }

}

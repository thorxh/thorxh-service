package com.thorxh.xh.result;

import lombok.*;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    /**
     * 响应码
     */
    private int responseCode;
    /**
     * 消息
     */
    private String message;
    /**
     * 请求是否成功
     */
    private boolean success;
    /**
     * 返回数据
     */
    private T data;

    private static final Result SERVER_ERROR_RESULT = new Result<>(ResponseCode.INTERNAL_SERVER_ERROR.code, "FAILED", false, null);

    private static final Result OK_RESULT = new Result<>(ResponseCode.OK.code, "OK", true, null);

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode.code;
    }

    public boolean isSuccess() {
        return responseCode == ResponseCode.OK.code;
    }

    public static <T> Result<T> getOKResult(T data) {
        Result<T> result = new Result<>();
        result.setResponseCode(ResponseCode.OK);
        result.setMessage("OK");
        result.setData(data);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static Result getOKResult() {
        return OK_RESULT;
    }

    @SuppressWarnings("unchecked")
    public static <T> Result<T> getFailedResult() {
        return SERVER_ERROR_RESULT;
    }

    public static Result<Object> getFailedResult(Object obj) {
        return new Result<>(ResponseCode.INTERNAL_SERVER_ERROR.code, "FAILED", false, obj);
    }

}

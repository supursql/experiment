package org.exp.utils;

/**
 * @author: 紫苏
 * @date: 2020/4/11 下午9:25
 * @description:
 */
public class ResultUtils {

    private Integer status;

    private String msg;

    private Object data;

    private String ok;

    public static ResultUtils build(Integer status, String msg, Object data) {
        return new ResultUtils(status, msg, data);
    }

    public static ResultUtils ok(Object data) {
        return new ResultUtils(200, "ok", data);
    }

    public static ResultUtils ok() {
        return new ResultUtils(200, "ok", null);
    }

    public static ResultUtils errorMsg(String msg) {
        return new ResultUtils(500, msg, null);
    }

    public static ResultUtils errorMap(Object data) {
        return new ResultUtils(501, "error", data);
    }

    public static ResultUtils errorTokenMsg(String msg) {
        return new ResultUtils(502, msg, null);
    }

    public static ResultUtils errorException(String msg) {
        return new ResultUtils(555, msg, null);
    }

    public ResultUtils() {
    }

    public ResultUtils(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtils(Object data) {
        this.data = data;
    }

    public Boolean isOk() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}

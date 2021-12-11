package com.aiden.kpcon.common.constant;
import com.aiden.kpcon.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * [返回值]
 *
 * @author: aiden
 * @date: on 2021-11-13 10:23
 * @Classname HttpStatus
 * @Version 1.0
 */
@Data
@ApiModel(value = "API返回参数")
public class Result implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 失败消息
     */
    private String msg;

    /**
     * 时间戳
     */
    private String time;

    /**
     * 返回数据
     */
    private Object data;

    public Result(String msg, int code)
    {
        this.setMsg(msg);
        this.setCode(code);
        this.setTime(DateUtils.getCurrDate("yyyy-MM-dd HH:mm:ss"));
    }

    public Result(String msg, int code, Object data)
    {
        this.setMsg(msg);
        this.setCode(code);
        this.setData(data);
        this.setTime(DateUtils.getCurrDate("yyyy-MM-dd HH:mm:ss"));
    }

    public Result(Integer code, String msg, Object data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.setTime(DateUtils.getCurrDate("yyyy-MM-dd HH:mm:ss"));
    }

    public static Result success()
    {
        return new Result(ResultCode.SUCCESS.getMsg(), ResultCode.SUCCESS.getCode());
    }

    public static Result success(Object data)
    {
        return new Result(ResultCode.SUCCESS.getMsg(), ResultCode.SUCCESS.getCode(), data);
    }

    public static Result success(String msg, Object data)
    {
        return new Result(msg, HttpStatus.SUCCESS, data);
    }

    public static Result success(ResultCode resultCode, Object data)
    {
        return new Result(resultCode.getMsg(), resultCode.getCode(), data);
    }

    public static Result success(ResultCode resultCode)
    {
        return new Result(resultCode.getMsg(), resultCode.getCode());
    }

    public static Result fail()
    {
        return new Result(ResultCode.SERVER_ERROR.getMsg(), ResultCode.SERVER_ERROR.getCode());
    }

    public static Result fail(String msg)
    {
        return new Result(msg, HttpStatus.ERROR);
    }

    public static Result fail(ResultCode resultCode)
    {
        return new Result(resultCode.getMsg(), resultCode.getCode());
    }

    public static Result fail(ResultCode resultCode, Object data)
    {
        return new Result(resultCode.getMsg(), resultCode.getCode(), data);
    }

    @Override
    public String toString()
    {
        return "{" + "\"code\":" + code + ", \"msg\":\"" + msg + '\"' + ", \"data\":\"" + data + '\"' + ", \"time\":\"" + time + '\"' + '}';
    }
}



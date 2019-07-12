package com.rehoshi.dto;

/**
 * 接口返回的响应数据
 * @param <T>
 */
public class RespData<T> {
    interface Code{
       int SUCCESS = 200 ;
       int FAIL = 0 ;
       int TOKEN_TIMEOUT = 1 ;
    }

    //响应码
    public int code ;
    //响应消息
    public String msg ;
    //查询数据
    public T data ;

    public RespData<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public RespData<T> setData(T data) {
        this.data = data;
        return this ;
    }

    public RespData<T> setMsg(String msg) {
        this.msg = msg;
        return this ;
    }

    public static <T>RespData<T> success(T data){
        return new RespData<T>().setCode(Code.SUCCESS).setData(data).setMsg("成功") ;
    }

    public static <T>RespData<T> fail(T data){
        return new RespData<T>().setCode(Code.FAIL).setData(data).setMsg("失败") ;
    }
    public static <T>RespData<T> tokenTimeOut(T data){
        return new RespData<T>().setCode(Code.TOKEN_TIMEOUT).setData(data).setMsg("Token过期，请重新登录") ;
    }
}

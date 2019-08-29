package com.hc21cloud.common.core.support.wrapper;

import java.io.Serializable;

/**
 * Wrapper
 *
 * @param <T>
 * @author shaofeng
 * @date 2019-08-21 11:28
 */
public class Wrapper<T> implements Serializable {

    private static final long serialVersionUID = 8107750256729890040L;

    /**
     * 成功码.
     */
    public static final int SUCCESS_CODE = 0;

    /**
     * 成功信息.
     */
    public static final String SUCCESS_MESSAGE = "操作成功";

    /**
     * 错误码.
     */
    public static final int ERROR_CODE = -1;

    /**
     * 错误信息.
     */
    public static final String ERROR_MESSAGE = "服务器内部异常";

    /**
     * 编号.
     */
    private int code;

    /**
     * 信息.
     */
    private String msg;

    /**
     * 结果数据
     */
    private T data;

    /**
     * Instantiates a new wrapper. default code=200
     */
    Wrapper() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    /**
     * Instantiates a new wrapper.
     *
     * @param code the code
     * @param msg  the msg
     */
    Wrapper(int code, String msg) {
        super();
        this.code(code).msg(msg).data(null);
    }

    /**
     * Instantiates a new wrapper.
     *
     * @param code the code
     * @param msg  the msg
     * @param data the data
     */
    Wrapper(int code, String msg, T data) {
        super();
        this.code(code).msg(msg).data(data);
    }

    /**
     * Sets the 编号 , 返回自身的引用.
     *
     * @param code the new 编号
     * @return the wrapper
     */
    private Wrapper<T> code(int code) {
        this.setCode(code);
        return this;
    }

    /**
     * Sets the 信息 , 返回自身的引用.
     *
     * @param msg the new 信息
     * @return the wrapper
     */
    private Wrapper<T> msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    /**
     * Sets the 结果数据 , 返回自身的引用.
     *
     * @param data the new 结果数据
     * @return the wrapper
     */
    public Wrapper<T> data(T data) {
        this.setData(data);
        return this;
    }
    /**
     * 判断是否成功： 依据 Wrapper.SUCCESS_CODE == this.code
     *
     * @return code =0,true;否则 false.
     */
    public boolean success() {
        return Wrapper.SUCCESS_CODE == this.code;
    }

    /**
     * 判断是否成功： 依据 Wrapper.SUCCESS_CODE != this.code
     *
     * @return code !=200,true;否则 false.
     */
    public boolean error() {
        return !success();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

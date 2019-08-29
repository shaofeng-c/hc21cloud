package com.hc21cloud.common.core.support.wrapper;

import org.apache.commons.lang3.StringUtils;

/**
 * WrapHandler
 *
 * @author shaofeng
 * @date 2019-08-21 11:44
 */
public class WrapHandler {
    /**
     * Instantiates a new wrap mapper.
     */
    private WrapHandler() {
    }

    /**
     * Wrap.
     *
     * @param <E>     the element type
     * @param code    the code
     * @param message the message
     * @param o       the o
     * @return the wrapper
     */
    public static <E> Wrapper<E> wrap(int code, String message, E o) {
        return new Wrapper<>(code, message, o);
    }

    /**
     * Wrap.
     *
     * @param <E>     the element type
     * @param code    the code
     * @param message the message
     * @return the wrapper
     */
    public static <E> Wrapper<E> wrap(int code, String message) {
        return wrap(code, message, null);
    }

    /**
     * Wrap.
     *
     * @param <E>  the element type
     * @param code the code
     * @return the wrapper
     */
    public static <E> Wrapper<E> wrap(int code) {
        return wrap(code, null);
    }

    /**
     * Wrap.
     *
     * @param <E> the element type
     * @param e   the e
     * @return the wrapper
     */
    public static <E> Wrapper<E> wrap(Exception e) {
        return new Wrapper<>(Wrapper.ERROR_CODE, e.getMessage());
    }

    /**
     * Un wrapper.
     *
     * @param <E>     the element type
     * @param wrapper the wrapper
     * @return the e
     */
    public static <E> E unWrap(Wrapper<E> wrapper) {
        return wrapper.getData();
    }

    /**
     * Wrap ERROR
     *
     * @param <E> the element type
     * @return the wrapper
     */
    public static <E> Wrapper<E> error() {
        return wrap(Wrapper.ERROR_CODE, Wrapper.ERROR_MESSAGE);
    }


    /**
     * Error wrapper.
     *
     * @param <E>     the type parameter
     * @param message the message
     * @return the wrapper
     */
    public static <E> Wrapper<E> error(String message) {
        return wrap(Wrapper.ERROR_CODE, StringUtils.isBlank(message) ? Wrapper.ERROR_MESSAGE : message);
    }

    /**
     * Wrap SUCCESS. code=200
     *
     * @param <E> the element type
     * @return the wrapper
     */
    public static <E> Wrapper<E> ok() {
        return new Wrapper<>();
    }

    /**
     * Ok wrapper.
     *
     * @param <E> the type parameter
     * @param o   the o
     * @return the wrapper
     */
    public static <E> Wrapper<E> ok(E o) {
        return new Wrapper<>(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, o);
    }
}

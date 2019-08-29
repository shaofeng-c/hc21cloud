package com.hc21cloud.umps.exception;

import com.hc21cloud.common.base.enums.ErrorCodeEnum;
import com.hc21cloud.common.base.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * umps模块异常处理
 *
 * @author shaofeng
 */
public class UmpsBizException extends BusinessException {
    private static final long serialVersionUID = -59165349286086583L;

    private static final Logger log = LoggerFactory.getLogger(UmpsBizException.class);

    /**
     * Instantiates a new Uac rpc exception.
     */
    public UmpsBizException() {
    }

    /**
     * Instantiates a new Umps rpc exception.
     *
     * @param code      the code
     * @param msgFormat the msg format
     * @param args      the args
     */
    public UmpsBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
        log.info("<== UmpsBizException, code:" + this.code + ", message:" + super.getMessage());
    }

    /**
     * Instantiates a new Umps rpc exception.
     *
     * @param code the code
     * @param msg  the msg
     */
    public UmpsBizException(int code, String msg) {
        super(code, msg);
        log.info("<== UmpsBizException, code:" + this.code + ", message:" + super.getMessage());
    }

    /**
     * Instantiates a new Umps rpc exception.
     *
     * @param codeEnum the code enum
     */
    public UmpsBizException(ErrorCodeEnum codeEnum) {
        super(codeEnum.code(), codeEnum.msg());
        log.info("<== UmpsBizException, code:" + this.code + ", message:" + super.getMessage());
    }

    /**
     * Instantiates a new Umps rpc exception.
     *
     * @param codeEnum the code enum
     * @param args     the args
     */
    public UmpsBizException(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
        log.info("<== UmpsBizException, code:" + this.code + ", message:" + super.getMessage());
    }
}

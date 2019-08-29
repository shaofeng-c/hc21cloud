package com.hc21cloud.common.core.anno;

import java.lang.annotation.*;

/**
 * 防重复提交
 *
 * @author shaofeng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RepeatSubmit {
}


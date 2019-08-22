package com.h21cloud.common.anno;

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


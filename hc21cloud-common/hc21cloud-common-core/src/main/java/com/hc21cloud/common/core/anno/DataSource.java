package com.hc21cloud.common.core.anno;

import java.lang.annotation.*;

/**
 * 切换数据注解 可以用于类或者方法级别 方法级别优先级 > 类级别
 *
 * @author shaofeng
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    //该值即key值
    String value() default "master";
}

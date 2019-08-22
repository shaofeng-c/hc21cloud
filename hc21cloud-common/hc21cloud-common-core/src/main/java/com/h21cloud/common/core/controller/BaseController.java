package com.h21cloud.common.core.controller;

import com.h21cloud.common.core.page.Page;
import com.h21cloud.common.core.page.TableSupport;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * web层通用数据处理
 *
 * @author shaofeng
 */
public class BaseController {

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
//                setValue(DateUtils.stringToDate(text, DateUtils.TIME_PATTERN));
            }
        });
    }

    /**
     * 开启请求分页请求
     */
    protected Page startPage() {
        return TableSupport.buildPageRequest();
    }

}

package com.hc21cloud.generator.service;

import com.hc21cloud.common.core.anno.DataSource;
import com.hc21cloud.generator.entity.Table;

import java.util.List;

/**
 * 代码生成 服务层
 *
 * @author shaofeng
 */
public interface GenService {

    /**
     * 生成代码
     *
     * @param packageName   包名
     * @param author        作者
     * @param tableName     表名称
     * @param autoRemovePre 去掉前缀
     * @return 数据
     */
    void generatorCode(String packageName, String author, String tableName, boolean autoRemovePre);

    /**
     * 批量生成代码
     * @param packageName   包名
     * @param author        作者
     * @param tableNames     表数组
     * @param autoRemovePre 去掉前缀
     * @return byte[]
     */
    void generatorCode(String packageName, String author, boolean autoRemovePre, String[] tableNames);

}

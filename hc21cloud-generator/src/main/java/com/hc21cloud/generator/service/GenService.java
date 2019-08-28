package com.hc21cloud.generator.service;

import com.hc21cloud.generator.pojo.vo.TableVo;

import java.util.List;
import java.util.Map;

/**
 * 代码生成 服务层
 *
 * @author shaofeng
 */
public interface GenService {
    /**
     * 查询数据库表信息
     *
     * @param params 表信息
     * @return 数据库表列表
     */
    List<TableVo> selectTableList(Map<String, Object> params);

    /**
     * 生成代码
     *
     * @param packageName   包名
     * @param author        作者
     * @param tableName     表名称
     * @param autoRemovePre 去掉前缀
     * @return 数据
     */
    byte[] generatorCode(String packageName, String author, String tableName, boolean autoRemovePre);

    /**
     * 批量生成代码
     *
     * @param packageName   包名
     * @param author        作者
     * @param autoRemovePre 去掉前缀
     * @param tableNames    表名称数组
     * @return byte[]
     */
    byte[] generatorCode(String packageName, String author, boolean autoRemovePre, String[] tableNames);
}

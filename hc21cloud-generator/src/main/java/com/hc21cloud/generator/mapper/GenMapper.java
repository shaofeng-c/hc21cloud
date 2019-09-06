package com.hc21cloud.generator.mapper;


import com.hc21cloud.common.core.anno.DataSource;
import com.hc21cloud.generator.entity.Column;
import com.hc21cloud.generator.entity.Table;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 代码生成 数据层
 *
 * @author shaofeng
 */
@Mapper
public interface GenMapper {
    /**
     * 查找table信息
     *
     * @param tableName tableName
     * @return * @return
     */
    Table selectTableByName(String tableName);

    /**
     * 查找table信息
     *
     * @param tableName tableName
     * @return * @return
     */
    List<Table> selectTables();
    /**
     * 查找表列信息
     *
     * @param tableName tableName
     * @return List
     */
    List<Column> selectTableColumnsByName(String tableName);
}

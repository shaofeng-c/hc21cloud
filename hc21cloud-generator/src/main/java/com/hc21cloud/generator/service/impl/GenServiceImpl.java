package com.hc21cloud.generator.service.impl;

import com.hc21cloud.common.core.anno.DataSource;
import com.hc21cloud.common.core.anno.Logging;
import com.hc21cloud.generator.entity.Column;
import com.hc21cloud.generator.entity.Table;
import com.hc21cloud.generator.mapper.GenMapper;
import com.hc21cloud.generator.service.GenService;
import com.hc21cloud.generator.utils.GenUtils;
import com.hc21cloud.generator.utils.VelocityInitializer;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class GenServiceImpl implements GenService {

    private static final Logger log = LoggerFactory.getLogger(GenServiceImpl.class);

    @Autowired
    private GenMapper genMapper;

    @Override
    public void generatorCode(String packageName, String author, String tableName, boolean autoRemovePre) {
        // 查询表信息
        Table table = genMapper.selectTableByName(tableName);
        // 查询列信息
        List<Column> columns = genMapper.selectTableColumnsByName(tableName);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(bos);
        // 生成代码
        generatorCode(packageName, author, autoRemovePre, table, columns);
    }

    @Override
    public void generatorCode(String packageName, String author, boolean autoRemovePre, String[] tableNames) {
        for (String tableName : tableNames) {
            // 查询表信息
            Table table = genMapper.selectTableByName(tableName);
            // 查询列信息
            List<Column> columns = genMapper.selectTableColumnsByName(tableName);
            // 生成代码
            generatorCode(packageName, author, autoRemovePre, table, columns);
        }
    }

    private void generatorCode(String packageName, String author, boolean autoRemovePre, Table table, List<Column> columns) {
        // 表名转换成Java属性名
        String className = GenUtils.tableToJava(table.getTableName(), autoRemovePre);
        table.setClassName(className);
        table.setLowClassName(StringUtils.uncapitalize(className));
        // 列信息
        table.setColumns(GenUtils.transColumns(columns));
        // 设置主键
        table.setPrimaryKey(table.getColumnsLast());
        VelocityInitializer.initVelocity();
        String moduleName = GenUtils.getModuleName(packageName);
        VelocityContext context = GenUtils.getVelocityContext(table, packageName, author);
        // 获取模板列表
        List<String> templates = GenUtils.getTemplates();
        try {
            for (String template : templates) {
                String dirName = "D:\\code\\" + GenUtils.getDirName(template, packageName);
                String fileName = GenUtils.getFileName(template, table);
                if (StringUtils.isNotBlank(dirName) && StringUtils.isNotBlank(fileName)) {
                    File file = new File(dirName);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    // 渲染模板
                    FileWriter sw = new FileWriter(new File(dirName+fileName));
                    Template tpl = Velocity.getTemplate(template, "UTF-8");
                    tpl.merge(context, sw);
                    sw.close();
                }

            }
        } catch (IOException e) {
            log.error("渲染模板失败，表名：" + table.getTableName(), e);
        }
    }
}

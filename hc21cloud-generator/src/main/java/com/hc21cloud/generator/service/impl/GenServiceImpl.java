package com.hc21cloud.generator.service.impl;

import com.hc21cloud.generator.pojo.vo.TableVo;
import com.hc21cloud.generator.service.GenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 代码生成实现类
 *
 * @author shaofeng
 */
@Service
public class GenServiceImpl implements GenService {
    @Override
    public List<TableVo> selectTableList(Map<String, Object> params) {
        return null;
    }

    @Override
    public byte[] generatorCode(String packageName, String author, String tableName, boolean autoRemovePre) {
        return new byte[0];
    }

    @Override
    public byte[] generatorCode(String packageName, String author, boolean autoRemovePre, String[] tableNames) {
        return new byte[0];
    }
}

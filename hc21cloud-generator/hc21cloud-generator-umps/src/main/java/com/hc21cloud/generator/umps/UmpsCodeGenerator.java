package com.hc21cloud.generator.umps;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.google.common.collect.Maps;

import java.util.Date;
import java.util.Map;

public class UmpsCodeGenerator {

    private final static String BASE_PROJECT_PATH = System.getProperty("user.dir") + "/code_generator/umps";
    private final static String BASE_PACKAGE = "com.hc21cloud.umps";
    private final static String AUTHOR = "shaofeng";
    private final static String[] TABLES = {"t_role", "t_resource", "t_role_resource", "t_user_role"};
    private final static String PREFIX = "hc_";
    private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/hc21cloud_umps?useUnicode=true&useSSL=false&characterEncoding=utf8";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //数据库配置
        mpg.setDataSource(new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setDriverName(DRIVER_NAME)
                .setUrl(URL)
                .setUsername(USERNAME)
                .setPassword(PASSWORD)
                .setTypeConvert(new MySqlTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        System.out.println("转换类型：" + fieldType);
                        if (fieldType.toLowerCase().contains("tinyint(1)")) {
                            return DbColumnType.INTEGER;
                        }
                        return super.processTypeConvert(globalConfig, fieldType);
                    }
                }));
        //全局配置
        mpg.setGlobalConfig(new GlobalConfig()
                .setDateType(DateType.ONLY_DATE)
                //输出目录
                .setOutputDir(BASE_PROJECT_PATH)
                // 是否覆盖文件
                .setFileOverride(true)
                // 开启 activeRecord 模式
                .setActiveRecord(true)
                // XML 二级缓存
                .setEnableCache(false)
                // XML ResultMap
                .setBaseResultMap(true)
                // XML columnList
                .setBaseColumnList(true)
                //生成后打开文件夹
                .setOpen(false)
                .setSwagger2(true)
                .setAuthor(AUTHOR)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController")
        );

        // 策略模式
        mpg.setStrategy(new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        //.setDbColumnUnderline(true)//全局下划线命名
                        // 此处可以修改为您的表前缀
                        .setTablePrefix(PREFIX)
                        // 表名生成策略
                        .setNaming(NamingStrategy.underline_to_camel)
                        .setRestControllerStyle(true)
                        // 需要生成的表
//                        .setInclude(TABLES)
                        //.setExclude(new String[]{"test"}) // 排除生成的表
                        // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                        .setEntityLombokModel(false)
//                        // 自定义实体父类
//                        .setSuperEntityClass("com.hc21cloud.common.core.support.BaseEntity")
//                        // 自定义 mapper 父类 默认BaseMapper
//                        .setSuperMapperClass("")
//                        // 自定义 service 父类 默认IService
//                        .setSuperServiceClass("")
//                        // 自定义 controller 父类
//                        .setSuperControllerClass("com.hc21cloud.common.core.support.BaseController")
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        );

        //包配置
        mpg.setPackageInfo(new PackageConfig()
                //.setModuleName("User")
                // 自定义包路径
                .setParent(BASE_PACKAGE)
                // 这里是控制器包名，默认 web
                .setController("web.frontend")
                .setEntity("model.entity")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setXml("mapper")
        );

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        mpg.setCfg(new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = Maps.newHashMap();
                map.put("author", this.getConfig().getGlobalConfig().getAuthor());
                this.setMap(map);
            }
        });

        // 模板配置

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig templateConfig = new TemplateConfig().setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                .setController("templates/controller.java")
                .setEntity("templates/entity.java")
                .setMapper("templates/mapper.java")
                .setXml("templates/mapper.xml")
                .setService("templates/service.java")
                .setServiceImpl("templates/serviceImpl.java");
        mpg.setTemplate(templateConfig);
        // 执行生成
        mpg.execute();
    }
}

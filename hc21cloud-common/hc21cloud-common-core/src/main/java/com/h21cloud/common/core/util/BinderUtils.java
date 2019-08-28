package com.h21cloud.common.core.util;

import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.boot.context.properties.source.ConfigurationPropertyNameAliases;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 负责处理对象与多个ConfigurationPropertySource（属性）之间的绑定（属性）之间的绑定
 *
 * @author shaofeng
 */
public class BinderUtils {

    /**
     * 由于部分不同，所以在此处添加别名，避免出现某些参数无法注入的情况
     */
    private final static ConfigurationPropertyNameAliases ALIASES = new ConfigurationPropertyNameAliases();

    static {
        ALIASES.addAliases("url", "jdbc-url");
        ALIASES.addAliases("username", "user");
    }

    public static void bind(DataSource result, Map properties) {
        ConfigurationPropertySource source = new MapConfigurationPropertySource(properties);
        Binder binder = new Binder(source.withAliases(ALIASES));
        // 将参数绑定到对象
        binder.bind(ConfigurationPropertyName.EMPTY, Bindable.ofInstance(result));
    }

    public static <T extends DataSource> T bind(Class<T> clazz, Map properties) {
        ConfigurationPropertySource source = new MapConfigurationPropertySource(properties);
        Binder binder = new Binder(source.withAliases(ALIASES));
        // 通过类型绑定参数并获得实例对象
        return binder.bind(ConfigurationPropertyName.EMPTY, Bindable.of(clazz)).get();
    }

    /**
     * @param clazz      数据源
     * @param sourcePath 参数路径，对应配置文件中的值，如: spring.datasource
     * @param <T>        DataSource
     * @return DataSource
     */
    public static <T extends DataSource> T bind(Binder binder, Class<T> clazz, String sourcePath) {
        Map properties = binder.bind(sourcePath, Map.class).get();
        return bind(clazz, properties);
    }
}

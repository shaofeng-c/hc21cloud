package com.hc21cloud.generator.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionUtils {

    /***
     * 读取配置文件
     * @return SqlSession
     */
    public SqlSession get() {
        SqlSession session = null;
        try {
            Reader reader = Resources.getResourceAsReader("src/main/resources/mybatis-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder()
                    .build(reader);
            session = ssf.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }

    public void close(SqlSession session) {
        session.close();
    }
}

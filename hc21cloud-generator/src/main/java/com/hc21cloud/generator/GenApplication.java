package com.hc21cloud.generator;

import com.hc21cloud.common.core.anno.DataSource;
import com.hc21cloud.generator.register.GenDynamicDataSourceRegister;
import com.hc21cloud.generator.service.GenService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author shaofeng
 */
@SpringBootApplication
@Import(GenDynamicDataSourceRegister.class)
@ComponentScan(basePackages = {"com.hc21cloud.*"})
public class GenApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GenApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }


    @Resource
    private GenService genService;

    @Override
    @DataSource("umps")
    public void run(String... args) throws Exception {
        String table = "hc_umps_user";
        genService.generatorCode("com.hc21cloud.umps", "shaofeng", table, true);
    }


}

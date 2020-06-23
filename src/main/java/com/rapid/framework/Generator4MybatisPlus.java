package main.java.com.rapid.framework;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 *
 * @ClassName: CodeGeneration
 * @Description: 代码生成器
 * @author yux
 * @date 2018年1月25日 下午2:55:14
 */
public class Generator4MybatisPlus {

    /**
     *
     * @Title: main
     * @Description: 生成
     * @param args
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOutputDir("D:\\test");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("dingzhichao3@jd.com");// 作者

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sManager");
        gc.setServiceImplName("%sManagerImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("m_esu_configkiis");
        dsc.setPassword("A3GnET");
        dsc.setUrl("jdbc:mysql://172.25.4.216:3306/esu_config_center");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
//        strategy.setInclude(new String[] { "cfg_app_config" });

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);
        strategy.setEntityLombokModel(true);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.jd.jr.esu.config.center");
        pc.setController("controller");
        pc.setService("manager");
        pc.setServiceImpl("manager.impl");
        pc.setMapper("dao.mapper");
        pc.setEntity("domain.entity.core.enterprise");

        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}

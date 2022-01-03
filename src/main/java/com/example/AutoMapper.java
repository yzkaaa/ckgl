package com.example;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


public class AutoMapper {
    public static void main(String[] args) {
        //创建AutoGenerator ,MP中对象
        AutoGenerator ag = new AutoGenerator();

        //设置全局配置
        GlobalConfig gc  = new GlobalConfig();
        //设置代码的生成位置， 磁盘的目录
        // String path = System.getProperty("user.dir");
        //gc.setOutputDir(path+"/src/main/java");
        gc.setOutputDir("C:\\zzzzz\\ck\\yzk\\src\\main\\java");
        //设置生成的类的名称（命名规则）
        gc.setMapperName("%sMapper");//所有的Dao类都是Mapper结尾的，例如DeptMapper
        //设置Service接口的命名
        gc.setServiceName("%sService");//DeptService
        //设置Service实现类的名称
        gc.setServiceImplName("%sServiceImpl");//DeptServiceImpl
        //设置Controller类的命名
        gc.setControllerName("%sController");//DeptController
        //设置作者
        gc.setAuthor("yuanzhikong");
        //设置主键id的配置
        gc.setIdType(IdType.AUTO);
        ag.setGlobalConfig(gc);

        //设置数据源DataSource
        DataSourceConfig ds  = new DataSourceConfig();
        //驱动
        ds.setDriverName("com.mysql.jdbc.Driver");
        //设置url
        ds.setUrl("jdbc:mysql://47.98.247.62:3306/0520erp");
        //设置数据库的用户名
        ds.setUsername("root");
        //设置密码
        ds.setPassword("333");
        //把DataSourceConfig赋值给AutoGenerator
        ag.setDataSource(ds);

        //设置Package信息
        PackageConfig pc  = new PackageConfig();
        //设置模块名称， 相当于包名， 在这个包的下面有 mapper， service， controller。
         pc.setModuleName("sys");
        //设置父包名，order就在父包的下面生成
        pc.setParent("com.example");
        ag.setPackageInfo(pc);



        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("sys_dept");//对那一张表生成代码
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
        //设置支持驼峰的命名规则
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        ag.setStrategy( strategy);

        //执行代码的生成
        ag.execute();
    }
}

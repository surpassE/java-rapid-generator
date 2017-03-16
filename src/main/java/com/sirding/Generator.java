package com.sirding;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;

public class Generator {

	public static void main(String[] args) throws Exception{
		GeneratorFacade g = new GeneratorFacade();
//		删除生成器的输出目录
//		g.deleteOutRootDir();
//		通过数据库表生成文件,template为模板的根目录
//		g.generateByTable("T_TEST_TABLE", "template");
//		自动搜索数据库中的所有表并生成文件,template为模板的根目录
		g.getGenerator().setTemplateRootDir("template");
//		自动搜索数据库中的所有表并生成文件,template为模板的根目录
		g.generateByAllTable();
		//打开文件夹
		Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
	}
}

<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.service.${className}Service;

/**
 * @Project       : ${projectName}
 * @Program Name  : ${basepackage}.service.impl.${className}ServiceImpl.java
 * @Class Name    : ${className}ServiceImpl.java
 * @Description   : GENERATOR SERVICE实现类
 * @Author        : generator
 */
@Service
public class ${className}ServiceImpl implements ${className}Service {

	/**
	 * ${className}DAO
	 */
	@Autowired
	private ${className}Dao ${classNameLower}Dao;
	
}

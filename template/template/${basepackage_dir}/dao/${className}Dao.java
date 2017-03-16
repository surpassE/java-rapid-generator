<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import ${basepackage}.model.${className};
import com.yirun.framework.dao.mybatis.MyBatisBaseDao;

/**
 * @Project       : ${projectName}
 * @Program Name  : ${basepackage}.dao.${className}Dao.java
 * @Class Name    : ${className}Dao.java
 * @Description   : GENERATOR DAO类
 * @Author        : generator
 */
public interface ${className}Dao extends MyBatisBaseDao<${className}, java.lang.Long> {
	
}

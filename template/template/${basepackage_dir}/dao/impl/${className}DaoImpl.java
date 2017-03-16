<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.impl;

import ${basepackage}.model.${className};
import ${basepackage}.dao.${className}Dao;
import com.yirun.framework.core.annotation.Dao;
import com.yirun.framework.dao.mybatis.impl.MyBatisBaseDaoImpl;

/**
 * @Project       : ${projectName}
 * @Program Name  : ${basepackage}.dao.impl.${className}DaoImpl.java
 * @Class Name    : ${className}DaoImpl.java
 * @Description   : GENERATOR DAO实现类
 * @Author        : generator
 */
@Dao
public class ${className}DaoImpl extends MyBatisBaseDaoImpl<${className}, java.lang.Long> implements ${className}Dao {

}

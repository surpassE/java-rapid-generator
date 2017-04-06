<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yirun.framework.core.utils.pager.Pager;

import ${basepackage}.model.${className};

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

	final int BATCH_SIZE = 50;
	
	/**
	 * ${className}DAO
	 */
	@Autowired
	private ${className}Dao ${classNameLower}Dao;
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(${className} ${classNameLower}) {
		this.${classNameLower}Dao.save(${classNameLower});
	}
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void insertBatch(List<${className}> list) {
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size(); i += BATCH_SIZE){
				if(list.size() - i >= BATCH_SIZE){
					this.${classNameLower}Dao.insertBatch(${className}.class, list.subList(i, i + BATCH_SIZE), BATCH_SIZE);
				}else{
					this.${classNameLower}Dao.insertBatch(${className}.class, list.subList(i, list.size()), list.size() - i);
				}
			}
		}
	}
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void update(${className} ${classNameLower}) {
		this.${classNameLower}Dao.update(${classNameLower});
	}
	
	@Override
	public ${className} findById(int id) {
		return this.${classNameLower}Dao.findByPK(new Long(id), ${className}.class);
	}
	
	@Override
	public List<${className}> findByCondition(${className} ${classNameLower}) {
		return this.${classNameLower}Dao.findByCondition(${classNameLower});
	}
	
	@Override
	public List<${className}> findByCondition(${className} ${classNameLower}, int start, int limit) {
		return this.${classNameLower}Dao.findByCondition(${classNameLower}, start, limit);
	}
	
	@Override
	public List<${className}> findByCondition(${className} ${classNameLower}, Pager pager) {
		return this.${classNameLower}Dao.findByCondition(${classNameLower}, pager);
	}
}

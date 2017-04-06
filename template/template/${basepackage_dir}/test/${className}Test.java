<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.test;

import java.util.ArrayList;
import java.util.List;

import com.yirun.framework.core.utils.pager.Pager;

import ${basepackage}.model.${className};

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ${basepackage}.service.${className}Service;


public class ${className}Test extend BaseTest{
	
	private final Logger LOG = Logger.getLogger(${className}Test.class);
	
	@Autowired
	private ${className}Service ${classNameLower}Service;
	
	private ${className} get${className}(){
		${className} model = new ${className}();
		return model;
	}

	/**
	 * @Described			: 测试单条插入
	 * @return				: void
	 */
	@Test
	public void testAdd(){
		${className} model = get${className}();
		this.${classNameLower}Service.insert(model);
	}

	/**
	 * @Described			: 测试批量插入
	 * @return				: void
	 */
	@Test
	public void testAddBatch(){
		List<${className}> list = new ArrayList<>();
		list.add(get${className}());
		list.add(get${className}());
		this.${classNameLower}Service.insertBatch(list);
	}

	/**
	 * @Described			: 测试更新
	 * @return				: void
	 */
	@Test
	public void testUpdate(){
		${className} model = this.${classNameLower}Service.findById(1);
		this.${classNameLower}Service.update(model);
	}

	/**
	 * @Described			: 测试分页条件检索
	 * @return				: void
	 */
	@Test
	public void testFindByCondition(){
		${className} model = this.${classNameLower}Service.findById(1);
		Pager pager = new Pager();
		pager.setCurrentPage(1);
		pager.setPageSize(10);
		pager.setStartNum(1);
		List<${className}> list = this.${classNameLower}Service.findByCondition(model, pager);
		LOG.debug(list);
	}
}
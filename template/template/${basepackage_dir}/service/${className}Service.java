<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.service;

/**
 * @Project       : ${projectName}
 * @Program Name  : ${basepackage}.service.${className}Service.java
 * @Class Name    : ${className}Service.java
 * @Description   : GENERATOR SERVICE类
 * @Author        : generator
 */
public interface ${className}Service {
	
	/**
	 * @Described			: 单条插入
	 * @param ${classNameLower} 持久化的数据对象
	 * @return				: void
	 */
	void insert(${className} ${classNameLower});
	
	/**
	 * @Described			: 批量插入
	 * @param List<${className}> 批量插入的数据
	 * @return				: void
	 */
	void insertBatch(List<${className}> list);
	
	/**
	 * @Described			: 更新数据
	 * @param ${classNameLower} 要更新的数据
	 * @return				: void
	 */
	void update(${className} ${classNameLower});
	
	/**
	 * @Described			: 通过id查询数据
	 * @param id id值
	 * @return	${className}
	 */
	${className} findById(int id);
	
	/**
	 * @Described			: 条件检索数据
	 * @param ${classNameLower} 检索条件
	 * @return	List<${className}>
	 */
	List<${className}> findByCondition(${className} ${classNameLower});
	
	/**
	 * @Described			: 条件检索数据
	 * @param ${classNameLower} 检索条件
	 * @param start	起始页
	 * @param limit 检索条数
	 * @return	List<${className}>
	 */
	List<${className}> findByCondition(${className} ${classNameLower}, int start, int limit);
	
	/**
	 * @Described			: 条件检索数据
	 * @param ${classNameLower} 检索条件
	 * @param pager	分页数据
	 * @return	List<${className}>
	 */
	List<${className}> findByCondition(${className} ${classNameLower}, Pager pager);
}

package com.soft.web.dao.system;

import java.util.*;

import org.apache.ibatis.annotations.*;

public interface ConfigMapper {

	Map<String, Object> getConfig();
	
	void update(@Param("company") String company,
			@Param("telephone") String telephone,
			@Param("filepath") String filepath);
}
package com.soft.web.dao.user;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.soft.util.Page;

public interface UserMapper {

	Map<String, Object> queryUser(@Param("user_name") String user_name);
	
	List<Map<String, Object>> queryRegister(@Param("user_name") String user_name, @Param("page") Page page);

	int queryRegisterCount(@Param("user_name")String user_name);

	void password(@Param("user_id") Integer user_id, @Param("password") String password);
	
	void inside(@Param("user_id") Integer user_id);
}
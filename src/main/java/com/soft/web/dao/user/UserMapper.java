package com.soft.web.dao.user;

import java.util.*;

import org.apache.ibatis.annotations.*;

public interface UserMapper {

	Map<String, Object> queryUser(@Param("user_name") String user_name);

	void password(@Param("user_id") Integer user_id, @Param("password") String password);
}
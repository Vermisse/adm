package com.soft.web.service.login;

import java.util.*;

import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.web.dao.user.*;

@Service
public class LoginService {
	
	private static Logger logger = Logger.getLogger(LoginService.class);
	
	@Autowired
	private UserMapper userMapper;

	public Map<String, Object> login(String user_name) {
		logger.info("登录:" + user_name);
		return userMapper.queryUser(user_name);
	}
	
	public void password(Integer user_id, String password) {
		userMapper.password(user_id, password);
	}
}
package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.util.Page;
import com.soft.web.dao.user.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	public List<Map<String, Object>> queryRegister(String user_name, Page page) {
		return mapper.queryRegister(user_name, page);
	}
	
	public int queryRegisterCount(String user_name) {
		return mapper.queryRegisterCount(user_name);
	}
}
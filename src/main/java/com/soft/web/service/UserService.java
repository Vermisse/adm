package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.web.dao.user.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	public List<Map<String, Object>> queryRegister(){
		return mapper.queryRegister();
	}
}
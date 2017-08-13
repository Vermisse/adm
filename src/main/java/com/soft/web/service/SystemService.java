package com.soft.web.service;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.web.dao.system.*;

@Service
public class SystemService {
	
	@Autowired
	private ConfigMapper mapper;
	
	public Map<String, Object> getConfig() {
		return mapper.getConfig();
	}
	
	public void update(String company, String telephone, String filepath) {
		mapper.update(company, telephone, filepath);
	}
}
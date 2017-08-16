package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.web.dao.type.*;

@Service
public class TypeService {

	@Autowired
	private TypeMapper mapper;
	
	public List<Map<String, Object>> queryType() {
		return mapper.queryType();
	}
}
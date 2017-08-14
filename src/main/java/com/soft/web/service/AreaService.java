package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.web.dao.area.*;

@Service
public class AreaService {
	
	@Autowired
	private AreaMapper mapper;

	public List<Map<String, Object>> getProvince() {
		return mapper.getProvince();
	}
	
	public List<Map<String, Object>> getCity(Integer province_id) {
		return mapper.getCity(province_id);
	}
	
	public List<Map<String, Object>> getDistrict(Integer city_id) {
		return mapper.getDistrict(city_id);
	}
}
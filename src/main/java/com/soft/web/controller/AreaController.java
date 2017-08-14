package com.soft.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.*;
import com.soft.web.service.*;

@Controller
@RequestMapping("area")
public class AreaController {

	@Autowired
	private AreaService service;
	
	@RequestMapping("city")
	@ResponseBody
	public String city(Integer province_id) {
		List<Map<String, Object>> list = service.getCity(province_id);
		return JSON.toJSONString(list);
	}
	
	@RequestMapping("district")
	@ResponseBody
	public String district(Integer city_id) {
		List<Map<String, Object>> list = service.getDistrict(city_id);
		return JSON.toJSONString(list);
	}
}
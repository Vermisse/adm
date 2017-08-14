package com.soft.web.dao.area;

import java.util.*;

import org.apache.ibatis.annotations.*;

public interface AreaMapper {

	List<Map<String, Object>> getProvince();
	
	List<Map<String, Object>> getCity(@Param("province_id") Integer province_id);
	
	List<Map<String, Object>> getDistrict(@Param("city_id") Integer city_id);
}
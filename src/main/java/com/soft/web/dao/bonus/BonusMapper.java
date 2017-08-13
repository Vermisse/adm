package com.soft.web.dao.bonus;

import java.util.*;

import org.apache.ibatis.annotations.*;

public interface BonusMapper {
	
	Map<String, Object> getBonus();
	
	void save(@Param("const") Double con, @Param("rate") Double rate);
}
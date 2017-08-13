package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.web.dao.bonus.*;

@Service
public class BonusService {

	@Autowired
	private BonusMapper mapper;
	
	public Map<String, Object> getBonus(){
		return mapper.getBonus();
	}
	
	public void save(Double con,Double rate) {
		mapper.save(con, rate);
	}
}
package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.web.dao.product.*;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper mapper;
	
	public List<Map> queryProduct(String product_name) {
		return mapper.queryProduct(product_name);
	}
}
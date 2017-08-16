package com.soft.web.service;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.util.*;
import com.soft.web.dao.product.*;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper mapper;
	
	public List<Map> queryProduct(String product_name, Page page) {
		return mapper.queryProduct(product_name, page);
	}
	
	public int queryProductCount(String product_name) {
		return mapper.queryProductCount(product_name);
	}
	
	public Map<String, Object> queryProductOne(Integer product_id) {
		return mapper.queryProductOne(product_id);
	}
	
	public int save(String product_name,
			Double product_price,
			String description,
			String feature,
			String price_description,
			String stroke,
			String notice,
			String filepath,
			Integer district,
			Integer type) {
		return mapper.save(product_name, product_price, description, feature, price_description, stroke, notice, filepath, district, type);
	}
	
	public void edit(Integer product_id,
			String product_name,
			Double product_price,
			String description,
			String feature,
			String price_description,
			String stroke,
			String notice,
			String filepath,
			Integer district,
			Integer type) {
		mapper.edit(product_id, product_name, product_price, description, feature, price_description, stroke, notice, filepath, district, type);
	}
	
	public void update(int product_id) {
		mapper.update(product_id);
	}
}
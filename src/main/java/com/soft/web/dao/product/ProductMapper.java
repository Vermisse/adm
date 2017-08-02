package com.soft.web.dao.product;

import java.util.*;

import org.apache.ibatis.annotations.*;

public interface ProductMapper {


	List<Map> queryProduct(@Param("product_name") String product_name,
			@Param("product_price") Double product_price,
			@Param("state") String state);
}
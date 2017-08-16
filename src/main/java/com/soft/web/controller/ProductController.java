package com.soft.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.soft.util.*;
import com.soft.web.service.*;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private AreaService area;
	
	@Autowired
	private TypeService type;
	
	@RequestMapping("list")
	public String list(String product_name, Page page, Model model) {
		List<Map> list = service.queryProduct(product_name, page);
		int count = service.queryProductCount(product_name);
		page.setCount(count);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "manage/product/product";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		List<Map<String, Object>> province = area.getProvince();
		List<Map<String, Object>> type = this.type.queryType();
		
		model.addAttribute("province", province);
		model.addAttribute("type", type);
		return "manage/product/productAdd";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(String product_name,
			Double product_price,
			String description,
			String feature,
			String price_description,
			String stroke,
			String notice,
			String filepath,
			Integer district,
			Integer type) {
		service.save(product_name, product_price, description, feature, price_description, stroke, notice, filepath, district, type);
		return "redirect:/product/list.html";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(int product_id, Model model) {
		Map<String, Object> product = service.queryProductOne(product_id);
		
		List<Map<String, Object>> province = area.getProvince();
		List<Map<String, Object>> city = area.getCity(((Long) product.get("ProvinceID")).intValue());
		List<Map<String, Object>> district = area.getDistrict(((Long) product.get("CityID")).intValue());
		List<Map<String, Object>> type = this.type.queryType();

		model.addAttribute("product", product);
		model.addAttribute("province", province);
		model.addAttribute("city", city);
		model.addAttribute("district", district);
		model.addAttribute("type", type);
		return "manage/product/productEdit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(Integer product_id,
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
		service.edit(product_id, product_name, product_price, description, feature, price_description, stroke, notice, filepath, district, type);
		return "redirect:/product/list.html";
	}
	
	@RequestMapping("update")
	public String update(int product_id) {
		service.update(product_id);
		return "redirect:/product/list.html";
	}
}
package com.soft.web.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product")
public class ProductController {

	@RequestMapping("list")
	public String list() {
		return "manage/product";
	}
}
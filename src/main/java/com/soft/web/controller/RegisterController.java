package com.soft.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.soft.util.*;
import com.soft.web.service.*;

@Controller
@RequestMapping("register")
public class RegisterController {

	@Autowired
	private UserService service;
	
	@RequestMapping("list")
	public String list(String user_name, Model model, Page page) {
		List list = service.queryRegister(user_name, page);
		int count = service.queryRegisterCount(user_name);
		page.setCount(count);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "manage/register/register_list";
	}
}
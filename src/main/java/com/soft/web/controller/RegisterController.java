package com.soft.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.soft.web.service.UserService;

@Controller
@RequestMapping("register")
public class RegisterController {

	@Autowired
	private UserService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		List list = service.queryRegister();
		model.addAttribute("list", list);
		return "manage/register/register_list";
	}
}
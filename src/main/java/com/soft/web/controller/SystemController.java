package com.soft.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.soft.web.service.*;

@Controller
@RequestMapping("system")
public class SystemController {

	@Autowired
	private SystemService service;
	
	@RequestMapping("show")
	public String show(Model model) {
		Map<String, Object> config = service.getConfig();
		model.addAttribute("config", config);
		return "manage/system";
	}
	
	@RequestMapping("save")
	public String save(String company, String telephone, String filepath) {
		service.update(company, telephone, filepath);
		return "redirect:/system/show.html";
	}
}
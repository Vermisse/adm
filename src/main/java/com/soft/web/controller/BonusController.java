package com.soft.web.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.soft.web.service.*;

@Controller
@RequestMapping("bonus")
public class BonusController {
	
	@Autowired
	private BonusService service;

	@RequestMapping("show")
	public String show(Model model) {
		model.addAttribute("bonus", service.getBonus());
		return "manage/bonus";
	}
	
	@RequestMapping("save")
	public String save(Double con, Double rate) {
		service.save(con, rate);
		return "redirect:/bonus/show.html";
	}
}
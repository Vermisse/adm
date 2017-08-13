package com.soft.web.controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.soft.web.service.BannerService;

@Controller
@RequestMapping("banner")
public class BannerController {
	
	@Autowired
	private BannerService service;
	
	@RequestMapping("list")
	public String list(HttpSession session, Model model) {
		List list = service.queryBanner();
		model.addAttribute("list", list);
		return "manage/banner";
	}
	
	@RequestMapping("add")
	public String add() {
		return "manage/bannerAdd";
	}
	
	@RequestMapping("save")
	public String save(String filepath, String url) {
		service.save(filepath, url);
		return "redirect:/banner/list.html";
	}

	@RequestMapping("delete")
	public String delete(Integer id) throws IOException {
		service.delete(id);
		return "redirect:/banner/list.html";
	}
}
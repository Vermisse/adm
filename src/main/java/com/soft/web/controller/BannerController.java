package com.soft.web.controller;

import java.io.*;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.*;

@Controller
@RequestMapping("banner")
public class BannerController {
	
	private final String banner = "/upload/banner";
	
	@RequestMapping("list")
	public String list(HttpSession session, Model model) {
		String path = session.getServletContext().getRealPath(banner);
		File file = new File(path);
		File[] banners = file.listFiles();
		
		model.addAttribute("banners", banners);
		return "manage/banner";
	}

	@RequestMapping("fileUpload")
	public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws IOException {
		String path = session.getServletContext().getRealPath(banner);
		String fileName = file.getOriginalFilename();
		String newPath = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));

		File newFile = new File(path + "/" + newPath);
		file.transferTo(newFile);
		
		return "redirect:/banner/list.html";
	}

	@RequestMapping("delete")
	public String delete(String fileName, HttpSession session) throws IOException {
		String path = session.getServletContext().getRealPath(banner);

		File file = new File(path + "/" + fileName);
		file.delete();

		return "redirect:/banner/list.html";
	}
}
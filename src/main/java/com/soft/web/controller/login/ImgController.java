package com.soft.web.controller.login;

import java.io.*;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.*;

@Controller
public class ImgController {

	private final String dir = "/upload/file";

	@RequestMapping("upload")
	@ResponseBody
	public String upload(@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws IOException {
		String path = session.getServletContext().getRealPath(dir);
		String fileName = file.getOriginalFilename();
		String newPath = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));

		File newFile = new File(path + "/" + newPath);
		file.transferTo(newFile);

		return newPath;
	}
}
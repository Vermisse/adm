package com.soft.web.controller.login;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.soft.util.Text;
import com.soft.web.service.login.*;

/**
 * 登录Controller
 * 
 * @author vermisse
 */
@Controller
public class LoginController {
	/**
	 * 登录Service
	 */
	@Autowired
	private LoginService service;
	
	/**
	 * 进入首页
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpSession session) {
		if (session.getAttribute("user") == null)
			return "index"; //未登录
		return "main"; //已登录
	}
	
	/**
	 * 登录
	 * @param 账号
	 * @param 密码
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(String user_name, String password, Model model, HttpSession session) {
		Map<String, Object> user = service.login(user_name);
		
		model.addAttribute("user_name", user_name);
		if (user == null) {
			model.addAttribute("message", "帐号不存在！");
			return "index";
		}
		
		if (!user.get("password").equals(passwd(password))) {
			model.addAttribute("message", "密码不正确！");
			return "index";
		}
		if (!user.get("status").equals(1)) {
			model.addAttribute("message", "该用户已禁用！");
			return "index";
		}
		
		session.setAttribute("user", user);
		model.addAttribute("user_name", null);
		return "redirect:index.html";
	}
	
	/**
	 * 注销
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("menu");
		return "redirect:index.html";
	}
	
	/**
	 * 进入修改密码页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/password",method = RequestMethod.GET)
	public String password() {
		return "manage/password";
	}
	
	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/password",method = RequestMethod.POST)
	public String password(String oldPass, String newPass, Model model, HttpSession session) {
		Map<String, Object> user = (Map) session.getAttribute("user");
		
		if(!user.get("password").equals(passwd(oldPass))) {
			model.addAttribute("message", "原密码错误");
			return "manage/password";
		}
		
		newPass = passwd(newPass);
		service.password((Integer) user.get("user_id"), newPass);
		user.put("password", newPass);
		return "redirect:/";
	}
	
	/**
	 * 进入Demo
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/{demo}")
	public String demo(@PathVariable String demo) {
		return "demo/" + demo;
	}
	
	private String passwd(String password) {
		String passwd = Text.crc32(password + (char) 10);
		passwd += Text.sha1((char) 800 + password);
		return Text.md5(passwd);
	}
}
package com.soft.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.util.DateUtil;
import com.soft.util.Page;
import com.soft.web.service.AutomobileService;

/**
 * 火车票操作类
 * @author wang
 *
 */
@Controller
@RequestMapping("automobile")
public class AutomobileController {
	// 时间格式
	private final String format = "yyyy-MM-dd HH:mm:ss";
	
	@Autowired 
	private AutomobileService automobileService;
	
	@RequestMapping("list")
	public String list(String state, Page page, Model model) {
		List<Map> list = automobileService.queryAutomobileList(state);
		model.addAttribute("list", list);
		return "manage/automobile/automobileList";
	}

	@RequestMapping("update")
	public String updateAutomobileStateById(String states, String id) {
		automobileService.updateAutomobileStateById(states, id, DateUtil.getNow(format));
		return "manage/automobile/automobileList";
	}
	
	/**
	 * 添加火车票订单
	 * @param peopleNum 火车票人数
	 * @param address  火车票地点
	 * @param checkStartTiIme 火车票开始时间
	 * @param checkEndTime 火车票结束时间
	 */
	@RequestMapping("add")
	public void addAutomobile(String peopleNum, String address, String checkStartTime, String checkEndTime) {
		// 获取登陆者的用户名+手机号码
		String userName = "";
		String userTel = "";
		String createTime = DateUtil.getNow(format);
		String updateTime = DateUtil.getNow(format);
		automobileService.addAutomobile(userName, userTel, peopleNum, createTime, updateTime, address, checkStartTime, checkEndTime);
	}
}
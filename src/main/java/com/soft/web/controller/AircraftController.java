package com.soft.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.util.DateUtil;
import com.soft.util.Page;
import com.soft.web.service.AircraftService;

/**
 * 机票操作类
 * @author wang
 *
 */
@Controller
@RequestMapping("aircraft")
public class AircraftController {
	// 时间格式
	private final String format = "yyyy-MM-dd HH:mm:ss";
	
	@Autowired 
	private AircraftService aircraftService;
	
	@RequestMapping("list")
	public String list(String state, Page page, Model model) {
		List<Map> list = aircraftService.queryAircraftList(state, page);
		int count = aircraftService.queryAircraftListCount(state);
		page.setCount(count);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "manage/aircraft/aircraftList";
	}

	@RequestMapping("update")
	public String updateAircraftStateById(String states, String id) {
		aircraftService.updateAircraftStateById(states, id, DateUtil.getNow(format));
		return "redirect:/aircraft/html.html";
	}
	
	/**
	 * 添加机票订单
	 * @param peopleNum 机票人数
	 * @param address  机票地点
	 * @param checkStartTiIme 机票开始时间
	 * @param checkEndTime 机票结束时间
	 */
	@RequestMapping("add")
	public void addAircraft(String peopleNum, String address, String checkStartTime, String checkEndTime) {
		// 获取登陆者的用户名+手机号码
		String userName = "";
		String userTel = "";
		String createTime = DateUtil.getNow(format);
		String updateTime = DateUtil.getNow(format);
		aircraftService.addAircraft(userName, userTel, peopleNum, createTime, updateTime, address, checkStartTime, checkEndTime);
	}
	
	/**
	 * 查询订单详情
	 * @param id
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("detailList")
	public String detailList(String id, Page page, Model model) {
		List<Map> list = aircraftService.queryAircraftDetailList(id);
		model.addAttribute("list", list);
		return "manage/aircraft/aircraftList";
	}
}
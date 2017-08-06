package com.soft.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.util.DateUtil;
import com.soft.util.Page;
import com.soft.web.service.HotelService;

/**
 * 酒店操作类
 * @author wang
 *
 */
@Controller
@RequestMapping("hotel")
public class HotelController {
	// 时间格式
	private final String format = "yyyy-MM-dd HH:mm:ss";
	
	@Autowired 
	private HotelService hotelService;
	
	@RequestMapping("list")
	public String list(String state, Page page, Model model) {
		List<Map> list = hotelService.queryHotelList(state);
		model.addAttribute("list", list);
		return "manage/hotel/hotelList";
	}

	@RequestMapping("update")
	public String updateHotelStateById(String states, String id) {
		hotelService.updateHotelStateById(states, id, DateUtil.getNow(format));
		return "manage/hotel/hotelList";
	}
	
	/**
	 * 添加酒店订单
	 * @param peopleNum 入住人数
	 * @param address  入住地点
	 * @param checkStartTiIme 入住开始时间
	 * @param checkEndTime 入住结束时间
	 */
	@RequestMapping("add")
	public void addHotel(String peopleNum, String address, String checkStartTime, String checkEndTime) {
		// 获取登陆者的用户名+手机号码
		String userName = "";
		String userTel = "";
		String createTime = DateUtil.getNow(format);
		String updateTime = DateUtil.getNow(format);
		hotelService.addHotel(userName, userTel, peopleNum, createTime, updateTime, address, checkStartTime, checkEndTime);
	}
}
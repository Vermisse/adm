package com.soft.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.util.DateUtil;
import com.soft.util.Page;
import com.soft.web.service.MyService;

/**
 * 私人订制操作类
 * @author wang 
 *
 */

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("my")
public class MyController {
	// 时间格式
	private final String format = "yyyy-MM-dd HH:mm:ss";
	
	@Autowired 
	private MyService myService;
	
	@RequestMapping("list")
	public String list(String state, Page page, Model model) {
		List<Map> list = myService.queryMyList(state);
		model.addAttribute("list", list);
		return "manage/my/myList";
	}

	@RequestMapping("update")
	public String updatemyStateById(String states, String id) {
		myService.updateMyStateById(states, id, DateUtil.getNow(format));
		return "manage/my/myList";
	}
	
	/**
	 * 添加私人订制订单
	 * @param peopleNum 私人订制人数
	 * @param address  私人订制地点
	 * @param checkStartTiIme 私人订制开始时间
	 * @param checkEndTime 私人订制结束时间
	 */
	@RequestMapping("add")
	public void addmy(String peopleNum, String tripMode) {
		// 获取登陆者的用户名+手机号码
		String userName = "";
		String userTel = "";
		String createTime = DateUtil.getNow(format);
		String updateTime = DateUtil.getNow(format);
		myService.addMy(userName, userTel, peopleNum, createTime, updateTime, tripMode);
	}
}
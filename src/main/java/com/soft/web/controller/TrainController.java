package com.soft.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.util.DateUtil;
import com.soft.util.Page;
import com.soft.web.service.TrainService;

/**
 * 签证操作类
 * @author wang
 *
 */
@Controller
@RequestMapping("train")
public class TrainController {
	// 时间格式
	private final String format = "yyyy-MM-dd HH:mm:ss";
	
	@Autowired 
	private TrainService trainService;
	
	@RequestMapping("list")
	public String list(String state, Page page, Model model) {
		List<Map> list = trainService.queryTrainList(state, page);
		int count = trainService.queryTrainListCount(state);
		page.setCount(count);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "manage/train/trainList";
	}

	@RequestMapping("update")
	public String updatetrainStateById(String states, String id) {
		trainService.updateTrainStateById(states, id, DateUtil.getNow(format));
		return "manage/train/trainList";
	}
	
	/**
	 * 添加签证订单
	 * @param peopleNum 签证人数
	 * @param address  签证地点
	 * @param checkStartTiIme 签证开始时间
	 * @param checkEndTime 签证结束时间
	 */
	@RequestMapping("add")
	public void addtrain(String peopleNum, String address, String checkStartTime, String checkEndTime) {
		// 获取登陆者的用户名+手机号码
		String userName = "";
		String userTel = "";
		String createTime = DateUtil.getNow(format);
		String updateTime = DateUtil.getNow(format);
		trainService.addTrain(userName, userTel, peopleNum, createTime, updateTime, address, checkStartTime, checkEndTime);
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
		List<Map> list = trainService.queryTrainDetailList(id);
		model.addAttribute("list", list);
		return "manage/train/detailList";
	}
}
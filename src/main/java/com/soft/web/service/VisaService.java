package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.visa.VisaMapper;

/**
 * 签证服务类
 * @author wang
 *
 */
@Service
@SuppressWarnings("rawtypes")
public class VisaService {
	
	@Autowired
	private VisaMapper mapper;
	
	/**
	 * 根据状态查询签证订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryVisaList(String state) {
		return mapper.queryVisaList(state);
	}
	
	
	/**
	 * 根据状态查询签证订单列表
	 * @param state
	 * @return
	 */
	public int updateVisaStateById(String state, String id, String updateTime) {
		return mapper.updateVisaStateById(state, id, updateTime);
	}

	/**
	 * 添加签证订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  签证人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addVisa(String userName, String userTel, String peopleNum, String createTime, String updateTime, String address, String checkStartTime, String checkEndTime) {
		return mapper.addVisa(userName, userTel, peopleNum, createTime, updateTime, address, checkStartTime, checkEndTime);
	}
}
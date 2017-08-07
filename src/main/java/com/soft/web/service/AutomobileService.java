package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.automobile.AutomobileMapper;

/**
 * 机票服务类
 * @author wang
 *
 */
@Service
@SuppressWarnings("rawtypes")
public class AutomobileService {
	
	@Autowired
	private AutomobileMapper mapper;
	
	/**
	 * 根据状态查询机票订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryAutomobileList(String state) {
		return mapper.queryAutomobileList(state);
	}
	
	
	/**
	 * 根据状态查询机票订单列表
	 * @param state
	 * @return
	 */
	public int updateAutomobileStateById(String state, String id, String updateTime) {
		return mapper.updateAutomobileStateById(state, id, updateTime);
	}

	/**
	 * 添加机票订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  机票人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addAutomobile(String userName, String userTel, String peopleNum, String createTime, String updateTime, String address, String checkStartTime, String checkEndTime) {
		return mapper.addAutomobile(userName, userTel, peopleNum, createTime, updateTime, address, checkStartTime, checkEndTime);
	}
}
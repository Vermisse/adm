package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.util.*;
import com.soft.web.dao.automobile.*;

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
	public List<Map> queryAutomobileList(String state, Page page) {
		return mapper.queryAutomobileList(state, page);
	}
	
	public int queryAutomobileListCount(String state) {
		return mapper.queryAutomobileListCount(state);
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
	

	/**
	 * 根据id查询机票详情列表
	 * @param id
	 * @return
	 */
	public List<Map> queryAutomobileDetailList(String id) {
		return mapper.queryAutomobileDetailList(id);
	}
}
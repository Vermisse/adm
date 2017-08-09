package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.my.MyMapper;

/**
 * 私人订制服务类
 * @author wang
 *
 */
@Service
@SuppressWarnings("rawtypes")
public class MyService {
	
	@Autowired
	private MyMapper mapper;
	
	/**
	 * 根据状态查询私人订制订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryMyList(String state) {
		return mapper.queryMyList(state);
	}
	
	
	/**
	 * 根据状态查询私人订制订单列表
	 * @param state
	 * @return
	 */
	public int updateMyStateById(String state, String id, String updateTime) {
		return mapper.updateMyStateById(state, id, updateTime);
	}

	/**
	 * 添加私人订制订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  私人订制人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addMy(String userName, String userTel, String peopleNum, String createTime, String updateTime, String tripMode) {
		return mapper.addMy(userName, userTel, peopleNum, createTime, updateTime, tripMode);
	}
}
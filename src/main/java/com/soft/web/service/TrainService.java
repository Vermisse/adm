package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.train.TrainMapper;

/**
 * 直通车服务类
 * @author wang
 *
 */
@Service
@SuppressWarnings("rawtypes")
public class TrainService {
	
	@Autowired
	private TrainMapper mapper;
	
	/**
	 * 根据状态查询直通车订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryTrainList(String state) {
		return mapper.queryTrainList(state);
	}
	
	
	/**
	 * 根据状态查询直通车订单列表
	 * @param state
	 * @return
	 */
	public int updateTrainStateById(String state, String id, String updateTime) {
		return mapper.updateTrainStateById(state, id, updateTime);
	}

	/**
	 * 添加直通车订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  直通车人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addTrain(String userName, String userTel, String peopleNum, String createTime, String updateTime, String address, String checkStartTime, String checkEndTime) {
		return mapper.addTrain(userName, userTel, peopleNum, createTime, updateTime, address, checkStartTime, checkEndTime);
	}
}
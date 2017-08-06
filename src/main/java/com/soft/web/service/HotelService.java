package com.soft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.web.dao.hotel.HotelMapper;

/**
 * 酒店服务类
 * @author wang
 *
 */
@Service
@SuppressWarnings("rawtypes")
public class HotelService {
	
	@Autowired
	private HotelMapper mapper;
	
	/**
	 * 根据状态查询酒店订单列表
	 * @param state
	 * @return
	 */
	public List<Map> queryHotelList(String state) {
		return mapper.queryHotelList(state);
	}
	
	
	/**
	 * 根据状态查询酒店订单列表
	 * @param state
	 * @return
	 */
	public int updateHotelStateById(String state, String id, String updateTime) {
		return mapper.updateHotelStateById(state, id, updateTime);
	}

	/**
	 * 添加酒店订单
	 * @param userName  联系人名字
	 * @param userTel  联系人电话
	 * @param peopleNum  入住人数
	 * @param createTime 创建时间
	 * @param updateTime 修改时间
	 * @return
	 */
	public int addHotel(String userName, String userTel, String peopleNum, String createTime, String updateTime, String address, String checkStartTime, String checkEndTime) {
		return mapper.addHotel(userName, userTel, peopleNum, createTime, updateTime, address, checkStartTime, checkEndTime);
	}
}
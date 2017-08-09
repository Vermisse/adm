package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.util.*;
import com.soft.web.dao.hotel.*;

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
	public List<Map> queryHotelList(String state, Page page) {
		return mapper.queryHotelList(state, page);
	}
	
	public int queryHotelListCount(String state) {
		return mapper.queryHotelListCount(state);
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
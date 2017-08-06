package com.soft.web.dao.hotel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 酒店dao
 * 
 * @author wang
 *
 */
@SuppressWarnings("rawtypes")
public interface HotelMapper {

	// 根据状态查询酒店订单列表
	List<Map> queryHotelList(@Param("state") String state);

	// 根据id修改酒店当前状态（0初始值；1未沟通；2已沟通；3未成单；已成单；）
	int updateHotelStateById(@Param("state") String state, @Param("id") String id,
			@Param("updateTime") String updateTime);

	// 添加酒店订单
	int addHotel(@Param("userName") String userName, @Param("userTel") String userTel,
			@Param("peopleNum") String peopleNum, @Param("createTime") String createTime,
			@Param("updateTime") String updateTime, @Param("address") String address,
			@Param("checkStartTime") String checkStartTime, @Param("checkEndTime") String checkEndTime);
}
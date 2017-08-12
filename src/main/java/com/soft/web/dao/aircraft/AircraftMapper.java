package com.soft.web.dao.aircraft;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.soft.util.*;

/**
 * 机票dao
 * 
 * @author wang
 *
 */
@SuppressWarnings("rawtypes")
public interface AircraftMapper {

	// 根据状态查询机票订单列表
	List<Map> queryAircraftList(@Param("state") String state, @Param("page") Page page);

	// 根据状态查询机票订单列表
	int queryAircraftListCount(@Param("state") String state);

	// 根据id修改机票当前状态（0初始值；1未沟通；2已沟通；3未成单；已成单；）
	int updateAircraftStateById(@Param("state") String state, @Param("id") String id,
			@Param("updateTime") String updateTime);

	// 添加机票订单
	int addAircraft(@Param("userName") String userName, @Param("userTel") String userTel,
			@Param("peopleNum") String peopleNum, @Param("createTime") String createTime,
			@Param("updateTime") String updateTime, @Param("address") String address,
			@Param("checkStartTime") String checkStartTime, @Param("checkEndTime") String checkEndTime);

	// 根据ID查询飞机票订单详情列表
	List<Map> queryAircraftDetailList(@Param("t_id") String t_id);
}
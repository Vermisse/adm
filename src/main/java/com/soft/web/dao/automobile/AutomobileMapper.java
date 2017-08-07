package com.soft.web.dao.automobile;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 火车票dao
 * 
 * @author wang
 *
 */
@SuppressWarnings("rawtypes")
public interface AutomobileMapper {

	// 根据状态查询火车票订单列表
	List<Map> queryAutomobileList(@Param("state") String state);

	// 根据id修改火车票当前状态（0初始值；1未沟通；2已沟通；3未成单；已成单；）
	int updateAutomobileStateById(@Param("state") String state, @Param("id") String id,
			@Param("updateTime") String updateTime);

	// 添加火车票订单
	int addAutomobile(@Param("userName") String userName, @Param("userTel") String userTel,
			@Param("peopleNum") String peopleNum, @Param("createTime") String createTime,
			@Param("updateTime") String updateTime, @Param("address") String address,
			@Param("checkStartTime") String checkStartTime, @Param("checkEndTime") String checkEndTime);
}
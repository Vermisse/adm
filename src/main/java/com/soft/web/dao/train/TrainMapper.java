package com.soft.web.dao.train;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.soft.util.*;

/**
 * 直通车dao
 * 
 * @author wang
 *
 */
@SuppressWarnings("rawtypes")
public interface TrainMapper {

	// 根据状态查询直通车订单列表
	List<Map> queryTrainList(@Param("state") String state, @Param("page") Page page);
	
	int queryTrainListCount(@Param("state") String state);

	// 根据id修改直通车当前状态（0初始值；1未沟通；2已沟通；3未成单；已成单；）
	int updateTrainStateById(@Param("state") String state,
			@Param("id") String id,
			@Param("updateTime") String updateTime);

	// 添加直通车订单
	int addTrain(@Param("userName") String userName, @Param("userTel") String userTel,
			@Param("peopleNum") String peopleNum, @Param("createTime") String createTime,
			@Param("updateTime") String updateTime, @Param("address") String address,
			@Param("checkStartTime") String checkStartTime, @Param("checkEndTime") String checkEndTime);
	
	// 根据ID查询直通车订单详情列表
	List<Map> queryTrainDetailList(@Param("t_id") String id);
}
package com.soft.web.dao.visa;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.soft.util.*;

/**
 * 签证dao
 * 
 * @author wang
 *
 */
@SuppressWarnings("rawtypes")
public interface VisaMapper {

	// 根据状态查询签证订单列表
	List<Map> queryVisaList(@Param("state") String state, @Param("page") Page page);
	
	int queryVisaListCount(@Param("state") String state);

	// 根据id修改签证当前状态（0初始值；1未沟通；2已沟通；3未成单；已成单；）
	int updateVisaStateById(@Param("state") String state,
			@Param("id") String id,
			@Param("updateTime") String updateTime);

	// 添加签证订单
	int addVisa(@Param("userName") String userName, @Param("userTel") String userTel,
			@Param("peopleNum") String peopleNum, @Param("createTime") String createTime,
			@Param("updateTime") String updateTime, @Param("address") String address,
			@Param("checkStartTime") String checkStartTime, @Param("checkEndTime") String checkEndTime);
}
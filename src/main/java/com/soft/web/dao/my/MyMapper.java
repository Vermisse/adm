package com.soft.web.dao.my;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 私人订制dao
 * 
 * @author wang
 *
 */
@SuppressWarnings("rawtypes")
public interface MyMapper {

	// 根据状态查询私人订制订单列表
	List<Map> queryMyList(@Param("state") String state);

	// 根据id修改私人订制当前状态（0初始值；1未沟通；2已沟通；3未成单；已成单；）
	int updateMyStateById(@Param("state") String state, @Param("id") String id,
			@Param("updateTime") String updateTime);

	// 添加私人订制订单
	int addMy(@Param("userName") String userName, @Param("userTel") String userTel,
			@Param("peopleNum") String peopleNum, @Param("createTime") String createTime,
			@Param("updateTime") String updateTime, @Param("tripMode") String address);
}
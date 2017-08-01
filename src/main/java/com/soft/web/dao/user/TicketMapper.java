package com.soft.web.dao.user;

import java.util.*;

import org.apache.ibatis.annotations.*;

public interface TicketMapper {
	
	List<Map> queryTickets(@Param("ticket_name") String ticket_name,
			@Param("ticket_price") Double ticket_price,
			@Param("state") String state);
	
	void save(@Param("ticket_name") String ticket_name,
			@Param("ticket_price") double ticket_price,
			@Param("filepath") String filepath);

	void edit(@Param("ticket_id") int ticket_id);
}
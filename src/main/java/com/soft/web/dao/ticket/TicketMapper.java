package com.soft.web.dao.ticket;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.soft.util.*;

public interface TicketMapper {
	
	List<Map> queryTickets(@Param("ticket_name") String ticket_name, @Param("page") Page page);
	
	int queryTicketsCount(@Param("ticket_name") String ticket_name);
	
	Map<String, Object> queryTicket(@Param("ticket_id") int ticket_id);
	
	void save(@Param("ticket_name") String ticket_name,
			@Param("ticket_price") double ticket_price,
			@Param("filepath") String filepath);
	
	void update(@Param("ticket_id") int ticket_id,
			@Param("ticket_name") String ticket_name,
			@Param("ticket_price") double ticket_price,
			@Param("filepath") String filepath);

	void edit(@Param("ticket_id") int ticket_id);
}
package com.soft.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.soft.util.*;
import com.soft.web.dao.ticket.*;

@Service
public class TicketService {

	@Autowired
	private TicketMapper mapper;
	
	public List<Map> queryTickets(String ticket_name, Page page) {
		return mapper.queryTickets(ticket_name, page);
	}
	
	public int queryTicketsCount(String ticket_name) {
		return mapper.queryTicketsCount(ticket_name);
	}
	
	public Map<String, Object> queryTicket(int ticket_id) {
		return mapper.queryTicket(ticket_id);
	}
	
	public void save(String ticket_name, double ticket_price, String filepath) {
		mapper.save(ticket_name, ticket_price, filepath);
	}
	
	public void update(int ticket_id,
			String ticket_name,
			double ticket_price,
			String filepath) {
		mapper.update(ticket_id, ticket_name, ticket_price, filepath);
	}

	public void edit(int ticket_id) {
		mapper.edit(ticket_id);
	}
}
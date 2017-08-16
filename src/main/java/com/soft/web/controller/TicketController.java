package com.soft.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.soft.util.*;
import com.soft.web.service.*;

/**
 * 门票Controller
 * 
 * @author vermisse
 */
@Controller
@RequestMapping("ticket")
public class TicketController {
	
	@Autowired
	private TicketService service;
	
	@RequestMapping("list")
	public String list(String ticket_name, Page page, Model model) {
		List<Map> list = service.queryTickets(ticket_name, page);
		int count = service.queryTicketsCount(ticket_name);
		page.setCount(count);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "manage/ticket/ticket";
	}
	
	@RequestMapping("add")
	public String add() {
		return "manage/ticket/ticketAdd";
	}

	@RequestMapping("save")
	public String save(String ticket_name, double ticket_price, String filepath) {
		service.save(ticket_name, ticket_price, filepath);
		return "redirect:/ticket/list.html";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(int ticket_id, Model model) {
		Map<String, Object> ticket = service.queryTicket(ticket_id);
		model.addAttribute("ticket", ticket);
		return "manage/ticket/ticketEdit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(int ticket_id,
			String ticket_name,
			double ticket_price,
			String filepath) {
		service.update(ticket_id, ticket_name, ticket_price, filepath);
		return "redirect:/ticket/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(int ticket_id) {
		service.edit(ticket_id);
		return "redirect:/ticket/list.html";
	}
}
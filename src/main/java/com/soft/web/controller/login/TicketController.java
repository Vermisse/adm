package com.soft.web.controller.login;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.soft.web.service.login.*;

@Controller
@RequestMapping("ticket")
public class TicketController {
	
	@Autowired
	private TicketService service;
	
	@RequestMapping("list")
	public String list(String ticket_name, Double ticket_price, String state, Model model) {
		List<Map> list = service.queryTickets(ticket_name, ticket_price, state);
		model.addAttribute("list", list);
		return "manage/ticket";
	}
	
	@RequestMapping("add")
	public String add() {
		return "manage/ticketAdd";
	}

	@RequestMapping("save")
	public String save(String ticket_name, double ticket_price, String filepath) {
		service.save(ticket_name, ticket_price, filepath);
		return "redirect:/ticket/list.html";
	}
	
	@RequestMapping("edit")
	public String edit(int ticket_id) {
		service.edit(ticket_id);
		return "redirect:/ticket/list.html";
	}
}
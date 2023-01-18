package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.entity.Ticket;
import com.greatlearning.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService service;

	/**
	 *  Fetch all tickets from DB
	 */
	@GetMapping("/list")
	public String listTickets(Model model) {
		List<Ticket> tickets = service.getAllTicket();
		model.addAttribute("tickets", tickets);
		return "tickets/list-tickets";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "tickets/ticket-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ticketId") int id, Model model) {
		Ticket ticket = service.findById(id);
		model.addAttribute("ticket", ticket);
		return "tickets/ticket-form-update";
	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		service.addTicket(ticket);
		return "redirect:/tickets/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("ticketId") int id) {
		service.deleteById(id);
		return "redirect:/tickets/list";
	}

	@GetMapping("/search")
	public String search(Model model, @Param("keyword") String keyword) {
		List<Ticket> tickets = service.findAllTickets(keyword);
		model.addAttribute("tickets", tickets);
		return "tickets/list-tickets";
	}

	@GetMapping("/view")
	public String listTickets(@RequestParam("ticketId") int id, Model model) {
		Ticket ticket = service.findById(id);
		model.addAttribute("ticket", ticket);
		return "tickets/index";
	}

}

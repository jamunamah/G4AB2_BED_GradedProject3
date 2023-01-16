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
	private TicketService ticketService;

	// add mapping for "/list"

	// getmapping to get the data from the server
	@GetMapping("/list")
	public String listTickets(Model theModel) {

		// get tickets from database aka calling service
		List<Ticket> theTickets = ticketService.getAllTicket();

		// add to the spring model aka setting property
		theModel.addAttribute("tickets", theTickets);

		return "tickets/list-tickets";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Ticket theTicket = new Ticket();

		theModel.addAttribute("ticket", theTicket);

		return "tickets/ticket-form";
	}

	// postmapping to post the data to the DB
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ticketId") int theId, Model theModel) {

		// get the book from the service
		Ticket theTicket = ticketService.findById(theId);

		// set book as a model attribute to pre-populate the form
		theModel.addAttribute("ticket", theTicket);

		// send over to our form
		return "tickets/ticket-form-update";
	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket theTicket) {

		// save the book
		ticketService.addTicket(theTicket);

		// use a redirect to prevent duplicate submissions
		return "redirect:/tickets/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("ticketId") int theId) {

		// delete the book
		ticketService.deleteById(theId);

		// redirect to /books/list , refreshing
		return "redirect:/tickets/list";
	}

	@GetMapping("/search")
	public String search(Model theModel, @Param("keyword") String keyword) {

		// find by keyword
		List<Ticket> tickets = ticketService.findAllTickets(keyword);

		theModel.addAttribute("tickets", tickets);

		return "tickets/list-tickets";
	}

	@GetMapping("/view")
	public String listTickets(@RequestParam("ticketId") int theId, Model theModel) {

		Ticket theTicket = ticketService.findById(theId);

		theModel.addAttribute("ticket", theTicket);

		return "tickets/index";
	}

}

package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Ticket;

public interface TicketService {

	List<Ticket> getAllTicket();

	Ticket addTicket(Ticket ticket);

	Ticket findById(int theId);

	void deleteById(int theId);

	List<Ticket> findAllTickets(String keyword);

}

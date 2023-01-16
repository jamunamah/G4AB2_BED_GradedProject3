package com.greatlearning.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.TicketRepository;
import com.greatlearning.entity.Ticket;
import com.greatlearning.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket addTicket(Ticket ticket) {
		return ticketRepository.saveAndFlush(ticket);
	}

	@Override
	public Ticket findById(int theId) {
		Optional<Ticket> result = ticketRepository.findById(theId);

		Ticket theTicket = null;

		if (result.isPresent()) {
			theTicket = result.get();
		} else
			try {
				throw new RuntimeException("Did not find book id - " + theId);
			} catch (Exception e) {
			}
		return theTicket;
	}

	@Override
	public void deleteById(int theId) {
		ticketRepository.deleteById(theId);
	}

	@Override
	public List<Ticket> findAllTickets(String keyword) {
		if (keyword != null) {
			return ticketRepository.search(keyword);
		}
		return ticketRepository.findAll();
	}
}

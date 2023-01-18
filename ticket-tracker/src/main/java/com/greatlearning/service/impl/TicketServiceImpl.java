package com.greatlearning.service.impl;

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
	TicketRepository repository;

	@Override
	public List<Ticket> getAllTicket() {
		return repository.findAll();
	}

	@Override
	public Ticket addTicket(Ticket ticket) {
		return repository.saveAndFlush(ticket);
	}

	@Override
	public Ticket findById(int id) {
		Optional<Ticket> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		throw new RuntimeException("Ticket not found for id: " + id);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Ticket> findAllTickets(String keyword) {
		if (keyword != null) {
			return repository.search(keyword);
		}
		return repository.findAll();
	}
}

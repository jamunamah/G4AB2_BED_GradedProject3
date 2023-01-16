package com.greatlearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.entity.Ticket;

//this layer talks to the DB
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	// Custom query for Search
	@Query(value = "SELECT ticket FROM Ticket ticket WHERE ticket.ticketTitle LIKE %?1% or ticket.ticketDescription LIKE %?1%")
	public List<Ticket> search(String keyword);
}
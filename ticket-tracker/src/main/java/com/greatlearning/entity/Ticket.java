package com.greatlearning.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "Ticket_Title")
	private String ticketTitle;

	@Column(name = "Ticket_Description")
	private String ticketDescription;

	@Column(name = "Ticket_Content")
	private String ticketContent;

	@Column(updatable = false, name = "Ticket_Created_On")
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@Column(name = "Ticket_Updated_On")
	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedDate;

}

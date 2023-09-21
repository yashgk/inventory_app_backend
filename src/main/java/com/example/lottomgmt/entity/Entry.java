package com.example.lottomgmt.entity;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "entry_tbl")
@JsonView(View.class)
public class Entry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(length = 20, nullable = false)
	private String date;

	@Column(nullable = false)
	private int rack_no;

	@Column(nullable = false)
	private int price;

	@Column(nullable = false)
	private int unit;

	@Column(nullable = false)
	private int total;

	@Column(length = 20)
	private String update_on;
}

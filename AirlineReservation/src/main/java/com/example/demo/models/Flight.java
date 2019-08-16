package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="flight_details")
public class Flight {
	
	@Id
	private long flight_number;
	private String flight_name;
	private double price;
	private int travel_time;
	private String source;
	private String destination;
	private int available_seats;

}

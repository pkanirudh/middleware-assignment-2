package com.example.demo.repos;


import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Flight;
import com.example.demo.models.User;

@Repository

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query(value="SELECT * FROM flight_details WHERE source=?1 AND destination=?2 AND available_seats>0",nativeQuery = true)
	public List<Flight> findAll(String source,String destination);

	@Query(value="SELECT cvv FROM user_card_details WHERE cvv=?1 AND card_number=?2 AND expiry_date=?3", nativeQuery = true)
	public List<Integer> validate(int cvv,long cardNumber,String date);
	
	@Query(value=" UPDATE flight_details SET available_seats = available_seats-1 WHERE flight_number=?1;", nativeQuery = true)
	public void reduceSeat(long flight_number);
}
//public interface FlightRepository extends CrudRepository<Flight, Long> {
//
////	@Query(value="select * from flight")
////	public List<Flight> findAll1();
//}



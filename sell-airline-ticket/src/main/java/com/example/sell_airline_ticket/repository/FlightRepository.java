package com.example.sell_airline_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sell_airline_ticket.entity.Flight;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query(value = "FROM Flight f " +
            "WHERE f.departure LIKE %:departure% " +
            "AND f.destination LIKE %:destination% " +
            "AND (CAST(f.depTime AS date) = :departureDate OR (:returnDate IS NOT NULL AND CAST(f.depTime AS date) = :returnDate))")
    List<Flight> searchFlights(@Param("departure") String departure, @Param("destination") String destination,
                               @Param("departureDate") LocalDate departureDate, @Param("returnDate") LocalDate returnDate);
}

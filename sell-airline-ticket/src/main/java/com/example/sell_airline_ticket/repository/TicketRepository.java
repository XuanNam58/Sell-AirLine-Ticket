package com.example.sell_airline_ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sell_airline_ticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Modifying
    @Query("DELETE FROM Ticket t WHERE t.flight.flightID = :flightID AND t.seatNum = :seatNum")
    void deleteByFlightIDAndSeatNum(@Param("flightID") Integer flightID, @Param("seatNum") Integer seatNum);

    @Query("FROM Ticket t WHERE t.user.userID = :userID")
    List<Ticket> getAllTicketOfCus(@Param("userID") String userID);

    @Query("FROM Ticket t WHERE t.flight.flightID = :flightId")
    List<com.example.sell_airline_ticket.entity.Ticket> searchTickets(@Param("flightId") int flightId);
}

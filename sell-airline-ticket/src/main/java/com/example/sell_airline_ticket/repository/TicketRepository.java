package com.example.sell_airline_ticket.repository;

import com.example.sell_airline_ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    @Modifying
    @Query("DELETE FROM Ticket t WHERE t.flight.flightID = :flightID AND t.seatNum = :seatNum")
    void deleteByFlightIDAndSeatNum(@Param("flightID") Integer flightID, @Param("seatNum") Integer seatNum);
}

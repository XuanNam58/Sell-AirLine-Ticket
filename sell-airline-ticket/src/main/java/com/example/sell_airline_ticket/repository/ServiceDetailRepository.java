package com.example.sell_airline_ticket.repository;

import com.example.sell_airline_ticket.entity.ServiceDetail;
import com.example.sell_airline_ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetail, Integer> {
    @Modifying
    @Query("DELETE FROM ServiceDetail sv WHERE sv.ticket.ticketID = (SELECT t.ticketID FROM Ticket t WHERE t.flight.flightID = :flightID AND t.seatNum = :seatNum)")
    void deleteServiceDetailByFlightIDAndSeatNum(@Param("flightID") Integer flightID, @Param("seatNum") Integer seatNum);
}

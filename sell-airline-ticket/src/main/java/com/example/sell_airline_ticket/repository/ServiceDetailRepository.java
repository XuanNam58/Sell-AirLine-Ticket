package com.example.sell_airline_ticket.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sell_airline_ticket.entity.ServiceDetail;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetail, Integer> {
    @Modifying
    @Query(
            value =
                    "DELETE FROM ServiceDetail WHERE ticketId = (SELECT t.Ticket_Id FROM Ticket t WHERE t.Flight_Id = :flightID AND t.Seat_Num = :seatNum)",
            nativeQuery = true)
    void deleteServiceDetailByFlightIDAndSeatNum(
            @Param("flightID") Integer flightID, @Param("seatNum") Integer seatNum);

    @Query("FROM ServiceDetail sd WHERE sd.ticket.ticketID = :ticketId AND sd.service.serviceId = :serviceId")
    ServiceDetail getServiceDetailByTS(@Param("ticketId") int ticketId, @Param("serviceId") String serviceId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ServiceDetail sd WHERE sd.ticket.ticketID = :ticketId")
    void deleteByTicketId(@Param("ticketId") int ticketId);
}

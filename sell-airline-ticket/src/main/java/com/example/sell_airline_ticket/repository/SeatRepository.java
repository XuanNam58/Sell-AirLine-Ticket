package com.example.sell_airline_ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sell_airline_ticket.dto.response.CustomerResponse;
import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
    //    @Query("SELECT new com.example.sell_airline_ticket.dto.response.SeatResponse(s.seatID, s.seatNum, " +
    //            " CASE WHEN t.seatNum IS NOT NULL THEN 'True' ELSE 'False' END)" +
    //            " FROM Seat s" +
    //            " LEFT JOIN Ticket t ON s.seatNum = t.seatNum" +
    //            " WHERE t.flight.flightID = :flightID)")
    @Query("SELECT new com.example.sell_airline_ticket.dto.response.SeatResponse(s.seatID, s.seatNum, "
            + " (CASE WHEN t.seatNum IS NOT NULL THEN true ELSE false END)) "
            + " FROM Seat s"
            + " LEFT JOIN Ticket t ON s.seatNum = t.seatNum AND t.flight.flightID = :flightID"
            + " ORDER BY s.seatNum")
    List<SeatResponse> getSeats(@Param("flightID") Integer flightID);

    @Query("FROM Seat s " + "INNER JOIN Ticket t ON s.seatNum = t.seatNum AND t.flight.flightID = :flightID "
            + "WHERE t.flight.flightID = :flightID")
    List<Seat> getSeatsInTicket(@Param("flightID") Integer flightID);

    @Query("FROM Seat s " + "INNER JOIN Flight f ON s.plane.planeID = f.plane.planeID "
            + "WHERE f.flightID = :flightID")
    List<Seat> getSeatsInFlight(@Param("flightID") Integer flightID);

    //    @Query("SELECT new com.example.sell_airline_ticket.dto.response.CustomerResponse(s.userID, s.name, s.phoneNum)
    // " +
    //            "FROM User s " +
    //            "INNER JOIN (SELECT user FROM Ticket " +
    //            "   WHERE flight.flightID = :flightID " +
    //            "           AND seatNum = (SELECT seatNum FROM Seat WHERE seatID = :seatID)) AS t ON s.userID =
    // t.user.userID ")
    @Query("SELECT new com.example.sell_airline_ticket.dto.response.CustomerResponse(u.userID, u.name, u.phoneNum) "
            + "FROM Ticket t "
            + "JOIN t.user u "
            + "JOIN Seat seat ON t.seatNum = seat.seatNum "
            + "WHERE t.flight.flightID = :flightID "
            + "AND seat.seatID = :seatID")
    CustomerResponse getCustomerInfo(@Param("flightID") Integer flightID, @Param("seatID") String seatID);
}

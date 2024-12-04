package com.example.sell_airline_ticket.dto.response;

import com.example.sell_airline_ticket.entity.Flight;
import com.example.sell_airline_ticket.entity.Ticket;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightTicketResponse {
     int ticketId;
     int flightID;
     String departure;
     String destination;
     LocalDateTime depTime;
     LocalDateTime ArrTime;
     int seatNum;
     boolean status;

     public FlightTicketResponse(Ticket ticket, Flight flight) {
          this.ticketId = ticket.getTicketID();
          this.flightID = flight.getFlightID();
          this.departure = flight.getDeparture();
          this.destination = flight.getDestination();
          this.depTime = flight.getDepTime();
          this.ArrTime = flight.getArrTime();
          this.seatNum = ticket.getSeatNum();
          this.status = ticket.getStatus();
     }
}

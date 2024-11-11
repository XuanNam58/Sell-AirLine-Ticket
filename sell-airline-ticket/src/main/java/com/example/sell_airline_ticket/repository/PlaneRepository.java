package com.example.sell_airline_ticket.repository;

import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.entity.Plane;
import com.example.sell_airline_ticket.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {

}

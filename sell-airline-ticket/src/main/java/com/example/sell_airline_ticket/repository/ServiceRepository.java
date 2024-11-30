package com.example.sell_airline_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sell_airline_ticket.entity.Service;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {

}

package com.example.sell_airline_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sell_airline_ticket.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {
}

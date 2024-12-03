package com.example.sell_airline_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sell_airline_ticket.entity.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {}

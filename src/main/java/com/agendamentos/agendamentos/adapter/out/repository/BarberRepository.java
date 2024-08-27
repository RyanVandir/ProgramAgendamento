package com.agendamentos.agendamentos.adapter.out.repository;

import com.agendamentos.agendamentos.adapter.out.entity.BarberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends JpaRepository<BarberEntity, String> {
}
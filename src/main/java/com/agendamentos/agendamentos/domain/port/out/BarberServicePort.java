package com.agendamentos.agendamentos.domain.port.out;

import com.agendamentos.agendamentos.adapter.out.entity.BarberEntity;
import com.agendamentos.agendamentos.domain.model.BarberModel;

import java.util.List;

public interface BarberServicePort {
    BarberModel createdBarber(BarberEntity barberEntity);

    List<BarberModel> findAllBarbers();

    BarberModel findByDocument(String documentBarber);
}
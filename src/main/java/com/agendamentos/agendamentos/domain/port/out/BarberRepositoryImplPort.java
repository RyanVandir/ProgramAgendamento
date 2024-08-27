package com.agendamentos.agendamentos.domain.port.out;

import com.agendamentos.agendamentos.adapter.out.entity.BarberEntity;
import com.agendamentos.agendamentos.domain.model.BarberModel;

import java.util.List;

public interface BarberRepositoryImplPort {

    List<BarberModel> findAllBarbers();

    BarberModel createdBarber(BarberEntity barberEntity);

    BarberModel findByDocument(String documentBarber);
}
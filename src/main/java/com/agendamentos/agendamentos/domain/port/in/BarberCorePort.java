package com.agendamentos.agendamentos.domain.port.in;

import com.agendamentos.agendamentos.adapter.in.request.BarberRequest;
import com.agendamentos.agendamentos.domain.model.BarberModel;

import java.util.List;

public interface BarberCorePort {

    List<BarberRequest> findAllBarbers();

    BarberRequest createdBarber(BarberModel barberModel);

    BarberRequest findByDocument(String documentBarber);
}
package com.agendamentos.agendamentos.domain.port.out;

import com.agendamentos.agendamentos.adapter.in.request.ClientRequest;
import com.agendamentos.agendamentos.adapter.out.entity.ClientEntity;
import com.agendamentos.agendamentos.domain.model.ClientModel;

import java.util.List;

public interface ClientServicePort {

    List<ClientModel> findAllClient();

    ClientModel createdClient(ClientEntity clientEntity);

    ClientModel findByEmail(String Email);
}
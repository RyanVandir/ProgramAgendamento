package com.agendamentos.agendamentos.domain.port.in;

import com.agendamentos.agendamentos.adapter.in.request.ClientRequest;
import com.agendamentos.agendamentos.domain.model.ClientModel;

import java.util.List;

public interface ClientCorePort {

    List<ClientRequest> findAllClient();

    ClientRequest createdClient(ClientModel clientModel);

    ClientRequest findByEmail(String Email);

}
package com.agendamentos.agendamentos.domain.core;

import com.agendamentos.agendamentos.adapter.in.request.ClientRequest;
import com.agendamentos.agendamentos.domain.mapper.ClientMapper;
import com.agendamentos.agendamentos.domain.model.ClientModel;
import com.agendamentos.agendamentos.domain.port.in.ClientCorePort;
import com.agendamentos.agendamentos.domain.port.out.ClientServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCore implements ClientCorePort {
    private final ClientMapper clientMapper;
    private final ClientServicePort clientServicePort;

    @Override
    public List<ClientRequest> findAllClient() {
        List<ClientModel> clients = clientServicePort.findAllClient();
        return clientMapper.toRequest(clients);
    }

    @Override
    public ClientRequest createdClient(ClientModel clientModel) {
        ClientModel result = clientServicePort.createdClient(clientMapper.toEntity(clientModel));
        return clientMapper.toRequest(result);
    }

    @Override
    public ClientRequest findByEmail(String email) {
        ClientModel clientModel = clientServicePort.findByEmail(email);
        return clientMapper.toRequest(clientModel);
    }
}
package com.agendamentos.agendamentos.adapter.out.service;

import com.agendamentos.agendamentos.adapter.out.entity.ClientEntity;
import com.agendamentos.agendamentos.adapter.out.repository.ClientRepository;
import com.agendamentos.agendamentos.domain.mapper.ClientMapper;
import com.agendamentos.agendamentos.domain.model.ClientModel;
import com.agendamentos.agendamentos.domain.port.out.ClientServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientServicePort {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Override
    public List<ClientModel> findAllClient() {
        List<ClientEntity> clients = clientRepository.findAll();
        return clientMapper.toModel(clients);
    }

    @Override
    public ClientModel createdClient(ClientEntity clientEntity) {
        return clientMapper.toModel(clientRepository.save(clientEntity));
    }

    @Override
    public ClientModel findByEmail(String Email) {
        Optional<ClientEntity> clientEntity = clientRepository.findById(Email);
        if (clientEntity.isEmpty())
            throw new RuntimeException("Cliente não encontrado");
        return clientMapper.toModel(clientEntity.get());
    }
}
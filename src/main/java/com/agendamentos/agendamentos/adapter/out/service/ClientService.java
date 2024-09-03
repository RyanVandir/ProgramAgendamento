package com.agendamentos.agendamentos.adapter.out.service;

import com.agendamentos.agendamentos.adapter.out.entity.ClientEntity;
import com.agendamentos.agendamentos.adapter.out.repository.ClientRepository;
import com.agendamentos.agendamentos.domain.mapper.ClientMapper;
import com.agendamentos.agendamentos.domain.model.ClientModel;
import com.agendamentos.agendamentos.domain.port.out.ClientServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService implements ClientServicePort {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Override
    public List<ClientModel> findAllClient() {
        try {
            List<ClientEntity> clients = clientRepository.findAll();
            log.info("Clientes encontrados: {}", clients);
            return clientMapper.toModel(clients);
        } catch (RuntimeException ex) {
            log.error("Banco de dados indisponivel: {}", ex.getMessage());
            throw new RuntimeException("Serviço temporariamente indisponivel!");
        }

    }

    @Override
    public ClientModel createdClient(ClientEntity clientEntity) {
        try {
            ClientModel save = clientMapper.toModel(clientRepository.save(clientEntity));
            log.info("Novo cliente: {}", save.getName());
            return save;
        } catch (RuntimeException ex) {
            log.error("Falha criação d dados, {}", ex.getMessage());
            throw new RuntimeException("Falha ao criar seu cadastro!");
        }
    }

    @Override
    public ClientModel findByEmail(String email) {
        log.info("Buscando cliente: {}", email);
        try {
            Optional<ClientEntity> clientEntity = clientRepository.findById(email);
            ClientModel response = clientMapper.toModel(clientEntity.get());
            log.info("Cliente encontrado, {}", response.getName());
            return response;
        } catch (RuntimeException ex) {
            throw new RuntimeException("Cliente não existente");
        }
    }
}
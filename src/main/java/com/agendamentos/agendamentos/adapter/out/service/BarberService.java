package com.agendamentos.agendamentos.adapter.out.service;

import com.agendamentos.agendamentos.adapter.out.entity.BarberEntity;
import com.agendamentos.agendamentos.adapter.out.repository.BarberRepository;
import com.agendamentos.agendamentos.domain.mapper.BarberMapper;
import com.agendamentos.agendamentos.domain.model.BarberModel;
import com.agendamentos.agendamentos.domain.port.out.BarberServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BarberService implements BarberServicePort {
    private final BarberMapper barberMapper;
    private final BarberRepository barberRepository;

    @Override
    public List<BarberModel> findAllBarbers() {
        try {
            List<BarberEntity> barbers = barberRepository.findAll();
            log.info("Babeiros encontrados: {}", barbers);
            return barberMapper.toModel(barbers);
        } catch (RuntimeException ex) {
            log.error("Banco de dados indisponivel: {}", ex.getMessage());
            throw new RuntimeException("Serviço temporariamente indisponivel");
        }

    }

    @Override
    public BarberModel createdBarber(BarberEntity barberEntity) {
        try {
            BarberModel save = barberMapper.toModel(barberRepository.save(barberEntity));
            log.info("Novo barbeiro: {}", save.getName());
            return save;
        } catch (RuntimeException ex) {
            log.error("Falha criação de dados: {}", ex.getMessage());
            throw new RuntimeException("Falha ao criar seu cadastro");
        }
    }

    @Override
    public BarberModel findByDocument(String documentBarber) {
        log.info("Buscando barbeiro, {}", documentBarber);
       try {
           Optional<BarberEntity> barberEntity = barberRepository.findById(documentBarber);
           BarberModel response = barberMapper.toModel(barberEntity.get());
           log.info("Barbeiro encontrado: {}", response.getName());
           return response;
       } catch (RuntimeException ex) {
           throw new RuntimeException("Barbeiro não existente");
       }
    }
}
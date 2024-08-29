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
            return barberMapper.toModel(barbers);
        } catch (RuntimeException ex) {
            log.error("Banco de dados indisponivel: {}", ex.getMessage());
            throw new RuntimeException("Serviço temporariamente indisponivel");
        }

    }

    @Override
    public BarberModel createdBarber(BarberEntity barberEntity) {
        return barberMapper.toModel(this.barberRepository.save(barberEntity));
    }

    @Override
    public BarberModel findByDocument(String documentBarber) {
        Optional<BarberEntity> barberEntity = barberRepository.findById(documentBarber);
        if (barberEntity.isEmpty())
            throw new RuntimeException("Barbeiro não existente");
        return barberMapper.toModel(barberEntity.get());
    }
}
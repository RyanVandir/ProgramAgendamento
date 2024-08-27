package com.agendamentos.agendamentos.adapter.out.repository;

import com.agendamentos.agendamentos.adapter.out.entity.BarberEntity;
import com.agendamentos.agendamentos.domain.mapper.BarberMapper;
import com.agendamentos.agendamentos.domain.model.BarberModel;
import com.agendamentos.agendamentos.domain.port.out.BarberRepositoryImplPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BarberRepositoryImpl implements BarberRepositoryImplPort {
    private final BarberMapper barberMapper;
    private final BarberRepository barberRepository;

    @Override
    public List<BarberModel> findAllBarbers() {
        List<BarberEntity> barbers = barberRepository.findAll();
        return barberMapper.toModel(barbers);
    }

    @Override
    public BarberModel createdBarber(BarberEntity barberEntity) {
        return barberMapper.toModel(barberRepository.save(barberEntity));
    }

    @Override
    public BarberModel findByDocument(String documentBarber) {
        Optional<BarberEntity> barberEntity = barberRepository.findById(documentBarber);
        if (barberEntity.isEmpty())
            throw new RuntimeException("Barbeiro não existente");
        return barberMapper.toModel(barberEntity.get());
    }
}

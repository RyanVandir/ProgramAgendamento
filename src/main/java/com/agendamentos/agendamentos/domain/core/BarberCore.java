package com.agendamentos.agendamentos.domain.core;

import com.agendamentos.agendamentos.adapter.in.request.BarberRequest;
import com.agendamentos.agendamentos.adapter.out.entity.BarberEntity;
import com.agendamentos.agendamentos.domain.mapper.BarberMapper;
import com.agendamentos.agendamentos.domain.model.BarberModel;
import com.agendamentos.agendamentos.domain.port.in.BarberCorePort;
import com.agendamentos.agendamentos.domain.port.out.BarberRepositoryImplPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarberCore implements BarberCorePort {
    private final BarberMapper barberMapper;
    private final BarberRepositoryImplPort barberRepositoryImplPort;

    @Override
    public List<BarberRequest> findAllBarbers() {
        List<BarberModel> barbers = barberRepositoryImplPort.findAllBarbers();
        return barberMapper.toRequest(barbers);
    }

    @Override
    public BarberRequest createdBarber(BarberModel barberModel) {
        BarberEntity barberEntity = barberMapper.toEntity(barberModel);
        BarberModel result = barberRepositoryImplPort.createdBarber(barberEntity);
        return barberMapper.toRequest(result);
    }

    @Override
    public BarberRequest findByDocument(String documentBarber) {
        BarberModel barberModel = barberRepositoryImplPort.findByDocument(documentBarber);
        return barberMapper.toRequest(barberModel);
    }
}
package com.agendamentos.agendamentos.domain.mapper;

import com.agendamentos.agendamentos.adapter.in.request.BarberRequest;
import com.agendamentos.agendamentos.adapter.out.entity.BarberEntity;
import com.agendamentos.agendamentos.domain.model.BarberModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BarberMapper {

    BarberModel toModel(BarberRequest barberRequest);

    BarberRequest toRequest(BarberModel barberModel);

    BarberModel toModel(BarberEntity barberEntity);

    BarberEntity toEntity(BarberModel barberModel);

    List<BarberRequest> toRequest(List<BarberModel> barberModels);

    List<BarberModel> toModel(List<BarberEntity> barberEntities);
}
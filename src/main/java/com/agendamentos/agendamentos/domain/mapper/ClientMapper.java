package com.agendamentos.agendamentos.domain.mapper;

import com.agendamentos.agendamentos.adapter.in.request.ClientRequest;
import com.agendamentos.agendamentos.adapter.out.entity.ClientEntity;
import com.agendamentos.agendamentos.domain.model.ClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    ClientRequest toRequest(ClientModel clientModel);

    ClientModel toModel(ClientRequest clientRequest);

    List<ClientRequest> toRequest(List<ClientModel> clientModels);

    ClientModel toModel(ClientEntity clientEntity);

    ClientEntity toEntity(ClientModel clientModel);

    List<ClientModel> toModel(List<ClientEntity> clientEntities);
}
package com.agendamentos.agendamentos.adapter.in.controller;

import com.agendamentos.agendamentos.adapter.in.request.ClientRequest;
import com.agendamentos.agendamentos.domain.mapper.ClientMapper;
import com.agendamentos.agendamentos.domain.model.ClientModel;
import com.agendamentos.agendamentos.domain.port.in.ClientCorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientCorePort clientCorePort;
    private final ClientMapper clientMapper;

    @PostMapping
    public ClientRequest createdClient(@RequestBody ClientRequest clientRequest) {
        return clientCorePort.createdClient(clientMapper.toModel(clientRequest));
    }

    @GetMapping("/{emailClient}")
    public ClientRequest findByClient(@PathVariable String Email) {
        return clientCorePort.findByEmail(Email);
    }

    @GetMapping
    public List<ClientRequest> findAllClient() {
        return clientCorePort.findAllClient();
    }
}

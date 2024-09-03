package com.agendamentos.agendamentos.adapter.in.controller;

import com.agendamentos.agendamentos.adapter.in.request.ClientRequest;
import com.agendamentos.agendamentos.domain.mapper.ClientMapper;
import com.agendamentos.agendamentos.domain.port.in.ClientCorePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientCorePort clientCorePort;
    private final ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity createdClient(@RequestBody ClientRequest clientRequest) {
        log.info("Cliente {}, email {}. Solicitou uma criação.", clientRequest.getName(), clientRequest.getEmail());
        try {
            ClientRequest response = clientCorePort.createdClient(clientMapper.toModel(clientRequest));
            log.info("Cliente {}, email {}. Criado com sucesso!", clientRequest.getName(), clientRequest.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException ex) {
            log.warn(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/{emailClient}")
    public ResponseEntity findByClient(@PathVariable String email) {
        log.info("Buscando cliente: {}", email);
        try {
            ClientRequest response = clientCorePort.findByEmail(email);
            log.info("Cliente encontrado: {}", response.getName());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (RuntimeException ex) {
            log.warn(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public List<ClientRequest> findAllClient() {
        return clientCorePort.findAllClient();
    }
}
package com.agendamentos.agendamentos.adapter.in.controller;

import com.agendamentos.agendamentos.adapter.in.request.BarberRequest;
import com.agendamentos.agendamentos.adapter.out.entity.BarberEntity;
import com.agendamentos.agendamentos.domain.mapper.BarberMapper;
import com.agendamentos.agendamentos.domain.port.in.BarberCorePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("barber")
@RequiredArgsConstructor
@Slf4j
public class BarberController {
    private final BarberCorePort barberCorePort;
    private final BarberMapper barberMapper;

    @GetMapping
    public List<BarberRequest> findAllBarbers() {
        return barberCorePort.findAllBarbers();
    }

    @GetMapping("/{documentBarber}")
    public ResponseEntity<BarberRequest> findByBarber(@PathVariable String documentBarber) {
        log.info("Buscando barbeiro {}", documentBarber);
        try {
            BarberRequest response = barberCorePort.findByDocument(documentBarber);
            log.info("Barbeiro {}, encontrado!", response.getName());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (RuntimeException ex) {
            log.warn(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping
    public ResponseEntity createdBarber(@RequestBody BarberRequest barberRequest) {
        log.info("Barbeiro {}, cpf {}. Solicitou uma criação.", barberRequest.getName(), barberRequest.getDocument());
        try {
            BarberRequest response = barberCorePort.createdBarber(barberMapper.toModel(barberRequest));
            log.info("Barbeiro {}, cpf {}. Criado com sucesso!", barberRequest.getName(), barberRequest.getDocument());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException ex) {
            log.warn(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
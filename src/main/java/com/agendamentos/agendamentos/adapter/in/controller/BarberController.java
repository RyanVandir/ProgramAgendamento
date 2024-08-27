package com.agendamentos.agendamentos.adapter.in.controller;

import com.agendamentos.agendamentos.adapter.in.request.BarberRequest;
import com.agendamentos.agendamentos.domain.mapper.BarberMapper;
import com.agendamentos.agendamentos.domain.port.in.BarberCorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("barber")
@RequiredArgsConstructor
public class BarberController {
    private final BarberCorePort barberCorePort;
    private final BarberMapper barberMapper;

    @GetMapping
    public List<BarberRequest> findAllBarbers() {
        return barberCorePort.findAllBarbers();
    }

    @GetMapping("/{documentBarber}")
    public BarberRequest findByBarber(@PathVariable String documentBarber) {
        return barberCorePort.findByDocument(documentBarber);
    }

    @PostMapping
    public BarberRequest createdBarber(@RequestBody BarberRequest barberRequest) {
        return barberCorePort.createdBarber(barberMapper.toModel(barberRequest));
    }
}
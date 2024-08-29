package com.agendamentos.agendamentos.adapter.in.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BarberRequest {
    String document;
    String name;
    String email;
    String phone;
    String password;
}
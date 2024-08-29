package com.agendamentos.agendamentos.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientModel {
    String name;
    String email;
    String password;
    String phone;
}
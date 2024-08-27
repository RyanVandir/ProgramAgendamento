package com.agendamentos.agendamentos.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BarberModel {
    String document;
    String name;
    String email;
    String phone;
    String passWord;
}
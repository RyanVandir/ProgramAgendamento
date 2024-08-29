package com.agendamentos.agendamentos.adapter.out.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class BarberEntity {
    @Id
    String document;
    String name;
    String email;
    String phone;
    String password;
}
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
public class ClientEntity {
    String name;
    @Id
    String email;
    String password;
    String phone;
}
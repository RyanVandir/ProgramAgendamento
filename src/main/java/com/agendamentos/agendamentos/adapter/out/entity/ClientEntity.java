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
    @Id
    String email;
    String name;
    String password;
    String phone;
}
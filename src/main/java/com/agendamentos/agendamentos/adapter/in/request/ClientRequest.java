package com.agendamentos.agendamentos.adapter.in.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientRequest {
    String name;
    String email;
    String password;
    String phone;
}

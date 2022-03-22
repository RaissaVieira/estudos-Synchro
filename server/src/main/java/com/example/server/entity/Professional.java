package com.example.server.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "tb_professional")
@Data
public class Professional implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "Name can't be empty")
    private String name;

    @Column(length = 11)
    @NotBlank(message = "CPF can't be empty")
    private String cpf;

    @Column(length = 8)
    @NotBlank(message = "Birthday can't be empty")
    private String birthday;

    @Column(length = 11)
    @NotBlank(message = "Whatsapp can't be empty")
    private String whatsapp;

    @Column
    @NotBlank(message = "Profession can't be empty")
    private String profession;

    @Column
    @NotBlank(message = "Bio can't be empty")
    private String bio;

}

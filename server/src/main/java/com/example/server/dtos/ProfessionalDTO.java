package com.example.server.dtos;

import com.example.server.entity.Professional;
import lombok.Data;

@Data
public class ProfessionalDTO {
    private String name;
    private String profession;
    private String whatsapp;
    private String bio;

    public ProfessionalDTO(String name, String profession, String whatsapp, String bio) {
        this.name = name;
        this.profession = profession;
        this.whatsapp = whatsapp;
        this.bio = bio;
    }

    public static ProfessionalDTO professionalDTO(Professional professional) {
        return new ProfessionalDTO(professional.getName(), professional.getProfession(), professional.getWhatsapp(), professional.getBio());
    }
}

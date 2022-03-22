package com.example.server.service;

import com.example.server.dtos.ProfessionalDTO;
import com.example.server.entity.Professional;
import com.example.server.repository.ProfessionalRepository;
import com.example.server.service.CustomException.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProfessionalService {
    @Autowired
    private ProfessionalRepository professionalRepository;

    // Register a new professional
    public Professional registerProfessional(Professional professional) throws CustomException {
        Optional<Professional> searchProfessional = professionalRepository.findByCpf(professional.getCpf());

        if(searchProfessional.isPresent()) {
            throw new CustomException("CPF already registered", HttpStatus.BAD_REQUEST);
        }

        return professionalRepository.save(professional);
    }

    // Get all professionals
    public List<ProfessionalDTO> getAllProfessionals() throws CustomException {
        List<ProfessionalDTO> listProfessionals = new ArrayList<>();

        for (Professional p: professionalRepository.findAll()) {
            listProfessionals.add(ProfessionalDTO.professionalDTO(p));
        }

        return listProfessionals;
    }

    // Find professional by CPF
    public Optional<Professional> findProfessionalByCpf(String cpf) throws CustomException{
        Optional<Professional> searchProfessional = professionalRepository.findByCpf(cpf);

        if(searchProfessional.isEmpty()) {
            throw new CustomException("CPF not registered", HttpStatus.NOT_FOUND);
        }

        return professionalRepository.findByCpf(cpf);
    }

    // Update professional
    public Professional updateProfessional(String cpf, Professional professional) {
        Optional<Professional> searchProfessional = professionalRepository.findByCpf(cpf);

        if (searchProfessional.isEmpty()) {
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }

        professional.setId(searchProfessional.get().getId());
        return professionalRepository.save(professional);
    }

    // Delete professional
    public String removeProfessional(String cpf) {
        Optional<Professional> searchProfessional = professionalRepository.findByCpf(cpf);

        if (searchProfessional.isEmpty()) {
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }

        professionalRepository.deleteProfessionalByCpf(cpf);
        return "Professional successfully deleted";
    }
}

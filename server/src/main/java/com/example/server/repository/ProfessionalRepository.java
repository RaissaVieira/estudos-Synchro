package com.example.server.repository;

import com.example.server.entity.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

    Professional save(Professional professional);

    Optional<Professional> findByCpf(String cpf);

    List<Professional> findAll();

    void deleteProfessionalByCpf(String cpf);
}

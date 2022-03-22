package com.example.server.controller;

import com.example.server.controller.response.Response;
import com.example.server.entity.Professional;
import com.example.server.service.CustomException.CustomException;
import com.example.server.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {
    @Autowired
    private ProfessionalService professionalService;

    @PostMapping()
    public ResponseEntity<?> registerProfessional(@RequestBody @Valid Professional professional) {
        try{
            return new ResponseEntity<>(professionalService.registerProfessional(professional), HttpStatus.CREATED);
        }catch (CustomException e){
            return new ResponseEntity<>(
                    new Response(e.getStatus(), e.getMessage()), e.getStatus());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllProfessionals() {
        try{
            return new ResponseEntity<>(professionalService.getAllProfessionals(), HttpStatus.OK);
        }catch (CustomException e){
            return new ResponseEntity<>(
                    new Response(e.getStatus(), e.getMessage()), e.getStatus());
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> getProfessionalByCpf(@PathVariable String cpf) {
        try{
            return new ResponseEntity<>(professionalService.findProfessionalByCpf(cpf), HttpStatus.FOUND);
        }catch (CustomException e){
            return new ResponseEntity<>(
                    new Response(e.getStatus(), e.getMessage()), e.getStatus());
        }
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<?> updateProfessional(@PathVariable String cpf, @RequestBody Professional professional) {
        try{
            return new ResponseEntity<>(professionalService.updateProfessional(cpf, professional), HttpStatus.NO_CONTENT);
        }catch (CustomException e){
            return new ResponseEntity<>(
                    new Response(e.getStatus(), e.getMessage()), e.getStatus());
        }
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> removeProfessional(@PathVariable String cpf) {
        try{
            return new ResponseEntity<>(professionalService.removeProfessional(cpf), HttpStatus.NO_CONTENT);
        }catch (CustomException e){
            return new ResponseEntity<>(
                    new Response(e.getStatus(), e.getMessage()), e.getStatus());
        }
    }
}

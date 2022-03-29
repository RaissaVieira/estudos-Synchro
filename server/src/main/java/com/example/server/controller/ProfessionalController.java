package com.example.server.controller;

import com.example.server.controller.response.Response;
import com.example.server.entity.Professional;
import com.example.server.service.CustomException.CustomException;
import com.example.server.service.ProfessionalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Create a new professional")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully registered professional", response = Response.class),
            @ApiResponse(code = 400, message = "CPF already registered", response = Response.class)
    })
    @PostMapping()
    public ResponseEntity<?> registerProfessional(@RequestBody @Valid Professional professional) {
        try{
            return new ResponseEntity<>(professionalService.registerProfessional(professional), HttpStatus.CREATED);
        }catch (CustomException e){
            return new ResponseEntity<>(
                    new Response(e.getStatus(), e.getMessage()), e.getStatus());
        }
    }

    @ApiOperation(value = "Return a list with all the professionals")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the list professionals", response = Response.class),
            @ApiResponse(code = 404, message = "Error on server", response = Response.class)
    })
    @GetMapping()
    public ResponseEntity<?> getAllProfessionals() {
        try{
            return new ResponseEntity<>(professionalService.getAllProfessionals(), HttpStatus.OK);
        }catch (CustomException e){
            return new ResponseEntity<>(
                    new Response(e.getStatus(), e.getMessage()), e.getStatus());
        }
    }

    @ApiOperation(value = "Find a professional by CPF")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the user", response = Response.class),
            @ApiResponse(code = 404, message = "Professional not found", response = Response.class)
    })
    @GetMapping("/{cpf}")
    public ResponseEntity<?> getProfessionalByCpf(@PathVariable String cpf) {
        try{
            return new ResponseEntity<>(professionalService.findProfessionalByCpf(cpf), HttpStatus.OK);
        }catch (CustomException e){
            return new ResponseEntity<>(
                    new Response(e.getStatus(), e.getMessage()), e.getStatus());
        }
    }

    @ApiOperation(value = "Update a professional")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated professional", response = Response.class),
            @ApiResponse(code = 404, message = "Professional not found", response = Response.class)
    })
    @PutMapping("/{cpf}")
    public ResponseEntity<?> updateProfessional(@PathVariable String cpf, @RequestBody Professional professional) {
        try{
            return new ResponseEntity<>(professionalService.updateProfessional(cpf, professional), HttpStatus.NO_CONTENT);
        }catch (CustomException e){
            return new ResponseEntity<>(
                    new Response(e.getStatus(), e.getMessage()), e.getStatus());
        }
    }

    @ApiOperation(value = "Delete a professional")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted professional", response = Response.class),
            @ApiResponse(code = 404, message = "Professional not found", response = Response.class)
    })
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

package com.mindhub.tiendaderopa.controllers;


import com.mindhub.tiendaderopa.dtos.ClienteDTO;
import com.mindhub.tiendaderopa.modelos.Cliente;
import com.mindhub.tiendaderopa.repositorios.ClienteRepositorio;
import com.mindhub.tiendaderopa.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClienteControlador {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ClienteServicio clienteServicio;

    @RequestMapping("/clientes")
    public List<ClienteDTO> getArticulos(){
        return clienteServicio.getArticulos();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Object> registrarCliente(
            @RequestParam String nombre, @RequestParam String apellido,
            @RequestParam String email , @RequestParam String password){

        if(nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || password.isEmpty()){
            return new ResponseEntity<>("datos invalidos", HttpStatus.FORBIDDEN);
        }

        Cliente cliente = new Cliente(nombre,apellido,email,passwordEncoder.encode(password));
        clienteServicio.saveCliente(cliente);
        return new ResponseEntity<>("Cliente creado con éxito", HttpStatus.CREATED);

    }
}

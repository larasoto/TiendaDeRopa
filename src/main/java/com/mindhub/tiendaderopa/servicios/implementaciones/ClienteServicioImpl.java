package com.mindhub.tiendaderopa.servicios.implementaciones;

import com.mindhub.tiendaderopa.dtos.ClienteDTO;
import com.mindhub.tiendaderopa.modelos.Cliente;
import com.mindhub.tiendaderopa.repositorios.ClienteRepositorio;
import com.mindhub.tiendaderopa.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public List<ClienteDTO> getArticulos() {
        return clienteRepositorio.findAll().stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente findByEmail(String email) {
        return clienteRepositorio.findByEmail(email);
    }
}

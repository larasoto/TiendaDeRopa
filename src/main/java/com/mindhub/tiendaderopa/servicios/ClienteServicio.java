package com.mindhub.tiendaderopa.servicios;

import com.mindhub.tiendaderopa.dtos.ClienteDTO;
import com.mindhub.tiendaderopa.modelos.Cliente;

import java.util.List;

public interface ClienteServicio {
    public List<ClienteDTO> getArticulos();
    Cliente saveCliente(Cliente cliente);
    Cliente findByEmail(String email);
}

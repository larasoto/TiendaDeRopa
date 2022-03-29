package com.mindhub.tiendaderopa.servicios;

import com.mindhub.tiendaderopa.dtos.PrendaClienteDTO;
import com.mindhub.tiendaderopa.modelos.PrendaCliente;

import java.util.List;

public interface PrendaClienteServicio {

    PrendaCliente savePrendaCliente(PrendaCliente prendaCliente);
    public List<PrendaClienteDTO> getArticulos();
}

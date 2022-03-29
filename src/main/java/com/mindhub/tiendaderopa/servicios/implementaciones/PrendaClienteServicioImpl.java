package com.mindhub.tiendaderopa.servicios.implementaciones;

import com.mindhub.tiendaderopa.dtos.PrendaClienteDTO;
import com.mindhub.tiendaderopa.modelos.PrendaCliente;
import com.mindhub.tiendaderopa.repositorios.PrendaClienteRepositorio;
import com.mindhub.tiendaderopa.servicios.PrendaClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaClienteServicioImpl implements PrendaClienteServicio {

    @Autowired
    PrendaClienteRepositorio prendaClienteRepositorio;

    @Override
    public PrendaCliente savePrendaCliente(PrendaCliente prendaCliente) {
        return prendaClienteRepositorio.save(prendaCliente);
    }

    @Override
    public List<PrendaClienteDTO> getArticulos() {
        return  prendaClienteRepositorio.findAll().stream().map(articulo -> new PrendaClienteDTO(articulo)).collect(Collectors.toList());
    }
}

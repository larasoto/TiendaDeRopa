package com.mindhub.tiendaderopa.servicios.implementaciones;

import com.mindhub.tiendaderopa.dtos.CompraDTO;
import com.mindhub.tiendaderopa.modelos.Compra;
import com.mindhub.tiendaderopa.repositorios.CompraRepositorio;
import com.mindhub.tiendaderopa.servicios.CompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraServicioImpl implements CompraServicio {

    @Autowired
    CompraRepositorio compraRepositorio;

    @Override
    public List<CompraDTO> getCompras() {
        return compraRepositorio.findAll().stream().map(pago -> new CompraDTO(pago)).collect(Collectors.toList());}

    @Override
    public Compra findByTipo(String tipoCompra) {
        return compraRepositorio.findByTipo(tipoCompra);
    }

    @Override
    public Compra saveCompra(Compra compra) {
        return compraRepositorio.save(compra);
    }


}


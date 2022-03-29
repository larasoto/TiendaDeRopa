package com.mindhub.tiendaderopa.servicios;

import com.mindhub.tiendaderopa.dtos.CompraDTO;
import com.mindhub.tiendaderopa.modelos.Compra;

import java.util.List;

public interface CompraServicio {
    public List<CompraDTO> getCompras();
    Compra findByTipo(String tipoCompra);
    Compra saveCompra(Compra compra);
}

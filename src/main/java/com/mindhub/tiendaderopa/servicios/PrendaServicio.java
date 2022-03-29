package com.mindhub.tiendaderopa.servicios;

import com.mindhub.tiendaderopa.dtos.PrendaDTO;
import com.mindhub.tiendaderopa.modelos.Prenda;

import java.util.List;

public interface PrendaServicio {
    Prenda findByNombrePrenda(String nombrePrenda);
    Prenda savePrenda(Prenda prenda);
    public List<PrendaDTO> getPrendas();
   //public Prenda deleteById ( Long id);
}

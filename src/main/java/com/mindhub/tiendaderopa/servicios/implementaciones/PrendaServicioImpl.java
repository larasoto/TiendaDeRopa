package com.mindhub.tiendaderopa.servicios.implementaciones;

import com.mindhub.tiendaderopa.dtos.PrendaDTO;
import com.mindhub.tiendaderopa.modelos.Prenda;
import com.mindhub.tiendaderopa.repositorios.PrendaRepositorio;
import com.mindhub.tiendaderopa.servicios.PrendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaServicioImpl implements PrendaServicio {

    @Autowired
    PrendaRepositorio prendaRepositorio;

    @Override
    public Prenda findByNombrePrenda(String nombrePrenda) {
        return prendaRepositorio.findByNombrePrenda(nombrePrenda) ;
    }

    @Override
    public Prenda savePrenda(Prenda prenda) {
        return prendaRepositorio.save(prenda);
    }

    @Override
    public List<PrendaDTO> getPrendas() {
        return prendaRepositorio.findAll().stream().map(inv -> new PrendaDTO(inv)).collect(Collectors.toList());
    }

   /* @Override
    public Prenda deleteById(Long id) {
        return prendaRepositorio.deleteById(id);
    }*/
}

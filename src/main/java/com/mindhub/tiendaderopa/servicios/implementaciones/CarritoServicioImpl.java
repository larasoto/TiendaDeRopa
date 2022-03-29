package com.mindhub.tiendaderopa.servicios.implementaciones;

import com.mindhub.tiendaderopa.dtos.CarritoDTO;
import com.mindhub.tiendaderopa.modelos.Carrito;
import com.mindhub.tiendaderopa.repositorios.CarritoRepositorio;
import com.mindhub.tiendaderopa.servicios.CarritoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarritoServicioImpl implements CarritoServicio {

    @Autowired
    CarritoRepositorio carritoRepositorio;

    @Override
    public Carrito saveCarrito(Carrito carrito) {
        return carritoRepositorio.save(carrito);
    }

    @Override
    public List<CarritoDTO> getArticulos() {
        return carritoRepositorio.findAll().stream().map(carrito -> new CarritoDTO(carrito)).collect(Collectors.toList());
    }

/*    @Override
    public ResponseEntity<Object> EliminarCarrito() {
        return carritoRepositorio.deleteAll();
    }*/
}

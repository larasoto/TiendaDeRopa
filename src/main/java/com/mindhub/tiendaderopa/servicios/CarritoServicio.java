package com.mindhub.tiendaderopa.servicios;

import com.mindhub.tiendaderopa.dtos.CarritoDTO;
import com.mindhub.tiendaderopa.modelos.Carrito;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarritoServicio {

    Carrito saveCarrito(Carrito carrito);
    public List<CarritoDTO> getArticulos();
//    public ResponseEntity<Object> EliminarCarrito ();

}

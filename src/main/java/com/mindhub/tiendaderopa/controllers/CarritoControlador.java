package com.mindhub.tiendaderopa.controllers;

import com.mindhub.tiendaderopa.dtos.CarritoDTO;
import com.mindhub.tiendaderopa.dtos.ClienteDTO;
import com.mindhub.tiendaderopa.modelos.Carrito;
import com.mindhub.tiendaderopa.modelos.Prenda;
import com.mindhub.tiendaderopa.repositorios.CarritoRepositorio;
import com.mindhub.tiendaderopa.repositorios.ClienteRepositorio;
import com.mindhub.tiendaderopa.repositorios.PrendaRepositorio;
import com.mindhub.tiendaderopa.servicios.CarritoServicio;
import com.mindhub.tiendaderopa.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CarritoControlador {

    @Autowired
    CarritoRepositorio carritoRepositorio;

    @Autowired
    CarritoServicio carritoServicio;


    @RequestMapping("/carrito")
    public List<CarritoDTO> getArticulos(){
        return carritoServicio.getArticulos();
    }

    @PostMapping("/carrito")
    public ResponseEntity<Object> crearCarrito (@RequestParam String nombrePrenda,
                                                @RequestParam int cantidad,
                                                @RequestParam double monto,
                                                @RequestParam double montoTotal
    ){


        if (nombrePrenda==null || cantidad==0 || monto==0 || montoTotal==0){
            return new ResponseEntity<>("complete todos los campos", HttpStatus.FORBIDDEN);
        }
        Carrito carrito = new Carrito(nombrePrenda,cantidad,monto,montoTotal);
        carritoServicio.saveCarrito(carrito);

        return new ResponseEntity<>("Item agregado correctamente al carrito", HttpStatus.CREATED);

    }

    @DeleteMapping("/carrito")
    public ResponseEntity<Object> EliminarCarrito (){
        carritoRepositorio.deleteAll();
        return new ResponseEntity<>("se ha eliminado los artículos del carrito con éxito", HttpStatus.OK);
    }

/*    @DeleteMapping("/carrito/{id}")
    public ResponseEntity<Object> EliminarCarritoPorId (@PathVariable Long id, @RequestParam String mantener){
        carritoControlador.;
        carritoRepositorio.deleteById(id);
        return new ResponseEntity<>("se ha eliminado los artículos del carrito con éxito", HttpStatus.OK);
    }*/
}

package com.mindhub.tiendaderopa.controllers;

import com.mindhub.tiendaderopa.dtos.PrendaDTO;
import com.mindhub.tiendaderopa.modelos.Prenda;
import com.mindhub.tiendaderopa.modelos.TipoArticulo;
import com.mindhub.tiendaderopa.repositorios.PrendaRepositorio;
import com.mindhub.tiendaderopa.servicios.PrendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController //le indicamos que hacemos un controlador rest
@RequestMapping("/api") //relacionar el controlador con la ruta /api
public class PrendaControlador {

    @Autowired //Inyección de dependencia
    PrendaServicio prendaServicio;

    @Autowired
    PrendaRepositorio prendaRepositorio;

    @RequestMapping("/prendas")
    public List<PrendaDTO> getPrendas(){
        return prendaServicio.getPrendas();
    }

    @PostMapping("/prendas")
    public ResponseEntity<Object> crearArticulo(
            @RequestParam String nombrePrenda,
            @RequestParam int precio,
            @RequestParam int stock,
            @RequestParam TipoArticulo tipo,
            @RequestParam List<String> talles,
            @RequestParam String imagen) {

        if(nombrePrenda.isEmpty() || talles.size() == 0 || precio == 0 || stock == 0 || imagen.isEmpty() ){
            return new ResponseEntity<>("datos invalidos",HttpStatus.FORBIDDEN);
        }

        Prenda articulo1 = new Prenda(nombrePrenda,precio,stock,tipo,talles,imagen);
        prendaServicio.savePrenda(articulo1);

            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/prendas/{id}")
    public ResponseEntity<Object>eliminarPrenda(@PathVariable Long id){

        prendaRepositorio.deleteById(id);


        return new ResponseEntity<>("La prenda ha sido eliminada",HttpStatus.CREATED);
    }


}

package com.mindhub.tiendaderopa.controllers;


import com.mindhub.tiendaderopa.dtos.CompraDTO;
import com.mindhub.tiendaderopa.modelos.*;
import com.mindhub.tiendaderopa.repositorios.ClienteRepositorio;
import com.mindhub.tiendaderopa.repositorios.CompraRepositorio;
import com.mindhub.tiendaderopa.repositorios.PrendaClienteRepositorio;
import com.mindhub.tiendaderopa.repositorios.PrendaRepositorio;
import com.mindhub.tiendaderopa.servicios.ClienteServicio;
import com.mindhub.tiendaderopa.servicios.CompraServicio;
import com.mindhub.tiendaderopa.servicios.PrendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CompraControlador {

    @Autowired
    CompraServicio compraServicio;

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    PrendaServicio prendaServicio;

    @Autowired
    PrendaClienteRepositorio prendaClienteRepositorio;

    @RequestMapping("/compras")
    public List<CompraDTO> getCompras(){
        return compraServicio.getCompras();
    }

    @PostMapping("/compras")
    public ResponseEntity<Object> realizarCompra(Authentication authentication,
                                                 @RequestParam String tipoCompra,
                                                 @RequestParam double monto,
                                                 @RequestParam String nombrePrenda,
                                                 @RequestParam int cantidad,
                                                 @RequestParam List<String> talles,
                                                 @RequestParam TipoArticulo tipoArticulo,
                                                 @RequestParam String imagen
                                                 ){

        Cliente cliente = clienteServicio.findByEmail(authentication.getName());

        Compra compra = compraServicio.findByTipo(tipoCompra);

        Prenda prenda = prendaServicio.findByNombrePrenda(nombrePrenda);



        if(cliente == null){
            return new ResponseEntity<>("Disculpe, debe iniciar sesión poder para continuar con la compra", HttpStatus.FORBIDDEN);
        }
        if(compra == null){
            return new ResponseEntity<>("Disculpe, debe elegir un medio de pago habilitado",HttpStatus.FORBIDDEN);
        }

        Compra compra1 = new Compra(compra.getTipo(), LocalDateTime.now(),monto);
        compraServicio.saveCompra(compra1);

        prenda.setStock(prenda.getStock() - cantidad);
        prendaServicio.savePrenda(prenda);

       // Prenda prenda = new Prenda(nombrePrenda,monto, tipoArticulo,talles,imagen);


        PrendaCliente prendaCliente = new PrendaCliente(prenda,cantidad,monto,compra1,cliente);
        prendaClienteRepositorio.save(prendaCliente);



        return new ResponseEntity<>("Compra realizada exitosamente", HttpStatus.CREATED);
    }


}

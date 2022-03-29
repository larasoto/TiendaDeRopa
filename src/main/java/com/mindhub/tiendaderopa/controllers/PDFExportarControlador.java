package com.mindhub.tiendaderopa.controllers;


import com.mindhub.tiendaderopa.modelos.Prenda;
import com.mindhub.tiendaderopa.repositorios.PrendaRepositorio;
import org.springframework.security.core.Authentication;

import com.mindhub.tiendaderopa.modelos.Cliente;
import com.mindhub.tiendaderopa.modelos.Compra;
import com.mindhub.tiendaderopa.repositorios.ClienteRepositorio;
import com.mindhub.tiendaderopa.repositorios.CompraRepositorio;
import com.mindhub.tiendaderopa.servicios.GeneradorPDFServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("/api")
public class PDFExportarControlador {

    @Autowired
    GeneradorPDFServicio generadorPDFServicio;

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Autowired
    PrendaRepositorio prendaRepositorio;

    @Autowired
    CompraRepositorio pagoRepositorio;

    @GetMapping("/pdf/generate/{id}")
    public void generatePDF(HttpServletResponse response, Authentication authentication, @PathVariable long id, @RequestParam Compra compra, @RequestParam String amount ) throws IOException {

        Cliente currentClient = clienteRepositorio.findByEmail(authentication.getName());

        response.setContentType("application/pdf");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=balance_"+currentClient.getNombre()+"_"+currentClient.getApellido()+".pdf";
        response.setHeader(headerKey, headerValue);

        generadorPDFServicio.export(response,currentClient, compra, amount);
    }
}

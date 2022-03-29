package com.mindhub.tiendaderopa.dtos;

import com.mindhub.tiendaderopa.modelos.Cliente;
import com.mindhub.tiendaderopa.modelos.Prenda;
import com.mindhub.tiendaderopa.modelos.PrendaCliente;

import java.util.List;
import java.util.Set;

public class PrendaClienteDTO {

    private int cant;
    private PrendaDTO prenda;
    private double monto;


    public PrendaClienteDTO() {
    }

    public PrendaClienteDTO(PrendaCliente prendaCliente) {
        this.cant = prendaCliente.getCant();
        this.prenda = new PrendaDTO(prendaCliente.getPrenda());
        this.monto = prendaCliente.getMonto();
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public PrendaDTO getPrenda() {
        return prenda;
    }

    public void setPrenda(PrendaDTO prenda) {
        this.prenda = prenda;
    }

    public double getMonto() {return monto;}

    public void setMonto(double monto) {this.monto = monto;}
}

package com.mindhub.tiendaderopa.dtos;

import com.mindhub.tiendaderopa.modelos.Carrito;

public class CarritoDTO {

    private long id;
    private String nombrePrenda;
    private int cantidad;
    private double precio;
    private double montoTotal;

    public CarritoDTO(Carrito carrito) {
        this.id = carrito.getId();
        this.nombrePrenda = carrito.getNombrePrenda();
        this.cantidad = carrito.getCantidad();
        this.precio = carrito.getPrecio();
        this.montoTotal = carrito.getMontoTotal();
    }

    public long getId() {
        return id;
    }

    public String getNombrePrenda() {
        return nombrePrenda;
    }

    public void setNombrePrenda(String nombrePrenda) {
        this.nombrePrenda = nombrePrenda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}

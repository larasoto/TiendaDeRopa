package com.mindhub.tiendaderopa.modelos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String nombrePrenda;
    private int cantidad;
    private double precio;
    private double montoTotal;

    @OneToOne
    @JoinColumn (name="cliente_id")
    private Cliente cliente;

    public Carrito() {
    }

    public Carrito(String nombrePrenda, int cantidad, double precio, double montoTotal) {
        this.nombrePrenda = nombrePrenda;
        this.cantidad = cantidad;
        this.precio = precio;
        this.montoTotal = montoTotal;
        this.cliente = cliente;
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

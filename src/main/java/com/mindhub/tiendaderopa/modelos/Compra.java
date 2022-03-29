package com.mindhub.tiendaderopa.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private LocalDateTime fechayHora;
    private TipoCompra tipo;
    private double monto;

    @OneToMany(mappedBy="compra", fetch=FetchType.EAGER)
    Set<PrendaCliente> prendaCliente =  new HashSet<>();



    public Compra() {
    }

    public Compra(TipoCompra tipo, LocalDateTime fechayHora, double monto) {
        this.tipo = tipo;
        this.fechayHora = fechayHora;
        this.monto = monto;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getFechayHora() {
        return fechayHora;
    }

    public void setFechayHora(LocalDateTime fechayHora) {
        this.fechayHora = fechayHora;
    }

    public TipoCompra getTipo() {
        return tipo;
    }

    public void setTipo(TipoCompra tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Set<PrendaCliente> getPrendaCliente() {
        return prendaCliente;
    }

    public void setPrendaCliente(Set<PrendaCliente> prendaCliente) {
        this.prendaCliente = prendaCliente;
    }

}

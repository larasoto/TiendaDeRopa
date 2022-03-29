package com.mindhub.tiendaderopa.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String nombrePrenda;
    private String color;
    private int stock;
    private double precio;

    @ElementCollection
    @Column(name = "talles")
    private List<String> talles = new ArrayList<>();

    private TipoArticulo tipoArticulo;

    private String imagen;

    @OneToMany(mappedBy = "prenda",fetch = FetchType.EAGER)
    private Set <PrendaCliente> prendaClientes = new HashSet<>();



    public Prenda() {
    }

    public Prenda(String nombrePrenda, double precio, int stock, TipoArticulo tipoArticulo, List<String> talles, String imagen) {
        this.nombrePrenda = nombrePrenda;
        this.precio = precio;
        this.stock = stock;
        this.tipoArticulo = tipoArticulo;
        this.talles = talles;
        this.imagen = imagen;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<String> getTalles() {
        return talles;
    }

    public void setTalles(List<String> talles) {
        this.talles = talles;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public String getImagen() {return imagen;}

    public void setImagen(String imagen) {this.imagen = imagen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<PrendaCliente> getPrendaCliente() {return prendaClientes;}

    public void setPrendaCliente(Set<PrendaCliente> prendaCliente) {this.prendaClientes = prendaCliente;}
}

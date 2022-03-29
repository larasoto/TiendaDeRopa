package com.mindhub.tiendaderopa.dtos;

import com.mindhub.tiendaderopa.modelos.Prenda;
import com.mindhub.tiendaderopa.modelos.Cliente;
import com.mindhub.tiendaderopa.modelos.Compra;
import com.mindhub.tiendaderopa.modelos.PrendaCliente;

import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDTO {

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Set<PrendaClienteDTO> prendaClienteDTOS;

    public ClienteDTO(Cliente cliente) {
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.email = cliente.getEmail();
        this.password = cliente.getPassword();
        this.prendaClienteDTOS = cliente.getPrendaClientes().stream().map(PrendaClienteDTO::new).collect(Collectors.toSet());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<PrendaClienteDTO> getPrendaClienteDTOS() {
        return prendaClienteDTOS;
    }

    public void setPrendaClienteDTOS(Set<PrendaClienteDTO> prendaClienteDTOS) {
        this.prendaClienteDTOS = prendaClienteDTOS;
    }
}

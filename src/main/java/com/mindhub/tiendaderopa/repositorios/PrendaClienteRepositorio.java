package com.mindhub.tiendaderopa.repositorios;

import com.mindhub.tiendaderopa.modelos.PrendaCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PrendaClienteRepositorio extends JpaRepository<PrendaCliente, Long> {
}

package com.mindhub.tiendaderopa.repositorios;

import com.mindhub.tiendaderopa.modelos.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PrendaRepositorio extends JpaRepository<Prenda, Long> {
    Prenda findByNombrePrenda (String nombrePrenda);
}

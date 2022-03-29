package com.mindhub.tiendaderopa.repositorios;

import com.mindhub.tiendaderopa.modelos.Compra;
import com.mindhub.tiendaderopa.modelos.TipoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompraRepositorio extends JpaRepository<Compra, Long> {
   Compra findByTipo (String tipo);
}

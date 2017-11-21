package com.loschidos.cotizaciones.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loschidos.cotizaciones.entity.Cotizacion;

@Repository("cotizacionRepository")
public interface CotizacionRepository extends JpaRepository<Cotizacion, Serializable>{

}

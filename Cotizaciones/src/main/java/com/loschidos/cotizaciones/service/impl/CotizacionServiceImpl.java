package com.loschidos.cotizaciones.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.loschidos.cotizaciones.entity.Cotizacion;
import com.loschidos.cotizaciones.repository.CotizacionRepository;
import com.loschidos.cotizaciones.service.CotizacionService;

@Service("cotizacionServiceImpl")
public class CotizacionServiceImpl implements CotizacionService {
	
	@Autowired
	@Qualifier("cotizacionRepository")
	private CotizacionRepository cotizacionRepository;

	@Override
	public Cotizacion addCotizacion(Cotizacion cotizacion) {
		return cotizacionRepository.save(cotizacion);
	}
}

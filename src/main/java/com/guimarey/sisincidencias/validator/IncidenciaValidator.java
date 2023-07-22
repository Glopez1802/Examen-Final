package com.guimarey.sisincidencias.validator;

import com.guimarey.sisincidencias.entity.Incidencia;
import com.guimarey.sisincidencias.exceptions.ValidateServiceException;


public class IncidenciaValidator {
	public static void save(Incidencia incidencia) {
		if(incidencia.getDenunciante()==null || incidencia.getDenunciante().trim().isEmpty()) {
			throw new ValidateServiceException("El denunciante es requerido");
		}
		if(incidencia.getDenunciante().length()>100) {
			throw new ValidateServiceException("El nombre es muy extenso");
			
		}
		if(incidencia.getUrbanizacion() == null || incidencia.getUrbanizacion().trim().isEmpty()) {
			throw new ValidateServiceException("La Urbanizacion es requerido");
		}
		if(incidencia.getUrbanizacion().length()>100) {
			throw new ValidateServiceException("El nombre de la urbanizacion es muy extenso");
		}
		if(incidencia.getCalle() == null || incidencia.getCalle().trim().isEmpty()) {
			throw new ValidateServiceException("La Calle es requerido");
		}
		if(incidencia.getCalle().length()>100) {
			throw new ValidateServiceException("El nombre de la calle es muy extenso");
		}
		if(incidencia.getReferencia() == null || incidencia.getReferencia().trim().isEmpty()) {
			throw new ValidateServiceException("La referencia es requerido");
		}
		if(incidencia.getReferencia().length()>255) {
			throw new ValidateServiceException("La referencia es muy extensa");
		}
		if(incidencia.getDescripcion() == null || incidencia.getDescripcion().trim().isEmpty()) {
			throw new ValidateServiceException("La descripcion es requerido");
		}
		if(incidencia.getDescripcion().length()>255) {
			throw new ValidateServiceException("La descripcion  es muy extensa");
		}
		
	}
}

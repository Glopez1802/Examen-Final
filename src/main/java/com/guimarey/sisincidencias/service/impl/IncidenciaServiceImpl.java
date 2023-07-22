package com.guimarey.sisincidencias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guimarey.sisincidencias.entity.Incidencia;
import com.guimarey.sisincidencias.exceptions.GeneralServiceException;
import com.guimarey.sisincidencias.exceptions.NoDataFoundException;
import com.guimarey.sisincidencias.exceptions.ValidateServiceException;
import com.guimarey.sisincidencias.repository.IncidenciaRepository;
import com.guimarey.sisincidencias.service.IncidenciaService;
import com.guimarey.sisincidencias.validator.IncidenciaValidator;



import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class IncidenciaServiceImpl implements IncidenciaService {
	
	@Autowired
	private IncidenciaRepository repository;
	@Override
	@Transactional(readOnly = true)
	public List<Incidencia> findAll(){
		try {
			return repository.findAll();
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Incidencia findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}	
	}
	
	@Override
	@Transactional(readOnly = true)
	public Incidencia findByDenunciante(String denunciante) {
		try {
			return repository.findByDenunciante(denunciante);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Incidencia> findByDenuncianteContaining(String denunciante) {
		try {
			return repository.findByDenuncianteContaining(denunciante);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	
	@Override
	@Transactional
	public Incidencia create(Incidencia obj) {
		try {
			//Validación
			IncidenciaValidator.save(obj);
			Incidencia incidencia=findByDenunciante(obj.getDenunciante());
			if(incidencia!=null) {
				throw new ValidateServiceException("Ya hay un registro con ese documento");
			}
			return repository.save(obj);			
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}	
	}
	
	@Override
	@Transactional
	public Incidencia update(Incidencia obj) {
		try {
			IncidenciaValidator.save(obj);
			Incidencia incidenciaDb=findById(obj.getId());
			if(incidenciaDb==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de nombre repetido
			Incidencia incidencia=findByDenunciante(obj.getDenunciante());
			if(incidencia!=null && obj.getId()!=incidencia.getId()) {
				throw new ValidateServiceException("Ya hay un registro con ese Documento");
			}
			//Actualizamos la incidencia
			incidenciaDb.setDenunciante(obj.getDenunciante());
			incidenciaDb.setUrbanizacion(obj.getUrbanizacion());
			incidenciaDb.setCalle(obj.getCalle());
			incidenciaDb.setReferencia(obj.getReferencia());
			incidenciaDb.setDescripcion(obj.getDescripcion());
			return repository.save(incidenciaDb);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public int delete(int id) {
		try {
			Incidencia incidenciaDb = repository.findById(id).orElse(null);
			if (incidenciaDb == null) {
				return 0;
			} else {
				repository.delete(incidenciaDb);
				return 1;
			}
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}

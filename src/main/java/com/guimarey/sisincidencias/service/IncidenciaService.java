package com.guimarey.sisincidencias.service;

import java.util.List;

import com.guimarey.sisincidencias.entity.Incidencia;

public interface IncidenciaService {
	
	public List<Incidencia> findAll();
	public Incidencia findById(int id);
	public Incidencia findByDenunciante(String denunciante);
	public List<Incidencia> findByDenuncianteContaining(String denunciante);
	public Incidencia create(Incidencia obj);
	public Incidencia update(Incidencia obj);
	public int delete(int id);

}

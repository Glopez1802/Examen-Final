package com.guimarey.sisincidencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guimarey.sisincidencias.entity.Incidencia;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {
	public Incidencia findByDenunciante(String denunciante);
	public List<Incidencia> findByDenuncianteContaining(String denunciante);
}

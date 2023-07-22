package com.guimarey.sisincidencias.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="incidencia")
@EntityListeners(AuditingEntityListener.class)
public class Incidencia {

	@Id
	@Column(name = "id", length = 10, columnDefinition = "int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "denunciante", length = 100, nullable = false, unique = false)
	private String denunciante;
	@Column(name = "urbanizacion", length = 100, nullable = false, unique = false)
	private String urbanizacion;
	@Column(name = "calle", length = 100, nullable = false, unique = false)
	private String calle;
	@Column(name = "referencia", length = 255, nullable = false, unique = false)
	private String referencia;
	@Column(name = "descripcion", length = 255, nullable = false, unique = false)
	private String descripcion;
	@Embedded
	private TimeStamp timeStamp;
}

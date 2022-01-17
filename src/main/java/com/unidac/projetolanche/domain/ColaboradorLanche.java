package com.unidac.projetolanche.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_colaborador_lanche")
public class ColaboradorLanche implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "colaborador_id")
	private Long colaborador;
	
	@Column(name = "lanche_id")
	private Long lanche;
	
	public ColaboradorLanche() {
	}
	
	public ColaboradorLanche(Long colaborador, Long lanche) {
		this.colaborador = colaborador;
		this.lanche = lanche;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getColaborador() {
		return colaborador;
	}

	public void setColaborador(Long colaborador) {
		this.colaborador = colaborador;
	}

	public Long getLanche() {
		return lanche;
	}

	public void setLanche(Long lanche) {
		this.lanche = lanche;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColaboradorLanche other = (ColaboradorLanche) obj;
		return Objects.equals(id, other.id);
	}
}

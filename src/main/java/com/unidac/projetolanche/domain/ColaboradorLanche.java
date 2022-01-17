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
	
	@Column(name = "colaborador_id", nullable = false, unique = true)
	private Long colaborador;
	
	private String nome;
	
	private String cpf;
	
	@Column(name = "lanche_id", nullable = false, unique = true)
	private Long lanche;
	
	private String nomeL;
	
	
	public ColaboradorLanche() {
	}
	
	public ColaboradorLanche(Long colaborador, Long lanche, String nome, String cpf, String nomeL) {
		this.colaborador = colaborador;
		this.lanche = lanche;
		this.nome = nome;
		this.cpf = cpf;
		this.nomeL = nomeL;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeL() {
		return nomeL;
	}

	public void setNomeL(String nomeL) {
		this.nomeL = nomeL;
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

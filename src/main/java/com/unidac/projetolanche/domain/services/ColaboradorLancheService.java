package com.unidac.projetolanche.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unidac.projetolanche.domain.Colaborador;
import com.unidac.projetolanche.domain.ColaboradorLanche;
import com.unidac.projetolanche.domain.Lanche;
import com.unidac.projetolanche.repositories.ColaboradorLancheRepository;

@Service
public class ColaboradorLancheService {

	@Autowired
	private ColaboradorLancheRepository repo;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private LancheService lancheService;
	
	public List<ColaboradorLanche> findAll() {
		return repo.findAll();
	}
	
	public ColaboradorLanche find(Long id) {
		Optional<ColaboradorLanche> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public ColaboradorLanche insert(ColaboradorLanche obj) throws Exception {
		obj.setId(null);
		Colaborador col = colaboradorService.find(obj.getColaborador());
		
		if (col.getId() == null || !col.getId().equals(obj.getColaborador())) {
			throw new Exception("Por favor cadastrar o colaborador ou o Colaborador %s não pertece a este pedido" + col.getNome());
		}
		
		Lanche lan = lancheService.findById(obj.getLanche());
		
		if (lan.getId() == null || !lan.getId().equals(obj.getLanche())) {
			throw new Exception("Por favor cadastrar o lanche ou o Lanche %s não pertece a este pedido" + lan.getNome());
		}

		obj = repo.save(obj);
		return obj;
	}

}

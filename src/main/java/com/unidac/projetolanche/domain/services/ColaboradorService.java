package com.unidac.projetolanche.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.unidac.projetolanche.domain.Colaborador;
import com.unidac.projetolanche.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repo;
	
	public List<Colaborador> findAll() {
		return repo.findAll();
	}
	
	public Colaborador find(Long id) {
		Optional<Colaborador> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Colaborador insert(Colaborador obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	
	public Colaborador update(Colaborador obj) {
		Colaborador newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir uma Colaborador que possui produtos");
		}
	}
	
	private void updateData(Colaborador newObj, Colaborador obj) {
		newObj.setNome(obj.getNome());
		newObj.setCpf(obj.getCpf());
	}
}

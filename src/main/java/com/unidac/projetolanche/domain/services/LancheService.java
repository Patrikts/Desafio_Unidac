package com.unidac.projetolanche.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unidac.projetolanche.domain.Lanche;
import com.unidac.projetolanche.repositories.LancheRepository;

@Service
public class LancheService {

	@Autowired
	private LancheRepository LancheRepository;

	public List<Lanche> findAll() {
		return LancheRepository.findAll();
	}

	public Lanche findById(Long id) {
		Optional<Lanche> obj = LancheRepository.findById(id);
		return obj.orElse(null);
	}

	@Transactional
	public Lanche insert(Lanche lanche) {
		lanche.setId(null);
		return LancheRepository.save(lanche);

	}

	public void delete(Long id) {
		try {
			LancheRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			if (id == null) {
				System.out.print(e.getMessage());
			}
		}
	}

	public Lanche update(Long id, Lanche obj) {
		Lanche entity = LancheRepository.getById(id);
		updateData(entity, obj);
		return LancheRepository.save(entity);
	}

	private void updateData(Lanche entity, Lanche obj) {
		entity.setNome(obj.getNome());
	}
}

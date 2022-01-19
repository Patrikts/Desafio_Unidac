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
	private LancheRepository repo;

	public List<Lanche> findAll() {
		return repo.findAll();
	}

	public Lanche findById(Long id) {
		Optional<Lanche> obj = repo.findById(id);
		return obj.orElse(null);
	}

	@Transactional
	public Lanche insert(Lanche lanche) {
		lanche.setId(null);
		return repo.save(lanche);

	}

	public void delete(Long id) {
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			if (id == null) {
				System.out.print(e.getMessage());
			}
		}
	}

	public Lanche update(Lanche obj) {
		Lanche newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Lanche newObj, Lanche obj) {
		newObj.setNome(obj.getNome());
	}
}

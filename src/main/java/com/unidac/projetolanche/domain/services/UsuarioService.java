package com.unidac.projetolanche.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unidac.projetolanche.domain.Usuario;
import com.unidac.projetolanche.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElse(null);
	}

	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);

	}

	public void delete(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			if (id == null) {
				System.out.print(e.getMessage());
			}
		}
	}

	public Usuario update(Long id, Usuario obj) {
		Usuario entity = usuarioRepository.getById(id);
		updateData(entity, obj);
		return usuarioRepository.save(entity);
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
	}
}

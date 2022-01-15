package com.unidac.projetolanche.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unidac.projetolanche.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

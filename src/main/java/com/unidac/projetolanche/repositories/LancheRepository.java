package com.unidac.projetolanche.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unidac.projetolanche.domain.Lanche;

public interface LancheRepository extends JpaRepository<Lanche, Long> {

}

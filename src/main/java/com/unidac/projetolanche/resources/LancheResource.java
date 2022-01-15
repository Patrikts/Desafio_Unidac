package com.unidac.projetolanche.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unidac.projetolanche.domain.Lanche;
import com.unidac.projetolanche.domain.services.LancheService;

@RestController
@RequestMapping(value = "/lanches")
public class LancheResource {
	
	@Autowired
	private LancheService LancheService;
	
	
	@GetMapping
	public ResponseEntity<List<Lanche>> findAll() {
		List<Lanche> list = LancheService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Lanche> findById(@PathVariable Long id) {
		Lanche obj = LancheService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Lanche> insert(@RequestBody Lanche obj) {
		obj = LancheService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		LancheService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Lanche> update(@PathVariable Long id, @RequestBody Lanche obj) {
		obj = LancheService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}

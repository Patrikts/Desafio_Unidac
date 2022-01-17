package com.unidac.projetolanche.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unidac.projetolanche.domain.ColaboradorLanche;
import com.unidac.projetolanche.domain.services.ColaboradorLancheService;

@RestController
@RequestMapping(value = "/pedidos")
public class ColaboradorLancheResource {
	
	@Autowired
	private ColaboradorLancheService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ColaboradorLanche>> findAll(ColaboradorLanche colaboradorLanche) {
		List<ColaboradorLanche> list = service.findAll(colaboradorLanche);
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ColaboradorLanche> find(@PathVariable Long id) {
		ColaboradorLanche obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ColaboradorLanche obj) throws Exception {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}

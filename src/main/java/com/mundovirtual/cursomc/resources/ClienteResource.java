package com.mundovirtual.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mundovirtual.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="clientes")
public class ClienteResource {
	
	@Autowired
	public ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok().body( clienteService.findAll() );
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		return ResponseEntity.ok().body( clienteService.find(id));
	}

}

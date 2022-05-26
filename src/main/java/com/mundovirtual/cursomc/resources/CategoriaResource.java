package com.mundovirtual.cursomc.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mundovirtual.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="categorias")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		//Categoria cat1 = new Categoria(1, "Informática");
		//Categoria cat2 = new Categoria(2, "Escritório");
		
		return Arrays.asList();
	}

}

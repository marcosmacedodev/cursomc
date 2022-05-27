package com.mundovirtual.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mundovirtual.cursomc.domain.Categoria;
import com.mundovirtual.cursomc.repositories.CategoriaRepository;
import com.mundovirtual.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 

	}
	
	public List<Categoria> findAll(){
		return this.categoriaRepository.findAll();
	}
	
	public void saveAll(List<Categoria> categorias) {
		this.categoriaRepository.saveAll(categorias);
	}
}

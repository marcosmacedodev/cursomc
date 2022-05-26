package com.mundovirtual.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mundovirtual.cursomc.domain.Produto;
import com.mundovirtual.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto find(Integer id){
		Optional<Produto> produto = this.produtoRepository.findById(id);
		return produto.orElse(null);
	}
	
	public List<Produto> findAll(){
		return this.produtoRepository.findAll();
	}
}

package com.mundovirtual.cursomc.domain;

import javax.persistence.Entity;

import com.mundovirtual.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	private int numeroDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, int numeroDeParcelas) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(int numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
}

package com.mundovirtual.cursomc.domain.enums;

public enum TipoCliente {
	PESSOA_FISICA(1, "Pessoa Física", "PF"), 
	PESSOA_JURIDICA(2, "Pessoa Jurídica", "PJ");
	
	private int codigo;
	private String descricao;
	private String siglas;
	
	private TipoCliente(int codigo, String descricao, String siglas) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.siglas = siglas;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public String getSiglas() {
		return this.siglas;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for(TipoCliente x : TipoCliente.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id é inválido");
	}
	
}

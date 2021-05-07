package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

//aqui vou ter os mesmos dados do Seller, so que nao vamos ter nenhuma relacao
// com JPA (@Entity)

public class SellerDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	// criar o contrutor da entidade
	public SellerDTO() {
		
	}

	public SellerDTO(Long id, String name) {
		
		this.id = id;
		this.name = name;
	}

	// fiz copia do contrutor acima
	// apontei para a entidade Seller (substituindo os parametros do contrutor original)
	// removi o this pois nao existe mais ambiguidade
	public SellerDTO(Seller entity) {		
		id = entity.getId();
		name = entity.getName();
	}
	// posso agora ajustar meu objeto 'SellerService' para retornar este 'SellerDTO' e nao mais o 'Seller' 

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

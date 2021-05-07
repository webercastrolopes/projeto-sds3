package com.devsuperior.dsvendas.dto;

import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Sale;

	public class SaleDTO {
		private Long id;
		private Integer visited;
		private Integer deals;
		private Double amount;
		private LocalDate date;
		
	
	// PRA TRAZER tb O vendedor vou trazer junto o objeto aninhado!
	// importante: a dependencia no DTO pra outro elemento NAO é recomentado de jeito nenhum que se coloque a Entidade por isto apontamos para SellerDTO
	//             do contrario estariamos liberando acesso a minha entidade na camada de controlador (nao recomentado) pra nao furar a arquitetura !
	private SellerDTO seller;
	
	
	//agora fazer o contrutor:
	public SaleDTO() {		
	}

	
	//criar agora o contrutor com argumentos:
	public SaleDTO(Long id, Integer visited, Integer deals, Double amount, LocalDate date, SellerDTO seller) {
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}
	
	
	//agora vamos fazer o construtor com entidade: copia o contrutor de cima e apaga os atributos e coloca a Entidade!
	// agora os dados do DTO vao ser copiados do entity:
	public SaleDTO(Sale entity) {
		//super();
		id = entity.getId();
		visited = entity.getVisited();
		deals = entity.getDeals();
		amount = entity.getAmount();
		date = entity.getDate();
		seller = new SellerDTO(entity.getSeller());          // o seller do meu DTO é do tipo SellerDTO e o seller da entidade é do tipo seller, entao vou usar o contrutor com '= new...' recebendo entidade seller como argumento
	// com isto copiamos todos dados da entidade 'sale' para o 'saleDTO' na camada do contrutor.
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getVisited() {
		return visited;
	}


	public void setVisited(Integer visited) {
		this.visited = visited;
	}


	public Integer getDeals() {
		return deals;
	}


	public void setDeals(Integer deals) {
		this.deals = deals;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public SellerDTO getSeller() {
		return seller;
	}


	public void setSeller(SellerDTO seller) {
		this.seller = seller;
	}
	
	
	//proximo passo é fazer o 'salesService'
	
	}
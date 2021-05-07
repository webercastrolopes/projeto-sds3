package com.devsuperior.dsvendas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_sellers")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String name;
	
	//representar Lista de vendas('Seles') de um(1) vendedor('Seller')
	//o vendedor vai ter uma lista de 'sale' com nome 'sales'
	@OneToMany(mappedBy = "seller")
	private List<Sale> sales = new ArrayList<>();
	
	
          //interface             //classe
	//nao posso instanciar uma interface, tem que colocar uma classe correspondente a interface.
	//colecao [arraylist<>()] convem ja instaniar por aqui
	
	
	public Seller() {
		// criado construtor padrao, aquele que nao tem argumento.
	}

	//contrutor recebendo 2 argumentos para os atributos da classe:
	public Seller(Long id, String name) {
		this.id = id;
		this.name = name;
	}

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

	public List<Sale> getSales() {
		return sales;
	}

	
	//os tritibutos da classe sao privados e nao podem ser acessados por outra classe, para isto implementa os gets e sets:
	
	
	
	
}

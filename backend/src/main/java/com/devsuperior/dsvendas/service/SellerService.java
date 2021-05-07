package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

//implementando um servico de seller que depende do repository de seller. Que por sua ves busca todos do repository
// esta é a relacao de camandas entre o servico e o acesso a dados(repository)
// so que como não vamos retornar entidade para a camada de servico entao
// vamos na sequencia criar o DTO.(em outra nova classe a ser criada posterior a esta)

@Service
public class SellerService {
	
	//vai injetar de forma transparente - minha variavel Nao precisa receber '= new ...'
	@Autowired
	private SellerRepository repository;
	
	
	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toUnmodifiableList());
		
	}
	
	//1:00:20
}


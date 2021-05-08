package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller") 
	//pode escrever t-Sql formato raiz ou ORM(Jpa) forma especifica - vamos usar JPQl
	//assinamos o método
	List<SaleSumDTO> amountGroupBySeller();

	
	//desenhei antes o modelo de retorno (usando VSCode) que
	//o método abaixo vai ter que me atender: 
	/*
	 {
			      "sellerName": "Anarkin",
			      "sumVisited": 1000,
			      "sumNegokDeals": 800     //=80%
			   },
			   {
			      "sellerName": "Anarkina",
			      "sumVisited": 2000,
			      "sumNegokDeals": 800     //=40%
			   },
	  */
	// abaixo criamos o método para atender modelo acima :
	//                                                   agrupo pelo vendedor, somo vendas       
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " //a qtde de campos tem que estar de 
			                                                                                      //acordo com definido no 'CONSTRUTOR'
			                                                                                     // ('SaleSucessDTO.java')
			+ " FROM Sale AS obj GROUP BY obj.seller") 
	List<SaleSuccessDTO> sucessGroupBySeller(); //assinamos o método e vamos DEFINI-lo NO 'SaleSERVICE'
	
	// o retorno deste método vai para o DTO aqui definido e que deverá ser buscado
	// o Método aqui assinado deverá ser criado no 'SaleSERVICE.java'
	
}

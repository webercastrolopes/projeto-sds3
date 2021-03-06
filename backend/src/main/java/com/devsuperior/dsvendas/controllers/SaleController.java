package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.service.SaleService;


// pra indicar que esta classe vai ser um controlador REST
@RestController

// para indicar o caminho deste recurso Web
@RequestMapping(value = "/sales")
public class SaleController {
	
	//injetado service
	@Autowired
	private SaleService service;
	
	
	// fazer um metodo para representar meu endpoint pra chamar la do navegador
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupBySeller() {
		List<SaleSumDTO> list = service.amountGroupBySeller();
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> sucessGroupBySeller() {
		List<SaleSuccessDTO> list = service.sucessGroupBySeller();
		return ResponseEntity.ok(list);
	}
	//List<SaleSuccessDTO> sucessGroupBySeller(); ==> definido na assinatura do Método
	//                                                em 'SaleRepositorie'.
	
}

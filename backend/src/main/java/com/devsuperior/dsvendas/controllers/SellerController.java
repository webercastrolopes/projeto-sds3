package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.service.SellerService;


// pra indicar que esta classe vai ser um controlador REST
@RestController

// para indicar o caminho deste recurso Web
@RequestMapping(value = "/sellers")
public class SellerController {
	
	//injetado service
	@Autowired
	private SellerService service;
	
	
	// fazer um metodo para representar meu endpoint pra chamar la do navegador
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
}

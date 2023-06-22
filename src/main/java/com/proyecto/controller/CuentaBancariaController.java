package com.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.CuentaBancaria;
import com.proyecto.service.CuentaBancariaService;

@RestController
@RequestMapping("/rest/cuenta_bancaria")
public class CuentaBancariaController {

	@Autowired
	private CuentaBancariaService service;

	@GetMapping()
	public ResponseEntity<?> lista() {
		List<CuentaBancaria> lstSalida = service.listaCuentaBancaria();
		return ResponseEntity.ok(lstSalida);
	}

	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody CuentaBancaria obj) {
		CuentaBancaria objSalida = service.insertaCuentaBancaria(obj);
		return ResponseEntity.ok(objSalida);
	}

	@GetMapping("/porId/{id}")
	public ResponseEntity<?> listaPorIdEnPath(@PathVariable Integer id) {
		Optional<CuentaBancaria> optSalida = service.buscaCuentaBancaria(id);
		return ResponseEntity.ok(optSalida.get());
	}

	@GetMapping("/porId")
	public ResponseEntity<?> listaPorIdEnParamaterer(
			@RequestParam(name = "id", defaultValue = "0", required = true) Integer id) {
		Optional<CuentaBancaria> optSalida = service.buscaCuentaBancaria(id);
		return ResponseEntity.ok(optSalida.get());
	}

	@GetMapping("/porBanco/{id}")
	public ResponseEntity<?> listaPorBanco(@PathVariable Integer id) {
		List<CuentaBancaria> lstSalida = service.listarPorBanco(id);
		return ResponseEntity.ok(lstSalida);
	}
	
	@GetMapping("/porUsuario/{id}")
	public ResponseEntity<?> listaPorUsuario(@PathVariable Integer id) {
		List<CuentaBancaria> lstSalida = service.listarPorUsuario(id);
		return ResponseEntity.ok(lstSalida);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaCuentaBancaria(@PathVariable Integer id) {
		service.eliminaCuentaBancaria(id);
		Optional<CuentaBancaria> optCuentaBancaria = service.buscaCuentaBancaria(id);
		if (optCuentaBancaria.isEmpty()) {
			return ResponseEntity.ok("Eliminación exitosa");
		}
		return ResponseEntity.ok("No existe el id " + id);
	}

	@PutMapping()
	public ResponseEntity<CuentaBancaria> actualiza(@RequestBody CuentaBancaria obj) {
		Optional<CuentaBancaria> optCuentaBancaria = service.buscaCuentaBancaria(obj.getIdCuenta());
		if (optCuentaBancaria.isPresent()) {
			return ResponseEntity.ok(service.insertaCuentaBancaria(obj));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.CuentaBancaria;
import com.proyecto.repository.CuentaBancariaRepository;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService {

	@Autowired
	private CuentaBancariaRepository repository;

	@Override
	public List<CuentaBancaria> listaCuentaBancaria() {
		return repository.findAll();
	}

	@Override
	public CuentaBancaria insertaCuentaBancaria(CuentaBancaria obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<CuentaBancaria> buscaCuentaBancaria(int idCuentaBancaria) {
		return repository.findById(idCuentaBancaria);
	}

	@Override
	public void eliminaCuentaBancaria(int idCuentaBancaria) {
		repository.deleteById(idCuentaBancaria);
	}
	
	@Override
	public List<CuentaBancaria> listarPorBanco(int idBanco) {
		return repository.listarPorBanco(idBanco);
	}
	
	@Override
	public List<CuentaBancaria> listarPorUsuario(int idUsuario) {
		return repository.listarPorUsuario(idUsuario);
	}

}

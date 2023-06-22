package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.entity.CuentaBancaria;

public interface CuentaBancariaService {

	public List<CuentaBancaria> listaCuentaBancaria();

	public CuentaBancaria insertaCuentaBancaria(CuentaBancaria obj);

	public Optional<CuentaBancaria> buscaCuentaBancaria(int idCuentaBancaria);

	public void eliminaCuentaBancaria(int idCuentaBancaria);

	public abstract List<CuentaBancaria> listarPorBanco(int idBanco);

	public abstract List<CuentaBancaria> listarPorUsuario(int idUsuario);
}

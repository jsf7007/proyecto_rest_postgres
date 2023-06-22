package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.entity.CuentaBancaria;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Integer> {
	@Query("Select p from CuentaBancaria p where p.idBanco = :var_banco")
	public abstract List<CuentaBancaria> listarPorBanco(@Param("var_banco") int idBanco);
	
	@Query("Select p from CuentaBancaria p where p.idUsuario = :var_usuario")
	public abstract List<CuentaBancaria> listarPorUsuario(@Param("var_usuario") int idUsuario);
}

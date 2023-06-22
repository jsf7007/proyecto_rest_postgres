package com.proyecto.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuenta_bancaria")
	private int idCuenta;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	@Column(name = "id")
	private int idUsuario;

	@Column(name = "id_banco")
	private int idBanco;

	@Column(name = "monto")
	private double monto;

	@Column(name = "numero_cuenta")
	private String numeroCuenta;

}

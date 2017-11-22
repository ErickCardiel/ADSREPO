package com.example.erickcairdiel.koko;

public class Tarjeta
{
	public int codigoSeguridad,anioVencimiento,mesVencimiento;
	public String tipo,numeroTarjeta;

	public Tarjeta(String numeroTarjeta, int codigoSeguridad, int anioVencimiento, int mesVencimiento, String tipo)	// Constructor
	{
		this.numeroTarjeta = numeroTarjeta;
		this.codigoSeguridad = codigoSeguridad;
		this.anioVencimiento = anioVencimiento;
		this.mesVencimiento = mesVencimiento;
		this.tipo = tipo;
	}
}

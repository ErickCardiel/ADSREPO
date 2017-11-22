package com.example.erickcairdiel.koko;

public class Transporte
{
	public int cantidadAsientos,idTransporte;
	public float tarifa;
	public Ruta ruta;
	
	public Transporte(int idTransporte, int cantidadAsientos,float tarifa)
	{
		this.idTransporte = idTransporte;
		this.cantidadAsientos = cantidadAsientos;
		this.tarifa = tarifa;
	}	
	
	public void registraRuta(String universidadDestino)
	{
		this.ruta = new Ruta(universidadDestino);
	}
	
}
package com.example.erickcairdiel.koko;

import android.app.Application;

public class Usuario extends Application
{
	public int idUsuario,edad,calificacion=0,contCalifs=0,cntTarjeta=0;
	public String nombre,correo,contrasena,telefono;
	public boolean registroConductor;
	public Estudiante estudiante;
	public Conductor conductor;
	public Tarjeta tarjeta;

	
	public boolean iniciarSesion(String contrasena)
	{
		if(contrasena == this.contrasena)
			return true;
		return false;
	}
	
	public void calificar(int calificacion)
	{
		this.calificacion = ((this.calificacion+calificacion)/++this.contCalifs);
	}

	
	public void registraTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	
	public void registraDatosGenerales(String nombre, String correo, String contrasena, int edad, int idUsuario)
	{
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.edad = edad;
		this.idUsuario = idUsuario;
	}
	
	public void registrarTarjeta(String numeroTarjeta, int codigoSeguridad, int anioVencimiento,int mesVencimiento, String tipo)
	{
		this.tarjeta = new Tarjeta(numeroTarjeta,codigoSeguridad,anioVencimiento,mesVencimiento,tipo);
	}
	
	
	public void registroConductor(String modelo, String marca,int idConductor,int asientosDisponibles, int anio)
	{
		this.conductor = new Conductor(idConductor);
		this.registroConductor = true;
		this.conductor.automovil = new Automovil(modelo,marca,asientosDisponibles,anio);
	}
	
	public void registrarTransporte(int idTransporte,int cantidadAsientos, float tarifa)
	{
		this.conductor.transporte = new Transporte(idTransporte,cantidadAsientos, tarifa);
	}
	
	public void registrarRuta(String universidadDestino)
	{
		this.conductor.transporte.ruta = new Ruta(universidadDestino);
	}
	
	public int asignarId()
	{
		return ((int)(Math.random()*999)+1);
	}
}
package com.example.erickcairdiel.koko;

public class Pruebas
{
	public static void main(String[] args) 
	{
		Usuario usuario = new Usuario();
		usuario.registraTelefono("6646703565");
		usuario.registraDatosGenerales("Erick","erick.gerardo@hotmail.com", "gatito123", 21, usuario.asignarId());
		usuario.registrarTarjeta("134564566",134,03,19,"Mastercard");
		usuario.registroConductor("Ford", "Focus", usuario.asignarId(), 6, 2017);
		usuario.registrarTransporte(usuario.asignarId(), 3, 21);
		usuario.registrarRuta("UABC");
		System.out.println(usuario.conductor.transporte.ruta.universidadDestino+usuario.conductor.idConductor);
		
	}
}
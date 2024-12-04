package Modelo;

import java.sql.Date;

public class Historico {
	public String fecha;
	public int nuevo_seguidores;
	public int interacciones;
	public Historico(String fecha, int nuevo_seguidores, int interacciones) {
		
		this.fecha = fecha;
		this.nuevo_seguidores = nuevo_seguidores;
		this.interacciones = interacciones;
	}
	public Historico() {
		
		this.fecha = fecha;
		this.nuevo_seguidores = nuevo_seguidores;
		this.interacciones = interacciones;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getNuevo_seguidores() {
		return nuevo_seguidores;
	}
	public void setNuevo_seguidores(int nuevo_seguidores) {
		this.nuevo_seguidores = nuevo_seguidores;
	}
	public int getInteracciones() {
		return interacciones;
	}
	public void setInteracciones(int interacciones) {
		this.interacciones = interacciones;
	}
	@Override
	public String toString() {
		return "historico [fecha=" + fecha + ", nuevo_seguidores=" + nuevo_seguidores + ", interacciones="
				+ interacciones + "]";
	}
	
}
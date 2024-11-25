package Modelo;

public class Historico {
	public String fecha;
	public int nuevos_seguidores;
	public int interacciones;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getNuevos_seguidores() {
		return nuevos_seguidores;
	}
	public void setNuevos_seguidores(int nuevos_seguidores) {
		this.nuevos_seguidores = nuevos_seguidores;
	}
	public int getInteracciones() {
		return interacciones;
	}
	public void setInteracciones(int interacciones) {
		this.interacciones = interacciones;
	}
	@Override
	public String toString() {
		return "Historico [fecha=" + fecha + ", nuevos_seguidores=" + nuevos_seguidores + ", interacciones="
				+ interacciones + "]";
	}
	
	
}

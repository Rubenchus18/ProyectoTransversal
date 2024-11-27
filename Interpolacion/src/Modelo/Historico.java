package Modelo;

public class Historico {
	public String fecha;
	public int nuevos_seguidores;
	public int interacciones;
	public Double Vistas;
	public Double MeGusta;
	public Double Rendimineto;
	public String TipoContenido;
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
	
	public Double getVistas() {
		return Vistas;
	}
	public void setVistas(Double vistas) {
		Vistas = vistas;
	}
	public Double getMeGusta() {
		return MeGusta;
	}
	public void setMeGusta(Double meGusta) {
		MeGusta = meGusta;
	}
	public Double getRendimineto() {
		return Rendimineto;
	}
	public void setRendimineto(Double rendimineto) {
		Rendimineto = rendimineto;
	}
	public String getTipoContenido() {
		return TipoContenido;
	}
	public void setTipoContenido(String tipoContenido) {
		TipoContenido = tipoContenido;
	}
	
	public String toString() {
		return "Historico [fecha=" + fecha + ", nuevos_seguidores=" + nuevos_seguidores + ", interacciones="
				+ interacciones + ", Vistas=" + Vistas + ", MeGusta=" + MeGusta + ", Rendimineto=" + Rendimineto
				+ ", TipoContenido=" + TipoContenido + "]";
	}
	
	
	
	
}

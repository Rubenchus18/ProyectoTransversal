package Modelo;

import java.util.List;

public class Plataforma {
	public String nombre;
	public String usuario;
	public int seguidores;
	public String fecha_creacion;
	public List<Historico> historico;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getSeguidores() {
		return seguidores;
	}
	public void setSeguidores(int seguidores) {
		this.seguidores = seguidores;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public List<Historico> getHistorico() {
		return historico;
	}
	public void setHistorico(List<Historico> historico) {
		this.historico = historico;
	}
	@Override
	public String toString() {
		return "Plataforma [nombre=" + nombre + ", usuario=" + usuario + ", seguidores=" + seguidores
				+ ", fecha_creacion=" + fecha_creacion + ", historico=" + historico + "]";
	}
	
}

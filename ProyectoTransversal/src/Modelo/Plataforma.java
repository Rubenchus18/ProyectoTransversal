package Modelo;

import java.sql.Date;
import java.util.List;

public class Plataforma {
	public String nombre;
	public String usuario;
	public int seguidores;
	public String fehca_creacion;
	public List<Historico>historico;
	public Plataforma(String nombre, String usuario, int seguidores, String fehca_creacion,
			List<Modelo.Historico> historico) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.seguidores = seguidores;
		this.fehca_creacion = fehca_creacion;
		this.historico = historico;
	}
	public Plataforma() {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.seguidores = seguidores;
		this.fehca_creacion = fehca_creacion;
		this.historico = historico;
	}
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
	public String getFehca_creacion() {
		return fehca_creacion;
	}
	public void setFehca_creacion(String fehca_creacion) {
		this.fehca_creacion = fehca_creacion;
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
				+ ", fehca_creacion=" + fehca_creacion + ", historico=" + historico + "]";
	}
	
}

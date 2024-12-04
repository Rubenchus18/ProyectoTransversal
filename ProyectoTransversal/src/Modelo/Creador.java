package Modelo;

import java.util.List;

public class Creador {
	public int id;
	public String nombre;
	public String pais;
	public String tematica;
	public int seguidores_totales;
	public List<Estadisticas>estadisticas;
	public List<Plataforma>plataforma;
	public List<Colaboraciones>colaboraciones;
	
	public Creador(int id, String nombre, String pais, String tematica, int seguidores_totales,
			List<Estadisticas> estadisticas, List<Plataforma> plataforma, List<Colaboraciones> colaboraciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.tematica = tematica;
		this.seguidores_totales = seguidores_totales;
		this.estadisticas = estadisticas;
		this.plataforma = plataforma;
		this.colaboraciones = colaboraciones;
	}
	public Creador() {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tematica = tematica;
		this.seguidores_totales = seguidores_totales;
		this.plataforma = plataforma;
		this.colaboraciones = colaboraciones;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public int getSeguidores_totales() {
		return seguidores_totales;
	}
	public void setSeguidores_totales(int seguidores_totales) {
		this.seguidores_totales = seguidores_totales;
	}
	public List<Estadisticas> getEstadisticas() {
		return estadisticas;
	}
	public void setEstadisticas(List<Estadisticas> estadisticas) {
		this.estadisticas = estadisticas;
	}
	public List<Plataforma> getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(List<Plataforma> plataforma) {
		this.plataforma = plataforma;
	}
	public List<Colaboraciones> getColaboraciones() {
		return colaboraciones;
	}
	public void setColaboraciones(List<Colaboraciones> colaboraciones) {
		this.colaboraciones = colaboraciones;
	}
	@Override
	public String toString() {
		return "Creador [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", tematica=" + tematica
				+ ", seguidores_totales=" + seguidores_totales + ", estadisticas=" + estadisticas + ", plataforma="
				+ plataforma + ", colaboraciones=" + colaboraciones + "]";
	}
	
	
}

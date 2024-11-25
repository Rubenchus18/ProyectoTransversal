package Modelo;

import java.util.List;

public class Creador {
	 	public Integer id;
	 	public String nombre;
	 	public String pais;
	 	public String tematica;
	 	public Integer seguidores_totales;
	 	public Estadisticas estadisticas;
	    public List<Plataforma> plataformas;
	    public List<Colaboracion> colaboraciones;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
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
		public Integer getSeguidores_totales() {
			return seguidores_totales;
		}
		public void setSeguidores_totales(Integer seguidores_totales) {
			this.seguidores_totales = seguidores_totales;
		}
		public Estadisticas getEstadisticas() {
			return estadisticas;
		}
		public void setEstadisticas(Estadisticas estadisticas) {
			this.estadisticas = estadisticas;
		}
		public List<Plataforma> getPlataformas() {
			return plataformas;
		}
		public void setPlataformas(List<Plataforma> plataformas) {
			this.plataformas = plataformas;
		}
		public List<Colaboracion> getColaboraciones() {
			return colaboraciones;
		}
		public void setColaboraciones(List<Colaboracion> colaboraciones) {
			this.colaboraciones = colaboraciones;
		}
		@Override
		public String toString() {
			return "Creador [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", tematica=" + tematica
					+ ", seguidores_totales=" + seguidores_totales + ", estadisticas=" + estadisticas + ", plataformas="
					+ plataformas + ", colaboraciones=" + colaboraciones + "]";
		}
	  
	    
}

package Modelo;

import com.opencsv.bean.CsvBindByName;

public class Contenido {
	@CsvBindByName(column="creador_id")
	private String creador_id;
	
	@CsvBindByName(column="plataforma")
	private String plataforma;
	
	@CsvBindByName(column="fecha")
	private String fecha;
	
	@CsvBindByName(column="contenido")
	private String contenido;
	
	@CsvBindByName(column="tipo")
	private String tipo;
	
	@CsvBindByName(column="vistas")
	private Integer vistas;
	
	@CsvBindByName(column="me_gusta")
	private Integer me_gustas;
	
	@CsvBindByName(column="comentarios")
	private Integer comentarios;
	
	@CsvBindByName(column="compartidos")
	private Integer compartidos;

	

	public String getCreador_id() {
		return creador_id;
	}

	public void setCreador_id(String creador_id) {
		this.creador_id = creador_id;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getVistas() {
		return vistas;
	}

	public void setVistas(Integer vistas) {
		this.vistas = vistas;
	}

	public Integer getMe_gustas() {
		return me_gustas;
	}

	public void setMe_gustas(Integer me_gustas) {
		this.me_gustas = me_gustas;
	}

	public Integer getComentarios() {
		return comentarios;
	}

	public void setComentarios(Integer comentarios) {
		this.comentarios = comentarios;
	}

	public Integer getCompartidos() {
		return compartidos;
	}

	public void setCompartidos(Integer compartidos) {
		this.compartidos = compartidos;
	}

	
	public String toString() {
		return "Contenido [creador_id=" + creador_id + ", plataforma=" + plataforma + ", fecha=" + fecha
				+ ", contenido=" + contenido + ", tipo=" + tipo + ", vistas=" + vistas + ", me_gustas=" + me_gustas
				+ ", comentarios=" + comentarios + ", compartidos=" + compartidos + "]";
	}
	
	
}

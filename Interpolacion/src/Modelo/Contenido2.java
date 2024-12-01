package Modelo;

public class Contenido2 {
	 public String id_creador;
     public  String plataforma;
     public String fecha;
     public String contenidoTexto ;
     public String tipo;
     public Integer vistasTexto;
     public Integer me_gustaTexto;
     public Integer comentariosTexto;
     public Integer compartidosTexto;
	public Contenido2(String id_creador, String plataforma, String fecha, String contenidoTexto, String tipo,
			Integer vistasTexto, Integer me_gustaTexto, Integer comentariosTexto, Integer compartidosTexto) {
		super();
		this.id_creador = id_creador;
		this.plataforma = plataforma;
		this.fecha = fecha;
		this.contenidoTexto = contenidoTexto;
		this.tipo = tipo;
		this.vistasTexto = vistasTexto;
		this.me_gustaTexto = me_gustaTexto;
		this.comentariosTexto = comentariosTexto;
		this.compartidosTexto = compartidosTexto;
	}
	public String getId_creador() {
		return id_creador;
	}
	public void setId_creador(String id_creador) {
		this.id_creador = id_creador;
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
	public String getContenidoTexto() {
		return contenidoTexto;
	}
	public void setContenidoTexto(String contenidoTexto) {
		this.contenidoTexto = contenidoTexto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getVistasTexto() {
		return vistasTexto;
	}
	public void setVistasTexto(Integer vistasTexto) {
		this.vistasTexto = vistasTexto;
	}
	public Integer getMe_gustaTexto() {
		return me_gustaTexto;
	}
	public void setMe_gustaTexto(Integer me_gustaTexto) {
		this.me_gustaTexto = me_gustaTexto;
	}
	public Integer getComentariosTexto() {
		return comentariosTexto;
	}
	public void setComentariosTexto(Integer comentariosTexto) {
		this.comentariosTexto = comentariosTexto;
	}
	public Integer getCompartidosTexto() {
		return compartidosTexto;
	}
	public void setCompartidosTexto(Integer compartidosTexto) {
		this.compartidosTexto = compartidosTexto;
	}
	@Override
	public String toString() {
		return "Contenido2 [id_creador=" + id_creador + ", plataforma=" + plataforma + ", fecha=" + fecha
				+ ", contenidoTexto=" + contenidoTexto + ", tipo=" + tipo + ", vistasTexto=" + vistasTexto
				+ ", me_gustaTexto=" + me_gustaTexto + ", comentariosTexto=" + comentariosTexto + ", compartidosTexto="
				+ compartidosTexto + "]";
	}
     

}

package Modelo;

public class Colaboracion {
	 private String colaborador;
	 public String tematica;
	 public String fecha_inicio;
	 public String fecha_fin;
	 public String tipo;
	 public String estado;
		
	    public String getColaborador() {
			return colaborador;
		}
		public void setColaborador(String colaborador) {
			this.colaborador = colaborador;
		}
		public String getTematica() {
			return tematica;
		}
		public void setTematica(String tematica) {
			this.tematica = tematica;
		}
		public String getFecha_inicio() {
			return fecha_inicio;
		}
		public void setFecha_inicio(String fecha_inicio) {
			this.fecha_inicio = fecha_inicio;
		}
		public String getFecha_fin() {
			return fecha_fin;
		}
		public void setFecha_fin(String fecha_fin) {
			this.fecha_fin = fecha_fin;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		@Override
		public String toString() {
			return "Colaboracion [colaborador=" + colaborador + ", tematica=" + tematica + ", fecha_inicio="
					+ fecha_inicio + ", fecha_fin=" + fecha_fin + ", tipo=" + tipo + ", estado=" + estado + "]";
		}
	    
	    
}

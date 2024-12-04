package Modelo;

public class Estadisticas {
	public int interacciones_totales;
	public int promedio_vistas_mensuales;
	public int tasa_crecimiento_seguidores;
	public Estadisticas(int interacciones_totales, int promedio_vistas_mensuales, int tasa_crecimiento_seguidores) {
		super();
		this.interacciones_totales = interacciones_totales;
		this.promedio_vistas_mensuales = promedio_vistas_mensuales;
		this.tasa_crecimiento_seguidores = tasa_crecimiento_seguidores;
	}
	public Estadisticas() {
		super();
		this.interacciones_totales = interacciones_totales;
		this.promedio_vistas_mensuales = promedio_vistas_mensuales;
		this.tasa_crecimiento_seguidores = tasa_crecimiento_seguidores;
	}
	public int getInteracciones_totales() {
		return interacciones_totales;
	}
	public void setInteracciones_totales(int interacciones_totales) {
		this.interacciones_totales = interacciones_totales;
	}
	public int getPromedio_vistas_mensuales() {
		return promedio_vistas_mensuales;
	}
	public void setPromedio_vistas_mensuales(int promedio_vistas_mensuales) {
		this.promedio_vistas_mensuales = promedio_vistas_mensuales;
	}
	public int getTasa_crecimiento_seguidores() {
		return tasa_crecimiento_seguidores;
	}
	public void setTasa_crecimiento_seguidores(int tasa_crecimiento_seguidores) {
		this.tasa_crecimiento_seguidores = tasa_crecimiento_seguidores;
	}
	@Override
	public String toString() {
		return "Estadisticas [interacciones_totales=" + interacciones_totales + ", promedio_vistas_mensuales="
				+ promedio_vistas_mensuales + ", tasa_crecimiento_seguidores=" + tasa_crecimiento_seguidores + "]";
	}
	
}

package Modelo;

public class InformeCreador {
    public  String nombreCreador;
    public  int totalSeguidores;
    public String plataformaMayorInteraccion;

    public InformeCreador(String nombreCreador, int totalSeguidores, String plataformaMayorInteraccion) {
        this.nombreCreador = nombreCreador;
        this.totalSeguidores = totalSeguidores;
        this.plataformaMayorInteraccion = plataformaMayorInteraccion;
    }

	public String getNombreCreador() {
		return nombreCreador;
	}

	public void setNombreCreador(String nombreCreador) {
		this.nombreCreador = nombreCreador;
	}

	public int getTotalSeguidores() {
		return totalSeguidores;
	}

	public void setTotalSeguidores(int totalSeguidores) {
		this.totalSeguidores = totalSeguidores;
	}

	public String getPlataformaMayorInteraccion() {
		return plataformaMayorInteraccion;
	}

	public void setPlataformaMayorInteraccion(String plataformaMayorInteraccion) {
		this.plataformaMayorInteraccion = plataformaMayorInteraccion;
	}

	public String toString() {
		return "InformeCreador [nombreCreador=" + nombreCreador + ", totalSeguidores=" + totalSeguidores
				+ ", plataformaMayorInteraccion=" + plataformaMayorInteraccion + "]";
	}
    
}

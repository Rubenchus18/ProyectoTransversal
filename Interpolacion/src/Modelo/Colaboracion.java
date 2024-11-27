package Modelo;

public class Colaboracion {
    private String colaborador;
    private String tematica;
    private String fecha_inicio;
    private String fecha_fin;
    private String tipo;
    private String estado;
    private String plataforma; // Agregado para almacenar el nombre de la plataforma
    private int impactoSeguidores; // Agregado para almacenar el impacto en seguidores
    private int impactoVisualizaciones; // Agregado para almacenar el impacto en visualizaciones

    // Getters y Setters
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

    public String getPlataforma() {
        return plataforma; // Método para obtener el nombre de la plataforma
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma; // Método para establecer el nombre de la plataforma
    }

    public int getImpactoSeguidores() {
        return impactoSeguidores;
    }

    public void setImpactoSeguidores(int impactoSeguidores) {
        this.impactoSeguidores = impactoSeguidores;
    }

    public int getImpactoVisualizaciones() {
        return impactoVisualizaciones;
    }

    public void setImpactoVisualizaciones(int impactoVisualizaciones) {
        this.impactoVisualizaciones = impactoVisualizaciones;
    }

   
    public String toString() {
        return "Colaboracion [colaborador=" + colaborador + ", tematica=" + tematica + ", fecha_inicio="
                + fecha_inicio + ", fecha_fin=" + fecha_fin + ", tipo=" + tipo + ", estado=" + estado
                + ", plataforma=" + plataforma + ", impactoSeguidores=" + impactoSeguidores + ", impactoVisualizaciones=" + impactoVisualizaciones + "]";
    }
}
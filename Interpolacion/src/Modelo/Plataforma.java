package Modelo;

import java.util.List;

public class Plataforma {
    private String nombre;
    private String usuario;
    private int seguidores;
    private String fecha_creacion;
    private List<Historico> historico;
    private int impactoSeguidores; 
    private int impactoVisualizaciones;

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
        return "Plataforma [nombre=" + nombre + ", usuario=" + usuario + ", seguidores=" + seguidores
                + ", fecha_creacion=" + fecha_creacion + ", historico=" + historico
                + ", impactoSeguidores=" + impactoSeguidores + ", impactoVisualizaciones=" + impactoVisualizaciones + "]";
    }
}
package Controlador;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import Modelo.Colaboracion;
import Modelo.Creador;
import Modelo.Historico;
import Modelo.Plataforma;

public class Controlador {
	 public static void main(String[] args) {
	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            Creador[] creadores = objectMapper.readValue(new File("files/creadores.json"), Creador[].class);
	            for (Creador creador : creadores) {
	                System.out.println("ID: " + creador.getId());
	                System.out.println("Nombre: " + creador.getNombre());
	                System.out.println("País: " + creador.getPais());
	                System.out.println("Temática: " + creador.getTematica());
	                System.out.println("Seguidores Totales: " + creador.getSeguidores_totales());
	                System.out.println("Interacciones Totales: " + creador.getEstadisticas().getInteracciones_totales());
	                System.out.println("Promedio Vistas Mensuales: " + creador.getEstadisticas().getPromedio_vistas_mensuales());
	                System.out.println("Tasa Crecimiento Seguidores: " + creador.getEstadisticas().getTasa_crecimiento_seguidores());
	                
	                for (Plataforma plataforma : creador.getPlataformas()) {
	                    System.out.println("  Plataforma: " + plataforma.getNombre());
	                    System.out.println("  Usuario: " + plataforma.getUsuario());
	                    System.out.println("  Seguidores: " + plataforma.getSeguidores());
	                    System.out.println("  Fecha Creación: " + plataforma.getFecha_creacion());
	                    for (Historico historico : plataforma.getHistorico()) {
	                        System.out.println("    Fecha: " + historico.getFecha());
	                        System.out.println("    Nuevos Seguidores: " + historico.getNuevos_seguidores());
	                        System.out.println("    Interacciones: " + historico.getInteracciones());
	                    }
	                }
	                
	                for (Colaboracion colaboracion : creador.getColaboraciones()) {
	                    System.out.println("  Colaboración con: " + colaboracion.getColaborador());
	                    System.out.println("    Temática: " + colaboracion.getTematica());
	                    System.out.println("    Fecha Inicio: " + colaboracion.getFecha_inicio());
	                    System.out.println("    Fecha Fin: " + colaboracion.getFecha_fin());
	                    System.out.println("    Tipo: " + colaboracion.getTipo());
	                    System.out.println("    Estado: " + colaboracion.getEstado());
	                }
	                System.out.println();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

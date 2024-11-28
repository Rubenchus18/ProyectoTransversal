package Controlador;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import Modelo.Colaboracion;
import Modelo.Contenido;
import Modelo.Creador;
import Modelo.Historico;
import Modelo.InformeCreador;
import Modelo.Plataforma;
import Vsita.VistaStreamer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.DefaultListModel;

public class Controlador implements ActionListener{
	Controlador control;
	VistaStreamer vista=new VistaStreamer();
	DefaultListModel modelo=new DefaultListModel();
	ObjectMapper objectMapper = new ObjectMapper();
	List<Contenido> contenido=new ArrayList<Contenido>();
	public Controlador(VistaStreamer vista) throws JsonParseException, JsonMappingException, IOException {
		
	
		
		
		JsonNode rootnode = objectMapper.readTree(new File("files/creadores.json"));
		ArrayNode streamernode=(ArrayNode)rootnode;
		control.mostrarDatosCreador(streamernode);
        contenido=abrirCSV("files/metricas_contenido.csv");
	}
    public void actionPerformed(ActionEvent e) {
    	
    }

//Metodos
    // Método auxiliar para mostrar datos de un creador
    public void mostrarDatosCreador(ArrayNode streamernode) {
        System.out.println("ID: " + streamernode.get("id").asText());
        System.out.println("Nombre: " + streamernode.get("nombre").asText());
        System.out.println("País: " + streamernode.get("pais").asText());
        System.out.println("Temática: " + streamernode.get("tematicas").asText());
        System.out.println("Seguidores Totales: " + streamernode.get("seguidores_totales").asText());
        System.out.println("Interacciones Totales: " + streamernode.get("estadisticas").get("interacciones_totales").asText());
        System.out.println("Promedio Vistas Mensuales: " + streamernode.get("estadisticas").get("promedio_vistas_mensuales").asText());
        System.out.println("Tasa Crecimiento Seguidores: " + streamernode.get("estadisticas").get("tasa_crecimiento_seguidores").asText());
        for (JsonNode plataforma : streamernode.get("plataformas")) {
        	System.out.println("  Plataforma: " + plataforma.get("nombre").asText());
            System.out.println("  Usuario: " + plataforma.get("usuario").asText());
            System.out.println("  Seguidores: " + plataforma.get("seguidores").asText());
            System.out.println("  Fecha Creación: " + plataforma.get("fecha_creacion").asText());
            for (JsonNode historico : plataforma.get("historico")) {
                System.out.println("    Fecha: " + historico.get("Fecha"));
                System.out.println("    Nuevos Seguidores: " + historico.get("nuevos_seguidores").asText());
                System.out.println("    Interacciones: " + historico.get("interaciones").asText());
            }
        }
        System.out.println("  Plataforma: " + streamernode.get("nombre").asText());
        System.out.println("  Usuario: " + streamernode.get("usuario").asText());
        System.out.println("  Seguidores: " + streamernode.get("seguidores").asText());
        System.out.println("  Fecha Creación: " + streamernode.get("fecha_creacion").asText());
        for (JsonNode historico : streamernode.get("Historico")) {
            System.out.println("    Fecha: " + historico.get("fecha").asText());
            System.out.println("    Nuevos Seguidores: " + historico.get("nuevo_seguidores").asText());
            System.out.println("    Interacciones: " + historico.get("interacciones").asText());
        }
        for (JsonNode colaboracion : streamernode.get("colaboraciones")) {
        	 System.out.println("  Colaboración con: " + colaboracion.get("colaborador").asText());
             System.out.println("    Temática: " + colaboracion.get("tematica").asText());
             System.out.println("    Fecha Inicio: " + colaboracion.get("fecha_inicio").asText());
             System.out.println("    Fecha Fin: " + colaboracion.get("fecha_fin").asText());
             System.out.println("    Tipo: " + colaboracion.get("tipo").asText());
             System.out.println("    Estado: " + colaboracion.get("estado").asText());
        }
    }
    public List<Contenido> abrirCSV(String rutaCSV) {
        List<Contenido> contenidoList = new ArrayList<>();
        try  {
        	  FileReader reader = new FileReader(rutaCSV);
        	  CsvToBeanBuilder<Contenido>csvBuilder=new CsvToBeanBuilder<Contenido>(reader);
        	  CsvToBean<Contenido>csv=csvBuilder.withType(Contenido.class).withIgnoreLeadingWhiteSpace(true).build();
            contenidoList = csv.parse();
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo CSV: " + e.getMessage());
        }
        return contenidoList;
    }

    // Método auxiliar para mostrar datos de una plataforma
    public void mostrarDatosPlataforma(Plataforma plataforma) {
        
    }

    // Método auxiliar para mostrar datos de una colaboración
    public void mostrarDatosColaboracion(Colaboracion colaboracion) {
        System.out.println("  Colaboración con: " + colaboracion.getColaborador());
        System.out.println("    Temática: " + colaboracion.getTematica());
        System.out.println("    Fecha Inicio: " + colaboracion.getFecha_inicio());
        System.out.println("    Fecha Fin: " + colaboracion.getFecha_fin());
        System.out.println("    Tipo: " + colaboracion.getTipo());
        System.out.println("    Estado: " + colaboracion.getEstado());
    }

    // Método para abrir un archivo CSV y leer contenido
   
    public void mostrarDatos(Creador[] creadores,List<Contenido>contenido) {
    	
    }
    // Método para insertar una nueva colaboración
    public void insertarNuevaColaboracion(Creador creador1, Creador creador2, Colaboracion colaboracion) {
        if (creador1 != null && colaboracion != null) {
            creador1.getColaboraciones().add(colaboracion);
            for (Plataforma plataforma : creador1.getPlataformas()) {
                if (plataforma.getNombre().equals(colaboracion.getPlataforma())) {
                    plataforma.setImpactoSeguidores(plataforma.getImpactoSeguidores() + colaboracion.getImpactoSeguidores());
                    plataforma.setImpactoVisualizaciones(plataforma.getImpactoVisualizaciones() + colaboracion.getImpactoVisualizaciones());
                }
            }
            crearCSV(creador1, "creadores.csv");
        } else {
            System.out.println("Creador o colaboración no pueden ser nulos.");
        }
    }

    // Método para exportar colaboraciones a un archivo CSV
    public void exportarColaboracionesACSV(Creador[] creadores, String rutaCSV) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("files/" + rutaCSV))) {
            String[] header = { "Fecha", "Creador", "Colaborador", "Impacto Seguidores", "Impacto Visualizaciones" };
            writer.writeNext(header);
            for (Creador creador : creadores) {
                if (creador.getColaboraciones() != null) {
                    for (Colaboracion colaboracion : creador.getColaboraciones()) {
                        String[] data = {
                            colaboracion.getFecha_inicio() != null ? colaboracion.getFecha_inicio() : "N/A",
                            creador.getNombre(),
                            colaboracion.getColaborador() != null ? colaboracion.getColaborador() : "N/A",
                            String.valueOf(colaboracion.getImpactoSeguidores()),
                            String.valueOf(colaboracion.getImpactoVisualizaciones())
                        };
                        writer.writeNext(data);
                    }
                }
            }

            System.out.println("Colaboraciones exportadas exitosamente a " + "files/" + rutaCSV);
        } catch (IOException e) {
            System.out.println("Error al exportar colaboraciones: " + e.getMessage());
        }
    }


    // Método para modificar una publicación
    public void modificarPublicacion(List<Contenido> contenido, String rutaCSV, String idPublicacion, Integer nuevosMeGusta, Integer nuevosComentarios) {
        boolean encontrado = false;

        for (Contenido c : contenido) {
            if (c.getCreador_id().equals(idPublicacion)) {
                if (nuevosMeGusta != null) {
                    c.setMe_gustas(nuevosMeGusta);
                }
                if (nuevosComentarios != null) {
                    c.setComentarios(nuevosComentarios);
                }
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            guardarContenidoEnCSV (contenido, "files/"+rutaCSV);
            System.out.println("Publicación con ID " + idPublicacion + " modificada exitosamente.");
        } else {
            System.out.println("No se encontró la publicación con ID " + idPublicacion + ".");
        }
    }

    // Método para eliminar publicaciones por vistas
    public void eliminarPublicacionesPorVistas(List<Contenido> contenido, String rutaCSV, int umbralVistas) {
       
        if (contenido == null) {
            System.out.println("La lista de contenido es nula. No se pueden eliminar publicaciones.");
            return; 
        }

        if (umbralVistas < 0) {
            System.out.println("El umbral de vistas debe ser un número positivo.");
            return; 
        }

        System.out.println("Eliminando publicaciones con menos de " + umbralVistas + " vistas...");

      
        Iterator<Contenido> iterator = contenido.iterator();
        int publicacionesEliminadas = 0;

        while (iterator.hasNext()) {
            Contenido c = iterator.next();
           
            if (c.getVistas() < umbralVistas) {
                iterator.remove();
                publicacionesEliminadas++;
            }
        }

      
        guardarContenidoEnCSV(contenido, "files/"+rutaCSV);

        // Informar al usuario cuántas publicaciones fueron eliminadas
        System.out.println("Se eliminaron " + publicacionesEliminadas + " publicaciones con menos de " + umbralVistas + " vistas.");
    }

    // Método para convertir colaboraciones a JSON
    public void convertirColaboracionesAJSON(Creador[] creadores) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Colaboracion> todasColaboraciones = new ArrayList<>();
            for (Creador creador : creadores) {
                todasColaboraciones.addAll(creador.getColaboraciones());
            }
            objectMapper.writeValue(new File("files/colaboraciones.json"), todasColaboraciones);
            System.out.println("Colaboraciones convertidas exitosamente a JSON.");
        } catch (IOException e) {
            System.out.println("Error al convertir colaboraciones a JSON: " + e.getMessage());
        }
    }

    // Método para generar un informe del creador
    public void generarInformeCreador(String rutaJSON, Creador[] creadores) {
        List<InformeCreador> informes = new ArrayList<>();

        for (Creador creador : creadores) {
            int totalSeguidores = 0;
            String plataformaMayorInteraccion = "";
            double maxInteraccionPromedio = 0;

            for (Plataforma plataforma : creador.getPlataformas()) {
                totalSeguidores += plataforma.getSeguidores();
                double totalInteracciones = 0;
                int cantidadRegistros = plataforma.getHistorico().size();

                for (Historico historico : plataforma.getHistorico()) {
                    totalInteracciones += historico.getInteracciones();
                }

                double interaccionPromedio = cantidadRegistros > 0 ? totalInteracciones / cantidadRegistros : 0;
                if (interaccionPromedio > maxInteraccionPromedio) {
                    maxInteraccionPromedio = interaccionPromedio;
                    plataformaMayorInteraccion = plataforma.getNombre();
                }
            }

            informes.add(new InformeCreador(creador.getNombre(), totalSeguidores, plataformaMayorInteraccion));
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("files/"+rutaJSON), informes);
            System.out.println("Informe generado exitosamente en " + "files/"+rutaJSON);
        } catch (IOException e) {
            System.out.println("Error al generar el informe: " + e.getMessage());
        }
    }

    // Método para analizar el crecimiento de seguidores
    public void analizarCrecimientoSeguidores(Creador[] creadores) {
        for (Creador creador : creadores) {
            System.out.println("Creador: " + creador.getNombre());
            for (Plataforma plataforma : creador.getPlataformas()) {
                System.out.println("  Plataforma: " + plataforma.getNombre());
                analizarHistoricoSeguidores(plataforma);
            }
        }
    }

    // Método auxiliar para analizar el histórico de seguidores
    public void analizarHistoricoSeguidores(Plataforma plataforma) {
        int seguidoresInicio = 0;
        int seguidoresFin = 0;
        double tasaCrecimientoEnero = 0;
        double tasaCrecimientoFebrero = 0;
        double tasaCrecimientoMarzo = 0;

        for (Historico historico : plataforma.getHistorico()) {
            String mes = historico.getFecha().split("-")[1]; 

            if (mes.equals("01")) {
                seguidoresInicio = historico.getNuevos_seguidores();
            } else if (mes.equals("02")) {
                seguidoresFin = historico.getNuevos_seguidores();
                if (seguidoresInicio > 0) {
                    tasaCrecimientoFebrero = ((double) (seguidoresFin - seguidoresInicio) / seguidoresInicio) * 100;
                }
            } else if (mes.equals("03")) {
                seguidoresInicio = historico.getNuevos_seguidores();
                if (seguidoresFin > 0) {
                    tasaCrecimientoMarzo = ((double) (seguidoresInicio - seguidoresFin) / seguidoresFin) * 100;
                }
            }
        }
        System.out.printf("    T asa de Crecimiento en Enero: %.2f%%\n", tasaCrecimientoEnero);
        System.out.printf("    Tasa de Crecimiento en Febrero: %.2f%%\n", tasaCrecimientoFebrero);
        System.out.printf("    Tasa de Crecimiento en Marzo: %.2f%%\n", tasaCrecimientoMarzo);
    }

    // Método para generar un reporte de colaboraciones
    public void generarReporteColaboraciones(String rutaCSV, Creador[] creadores) {
        try  {
        	CSVWriter writer = new CSVWriter(new FileWriter("files/"+rutaCSV));
            String[] header = { "Fecha Inicio", "Fecha Fin", "Creador", "Colaborador", "Plataforma", "Temática", "Tipo", "Estado" };
            writer.writeNext(header);

            for (Creador creador : creadores) {
                for (Colaboracion colaboracion : creador.getColaboraciones()) {
                    String[] data = {
                        colaboracion.getFecha_inicio(),
                        colaboracion.getFecha_fin(),
                        creador.getNombre(),
                        colaboracion.getColaborador(),
                        colaboracion.getPlataforma(),
                        colaboracion.getTematica(),
                        colaboracion.getTipo(),
                        colaboracion.getEstado()
                    };
                    writer.writeNext(data);
                }
            }
            System.out.println("Reporte de colaboraciones generado exitosamente en " + "files/"+rutaCSV);
        } catch (IOException e) {
            System.out.println("Error al generar el reporte de colaboraciones: " + e.getMessage());
        }
    }

    // Método para analizar el rendimiento del contenido
    public void analizarRendimientoContenido(List<Contenido> contenido) {
        Map<String, Map<String, double[]>> rendimiento = new HashMap<>();

        for (Contenido c : contenido) {
            String tipoContenido = c.getTipo();
            String plataforma = c.getPlataforma();

            rendimiento.putIfAbsent(tipoContenido, new HashMap<>());
            rendimiento.get(tipoContenido).putIfAbsent(plataforma, new double[3]); // [total vistas, total me gusta, cantidad]

            rendimiento.get(tipoContenido).get(plataforma)[0] += c.getVistas();
            rendimiento.get(tipoContenido).get(plataforma)[1] += c.getMe_gustas();
            rendimiento.get(tipoContenido).get(plataforma)[2] += 1;
        }

        System.out.println("Análisis Comparativo de Rendimiento:");
        for (String tipo : rendimiento.keySet()) {
            System.out.println("Tipo de Contenido: " + tipo);
            for (String plataforma : rendimiento.get(tipo).keySet()) {
                double totalVistas = rendimiento.get(tipo).get(plataforma)[0];
                double totalMeGusta = rendimiento.get(tipo).get(plataforma)[1];
                double cantidad = rendimiento.get(tipo).get(plataforma)[2];

                double promedioVistas = cantidad > 0 ? totalVistas / cantidad : 0;
                double promedioMeGusta = cantidad > 0 ? totalMeGusta / cantidad : 0;

                System.out.printf("  Plataforma: %s, Promedio Vistas: %.2f, Promedio Me Gusta: %.2f\n", plataforma, promedioVistas, promedioMeGusta);
            }
        }
    }

    // Método para generar un resumen de rendimiento
    public void generarResumenRendimiento(String rutaJSON, Creador[] creadores) {
        List<Map<String, Object>> resumen = new ArrayList<>();
        for (Creador creador : creadores) {
            String creadorNombre = creador.getNombre();
            String plataformaMasVistas = "";
            String plataformaMasInteracciones = "";
            double maxVistas = 0;
            double maxInteracciones = 0;

            for (Plataforma plataforma : creador.getPlataformas()) {
                double totalVistas = 0;
                double totalInteracciones = 0;
                int cantidadRegistros = plataforma.getHistorico().size();

                for (Historico historico : plataforma.getHistorico()) {
                    totalVistas += historico.getVistas();
                    totalInteracciones += historico.getInteracciones();
                }
                double promedioVistas = cantidadRegistros > 0 ? totalVistas / cantidadRegistros : 0;
                double promedioInteracciones = cantidadRegistros > 0 ? totalInteracciones / cantidadRegistros : 0;

                if (promedioVistas > maxVistas) {
                    maxVistas = promedioVistas;
                    plataformaMasVistas = plataforma.getNombre();
                }

                if (promedioInteracciones > maxInteracciones) {
                    maxInteracciones = promedioInteracciones;
                    plataformaMasInteracciones = plataforma.getNombre();
                }
            }

            Map<String, Object> creadorResumen = new HashMap<>();
            creadorResumen.put("Creador", creadorNombre);
            creadorResumen.put("Plataforma con más vistas", plataformaMasVistas);
            creadorResumen.put("Plataforma con más interacciones", plataformaMasInteracciones);

            resumen.add(creadorResumen);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("files/"+rutaJSON), resumen);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    // Método para agregar una nueva publicación
    public void agregarPublicacion(List<Contenido> contenido, Contenido nuevaPublicacion, String rutaCSV) {
        if (nuevaPublicacion != null) {
            contenido.add(nuevaPublicacion);
            guardarContenidoEnCSV(contenido, "files/"+rutaCSV);
            System.out.println("Publicación agregada exitosamente.");
        } else {
            System.out.println("La nueva publicación no puede ser nula.");
        }
    }
    //Metodo convertir colaboradores a Json
    public void convertirColaboracionesAJSON2(Creador[] creadores) {
        List<Colaboracion> todasColaboraciones = new ArrayList<>();

        for (Creador creador : creadores) {
            todasColaboraciones.addAll(creador.getColaboraciones());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("files/colaboraciones.json"), todasColaboraciones);
            System.out.println("Colaboraciones convertidas exitosamente a JSON y guardadas en colaboraciones.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar contenido en un archivo CSV
    public void guardarContenidoEnCSV(List<Contenido> contenido, String rutaCSV) {
        try  {
        	FileWriter writer = new FileWriter("files/"+rutaCSV);
            StatefulBeanToCsv<Contenido> beanToCsv = new StatefulBeanToCsvBuilder<Contenido>(writer).build();
            beanToCsv.write(contenido);
            writer.flush();
            System.out.println("Contenido guardado exitosamente en " + "files/"+rutaCSV);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("Error al guardar contenido en CSV: " + e.getMessage());
        }
    }

    // Método para crear un archivo CSV para un creador
    public void crearCSV(Creador creador, String rutaCSV) {
        try (FileWriter fw = new FileWriter("files/"+rutaCSV)) {
            StatefulBeanToCsv<Creador> beanToCsv = new StatefulBeanToCsvBuilder<Creador>(fw).build();
            beanToCsv.write(Arrays.asList(creador));
            fw.flush();
            System.out.println("CSV creado exitosamente para el creador en " + "files/"+rutaCSV);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.err.println("Error al crear CSV para el creador: " + e.getMessage());
        }
    }
    //METODOS
    /*controlador.exportarColaboracionesACSV(creadores, "Colaboraciones.csv");
    controlador.convertirColaboracionesAJSON(creadores);
    controlador.modificarPublicacion(contenido, "metricas_contenido.csv", null, null, null);
    controlador.eliminarPublicacionesPorVistas(contenido, "metricas_contenido.csv", 3000);
    controlador.generarInformeCreador("informe_creadores.json", creadores);
    controlador.analizarCrecimientoSeguidores(creadores);
    controlador.generarReporteColaboraciones("reporte_colaboraciones.csv", creadores);
    controlador.analizarRendimientoContenido(contenido);
    controlador.generarResumenRendimiento("resumen_rendimiento.json", creadores);
    controlador.agregarPublicacion(contenido, null, "metricas_contenido.csv");
    controlador.convertirColaboracionesAJSON2(creadores);
   controlador.insertarNuevaColaboracion(null, null, null);*/
}
package Controlador;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.io.*;
import java.util.*;

public class Controlador {
    public static void main(String[] args) {
        try {
            Controlador controlador = new Controlador();
            // Leer y mostrar datos de creadores
            Creador[] creadores = controlador.leerYVisualizarDatos();
            // Leer contenido desde un archivo CSV
            List<Contenido> contenido = controlador.abrirCSV("files/metricas_contenido.csv");

            
            controlador.insertarNuevaColaboracion(null, null, null); 
            controlador.exportarColaboracionesACSV(creadores, "nuevo.csv");
            controlador.modificarPublicacion(contenido, "metricas_contenido.csv", null, null, null);
            controlador.eliminarPublicacionesPorVistas(contenido, "metricas_contenido.csv", 3000);
            controlador.convertirColaboracionesAJSON(creadores);
            controlador.generarInformeCreador("informe_creadores.json", creadores);
            controlador.analizarCrecimientoSeguidores(creadores);
            controlador.generarReporteColaboraciones("reporte_colaboraciones.csv", creadores);
            controlador.analizarRendimientoContenido(contenido);
            controlador.generarResumenRendimiento("resumen_rendimiento.json", creadores);
            controlador.agregarPublicacion(contenido, null, "metricas_contenido.csv");
            controlador.convertirColaboracionesAJSON2(creadores);
        } catch (Exception e) {
            System.err.println("Error en la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Método para leer y mostrar datos de creadores desde un archivo JSON
    public Creador[] leerYVisualizarDatos() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Creador[] creadores = objectMapper.readValue(new File("files/creadores.json"), Creador[].class);

        for (Creador creador : creadores) {
            mostrarDatosCreador(creador);
        }
        return creadores;
    }

    // Método auxiliar para mostrar datos de un creador
    public void mostrarDatosCreador(Creador creador) {
        System.out.println("ID: " + creador.getId());
        System.out.println("Nombre: " + creador.getNombre());
        System.out.println("País: " + creador.getPais());
        System.out.println("Temática: " + creador.getTematica());
        System.out.println("Seguidores Totales: " + creador.getSeguidores_totales());
        System.out.println("Interacciones Totales: " + creador.getEstadisticas().getInteracciones_totales());
        System.out.println("Promedio Vistas Mensuales: " + creador.getEstadisticas().getPromedio_vistas_mensuales());
        System.out.println("Tasa Crecimiento Seguidores: " + creador.getEstadisticas().getTasa_crecimiento_seguidores());

        for (Plataforma plataforma : creador.getPlataformas()) {
            mostrarDatosPlataforma(plataforma);
        }

        for (Colaboracion colaboracion : creador.getColaboraciones()) {
            mostrarDatosColaboracion(colaboracion);
        }
        System.out.println();
    }

    // Método auxiliar para mostrar datos de una plataforma
    public void mostrarDatosPlataforma(Plataforma plataforma) {
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
    public List<Contenido> abrirCSV(String rutaCSV) {
        List<Contenido> contenidoList = new ArrayList<>();
        try  {
        	  FileReader reader = new FileReader(rutaCSV);
            CsvToBean<Contenido> csvToBean = new CsvToBeanBuilder<Contenido>(reader)
                    .withType(Contenido.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            contenidoList = csvToBean.parse();
        } catch (Exception e) {
            System.err.println("Error al abrir el archivo CSV: " + e.getMessage());
        }
        return contenidoList;
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
            System.err.println("Creador o colaboración no pueden ser nulos.");
        }
    }

    // Método para exportar colaboraciones a un archivo CSV
    public void exportarColaboracionesACSV(Creador[] creadores, String rutaCSV) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(rutaCSV))) {
            String[] header = { "Fecha", "Creador", "Colaborador", "Impacto Seguidores", "Impacto Visualizaciones" };
            writer.writeNext(header);
            for (Creador creador : creadores) {
                for (Colaboracion colaboracion : creador.getColaboraciones()) {
                    String[] data = {
                        colaboracion.getFecha_inicio(),
                        creador.getNombre(),
                        colaboracion.getColaborador(),
                        String.valueOf(colaboracion.getImpactoSeguidores()),
                        String.valueOf(colaboracion.getImpactoVisualizaciones())
                    };
                    writer.writeNext(data);
                }
            }
            System.out.println("Colaboraciones exportadas exitosamente a " + "files/"+rutaCSV);
        } catch (IOException e) {
            System.err.println("Error al exportar colaboraciones: " + e.getMessage());
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
            System.err.println("El umbral de vistas debe ser un número positivo.");
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
            System.err.println("Error al convertir colaboraciones a JSON: " + e.getMessage());
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
            System.err.println("Error al generar el informe: " + e.getMessage());
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
            System.err.println("Error al generar el reporte de colaboraciones: " + e.getMessage());
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
            System.err.println("La nueva publicación no puede ser nula.");
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
            System.err.println("Error al guardar contenido en CSV: " + e.getMessage());
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
}
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import Modelo.Colaboraciones;
import Modelo.Contenido;
import Modelo.Creador;
import Modelo.Estadisticas;
import Modelo.Historico;
import Modelo.Plataforma;
import Vsita.Vista;

public class Controlador implements ActionListener{
    Controlador control;
    Vista vista=new Vista();
    DefaultTableModel modelo2=new DefaultTableModel() ;
    DefaultListModel modelo=new DefaultListModel();
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayNode streamer = objectMapper.createArrayNode();
    List<Contenido> contenido=new ArrayList<Contenido>();
    public Controlador(Vista vista) throws JsonParseException, JsonMappingException, IOException {
    	this.vista=vista;
    	this.vista.btnVerStreamer.addActionListener(this);
    	this.vista.btnVolverMostrarTodo.addActionListener(this);
    	this.vista.btnVerMetrica.addActionListener(this);
    	this.vista.btnVolverMetrica.addActionListener(this);
    	this.vista.btnInsertarnuevoscolaboradores.addActionListener(this);
    	this.vista.btnVolverInsertarColaboradores.addActionListener(this);
    	this.vista.btnInsertarC.addActionListener(this);
    	this.vista.btnExportarcolaboracionescsv.addActionListener(this);
    	this.vista.btnCrearinformerJson6.addActionListener(this);
    	this.vista.btnExportarColaboraciones.addActionListener(this);
    	this.vista.btnComparar.addActionListener(this);
    	this.vista.btnNewButton.addActionListener(this);
    	this.vista.btnExportarSeguidores.addActionListener(this);
    	this.vista.btnExportarcolaboracionesJSON12.addActionListener(this);
    	this.vista.btnmodificarmegustaycomentarios.addActionListener(this);
    	this.vista.btnmodificarpublicacion.addActionListener(this);
    	this.vista.btnEliminar.addActionListener(this);
    	this.vista.btnEliminar2.addActionListener(this);
    	this.vista.btnResumerendimiento2023.addActionListener(this);
    	this.vista.btnañadirpublicacion.addActionListener(this);
    	this.vista.btneliminarminimo.addActionListener(this);
    	this.vista.ModificarPublicaciones.addActionListener(this);
    	this.vista.btnNewButtonAñadir.addActionListener(this);
    	this.vista.ModificarPublicaciones.addActionListener(this);
    	this.vista.btnNewButton_Modificarmegustas.addActionListener(this);
    	this.vista.btneliminarminimo.addActionListener(this);
    	this.vista.btnNewButtonEliminarminimovistas.addActionListener(this);
        this.vista.listStreamers.addListSelectionListener(e -> mostrarDatosStreamer(streamer));
    	this.vista.comboBoxPlataforma.addActionListener(e -> mostrarDatosPlataforma());
    	 this.vista.comboBoxHistorial.addActionListener(e -> mostrarDatosHistorial());
    	 streamer = leer();
         contenido = abrirCSV("files/metricas_contenido.csv");
         agregarcomboxestado();
         agregarcomboboxmodificar();
         llenarJListStreamers(streamer);
         agregarPlataformas();
  
        }
    public void actionPerformed(ActionEvent e) {
    	 
    	if (e.getSource() == this.vista.btnVerStreamer) {
             this.vista.panelMostrarTodo.setVisible(true);
             vista.panelMenu.setVisible(false);
             this.vista.panelprincipal.setVisible(false);
         }
         if (e.getSource() == this.vista.btnVerMetrica) {
                 this.vista.panelMetrica.setVisible(true);
                 calcularPromedios(streamer,contenido);
                 this.vista.panelprincipal.setVisible(false);

         }
         if (e.getSource() == this.vista.btnVolverMetrica) {
             this.vista.panelMetrica.setVisible(false);
             this.vista.panelprincipal.setVisible(true);
         }
         if (e.getSource() == this.vista.btnInsertarnuevoscolaboradores) {
             this.vista.InsertarColaboradores.setVisible(true);
             this.vista.panelprincipal.setVisible(false);
         }
         if (e.getSource() == this.vista.btnVolverInsertarColaboradores) {
             this.vista.InsertarColaboradores.setVisible(false);
             this.vista.panelprincipal.setVisible(true);
         }
         if (e.getSource() == this.vista.btnInsertarC) {
             try {
 				agregarColaboracion(streamer);
 			} catch (Exception e1) {
 				e1.printStackTrace();
 			}
         }if(e.getSource()==this.vista.btnExportarcolaboracionescsv) {
         	exportarColaboracionesACSV(streamer, contenido);
         }if(e.getSource()==this.vista.btnCrearinformerJson6) {
 				try {
 					generarInformeJSON(streamer);
 				} catch (IOException e1) {
 					e1.printStackTrace();
 				}
         }
         if(e.getSource()==this.vista.btnExportarColaboraciones) {
         	try {
         		generarReporteColaboracionesCSV(streamer);
 			} catch (IOException e1) {
 				e1.printStackTrace();
 			}
         }
         if(e.getSource()==this.vista.btnComparar) {
         	this.vista.panelprincipal.setVisible(false);
         	this.vista.panelComparativaRendimiendo.setVisible(true);
         }
         if(e.getSource()==this.vista.btnNewButton) {
    	analisisComparativoRendimiento(contenido);
         }
         if(e.getSource()==this.vista.btnExportarSeguidores) {
         	System.out.println("hola");
 				try {
 					crearResumenRendimientoJSON(contenido);
 				} catch (IOException e1) {
 					
 					e1.printStackTrace();
 				}
 			
         }
         if(e.getSource()==this.vista.btnExportarcolaboracionesJSON12) {
         	System.out.println("hora");
         	try {
 				convertirColaboracionesAJSON(streamer);
 			} catch (IOException e1) {
 				
 				e1.printStackTrace();
 			}
         }
         if(e.getSource()==this.vista.btnmodificarmegustaycomentarios) {
         	this.vista.panelprincipal.setVisible(false);
         	this.vista.panelmodificarpublicacion.setVisible(true);
         }
         if(e.getSource()==this.vista.btnmodificarpublicacion) {
         	modificarPublicacion(contenido);
         }
         if(e.getSource()==this.vista.btnEliminar) {
         	this.vista.panelprincipal.setVisible(false);
         	this.vista.panelEliminarpublicaciones.setVisible(true);
         }
         if(e.getSource()==this.vista.btnEliminar2) {
         	eliminarPublicacion(contenido);
         }
         if(e.getSource()==this.vista.btnResumerendimiento2023) {
         	this.vista.panelprincipal.setVisible(false);
         	this.vista.panelcrecimientoseguidores.setVisible(true);
         	try {
 				analizarCrecimientoMensualSeguidores(streamer);
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
         }
        if(e.getSource()==this.vista.btnañadirpublicacion) {
     	   this.vista.panelprincipal.setVisible(false);
     	   this.vista.panelAñadirNuevaPublicacion.setVisible(true);
        }
        if(e.getSource()==this.vista.btneliminarminimo) {
     	   this.vista.panelprincipal.setVisible(false);
     	   this.vista.panel_Eliminar_Minimo_Visitas.setVisible(true);
        }
        if(e.getSource()==this.vista.ModificarPublicaciones) {
     	   this.vista.panelprincipal.setVisible(false);
     	   this.vista.panelModificarMeGusta_yComentarios.setVisible(true);
        }
        if(e.getSource()==this.vista.btnNewButtonAñadir) {
        	try {
        		añadirPublicacion(contenido);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        if(e.getSource()==this.vista.ModificarPublicaciones) {
        	 this.vista.panelprincipal.setVisible(false);
       	   this.vista.ModificarPublicaciones.setVisible(true);
        }
        if(e.getSource()==this.vista.btnNewButton_Modificarmegustas) {
        	modificarPublicacion2(contenido);
        }
       if(e.getSource()==this.vista.btnNewButtonEliminarminimovistas) {
    	   eliminarPublicacionesPorLikes(contenido);
       }
    }

//Metodos
    // Método auxiliar para mostrar datos de un creador
    
    public void agregarcomboxestado() {
    	this.vista.comboBoxEstadoColaboracion.addItem("Activo");
    	this.vista.comboBoxEstadoColaboracion.addItem("Finalizada");
    }
    public void agregarcomboboxmodificar() {
    	this.vista.comboBoxparaModificar.addItem("creador_id");
    	this.vista.comboBoxparaModificar.addItem("plataforma");
    	this.vista.comboBoxparaModificar.addItem("fecha");
    	this.vista.comboBoxparaModificar.addItem("contenido");
    	this.vista.comboBoxparaModificar.addItem("tipo");
    	this.vista.comboBoxparaModificar.addItem("vistas");
    	this.vista.comboBoxparaModificar.addItem("me_gusta");
    	this.vista.comboBoxparaModificar.addItem("comentarios");
    	this.vista.comboBoxparaModificar.addItem("compartidos");
    }
    public  ArrayNode leer() throws JsonProcessingException, IOException {
        DefaultTableModel modelo = new DefaultTableModel();
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonfile=new File("files/creadores.json");
        JsonNode rootNode=objectMapper.readTree(jsonfile);
        ArrayNode streamer=(ArrayNode) rootNode;
        return streamer;
    }
    
    public List<Contenido> abrirCSV(String rutaCSV){
		List<Contenido> contenido = null;
		try  {
			FileReader reader = new FileReader(rutaCSV);
			
			CsvToBeanBuilder<Contenido> csvBuilder = new CsvToBeanBuilder<Contenido>(reader);
			CsvToBean<Contenido> csv = csvBuilder.withType(Contenido.class).withIgnoreLeadingWhiteSpace(true).build();

			contenido = csv.parse();

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return contenido;
	}
    
    public void agregarPlataformas() {
        this.vista.comboBoxPlataforma.addItem("TikTok");
        this.vista.comboBoxPlataforma.addItem("Twitch");
        this.vista.comboBoxPlataforma.addItem("Instagram");
        this.vista.comboBoxPlataforma.addItem("YouTube");
    }
    public void llenarJListStreamers(ArrayNode streamer) {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        Set<String> nombresUnicos = new HashSet<>();
        for (JsonNode creatorNode : streamer) {
            String nombreCreador = creatorNode.get("nombre").asText();
            if (nombresUnicos.add(nombreCreador)) {
                modelo.addElement(nombreCreador);
            }
        }
        this.vista.listStreamers.setModel(modelo); 
    }
    //1
    public void mostrarDatosStreamer(ArrayNode streamer) {
        String nombreSeleccionado = (String) vista.listStreamers.getSelectedValue();
        if (nombreSeleccionado != null) {
            vista.comboBoxHistorial.removeAllItems();
            Set<String> fechasUnicas = new HashSet<>(); 
            for (JsonNode creatorNode : streamer) {
                String nombreCreador = creatorNode.get("nombre").asText();
                if (nombreCreador.equals(nombreSeleccionado)) {
                    String idCreador = creatorNode.get("id").asText();
                    String pais = creatorNode.get("pais").asText();
                    String tematica = creatorNode.get("tematica").asText();
                    String seguidoresTotales = creatorNode.get("seguidores_totales").asText();

                    JsonNode estadisticas = creatorNode.get("estadisticas");
                    String interaccionesTotales = estadisticas.get("interacciones_totales").asText();
                    String promedioVistasMensuales = estadisticas.get("promedio_vistas_mensuales").asText();
                    String tasaCrecimientoSeguidores = estadisticas.get("tasa_crecimiento_seguidores").asText();
                    vista.lblIdMostrar.setText(idCreador);
                    vista.lblNombreMostrar.setText(nombreCreador);
                    vista.lblPaisMostrar.setText(pais);
                    vista.lblTematicaMostrar.setText(tematica);
                    vista.lblSeguidoresTotalesMostrar.setText(seguidoresTotales);
                    vista.lblInteraccionesTotalesMostrar.setText(interaccionesTotales);
                    vista.lblPromedioVistasMensualesMostrar.setText(promedioVistasMensuales);
                    vista.lblTasaCrecimientoSeguidoresMostrar.setText(tasaCrecimientoSeguidores);
                    
                    for (JsonNode plataforma : creatorNode.get("plataformas")) {
                        for (JsonNode historico : plataforma.get("historico")) {
                            String fechaHistorial = historico.get("fecha").asText();
                            if (fechasUnicas.add(fechaHistorial)) {
                                vista.comboBoxHistorial.addItem(fechaHistorial);
                            }
                        }
                    }
                    break; 
                }
            }
        }
    }

    public void mostrarDatosPlataforma() {
        String plataformaSeleccionada = (String) vista.comboBoxPlataforma.getSelectedItem();
        if (plataformaSeleccionada != null) {
            for (JsonNode creatorNode : streamer) {
                for (JsonNode plataforma : creatorNode.get("plataformas")) {
                    String nombrePlataforma = plataforma.get("nombre").asText();
                    if (nombrePlataforma.equals(plataformaSeleccionada)) {
                      
                        String usuarioPlataforma = plataforma.get("usuario").asText();
                        String seguidoresPlataforma = plataforma.get("seguidores").asText();
                        String fechaCreacionPlataforma = plataforma.get("fecha_creacion").asText();
                      
                        vista.lblPlataformaUsuarioMostrar.setText(usuarioPlataforma);
                        vista.lblPlataformaSeguidoresMostrar.setText(seguidoresPlataforma);
                        vista.lblPlataformaFechaCreacionMostrar.setText(fechaCreacionPlataforma);
                        
                   
                        
                        break; 
                    }
                }
            }
        }
    }
    public void mostrarDatosHistorial() {
        String fechaSeleccionada = (String) vista.comboBoxHistorial.getSelectedItem();
        if (fechaSeleccionada != null) {
        
            vista.lblHistNuevosSeguidores1Mostrar.setText("");
            vista.lblHistInteracciones1Mostrar.setText("");
            vista.lblHistFecha1Mostrar.setText("");
         
            for (JsonNode creatorNode : streamer) {
                for (JsonNode plataforma : creatorNode.get("plataformas")) {
                    for (JsonNode historico : plataforma.get("historico")) {
                        String fechaHistorial = historico.get("fecha").asText();
                        if (fechaSeleccionada.equals(fechaHistorial)) {
                            String nuevosSeguidores = historico.get("nuevos_seguidores").asText();
                            String interacciones = historico.get("interacciones").asText();
                            String nuevosseguidores=historico.get("nuevos_seguidores").asText();

                            vista.lblHistNuevosSeguidores1Mostrar.setText(nuevosSeguidores);
                            vista.lblHistInteracciones1Mostrar.setText(interacciones);
                            vista.lblHistFecha1Mostrar.setText(nuevosseguidores);
                            return; 
                        }
                    }
                }
            }
        }
    }
    //2
    public void calcularPromedios(ArrayNode streamer, List<Contenido> contenido) {
        modelo2.setRowCount(0);
        modelo2.setColumnCount(0);
        String[] nombrePromedios = {
            "ID Creador", "Nombre Creador", "Plataforma", "Promedio Vistas", "Promedio Me Gustas"
        };

        modelo2.setColumnIdentifiers(nombrePromedios);
        this.vista.tableRendimiento.setModel(modelo2); 
        
       

     
    }
//3
    public void agregarColaboracion(ArrayNode streamer) throws JsonGenerationException, JsonMappingException, IOException {
    	 File file = new File("files/creadores.json");
    	String idCreador1 = this.vista.textFieldCreador1.getText();
        String colaborador = this.vista.textFieldNombreColaborador.getText();
        String tematica = this.vista.textFieldTematica.getText();
        String fechaInicio = this.vista.textFieldFechaInicio.getText();
        String fechaFin = this.vista.textFieldFechaFin.getText();
        String tipoColaboracion = this.vista.textFieldTipoColaboracion.getText();
        String estadoColaboracion = (String) this.vista.comboBoxEstadoColaboracion.getSelectedItem();
        
        for (JsonNode creatorNode : streamer) {
            String creatorId = creatorNode.get("id").asText();
            if (creatorId != null && creatorId.equals(idCreador1)) {
                ObjectNode nuevaColaboracion = objectMapper.createObjectNode();
                nuevaColaboracion.put("colaborador", colaborador);
                nuevaColaboracion.put("tematica", tematica);
                nuevaColaboracion.put("fecha_inicio", fechaInicio);
                nuevaColaboracion.put("fecha_fin", fechaFin);
                nuevaColaboracion.put("tipo", tipoColaboracion);
                nuevaColaboracion.put("estado", estadoColaboracion);
                ((ArrayNode) creatorNode.get("colaboraciones")).add(nuevaColaboracion);
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, streamer);
                this.vista.lblConformar.setText("Colaboración añadida exitosamente.");
              
            }
        }
        this.vista.lblConformar.setText("Colaborador creado");
    }

   
   
 //4
    public void exportarColaboracionesACSV(ArrayNode streamer, List<Contenido> contenido) {
        String csvFile = "files/colaboraciones.csv";
        List<String[]> contenidoList = new ArrayList<>();
        List<String> comprobar = new ArrayList<>(); 

        try {
            String[] header = {"Fecha_Inicio", "Nombre_Creador", "Visualizaciones", "Compartidos"};
            contenidoList.add(header);        
            for (Contenido cont : contenido) {
             
                for (JsonNode creatorNode : streamer) {
                    String creadorNombre = creatorNode.get("nombre").asText();
                    if (creatorNode.has("colaboraciones")) {
                        ArrayNode colaboraciones = (ArrayNode) creatorNode.path("colaboraciones");
                        for (JsonNode colaboracion : colaboraciones) {
                            String nombreColaborador = colaboracion.get("colaborador").asText(); 
                            String fechaInicio = colaboracion.get("fecha_inicio").asText();
                            String mirar = fechaInicio + "|" + creadorNombre + "|" + nombreColaborador;
                            if (!comprobar.contains(mirar)) {
                                comprobar.add(mirar); 
                                String[] data = {
                                    fechaInicio,
                                    creadorNombre,
                                    String.valueOf(cont.getVistas()), 
                                    String.valueOf(cont.getCompartidos()) 
                                };
                                contenidoList.add(data); 
                            }
                        }
                    }
                }
            }
            crearCSV8(contenidoList, csvFile);
            this.vista.lblmostrarsiseaexportado.setText("Exportado correctamente"); 
        } catch (Exception e) {
            e.printStackTrace(); 
            this.vista.lblmostrarsiseaexportado.setText("Exportado erróneo"); 
        }
    }
    //5
    public void modificarPublicacion(List<Contenido> contenido) {
        String idStreamer = this.vista.textFieldidstreamer.getText();
        String fecha = this.vista.textFieldfehca.getText();
        String tipo = (String) this.vista.comboBoxparaModificar.getSelectedItem();
        String nuevoDato = this.vista.textFieldDato.getText();
        boolean modificada = false;

        for (Contenido cont : contenido) {
            if (cont.getCreador_id().equals(idStreamer) && cont.getFecha().equals(fecha)) {
                switch (tipo.toLowerCase()) {
                    case "me_gusta":
                        cont.setMe_gustas(Integer.parseInt(nuevoDato));
                        break;
                    case "comentarios":
                        cont.setComentarios(Integer.parseInt(nuevoDato)); 
                        break;
                    case "vistas":
                        cont.setVistas(Integer.parseInt(nuevoDato)); 
                        break;
                    case "compartidos":
                        cont.setCompartidos(Integer.parseInt(nuevoDato)); 
                        break;
                    case "tipo":
                        cont.setTipo(nuevoDato);
                        break;
                    case "contenido":
                        cont.setContenido(nuevoDato);
                        break;
                    case "fecha":
                        cont.setFecha(nuevoDato); 
                        break;
                    case "plataforma":
                        cont.setPlataforma(nuevoDato);
                        break; 
                    case "creador_id":
                        cont.setCreador_id(nuevoDato);
                        break; 
                    default:
                        System.out.println("Campo no reconocido: " + tipo);
                        return;
                }
                modificada = true;
                break; 
            }
        }
        if (modificada) {
            try {
                crearCSV(contenido, "files/metricas_contenido.csv");
               this.vista.lblNotificar.setText("Publicación modificada exitosamente.");
            } catch (Exception e) {
                e.printStackTrace();
                this.vista.lblNotificar.setText("Error al escribir en el archivo CSV.");
            }
        } 
    }
    public void eliminarPublicacion(List<Contenido> contenido) {
        String idStreamer = this.vista.textFieldidcreador.getText();
        String fecha = this.vista.textFieldfecha.getText();
        boolean eliminada = false;
        Iterator<Contenido> iterator = contenido.iterator();
        while (iterator.hasNext()) {
            Contenido cont = iterator.next();
            if (cont.getCreador_id().equals(idStreamer) && cont.getFecha().equals(fecha)) {
                iterator.remove();
                eliminada = true;
                break; 
            }
        }
        if (eliminada) {
            try {
                crearCSV(contenido, "files/metricas_contenido.csv"); 
                this.vista.lblNewLabelConfirmar.setText("Publicación eliminada exitosamente.");
            } catch (Exception e) {
                e.printStackTrace();
                this.vista.lblNewLabelConfirmar.setText("Error al escribir en el archivo CSV.");
            }
        } 
    }
    //6
    public void generarInformeJSON(ArrayNode streamer) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode reporte = objectMapper.createArrayNode(); 

        for (JsonNode creador : streamer) {
            String nombre = creador.get("nombre").asText();
            ArrayNode plataformas = (ArrayNode) creador.get("plataformas"); 
            
            int totalSeguidores = 0;
            String mejorPlataforma = "";
            int maxSeguidores = 0; 
            int seguidoresYoutube = 0;
            int seguidoresInstagram = 0;
            int seguidoresTikTok = 0;
            int seguidoresTwitch = 0;

            for (JsonNode plataforma : plataformas) {
                String nombrePlataforma = plataforma.get("nombre").asText();
                int seguidores = plataforma.get("seguidores").asInt();
                if (nombrePlataforma.equalsIgnoreCase("YouTube")) {
                    seguidoresYoutube += seguidores;
                } else if (nombrePlataforma.equalsIgnoreCase("Instagram")) {
                    seguidoresInstagram += seguidores;
                } else if (nombrePlataforma.equalsIgnoreCase("TikTok")) {
                    seguidoresTikTok += seguidores;
                } else if (nombrePlataforma.equalsIgnoreCase("Twitch")) {
                    seguidoresTwitch += seguidores;
                }
                totalSeguidores += seguidores;
                if (seguidores > maxSeguidores) {
                    maxSeguidores = seguidores;
                    mejorPlataforma = nombrePlataforma; 
                }
            }
            ObjectNode creadorReporte = objectMapper.createObjectNode();
            creadorReporte.put("nombre", nombre); 
            creadorReporte.put("totalSeguidores", totalSeguidores); 
            creadorReporte.put("mejorPlataforma", mejorPlataforma); 
            creadorReporte.put("seguidoresYoutube", seguidoresYoutube);
            creadorReporte.put("seguidoresInstagram", seguidoresInstagram);
            creadorReporte.put("seguidoresTikTok", seguidoresTikTok);
            creadorReporte.put("seguidoresTwitch", seguidoresTwitch);


            reporte.add(creadorReporte);
        }

        objectMapper.writeValue(new File("files/reporte_creadores.json"), reporte);
        this.vista.lblmostrarsiseaexportado.setText("Exportado correctamente");
    }
    //7
    public void analizarCrecimientoMensualSeguidores(ArrayNode streamer) throws IOException {
      
        modelo2.setRowCount(0);
        modelo2.setColumnCount(0);

     
        String[] nombre = {
            "ID Creador", "Nombre_Creador", "Tasa de crecimiento en YouTube", 
            "Tasa de crecimiento en Twitch", "Tasa de crecimiento en Instagram", 
            "Tasa de crecimiento en TikTok"
        };
        modelo2.setColumnIdentifiers(nombre);

      
        for (int i = 0; i < streamer.size(); i++) {
            ObjectNode creador = (ObjectNode) streamer.get(i);
            
           
            String idCreador = creador.get("id").asText();
            String nombreCreador = creador.get("nombre").asText();

          
            int seguidoresYoutubeInicio = 0;
            int seguidoresYoutubeFin = 0;
            int seguidoresTwitchInicio = 0;
            int seguidoresTwitchFin = 0;
            int seguidoresInstagramInicio = 0;
            int seguidoresInstagramFin = 0;
            int seguidoresTikTokInicio = 0;
            int seguidoresTikTokFin = 0;

         
            for (var plataforma : creador.get("plataformas")) {
                String nombrePlataforma = plataforma.get("nombre").asText();
                var historico = plataforma.get("historico");

                if (historico.size() > 0) {
                    seguidoresYoutubeInicio = historico.get(0).get("nuevos_seguidores").asInt();
                    seguidoresYoutubeFin = historico.get(historico.size() - 1).get("nuevos_seguidores").asInt();
 
                    switch (nombrePlataforma) {
                        case "YouTube":
                            seguidoresYoutubeInicio = plataforma.get("seguidores").asInt() - seguidoresYoutubeInicio;
                            seguidoresYoutubeFin = plataforma.get("seguidores").asInt();
                            break;
                        case "Twitch":
                            seguidoresTwitchInicio = plataforma.get("seguidores").asInt() - seguidoresYoutubeInicio;
                            seguidoresTwitchFin = plataforma.get("seguidores").asInt();
                            break;
                        case "Instagram":
                            seguidoresInstagramInicio = plataforma.get("seguidores").asInt() - seguidoresYoutubeInicio;
                            seguidoresInstagramFin = plataforma.get("seguidores").asInt();
                            break;
                        case "TikTok":
                            seguidoresTikTokInicio = plataforma.get("seguidores").asInt() - seguidoresYoutubeInicio;
                            seguidoresTikTokFin = plataforma.get("seguidores").asInt();
                            break;
                    }
                }
            }
            double tasaCrecimientoYoutube = calcularTasaCrecimiento(seguidoresYoutubeInicio, seguidoresYoutubeFin);
            double tasaCrecimientoTwitch = calcularTasaCrecimiento(seguidoresTwitchInicio, seguidoresTwitchFin);
            double tasaCrecimientoInstagram = calcularTasaCrecimiento(seguidoresInstagramInicio, seguidoresInstagramFin);
            double tasaCrecimientoTikTok = calcularTasaCrecimiento(seguidoresTikTokInicio, seguidoresTikTokFin);
            modelo2.addRow(new Object[]{
                idCreador, 
                nombreCreador, 
                tasaCrecimientoYoutube, 
                tasaCrecimientoTwitch, 
                tasaCrecimientoInstagram, 
                tasaCrecimientoTikTok
            });
        }
    }
    public double calcularTasaCrecimiento(int seguidoresInicio, int seguidoresFin) {
        if (seguidoresInicio == 0) {
            return seguidoresFin > 0 ? 100.0 : 0.0; 
        }
        return ((double) (seguidoresFin - seguidoresInicio) / seguidoresInicio) * 100;
    }

    //8
    public void generarReporteColaboracionesCSV(ArrayNode streamer) throws IOException {
        String csvFile = "files/reporte_colaboraciones.csv";
        List<String[]> contenidoList = new ArrayList<>();
        String[] header = {"Fecha", "Plataforma", "Colaborador"};
        contenidoList.add(header);
        for (JsonNode creador : streamer) {
            ArrayNode colaboraciones = (ArrayNode) creador.path("colaboraciones");
            for (JsonNode colaboracion : colaboraciones) {
                String fechaInicio = colaboracion.path("fecha_inicio").asText();
                String colaboradorId = colaboracion.path("colaborador").asText();
                ArrayNode plataformas = (ArrayNode) creador.path("plataformas");
                for (JsonNode plataforma : plataformas) {
                    String nombrePlataforma = plataforma.path("nombre").asText();
                    String[] data = {fechaInicio, nombrePlataforma, colaboradorId};
                    contenidoList.add(data);
                }
            }
        }
        crearCSV8(contenidoList, csvFile);
        this.vista.lblmostrarsiseaexportado.setText("Exportado existosamente");
    }
    //9
    public void analisisComparativoRendimiento(List<Contenido> contenido) {
    
     
    }
    //10
    public static void crearResumenRendimientoJSON(List<Contenido> contenido) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode resumen = objectMapper.createArrayNode();

        Map<String, Map<String, int[]>> rendimiento = new HashMap<>();
        for (Contenido cont : contenido) {
            String creadorId = cont.getCreador_id();
            String plataforma = cont.getPlataforma();
            String fecha = cont.getFecha();
            int vistas = cont.getVistas();
            int meGusta = cont.getMe_gustas();
            int comentarios = cont.getComentarios();
            int compartidos = cont.getCompartidos();
            if (fecha.startsWith("2023")) {
                rendimiento.putIfAbsent(creadorId, new HashMap<>());
                rendimiento.get(creadorId).putIfAbsent(plataforma, new int[3]); 
                rendimiento.get(creadorId).get(plataforma)[0] += vistas;
                rendimiento.get(creadorId).get(plataforma)[1] += (meGusta + comentarios + compartidos);
                rendimiento.get(creadorId).get(plataforma)[2]++;
            }
        }

       
        for (String creadorId : rendimiento.keySet()) {
            Map<String, int[]> plataformas = rendimiento.get(creadorId);
            String mejorPlataformaVistas = "";
            int maxVistas = 0;
            String mejorPlataformaInteracciones = "";
            double maxInteraccionPromedio = 0.0;

            for (String plataforma : plataformas.keySet()) {
                int vistas = plataformas.get(plataforma)[0];
                int interacciones = plataformas.get(plataforma)[1];
                int conteo = plataformas.get(plataforma)[2];

              
                if (vistas > maxVistas) {
                    maxVistas = vistas;
                    mejorPlataformaVistas = plataforma;
                }
                double interaccionPromedio = (double) interacciones / conteo;

                
                if (interaccionPromedio > maxInteraccionPromedio) {
                    maxInteraccionPromedio = interaccionPromedio;
                    mejorPlataformaInteracciones = plataforma;
                }
            }

          
            ObjectNode creadorResumen = objectMapper.createObjectNode();
            creadorResumen.put("creador_id", creadorId);
            creadorResumen.put("mejor_plataforma_vistas", mejorPlataformaVistas);
            creadorResumen.put("max_vistas", maxVistas);
            creadorResumen.put("mejor_plataforma_interacciones", mejorPlataformaInteracciones);
            creadorResumen.put("max_interaccion_promedio", maxInteraccionPromedio);

            resumen.add(creadorResumen);
        }
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter("files/resume_rendimiento2023.json"), resumen);
        
    }

//11
    public void añadirPublicacion(List<Contenido> contenido) throws IOException {
        String id_creador = this.vista.textFieldidcreador1.getText();
        String plataforma = this.vista.textFieldplataforma2.getText();
        String fecha = this.vista.textFieldFecha2.getText();
        String contenidoTexto = this.vista.textFieldContenido2.getText();
        String tipo = this.vista.textFieldTipo2.getText();

        try {
            String vistasTextoStr = this.vista.textFieldVistas2.getText();
            String me_gustaTextoStr = this.vista.textFieldMeGsuta2.getText();
            String comentariosTextoStr = this.vista.textFieldComentarios2.getText();
            String compartidosTextoStr = this.vista.textFieldCompartidos2.getText();

            if (vistasTextoStr.isEmpty() || me_gustaTextoStr.isEmpty() || 
                comentariosTextoStr.isEmpty() || compartidosTextoStr.isEmpty()) {
                throw new NumberFormatException("Los campos numéricos no pueden estar vacíos.");
            }

            Integer vistasTexto = Integer.parseInt(vistasTextoStr);
            Integer me_gustaTexto = Integer.parseInt(me_gustaTextoStr);
            Integer comentariosTexto = Integer.parseInt(comentariosTextoStr);
            Integer compartidosTexto = Integer.parseInt(compartidosTextoStr);
            Contenido contenido1 = new Contenido();
            contenido1.setCreador_id(id_creador);
            contenido1.setPlataforma(plataforma);
            contenido1.setFecha(fecha);
            contenido1.setContenido(contenidoTexto);
            contenido1.setTipo(tipo);
            contenido1.setVistas(vistasTexto);
            contenido1.setMe_gustas(me_gustaTexto);
            contenido1.setComentarios(comentariosTexto);
            contenido1.setCompartidos(compartidosTexto);

         
            contenido.add(contenido1);
            crearCSV(contenido, "files/metricas_contenido.csv");

            this.vista.lblNewLabelCreado.setText("Publicación añadida con éxito.");

        } catch (NumberFormatException e) {
            this.vista.lblNewLabelCreado.setText("Error: " + e.getMessage());
        } catch (Exception e) {
            this.vista.lblNewLabelCreado.setText("Error: " + e.getMessage());
        }
    }

    public void modificarPublicacion2(List<Contenido> contenido) {
        String id_creador = this.vista.textFieldid_creador3.getText();
        String fecha = this.vista.textFieldFechaContenido3.getText();
        String plataforma = this.vista.textFieldel_plataforma3.getText();
        
        try {
            Integer me_gustaTexto = Integer.parseInt(this.vista.textField_megusta2.getText());
            Integer comentariosTexto = Integer.parseInt(this.vista.textFieldComentarios2.getText());

            boolean encontrado = false;
            for (Contenido publicacion : contenido) {
                if (publicacion.getCreador_id().equals(id_creador) && 
                    publicacion.getFecha().equals(fecha) && 
                    publicacion.getPlataforma().equals(plataforma)) {
                    publicacion.setMe_gustas(me_gustaTexto);
                    publicacion.setComentarios(comentariosTexto);
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                crearCSV(contenido, "files/metricas_contenido.csv");
                System.out.println("Publicación modificada y guardada con éxito.");
            } else {
                System.out.println("No se encontró la publicación con los datos proporcionados.");
            }

        } catch (Exception  e) {
           e.printStackTrace();
        } 
    }
    public void eliminarPublicacionesPorLikes(List<Contenido> contenido) {
        String likesTexto = this.vista.textFieldMinVistas.getText(); 
        try {
            int minLikes = Integer.parseInt(likesTexto);
            Iterator<Contenido> iterator = contenido.iterator();
            boolean eliminadas = false;

            while (iterator.hasNext()) {
                Contenido publicacion = iterator.next();
                if (publicacion.getMe_gustas() < minLikes) {
                    iterator.remove(); 
                    eliminadas = true; 
                }
            }
            crearCSV(contenido, "files/metricas_contenido.csv");
            if (eliminadas) {
                System.out.println("Publicaciones eliminadas con éxito.");
            } else {
                System.out.println("No se encontraron publicaciones que eliminar.");
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
    //12
    public void convertirColaboracionesAJSON(ArrayNode streamer) throws IOException {
      
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode colaboracionesArray = objectMapper.createArrayNode();

        for (JsonNode creador : streamer) {
            String nombreCreador = creador.get("nombre").asText();
            ArrayNode colaboraciones = (ArrayNode) creador.path("colaboraciones");

            for (JsonNode colaboracion : colaboraciones) {
                ObjectNode colaboracionJSON = objectMapper.createObjectNode();
                colaboracionJSON.put("nombreCreador", nombreCreador);
                colaboracionJSON.put("colaborador", colaboracion.path("colaborador").asText());
                colaboracionJSON.put("tematica", colaboracion.path("tematica").asText());
                colaboracionJSON.put("fechaInicio", colaboracion.path("fecha_inicio").asText());
                colaboracionJSON.put("fechaFin", colaboracion.path("fecha_fin").asText());
                colaboracionJSON.put("tipo", colaboracion.path("tipo").asText());
                colaboracionJSON.put("estado", colaboracion.path("estado").asText());

                colaboracionesArray.add(colaboracionJSON);
            }
        }
    }
    public void crearCSV(List<Contenido> misFutbolistas, String rutaCSV) {
		try {
            FileWriter fw = new FileWriter(rutaCSV);
            StatefulBeanToCsv<Contenido> beanToCsv = new StatefulBeanToCsvBuilder<Contenido>(fw).build();
            beanToCsv.write(misFutbolistas);
            fw.flush();
		}catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
	}
    public void crearCSV8(List<String[]> contenido, String rutaCSV) {
        try (FileWriter fw = new FileWriter(rutaCSV);
             CSVWriter writer = new CSVWriter(fw)) {
            for (String[] todo : contenido) {
                writer.writeNext(todo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
  
}
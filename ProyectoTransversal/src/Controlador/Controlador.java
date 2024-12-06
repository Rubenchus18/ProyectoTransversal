package Controlador;

import java.awt.Color;
import java.awt.Image;
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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

public class Controlador implements ActionListener {
	Controlador control;
	Vista vista = new Vista();
	DefaultTableModel modelo2 = new DefaultTableModel();
	DefaultListModel modelo = new DefaultListModel();
	ObjectMapper objectMapper = new ObjectMapper();
	ArrayNode streamer = objectMapper.createArrayNode();
	List<Contenido> contenido = new ArrayList<Contenido>();
	JsonNode creadorSeleccionado;
	JsonNode plataformaSeleccionada;
	ArrayList<ImageIcon> fotosIcon = new ArrayList<ImageIcon>();

	public Controlador(Vista vista) throws JsonParseException, JsonMappingException, IOException {
		this.vista = vista;
		this.vista.btnVerStreamer.addActionListener(this);
		this.vista.btnVolverMostrarTodo.addActionListener(this);
		this.vista.btnSalir_1.addActionListener(this);
		this.vista.btnMetricas.addActionListener(this);
		this.vista.btnSalir.addActionListener(this);
		this.vista.btnresumenrendimientojson.addActionListener(this);
		this.vista.btnExportaColaboracionesCSV.addActionListener(this);
		this.vista.btngenerarreportecsvcolaboraciones.addActionListener(this);
		this.vista.btnExportarInfrome_reportejson.addActionListener(this);
		this.vista.btncolaboracionesajson.addActionListener(this);
		this.vista.listStreamers.addListSelectionListener(e -> creadorSeleccionado = mostrarDatosStreamer(streamer));
		this.vista.comboBoxPlataforma.addActionListener(this);
		this.vista.comboBoxHistorial.addActionListener(this);
		this.vista.btnInfoCreador.addActionListener(this);
		this.vista.comboBoxelegiropciones.addActionListener(this);
		streamer = leer();
		contenido = abrirCSV("files/metricas_contenido.csv");
		agregarcomboxestado();
		agregarcomboboxmodificar();
		llenarJListStreamers(streamer);
		llenarJlistStreamer(streamer);
		agregarPlataformas();
		agregarcomboxopciones();
		rellenarFotosIcon(fotosIcon);
		
	}

	public void actionPerformed(ActionEvent e) {
		// Nuevo
		 if (e.getSource() == this.vista.comboBoxelegiropciones) {
		        String selectedOption = (String) this.vista.comboBoxelegiropciones.getSelectedItem();

		        this.vista.panelInsertarColaboradores.setVisible(true);
		        this.vista.panelEliminarpubli.setVisible(false);
		        this.vista.panelañadirpublicion.setVisible(false);
		        this.vista.paneleliminarminimovistas.setVisible(false);
		        this.vista.panelModificarPublicacion.setVisible(false);
		        this.vista.panelmodificarLikesComentarios.setVisible(false);
		        switch (selectedOption) {
		            case "Insertar colaboraciones":
		                this.vista.panelInsertarColaboradores.setVisible(true);
		                this.vista.panelañadirpublicion.setVisible(false);
		                this.vista.panelEliminarpubli.setVisible(false);
		                this.vista.paneleliminarminimovistas.setVisible(false);
				        this.vista.panelModificarPublicacion.setVisible(false);
				        this.vista.panelmodificarLikesComentarios.setVisible(false);
				        this.vista.lblCreado.setText("");
		                break;
		            case "Añadir publicaciones":
		                this.vista.panelInsertarColaboradores.setVisible(false);
		                this.vista.panelañadirpublicion.setVisible(true);
		                this.vista.panelEliminarpubli.setVisible(false);
		                this.vista.paneleliminarminimovistas.setVisible(false);
				        this.vista.panelModificarPublicacion.setVisible(false);
				        this.vista.panelmodificarLikesComentarios.setVisible(false);
				        this.vista.lblCreado.setText("");
		                break;
		            case "Eliminar publicaciones":
		            	 this.vista.panelInsertarColaboradores.setVisible(false);
			                this.vista.panelañadirpublicion.setVisible(false);
			                this.vista.panelEliminarpubli.setVisible(true);
			                this.vista.paneleliminarminimovistas.setVisible(false);
					        this.vista.panelModificarPublicacion.setVisible(false);
					        this.vista.panelmodificarLikesComentarios.setVisible(false);
					        this.vista.lblCreado.setText("");
		                break;
		            case "Eliminar minimo de vistas":
		            	 this.vista.panelInsertarColaboradores.setVisible(false);
			                this.vista.panelañadirpublicion.setVisible(false);
			                this.vista.panelEliminarpubli.setVisible(false);
			                this.vista.paneleliminarminimovistas.setVisible(true);
					        this.vista.panelModificarPublicacion.setVisible(false);
					        this.vista.panelmodificarLikesComentarios.setVisible(false);
					        this.vista.lblCreado.setText("");
		            	break;
		            case "Modificar publicacion":
		            	 this.vista.panelInsertarColaboradores.setVisible(false);
			                this.vista.panelañadirpublicion.setVisible(false);
			                this.vista.panelEliminarpubli.setVisible(false);
			                this.vista.paneleliminarminimovistas.setVisible(false);
					        this.vista.panelModificarPublicacion.setVisible(true);
					        this.vista.panelmodificarLikesComentarios.setVisible(false);
					        this.vista.lblCreado.setText("");
		            	break;
		            case "Modificar Like y Visualizaciones":
		            	 this.vista.panelInsertarColaboradores.setVisible(false);
			                this.vista.panelañadirpublicion.setVisible(false);
			                this.vista.panelEliminarpubli.setVisible(false);
			                this.vista.paneleliminarminimovistas.setVisible(false);
					        this.vista.panelModificarPublicacion.setVisible(false);
					        this.vista.panelmodificarLikesComentarios.setVisible(true);
					        this.vista.lblCreado.setText("");
		            	break;
		            default:
		                break;
		        }
		    }
		if (e.getSource() == this.vista.btnVerStreamer) {
			this.vista.panelMostrarTodo.setVisible(true);
			vista.panelMenu.setVisible(false);
			
			this.vista.panelBotones.setVisible(false);
		}
		if (e.getSource() == this.vista.btnSalir) {
			this.vista.panelMostrarTodo.setVisible(false);
			vista.panelMenu.setVisible(true);

			this.vista.panelBotones.setVisible(true);
		}
		if (e.getSource() == this.vista.btnMetricas) {
			this.vista.panelMenu.setVisible(false);
			this.vista.panelBotones.setVisible(false);
			this.vista.panelExportacionDatos.setVisible(true);
			this.vista.panelBotones_1.setVisible(true);
		}
		if (e.getSource() == this.vista.btnSalir_1) {
			this.vista.panelMenu.setVisible(true);
			this.vista.panelBotones.setVisible(true);
			this.vista.panelExportacionDatos.setVisible(false);
			this.vista.panelBotones_1.setVisible(false);
		}
		if (e.getSource() == this.vista.btnresumenrendimientojson) {
			exportarColaboracionesACSV(streamer, contenido);
		}
		if (e.getSource() == this.vista.btnExportaColaboracionesCSV) {
			try {
				generarInformeJSON(streamer);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == this.vista.btngenerarreportecsvcolaboraciones) {
			try {
				generarReporteColaboracionesCSV(streamer);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == this.vista.btnExportarInfrome_reportejson) {
			try {
				generarInformeJSON(streamer);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == this.vista.btncolaboracionesajson) {
			try {
				convertirColaboracionesAJSON(streamer);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==this.vista.btnInfoCreador) {
			this.vista.panelMenu.setVisible(false);
			this.vista.panelModifcar.setVisible(true);
		}
		if (e.getSource() == this.vista.comboBoxPlataforma) {
			if (vista.comboBoxPlataforma.getSelectedItem() != null && creadorSeleccionado != null) {
				plataformaSeleccionada = verPlataforma((String) vista.comboBoxPlataforma.getSelectedItem(),
						creadorSeleccionado);
			}
		}
		if (e.getSource() == this.vista.comboBoxHistorial) {
			if (plataformaSeleccionada != null && vista.comboBoxHistorial.getSelectedIndex() > -1) {
				String selec = (String) vista.comboBoxHistorial.getSelectedItem();
				verHistorial(selec, plataformaSeleccionada);
			}
		}
	}

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
	public void agregarcomboxopciones() {
		this.vista.comboBoxelegiropciones.addItem("Insertar colaboraciones");
		this.vista.comboBoxelegiropciones.addItem("Añadir publicaciones");
		this.vista.comboBoxelegiropciones.addItem("Eliminar publicaciones");
		this.vista.comboBoxelegiropciones.addItem("Eliminar minimo de vistas");
		this.vista.comboBoxelegiropciones.addItem("Modificar publicacion");
		this.vista.comboBoxelegiropciones.addItem("Modificar Like y Visualizaciones");
	}
	public ArrayNode leer() throws JsonProcessingException, IOException {
		DefaultTableModel modelo = new DefaultTableModel();
		ObjectMapper objectMapper = new ObjectMapper();
		File jsonfile = new File("files/creadores.json");
		JsonNode rootNode = objectMapper.readTree(jsonfile);
		ArrayNode streamer = (ArrayNode) rootNode;
		return streamer;
	}
	

	public List<Contenido> abrirCSV(String rutaCSV) {
		List<Contenido> contenido = null;
		try {
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
		modelo.setSize(0);
		for (JsonNode creatorNode : streamer) {
			String nombreCreador = creatorNode.get("nombre").asText();
			String idCreador = creatorNode.get("id").asText();
			String elementoJlist = "Id: " + idCreador + " Nombre: " + nombreCreador;
			modelo.addElement(elementoJlist);
		}
		this.vista.listStreamers.setModel(modelo);
	}
	public void llenarJlistStreamer(ArrayNode streamer) {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		modelo.setSize(0);
		for (JsonNode creatorNode : streamer) {
			String nombreCreador = creatorNode.get("nombre").asText();
			String idCreador = creatorNode.get("id").asText();
			String elementoJlist = "Id: " + idCreador + " Nombre: " + nombreCreador;
			modelo.addElement(elementoJlist);
		}
		this.vista.liststreamer.setModel(modelo);
	}
	// 1
	public JsonNode mostrarDatosStreamer(ArrayNode streamer) {
		String nombreSeleccionado = (String) vista.listStreamers.getSelectedValue();
		if (nombreSeleccionado == null || nombreSeleccionado.trim().isEmpty()) {
			return null;
		}

		String[] partes = nombreSeleccionado.split(" ");
		if (partes.length < 2) {
			return null;
		}

		String idCreadorSeleccionado = partes[1]; // "20"
		JsonNode creador = null;

		if (idCreadorSeleccionado != null) {
			vista.comboBoxHistorial.removeAllItems();
			Set<String> fechasUnicas = new HashSet<>();
			for (JsonNode creatorNode : streamer) {
				String idCreador = creatorNode.get("id").asText();
				if (idCreador.equals(idCreadorSeleccionado)) {
					String nombreCreador = creatorNode.get("nombre").asText();
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

					creador = creatorNode;
					vista.comboBoxPlataforma.setSelectedIndex(0);
				}
			}
		}
		return creador;
	}

	public JsonNode verPlataforma(String plataformaSeleccionada, JsonNode creatorNode) {

		JsonNode plataformaSelecc = null;

		if (plataformaSeleccionada != null) {

			cambiarPlataforma(plataformaSeleccionada);

			for (JsonNode plataforma : creatorNode.get("plataformas")) {
				String nombrePlataforma = plataforma.get("nombre").asText();
				if (nombrePlataforma.equals(plataformaSeleccionada)) {

					String usuarioPlataforma = plataforma.get("usuario").asText();
					String seguidoresPlataforma = plataforma.get("seguidores").asText();
					String fechaCreacionPlataforma = plataforma.get("fecha_creacion").asText();

					vista.lblPlataformaUsuarioMostrar.setText(usuarioPlataforma);
					vista.lblPlataformaSeguidoresMostrar.setText(seguidoresPlataforma);
					vista.lblPlataformaFechaCreacionMostrar.setText(fechaCreacionPlataforma);

					rellenarComboHistorico(plataforma);

					String fechaSeleccionada = null;
					vista.comboBoxHistorial.setSelectedIndex(0);
					fechaSeleccionada = (String) vista.comboBoxHistorial.getSelectedItem();

					verHistorial(fechaSeleccionada, plataforma);
					plataformaSelecc = plataforma;
				}
			}
		}
		return plataformaSelecc;
	}

	public void cambiarPlataforma(String plataformaSeleccionada) {
		// TODO Auto-generated method stub
		if (plataformaSeleccionada.equalsIgnoreCase("Twitch")) {
			vista.panelYoutube.setBackground(new Color(75, 0, 130));
			vista.lblFotoPlataforma.setIcon(fotosIcon.get(2));
		}
		if (plataformaSeleccionada.equalsIgnoreCase("YouTube")) {
			vista.panelYoutube.setBackground(new Color(204, 0, 0));
			vista.lblFotoPlataforma.setIcon(fotosIcon.get(3));
		}
		if (plataformaSeleccionada.equalsIgnoreCase("Instagram")) {
			vista.panelYoutube.setBackground(new Color(255, 0, 128));
			vista.lblFotoPlataforma.setIcon(fotosIcon.get(0));
		}
		if (plataformaSeleccionada.equalsIgnoreCase("TikTok")) {
			vista.panelYoutube.setBackground(Color.black);
			vista.lblFotoPlataforma.setIcon(fotosIcon.get(1));
		}

	}

	public void rellenarFotosIcon(ArrayList<ImageIcon> fotosIcon) {
		ArrayList<String> rutas = new ArrayList<>(
				Arrays.asList("/img/insta.png", "/img/tiktok.png", "/img/Twitch_logo.svg.png", "/img/youtu.png"));

		JLabel label = vista.lblFotoPlataforma;
		int width = vista.lblFotoPlataforma.getWidth();
	    int height = vista.lblFotoPlataforma.getHeight();

		for (String ruta : rutas) {
			ImageIcon imagen = new ImageIcon(getClass().getResource(ruta));
			Image img=imagen.getImage();
			Image imgEscalada = img.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			fotosIcon.add(new ImageIcon(imgEscalada));
		}
	}

	public void verHistorial(String fechaSeleccionada, JsonNode plataforma) {
		// Limpiar las etiquetas antes de cargar nueva información
		vista.lblHistNuevosSeguidores1Mostrar.setText("");
		vista.lblHistInteracciones1Mostrar.setText("");
		vista.lblHistFecha1Mostrar.setText("");

		// Rellenar comboBox con fechas únicas

		if (fechaSeleccionada != null) {
			for (JsonNode historico : plataforma.get("historico")) {
				String fechaHistorial = historico.get("fecha").asText();
				if (fechaSeleccionada.equals(fechaHistorial)) {
					String nuevosSeguidores = historico.get("nuevos_seguidores").asText();
					String interacciones = historico.get("interacciones").asText();
					String fecha = historico.get("fecha").asText();

					// Mostrar la información correcta en las etiquetas correspondientes
					vista.lblHistFecha1Mostrar.setText(fecha);
					vista.lblHistInteracciones1Mostrar.setText(interacciones);
					vista.lblHistNuevosSeguidores1Mostrar.setText(nuevosSeguidores);
					break; // Sal del bucle al encontrar la fecha
				}
			}
		}
	}

	public void rellenarComboHistorico(JsonNode creatorNode) {
		
		vista.comboBoxHistorial.removeAllItems();
		Set<String> fechasUnicas = new HashSet<>();

	
		for (JsonNode historico : creatorNode.get("historico")) {
			String fechaHistorial = historico.get("fecha").asText();
			fechasUnicas.add(fechaHistorial);
		}

		for (String fecha : fechasUnicas) {
			vista.comboBoxHistorial.addItem(fecha);
		}

		if (!fechasUnicas.isEmpty()) {
			vista.comboBoxHistorial.setSelectedIndex(0);
		}
	}

	// 2
	public void calcularPromedios(ArrayNode streamer, List<Contenido> contenido) {
		modelo2.setRowCount(0);
		modelo2.setColumnCount(0);
		String[] nombrePromedios = { "ID Creador", "Nombre Creador", "Plataforma", "Promedio Vistas",
				"Promedio Me Gustas" };

		modelo2.setColumnIdentifiers(nombrePromedios);
	

	}

//3
	public void agregarColaboracion(ArrayNode streamer)
			throws JsonGenerationException, JsonMappingException, IOException {
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
				this.vista.lblCreado.setText("Colaboración añadida exitosamente.");

			}
		}
	
	}

	// 4
	public void exportarColaboracionesACSV(ArrayNode streamer, List<Contenido> contenido) {
		String csvFile = "files/colaboraciones.csv";
		List<String[]> contenidoList = new ArrayList<>();
		List<String> comprobar = new ArrayList<>();

		try {
			String[] header = { "Fecha_Inicio", "Nombre_Creador", "Nombre_Colaborador", "Seguidores_Totales",
					"Interacciones_Totales" };
			contenidoList.add(header);
			for (JsonNode creatorNode : streamer) {
				String creadorNombre = creatorNode.get("nombre").asText();
				int seguidoresTotales = creatorNode.get("seguidores_totales").asInt();
				int interaccionesTotales = creatorNode.get("estadisticas").get("interacciones_totales").asInt();

				if (creatorNode.has("colaboraciones")) {
					ArrayNode colaboraciones = (ArrayNode) creatorNode.path("colaboraciones");
					for (JsonNode colaboracion : colaboraciones) {
						String nombreColaborador = colaboracion.get("colaborador").asText();
						String fechaInicio = colaboracion.get("fecha_inicio").asText();
						String mirar = fechaInicio + "|" + creadorNombre + "|" + nombreColaborador;

						if (!comprobar.contains(mirar)) {
							comprobar.add(mirar);
							String[] data = { fechaInicio, creadorNombre, nombreColaborador,
									String.valueOf(seguidoresTotales), String.valueOf(interaccionesTotales) };
							contenidoList.add(data);
						}
					}
				}
			}
			crearCSV8(contenidoList, csvFile);
			this.vista.lblResultado.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			this.vista.lblFallo.setVisible(false);
		}
	}

	public Contenido encontrarContenidoPorColaboracion(List<Contenido> contenido, JsonNode colaboracion) {
		if (!colaboracion.has("id_contenido")) {
			return null;
		}

		String idContenido = colaboracion.get("id_contenido").asText();
		for (Contenido cont : contenido) {
			if (cont.getCreador_id().equals(idContenido)) {
				return cont;
			}
		}
		return null;
	}

	// 5
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
				this.vista.lblCreado.setText("Publicación modificada exitosamente.");
			} catch (Exception e) {
				e.printStackTrace();
				this.vista.lblCreado.setText("Error al escribir en el archivo CSV.");
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
				this.vista.lblCreado.setText("Publicación eliminada exitosamente.");
			} catch (Exception e) {
				e.printStackTrace();
				this.vista.lblCreado.setText("Error al escribir en el archivo CSV.");
			}
		}
	}

	// 6
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

		objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("files/reporte_creadores.json"), reporte);
		this.vista.lblResultado.setVisible(true);
	}

	// 7
	public void analizarCrecimientoMensualSeguidores(ArrayNode streamer) throws IOException {

		modelo2.setRowCount(0);
		modelo2.setColumnCount(0);

		String[] nombre = { "ID Creador", "Nombre_Creador", "Tasa de crecimiento en YouTube",
				"Tasa de crecimiento en Twitch", "Tasa de crecimiento en Instagram", "Tasa de crecimiento en TikTok" };
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
			double tasaCrecimientoInstagram = calcularTasaCrecimiento(seguidoresInstagramInicio,
					seguidoresInstagramFin);
			double tasaCrecimientoTikTok = calcularTasaCrecimiento(seguidoresTikTokInicio, seguidoresTikTokFin);
			modelo2.addRow(new Object[] { idCreador, nombreCreador, tasaCrecimientoYoutube, tasaCrecimientoTwitch,
					tasaCrecimientoInstagram, tasaCrecimientoTikTok });
		}
	}

	public double calcularTasaCrecimiento(int seguidoresInicio, int seguidoresFin) {
		if (seguidoresInicio == 0) {
			return seguidoresFin > 0 ? 100.0 : 0.0;
		}
		return ((double) (seguidoresFin - seguidoresInicio) / seguidoresInicio) * 100;
	}

	// 8
	public void generarReporteColaboracionesCSV(ArrayNode streamer) throws IOException {
		String csvFile = "files/reporte_colaboraciones.csv";
		List<String[]> contenidoList = new ArrayList<>();
		String[] header = { "Fecha", "Plataforma", "Colaborador" };
		contenidoList.add(header);
		for (JsonNode creador : streamer) {
			ArrayNode colaboraciones = (ArrayNode) creador.path("colaboraciones");
			for (JsonNode colaboracion : colaboraciones) {
				String fechaInicio = colaboracion.path("fecha_inicio").asText();
				String colaboradorId = colaboracion.path("colaborador").asText();
				ArrayNode plataformas = (ArrayNode) creador.path("plataformas");
				for (JsonNode plataforma : plataformas) {
					String nombrePlataforma = plataforma.path("nombre").asText();
					String[] data = { fechaInicio, nombrePlataforma, colaboradorId };
					contenidoList.add(data);
				}
			}
		}
		crearCSV8(contenidoList, csvFile);
		this.vista.lblResultado.setVisible(true);
	}

	// 9
	public void analisisComparativoRendimiento(List<Contenido> contenido) {
	    Map<String, Map<String, int[]>> resultados = new HashMap<>();
	    for (Contenido c : contenido) {
	        String tipo = c.getTipo(); 
	        String plataforma = c.getPlataforma(); 
	        int vistas = c.getVistas();
	        int meGusta = c.getMe_gustas();

	      
	        resultados.putIfAbsent(tipo, new HashMap<>());
	        resultados.get(tipo).putIfAbsent(plataforma, new int[2]); 

	        resultados.get(tipo).get(plataforma)[0] += vistas;
	        resultados.get(tipo).get(plataforma)[1] += meGusta;
	    }
	    for (String tipo : resultados.keySet()) {
	        System.out.println("Tipo de Contenido: " + tipo);
	        for (String plataforma : resultados.get(tipo).keySet()) {
	            int totalVistas = resultados.get(tipo).get(plataforma)[0];
	            int totalMeGusta = resultados.get(tipo).get(plataforma)[1];
	            int conteo = 0;
	            for (Contenido c : contenido) {
	                if (c.getTipo().equals(tipo) && c.getPlataforma().equals(plataforma)) {
	                    conteo++;
	                }
	            }
	            if (conteo > 0) {
	                double promedioVistas = (double) totalVistas / conteo;
	                double promedioMeGusta = (double) totalMeGusta / conteo;

	                System.out.println("Plataforma: " + plataforma + " | Promedio Vistas: " + promedioVistas + " | Promedio Me Gusta: " + promedioMeGusta);
	            } else {
	                System.out.println("Plataforma: " + plataforma + " | No hay datos suficientes para calcular promedios.");
	            }
	        }
	        System.out.println();
	    }
	}

	// 10
	public void crearResumenRendimientoJSON(List<Contenido> contenido) throws IOException {
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
		File directory = new File("files");
		if (!directory.exists()) {
			directory.mkdirs();
		}
		try {
			objectMapper.writerWithDefaultPrettyPrinter()
					.writeValue(new FileWriter("files/resume_rendimiento2023.json"), resumen);
			this.vista.lblResultado.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
			this.vista.lblFallo.setVisible(false);
		}
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

			if (vistasTextoStr.isEmpty() || me_gustaTextoStr.isEmpty() || comentariosTextoStr.isEmpty()
					|| compartidosTextoStr.isEmpty()) {
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

			this.vista.lblCreado.setText("Publicación añadida con éxito.");

		} catch (NumberFormatException e) {
			this.vista.lblCreado.setText("Error: " + e.getMessage());
		} catch (Exception e) {
			this.vista.lblCreado.setText("Error: " + e.getMessage());
		}
	}

	public void modificarPublicacion2(List<Contenido> contenido) {
		String id_creador = this.vista.textFieldid_creador3.getText();
		String fecha = this.vista.textFieldFechaContenido3.getText();
		String plataforma = this.vista.textFieldel_plataforma3.getText();

		try {
			Integer me_gustaTexto = Integer.parseInt(this.vista.textField_megusta2.getText());
			Integer comentariosTexto = Integer.parseInt(this.vista.textFieldComentarios3.getText());

			boolean encontrado = false;
			for (Contenido publicacion : contenido) {
				if (publicacion.getCreador_id().equals(id_creador) && publicacion.getFecha().equals(fecha)
						&& publicacion.getPlataforma().equals(plataforma)) {
					publicacion.setMe_gustas(me_gustaTexto);
					publicacion.setComentarios(comentariosTexto);
					encontrado = true;
					break;
				}
			}

			if (encontrado) {
				crearCSV(contenido, "files/metricas_contenido.csv");
				this.vista.lblCreado.setText("Publicación modificada y guardada con éxito.");
			} else {
				this.vista.lblCreado.setText("No se encontró la publicación con los datos proporcionados.");
			}

		} catch (Exception e) {
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
				this.vista.lblCreado.setText("Publicaciones eliminadas con éxito.");
			} else {
				this.vista.lblCreado.setText("No se encontraron publicaciones que eliminar.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 12
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

		try (FileWriter fileWriter = new FileWriter("files/colaboraciones.json")) {
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileWriter, colaboracionesArray);
			this.vista.lblResultado.setVisible(true);
		}
	}

	public void crearCSV(List<Contenido> misFutbolistas, String rutaCSV) {
		try {
			FileWriter fw = new FileWriter(rutaCSV);
			StatefulBeanToCsv<Contenido> beanToCsv = new StatefulBeanToCsvBuilder<Contenido>(fw).build();
			beanToCsv.write(misFutbolistas);
			fw.flush();
		} catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}
	}

	public void crearCSV8(List<String[]> contenido, String rutaCSV) {
		try (FileWriter fw = new FileWriter(rutaCSV); CSVWriter writer = new CSVWriter(fw)) {
			for (String[] todo : contenido) {
				writer.writeNext(todo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
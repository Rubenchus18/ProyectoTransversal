package Controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
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
	JsonNode colabSeleccionada;
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
		this.vista.listColabs.addListSelectionListener(e -> verColaboracion(creadorSeleccionado));
		this.vista.listMetricas.addListSelectionListener(e -> verMetricas());
		this.vista.listColaboradores.addListSelectionListener(e -> seleccionarColaborador());
		this.vista.comboBoxPlataforma.addActionListener(this);
		this.vista.comboBoxHistorial.addActionListener(this);
		this.vista.btnInfoCreador.addActionListener(this);
		this.vista.comboBoxelegiropciones.addActionListener(this);
		this.vista.btnJoptionPaint.addActionListener(this);
		this.vista.btnColaboraciones.addActionListener(this);
		this.vista.btnMetricasContenido.addActionListener(this);
		this.vista.btnVolverMenu.addActionListener(this);
		this.vista.btnInsertarCo.addActionListener(this);
		this.vista.btnAñadirPublic.addActionListener(this);
		this.vista.btnEliminarPublicacion.addActionListener(this);
		this.vista.btnEliminarMin.addActionListener(this);
		this.vista.btnmodificarpublicacionenespecifico.addActionListener(this);
		this.vista.btnModificarLikes.addActionListener(this);
		this.vista.btnSalirInfoGen.addActionListener(this);
		this.vista.btnSalirInfoGen2.addActionListener(this);
		this.vista.btnMetricasContenido.addActionListener(this);
		this.vista.btnVerInfoColab.addActionListener(this);
		this.vista.btnAniadirColab.addActionListener(this);
		this.vista.btnAñadirPubli.addActionListener(this);
		this.vista.btnVerInfoPubli.addActionListener(this);
		this.vista.btnModificarPubli.addActionListener(this);
		this.vista.btnModificarPubli_1.addActionListener(this);

		streamer = leer();
		contenido = abrirCSV("files/metricas_contenido.csv");
		agregarcomboxestado();
		agregarComboTipoColab();
		agregarcomboboxmodificar();
		llenarJListStreamers(streamer);
		llenarJlistStreamer(streamer);
		agregarPlataformas();
		agregarcomboxopciones();
		rellenarFotosIcon(fotosIcon);
		agregarcomboboxmodificar1();
	}

	public void actionPerformed(ActionEvent e) {
		// Nuevo
		if (e.getSource() == this.vista.btnInsertarCo) {
			try {
				agregarColaboracion(streamer);
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == this.vista.btnAñadirPublic) {
			try {
				añadirPublicacion(contenido);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == this.vista.btnEliminarPublicacion) {
			eliminarPublicacion(contenido);
		}
		if (e.getSource() == this.vista.btnmodificarpublicacionenespecifico) {
			modificarPublicacion(contenido);
		}
		if (e.getSource() == this.vista.btnModificarLikes) {
			modificarPublicacion2(contenido);
		}
		if (e.getSource() == this.vista.comboBoxelegiropciones) {
			String selectedOption = (String) this.vista.comboBoxelegiropciones.getSelectedItem();

			this.vista.panelEliminarpubli.setVisible(false);
			this.vista.paneleliminarminimovistas.setVisible(false);
			switch (selectedOption) {
			case "Eliminar publicaciones":
				this.vista.panelEliminarpubli.setVisible(true);
				this.vista.paneleliminarminimovistas.setVisible(false);
				this.vista.lblCreado.setText("");
				break;
			case "Eliminar minimo de vistas":
				this.vista.panelEliminarpubli.setVisible(false);
				this.vista.paneleliminarminimovistas.setVisible(true);
				this.vista.lblCreado.setText("");
				break;
			case "Modificar publicacion":
				this.vista.panelEliminarpubli.setVisible(false);
				this.vista.paneleliminarminimovistas.setVisible(false);
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
		if (e.getSource() == this.vista.btnInfoCreador) {
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

		if (e.getSource() == this.vista.btnVolverMenu) {
			this.vista.panelMenu.setVisible(true);
			this.vista.panelModifcar.setVisible(false);
		}

		if (e.getSource() == vista.btnColaboraciones) {
			if (creadorSeleccionado != null) {
				llenarJlistColabs(creadorSeleccionado);
				llenarJListColaboradores(streamer);
				this.vista.panelMostrarColabs.setVisible(true);
				vista.panelMostrarTodo.setVisible(false);
				habilitarVerColabs();
			}
		}
		if (vista.btnSalirInfoGen == e.getSource()) {
			salirInfoGeneral(vista.btnSalirInfoGen);
		}
		if (vista.btnAniadirColab == e.getSource()) {
			habilitarAnidadirColab();
		}
		if (vista.btnVerInfoColab == e.getSource()) {
			habilitarVerColabs();
		}

		if (e.getSource() == vista.btnMetricasContenido) {
			if (creadorSeleccionado != null) {
				llenarMetricasContenido(creadorSeleccionado);
				nuevoContenido();
				this.vista.panelMostrarMetricasCSV.setVisible(true);
				vista.panelMostrarTodo.setVisible(false);
				habilitarInfoMetrica();
			}
		}

		if (vista.btnSalirInfoGen2 == e.getSource()) {
			salirInfoGeneral(vista.btnSalirInfoGen2);
		}
		if (vista.btnAñadirPubli == e.getSource()) {
			habilitarAniadirPubli();
		}
		if (vista.btnVerInfoPubli == e.getSource()) {
			habilitarInfoMetrica();
		}
		if (vista.btnModificarPubli == e.getSource()) {
			habilitarModificarPubli();
		}
		if(vista.btnModificarPubli_1==e.getSource()) {
			habilitarModificarCSVLikes();
		}

		if (e.getSource() == vista.btnJoptionPaint) {
			bomba();
		}

	}

	private void habilitarModificarCSVLikes() {
		vista.panelmodificarLikesComentarios.setVisible(true);
		vista.panelInfoMetricas.setVisible(false);
		vista.panelModificarPublicacion.setVisible(false);
		vista.panelañadirpublicion.setVisible(false);

		// boton añadirPubli inactivo
		vista.btnAñadirPubli.setForeground(SystemColor.desktop);
		vista.btnAñadirPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnAñadirPubli.setBackground(SystemColor.scrollbar);
		vista.btnAñadirPubli.setBounds(656, 127, 203, 31);

		// boton btnVerInfoPubli inactivo
		vista.btnVerInfoPubli.setForeground(SystemColor.desktop);
		vista.btnVerInfoPubli.setFont(new Font("Tahoma", Font.BOLD, 17));
		vista.btnVerInfoPubli.setBackground(SystemColor.scrollbar);
		vista.btnVerInfoPubli.setBounds(464, 127, 194, 31);

		// boton btnModificarPubli inactivo
		vista.btnModificarPubli.setForeground(SystemColor.desktop);
		vista.btnModificarPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnModificarPubli.setBackground(SystemColor.scrollbar);
		vista.btnModificarPubli.setBounds(856, 127, 217, 31);

		// boton btnModificarPubli inactivo
		vista.btnModificarPubli.setForeground(SystemColor.desktop);
		vista.btnModificarPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnModificarPubli.setBackground(SystemColor.scrollbar);
		vista.btnModificarPubli.setBounds(856, 127, 217, 31);

		// boton btnModificarPubliLikes inactivo
		vista.btnModificarPubli_1.setForeground(Color.WHITE);
		vista.btnModificarPubli_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		vista.btnModificarPubli_1.setBackground(new Color(128, 64, 0));
		vista.btnModificarPubli_1.setBounds(1072, 120, 210, 38);
		
		// valores por defecto
		
		this.vista.lblContenidoSeleccionadoModificarLike.setText("");
		this.vista.lblPlataformaLikes.setText("");
		this.vista.textField_megusta2.setText("");
		this.vista.textFieldComentarios3.setText("");
		vista.listMetricas.clearSelection();
		vista.lblCreado5.setText("");
	}

	private void habilitarAniadirPubli() {
		// TODO Auto-generated method stub
		vista.panelañadirpublicion.setVisible(true);
		vista.panelInfoMetricas.setVisible(false);
		vista.panelModificarPublicacion.setVisible(false);
		vista.panelmodificarLikesComentarios.setVisible(false);


		// boton añadirPubli activo
		vista.btnAñadirPubli.setForeground(Color.WHITE);
		vista.btnAñadirPubli.setFont(new Font("Tahoma", Font.BOLD, 17));
		vista.btnAñadirPubli.setBackground(new Color(128, 64, 0));
		vista.btnAñadirPubli.setBounds(656, 120, 203, 38);

		// boton btnVerInfoPubli inactivo
		vista.btnVerInfoPubli.setForeground(SystemColor.desktop);
		vista.btnVerInfoPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnVerInfoPubli.setBackground(SystemColor.scrollbar);
		vista.btnVerInfoPubli.setBounds(464, 127, 194, 31);

		// boton btnModificarPubli inactivo
		vista.btnModificarPubli.setForeground(SystemColor.desktop);
		vista.btnModificarPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnModificarPubli.setBackground(SystemColor.scrollbar);
		vista.btnModificarPubli.setBounds(856, 127, 217, 31);

		// boton btnModificarPubli inactivo
		vista.btnModificarPubli.setForeground(SystemColor.desktop);
		vista.btnModificarPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnModificarPubli.setBackground(SystemColor.scrollbar);
		vista.btnModificarPubli.setBounds(856, 127, 217, 31);

		// boton btnModificarPubliLikes inactivo
		vista.btnModificarPubli_1.setForeground(SystemColor.desktop);
		vista.btnModificarPubli_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnModificarPubli_1.setBackground(SystemColor.scrollbar);
		vista.btnModificarPubli_1.setBounds(1072, 127, 210, 31);

		// valores por defecto

		this.vista.comboBoxPlataformaCSV.setSelectedIndex(0); // Desmarca cualquier selección en el combo box
		this.vista.textFieldFecha2.setText("");
		this.vista.textFieldTipo2.setText("");
		this.vista.textFieldVistas2.setText("");
		this.vista.textFieldMeGsuta2.setText("");
		this.vista.textFieldComentarios2.setText("");
		this.vista.textFieldCompartidos2.setText("");
		vista.lblCreado3.setText("");
	}

	private void habilitarInfoMetrica() {
		// TODO Auto-generated method stub
		vista.panelañadirpublicion.setVisible(false);
		vista.panelInfoMetricas.setVisible(true);
		vista.panelModificarPublicacion.setVisible(false);
		vista.panelmodificarLikesComentarios.setVisible(false);


		// boton añadirPubli inactivo
		vista.btnAñadirPubli.setForeground(SystemColor.desktop);
		vista.btnAñadirPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnAñadirPubli.setBackground(SystemColor.scrollbar);
		vista.btnAñadirPubli.setBounds(656, 127, 203, 31);

		// boton btnVerInfoPubli activo
		vista.btnVerInfoPubli.setForeground(Color.WHITE);
		vista.btnVerInfoPubli.setFont(new Font("Tahoma", Font.BOLD, 17));
		vista.btnVerInfoPubli.setBackground(new Color(128, 64, 0));
		vista.btnVerInfoPubli.setBounds(464, 120, 194, 38);

		// boton btnModificarPubli inactivo
		vista.btnModificarPubli.setForeground(SystemColor.desktop);
		vista.btnModificarPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnModificarPubli.setBackground(SystemColor.scrollbar);
		vista.btnModificarPubli.setBounds(856, 127, 217, 31);

		// boton btnModificarPubliLikes inactivo
		vista.btnModificarPubli_1.setForeground(SystemColor.desktop);
		vista.btnModificarPubli_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnModificarPubli_1.setBackground(SystemColor.scrollbar);
		vista.btnModificarPubli_1.setBounds(1072, 127, 210, 31);
		
		//valores vacios
		vista.lblContenidoMetricaMostrar.setText("");
		vista.lblMostrarPlataformaMetrica.setText("");
		vista.lblTipoContenidoMetricaMostrar.setText("");
		vista.lblFechaMetricaMostrar.setText("");
		vista.lblVistasMetricasMostrar.setText("");
		vista.lblMeGustaMetricasMostrar.setText("");
		vista.lblCompartidosMetricasMostrar.setText("");
		vista.lblComentariosMetricasMostrar.setText("");
		vista.listMetricas.clearSelection();
	}

	private void habilitarModificarPubli() {
		// TODO Auto-generated method stub
		vista.panelañadirpublicion.setVisible(false);
		vista.panelInfoMetricas.setVisible(false);
		vista.panelModificarPublicacion.setVisible(true);
		vista.panelmodificarLikesComentarios.setVisible(false);


		// boton añadirPubli inactivo
		vista.btnAñadirPubli.setForeground(SystemColor.desktop);
		vista.btnAñadirPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnAñadirPubli.setBackground(SystemColor.scrollbar);
		vista.btnAñadirPubli.setBounds(656, 127, 203, 31);

		// boton btnVerInfoPubli inactivo
		vista.btnVerInfoPubli.setForeground(SystemColor.desktop);
		vista.btnVerInfoPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnVerInfoPubli.setBackground(SystemColor.scrollbar);
		vista.btnVerInfoPubli.setBounds(464, 127, 194, 31);

		// boton btnModificarPubli inactivo
		vista.btnModificarPubli.setForeground(SystemColor.desktop);
		vista.btnModificarPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnModificarPubli.setBackground(SystemColor.scrollbar);
		vista.btnModificarPubli.setBounds(856, 127, 217, 31);

		// boton btnModificarPubli activo
		vista.btnModificarPubli.setForeground(Color.WHITE);
		vista.btnModificarPubli.setFont(new Font("Tahoma", Font.BOLD, 17));
		vista.btnModificarPubli.setBackground(new Color(128, 64, 0));
		vista.btnModificarPubli.setBounds(856, 120, 217, 38);

		// boton btnModificarPubliLikes inactivo
		vista.btnModificarPubli_1.setForeground(SystemColor.desktop);
		vista.btnModificarPubli_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnModificarPubli_1.setBackground(SystemColor.scrollbar);
		vista.btnModificarPubli_1.setBounds(1072, 127, 210, 31);

		// valores por defecto
		this.vista.lblContenidoSeleccionadoModificar.setText("");
		this.vista.comboBoxparaModificar.setSelectedIndex(0); // Desmarcar la selección
		this.vista.textFieldDato.setText("");
		vista.listMetricas.clearSelection();
		vista.lblCreado3.setText("");
	}

	private void habilitarVerColabs() {
		vista.panelInfoColab.setVisible(true);

		vista.panelInsertarColaboradores.setVisible(false);
		vista.scrollPaneColaboradores.setVisible(false);
		vista.listColaboradores.setVisible(false);
		// botonInfoColab activo
		vista.btnVerInfoColab.setForeground(Color.WHITE);
		vista.btnVerInfoColab.setBackground(new Color(25, 25, 112));
		vista.btnVerInfoColab.setFont(new Font("Tahoma", Font.BOLD, 17));
		vista.btnVerInfoColab.setBounds(535, 120, 231, 38);

		// botonAñadircolab inactivo

		vista.btnAniadirColab.setForeground(SystemColor.desktop);
		vista.btnAniadirColab.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnAniadirColab.setBackground(SystemColor.scrollbar);
		vista.btnAniadirColab.setBounds(766, 127, 242, 31);
		
		//valores vacios

		vista.lblIdMostrarColaborador.setText("");
		vista.lblTematicaMostrar2.setText("");
		vista.lblMostrarFechaInicio.setText("");
		vista.lblFechaFinMostrar.setText("");
		vista.lblTipoColabMostrar.setText("");
		vista.lblEstadoColabMostrar.setText("");
		vista.listColabs.clearSelection();
	}

	public void habilitarAnidadirColab() {
		vista.panelInfoColab.setVisible(false);

		vista.panelInsertarColaboradores.setVisible(true);
		vista.scrollPaneColaboradores.setVisible(true);
		vista.listColaboradores.setVisible(true);

		// modificar botones
		// botonAñadircolab activo
		vista.btnAniadirColab.setBounds(766, 120, 242, 38);
		vista.btnAniadirColab.setBackground(new Color(25, 25, 112));
		vista.btnAniadirColab.setForeground(Color.WHITE);
		vista.btnAniadirColab.setFont(new Font("Tahoma", Font.BOLD, 17));

		// botonInfoColab inactivo
		vista.btnVerInfoColab.setForeground(SystemColor.desktop);
		vista.btnVerInfoColab.setBackground(SystemColor.scrollbar);
		vista.btnVerInfoColab.setFont(new Font("Tahoma", Font.BOLD, 16));
		vista.btnVerInfoColab.setBounds(535, 127, 231, 31);

		this.vista.listColaboradores.setSelectedIndex(-1);
		this.vista.lblNombreColabSeleccionado.setText("");
		this.vista.textFieldTematica.setText("");
		this.vista.textFieldFechaInicio.setText("");
		this.vista.textFieldFechaFin.setText("");
		this.vista.comboboxTipoColab.setSelectedIndex(0); // Deseleccionar cualquier opción
		this.vista.comboBoxEstadoColaboracion.setSelectedIndex(0); // Deseleccionar cualquier opción
		vista.lblCreado2.setText("");
		vista.listColabs.clearSelection();
		vista.listColaboradores.clearSelection();

	}

	public void salirInfoGeneral(JButton botonPasado) {
		JButton boton = botonPasado;
		if (boton == vista.btnSalirInfoGen2) {
			this.vista.panelMostrarMetricasCSV.setVisible(false);
			vista.panelMostrarTodo.setVisible(true);
		} else if (boton == vista.btnSalirInfoGen) {
			this.vista.panelMostrarColabs.setVisible(false);
			vista.panelMostrarTodo.setVisible(true);
		}
	}

	public void agregarcomboxestado() {
		this.vista.comboBoxEstadoColaboracion.addItem("Activo");
		this.vista.comboBoxEstadoColaboracion.addItem("Finalizada");
	}

	public void agregarComboTipoColab() {
		vista.comboboxTipoColab.addItem("Colaboracion Natural");
		vista.comboboxTipoColab.addItem("Patrocinado");

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

	public void agregarcomboboxmodificar1() {
		this.vista.comboBoxOpcion.addItem("vistas");
		this.vista.comboBoxOpcion.addItem("me_gusta");
		this.vista.comboBoxOpcion.addItem("comentarios");
		this.vista.comboBoxOpcion.addItem("compartidos");
	}

	public void agregarcomboxopciones() {
		this.vista.comboBoxelegiropciones.addItem("Eliminar publicaciones");
		this.vista.comboBoxelegiropciones.addItem("Eliminar minimo de vistas");
	}
//Metodos generalizados y leer metodos
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
	        String[] plataformas = {"TikTok", "Twitch", "Instagram", "YouTube"};
	        for (String plataforma : plataformas) {
	            vista.comboBoxPlataforma.addItem(plataforma);
	            vista.comboBoxPlataformaCSV.addItem(plataforma);
	        }
	    }

	public void llenarJListStreamers(ArrayNode streamer) {
	        DefaultListModel<String> modelo = new DefaultListModel<>();
	        for (JsonNode creatorNode : streamer) {
	            String nombreCreador = creatorNode.get("nombre").asText();
	            String idCreador = creatorNode.get("id").asText();
	            modelo.addElement("Id: " + idCreador + " Nombre: " + nombreCreador);
	        }
	        vista.listStreamers.setModel(modelo);
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

	public void llenarJlistColabs(JsonNode creador) {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		modelo.setSize(0);
		for (JsonNode creatorNode : creador.get("colaboraciones")) {
			String colaborador = creatorNode.get("colaborador").asText();
			String tematica = creatorNode.get("tematica").asText();
			String elementoJlist = "Colaborador: " + colaborador + ", tematica: " + tematica;
			modelo.addElement(elementoJlist);
		}
		this.vista.listColabs.setModel(modelo);
	}

	public void nuevoContenido() {
		String nuevoContenido = null;

		for (Contenido conten : contenido) {
			String idCreadorMetrica = conten.getCreador_id();

			String contenidoActual = conten.getContenido();

			
			int numero = 1; 
			if (contenidoActual.matches(".*\\d+")) { 
				numero = Integer.parseInt(contenidoActual.replaceAll("[^0-9]", "")) + 1;
			}

			nuevoContenido = "Contenido " + numero;
		}

		vista.lblContenidoNuevo.setText(nuevoContenido);
	}

	public void llenarMetricasContenido(JsonNode creadorSeleccionado) {

		DefaultListModel<String> modelo = new DefaultListModel<>();
		modelo.setSize(0);
		String idCreador = creadorSeleccionado.get("id").asText();

		if (idCreador != null) {
			for (Contenido conten : contenido) {
				String idCreadorMetrica = conten.getCreador_id();
				if (idCreadorMetrica.equalsIgnoreCase(idCreador)) {
					String contenido = conten.getContenido();
					String tipocontenido = conten.getTipo();
					String elementoJlist = contenido + ", tipo: " + tipocontenido;
					modelo.addElement(elementoJlist);

				}
			}
			this.vista.listMetricas.setModel(modelo);
		}

	}

	public void verMetricas() {
		String metricaSeleccionada = (String) vista.listMetricas.getSelectedValue();

		if (metricaSeleccionada == null || metricaSeleccionada.trim().isEmpty()) {
			return;
		}
		String[] partes = metricaSeleccionada.split(",");
		if (partes.length < 2) {
			System.out.println("Formato inválido.");
			return;
		}
		String contenidoSeleccionado = partes[0].trim();

		if (contenido != null) {
			for (Contenido conten : contenido) {
				String contenidoMetrica = conten.getContenido();
				if (contenidoMetrica.equalsIgnoreCase(contenidoSeleccionado)) {
					String tipocontenido = conten.getTipo();
					String plataforma = conten.getPlataforma();
					String fecha = conten.getFecha();
					String vistas = String.valueOf(conten.getVistas());
					String meGusta = String.valueOf(conten.getMe_gustas());
					String comentarios = String.valueOf(conten.getComentarios());
					String compartidos = String.valueOf(conten.getCompartidos());

					vista.lblContenidoMetricaMostrar.setText(contenidoMetrica);
					vista.lblMostrarPlataformaMetrica.setText(plataforma);
					vista.lblTipoContenidoMetricaMostrar.setText(tipocontenido);
					vista.lblFechaMetricaMostrar.setText(fecha);
					vista.lblVistasMetricasMostrar.setText(vistas);
					vista.lblMeGustaMetricasMostrar.setText(meGusta);
					vista.lblCompartidosMetricasMostrar.setText(compartidos);
					vista.lblComentariosMetricasMostrar.setText(comentarios);

					vista.lblContenidoSeleccionadoModificar.setText(contenidoMetrica);
					vista.lblContenidoSeleccionadoModificarLike.setText(contenidoMetrica);
					vista.lblPlataformaLikes.setText(plataforma);
				}
			}
		}
	}

	public void verColaboracion(JsonNode creatorNode) {
		String colaboracionSeleccionada = (String) vista.listColabs.getSelectedValue();

		if (colaboracionSeleccionada == null || colaboracionSeleccionada.trim().isEmpty()) {
			return;
		}

		String[] partes = colaboracionSeleccionada.split(",");
		if (partes.length < 2) {
			System.out.println("Formato inválido.");
			return;
		}

		String colaborador = partes[0].replace("Colaborador:", "").trim();

		String tematica = partes[1].replace("tematica:", "").trim();

		if (colaborador != null && tematica != null) {
			for (JsonNode colab : creatorNode.get("colaboraciones")) {
				String colaboradorJson = colab.get("colaborador").asText();
				String tematicaJson = colab.get("tematica").asText();
				if (colaborador.equalsIgnoreCase(colaboradorJson) && tematica.equalsIgnoreCase(tematicaJson)) {
					String fechaInicio = colab.get("fecha_inicio").asText();
					String fechaFin = colab.get("fecha_fin").asText();
					String tipo = colab.get("tipo").asText();
					String estado = colab.get("estado").asText();

					vista.lblIdMostrarColaborador.setText(colaboradorJson);
					vista.lblTematicaMostrar2.setText(tematicaJson);
					vista.lblMostrarFechaInicio.setText(fechaInicio);
					vista.lblFechaFinMostrar.setText(fechaFin);
					vista.lblTipoColabMostrar.setText(tipo);
					vista.lblEstadoColabMostrar.setText(estado);
				}
			}
		}
	}
//Feha
	public boolean ValidarDate(String date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    try {
	        sdf.parse(date);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}
//Lista Colaboradores
	public void llenarJListColaboradores(ArrayNode streamer) {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		modelo.setSize(0);

		String nombreSeleccionado = (String) vista.listStreamers.getSelectedValue();
		if (nombreSeleccionado == null || nombreSeleccionado.trim().isEmpty()) {

		}

		String[] partes = nombreSeleccionado.split(" ");
		if (partes.length < 2) {

		}

		String idCreadorSeleccionado = partes[1]; // "20"
		JsonNode creador = null;

		if (idCreadorSeleccionado != null) {
			for (JsonNode creatorNode : streamer) {
				String idCreador = creatorNode.get("id").asText();
				if (!idCreador.equals(idCreadorSeleccionado)) {
					String nombreCreador = creatorNode.get("nombre").asText();
					String elementoJlist = "Id: " + idCreador + " Nombre: " + nombreCreador;
					modelo.addElement(elementoJlist);
				}
			}
		}
		this.vista.listColaboradores.setModel(modelo);
	}
//Seleccionar colaboraciones
	public void seleccionarColaborador() {
	
		String nombreSeleccionado = (String) vista.listColaboradores.getSelectedValue();

		String nombreCreador = null;

		if (nombreSeleccionado != null && !nombreSeleccionado.trim().isEmpty()) {
			
			String[] partes = nombreSeleccionado.split("Nombre: ");
			if (partes.length == 2) {
				
				nombreCreador = partes[1].trim();
			}
		}

		if (nombreCreador != null) {
			vista.lblNombreColabSeleccionado.setText(nombreCreador);
		}
	}
//Mostar los mensajes temporales
	public  void mostrarMensajeTemporal(JLabel label, String mensaje) {
	    label.setText(mensaje);
	    label.setVisible(true);
	    
	    new javax.swing.Timer(5000, new ActionListener() {

	        public void actionPerformed(ActionEvent e) {
	            label.setVisible(false); 
	        }
	    }).start();
	}
//Metodos de los ejercicios
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
					Double tasaCrecimientoSeguidoresDouble = estadisticas.get("tasa_crecimiento_seguidores").asDouble();
					String tasaCrecimientoSeguidores = String.format("%.2f%%", tasaCrecimientoSeguidoresDouble);
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
					vista.lblIdMostrarIdSelec.setText(idCreador);
					vista.lblIdCreadorSeleccionadoCSV.setText(idCreador);
					vista.lblIdCreadorSeleccionadoCSVModificar.setText(idCreador);
					vista.lblIdCreadorSeleccionadoCSVModificarLike.setText(idCreador);
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
			Image img = imagen.getImage();
			Image imgEscalada = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			fotosIcon.add(new ImageIcon(imgEscalada));
		}
	}

	public void verHistorial(String fechaSeleccionada, JsonNode plataforma) {

		vista.lblHistNuevosSeguidores1Mostrar.setText("");
		vista.lblHistInteracciones1Mostrar.setText("");
		vista.lblHistFecha1Mostrar.setText("");

		if (fechaSeleccionada != null) {
			for (JsonNode historico : plataforma.get("historico")) {
				String fechaHistorial = historico.get("fecha").asText();
				if (fechaSeleccionada.equals(fechaHistorial)) {
					String nuevosSeguidores = historico.get("nuevos_seguidores").asText();
					String interacciones = historico.get("interacciones").asText();
					String fecha = historico.get("fecha").asText();

					vista.lblHistFecha1Mostrar.setText(fecha);
					vista.lblHistInteracciones1Mostrar.setText(interacciones);
					vista.lblHistNuevosSeguidores1Mostrar.setText(nuevosSeguidores);
					break;
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
	public JsonNode mostrarDatosStreamer21(ArrayNode streamer) {
		String nombreSeleccionado = (String) vista.listStreamers.getSelectedValue();
		if (nombreSeleccionado == null || nombreSeleccionado.trim().isEmpty()) {
			return null;
		}

		String[] partes = nombreSeleccionado.split(" ");
		if (partes.length < 2) {
			return null;
		}

		String idCreadorSeleccionado = partes[1];
		JsonNode creador = null;

		if (idCreadorSeleccionado != null) {
			vista.comboBoxHistorial.removeAllItems();
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
					Double tasaCrecimientoSeguidoresDouble = estadisticas.get("tasa_crecimiento_seguidores").asDouble();
					String tasaCrecimientoSeguidores = String.format("%.2f%%", tasaCrecimientoSeguidoresDouble);

					vista.lblIdMostrar.setText(idCreador);
					vista.lblNombreMostrar.setText(nombreCreador);
					vista.lblPaisMostrar.setText(pais);
					vista.lblTematicaMostrar.setText(tematica);
					vista.lblSeguidoresTotalesMostrar.setText(seguidoresTotales);
					vista.lblInteraccionesTotalesMostrar.setText(interaccionesTotales);
					vista.lblPromedioVistasMensualesMostrar.setText(promedioVistasMensuales);
					vista.lblTasaCrecimientoSeguidoresMostrar.setText(tasaCrecimientoSeguidores);

					calcularPromedios(creatorNode);
					identificarMejorRendimiento(creatorNode);

					creador = creatorNode;
					vista.comboBoxPlataforma.setSelectedIndex(0);
				}
			}
		}
		return creador;
	}

	public void calcularPromedios(JsonNode creatorNode) {
		ArrayNode plataformas = (ArrayNode) creatorNode.get("plataformas");
		for (JsonNode plataforma : plataformas) {
			String nombrePlataforma = plataforma.get("nombre").asText();
			int totalVistas = 0;
			int totalMeGusta = 0;
			int conteo = 0;

			for (Contenido cont : contenido) {
				if (cont.getPlataforma().equals(nombrePlataforma)
						&& cont.getCreador_id().equals(creatorNode.get("id").asText())) {
					totalVistas += cont.getVistas();
					totalMeGusta += cont.getMe_gustas();
					conteo++;
				}
			}

			double promedioVistas;
			double promedioMeGusta;

			if (conteo > 0) {
				promedioVistas = (double) totalVistas / conteo;
				promedioMeGusta = (double) totalMeGusta / conteo;
			} else {
				promedioVistas = 0;
				promedioMeGusta = 0;
			}

			// vista.lblPromedioVistasMostrar.setText(String.format("Promedio Vistas en %s:
			// %.2f", nombrePlataforma, promedioVistas));
			// vista.lblPromedioMeGustaMostrar.setText(String.format("Promedio Me Gusta en
			// %s: %.2f", nombrePlataforma, promedioMeGusta));
		}
	}

	public void identificarMejorRendimiento(JsonNode creatorNode) {
		ArrayNode plataformas = (ArrayNode) creatorNode.get("plataformas");
		for (JsonNode plataforma : plataformas) {
			String nombrePlataforma = plataforma.get("nombre").asText();
			Map<String, Integer> rendimientoPorTipo = new HashMap<>();

			for (Contenido cont : contenido) {
				if (cont.getPlataforma().equals(nombrePlataforma)
						&& cont.getCreador_id().equals(creatorNode.get("id").asText())) {
					rendimientoPorTipo.put(cont.getTipo(),
							rendimientoPorTipo.getOrDefault(cont.getTipo(), 0) + cont.getVistas());
				}
			}

			String mejorTipo = null;
			int maxRendimiento = 0;
			for (Map.Entry<String, Integer> entry : rendimientoPorTipo.entrySet()) {
				if (entry.getValue() > maxRendimiento) {
					maxRendimiento = entry.getValue();
					mejorTipo = entry.getKey();
				}
			}

			if (mejorTipo != null) {
				// vista.lblMejorRendimientoMostrar.setText(String.format("Mejor tipo de
				// contenido en %s: %s con %d vistas", nombrePlataforma, mejorTipo,
				// maxRendimiento));
			}
		}
	}
//3

	public void agregarColaboracion(ArrayNode streamer)
			throws JsonGenerationException, JsonMappingException, IOException {
		File file = new File("files/creadores.json");
		String idCreador1 = this.vista.lblIdMostrarIdSelec.getText();
		String colaborador = this.vista.lblNombreColabSeleccionado.getText();
		String tematica = this.vista.textFieldTematica.getText();
		String fechaInicio = this.vista.textFieldFechaInicio.getText();
		String fechaFin = this.vista.textFieldFechaFin.getText();
		String tipoColaboracion = (String) this.vista.comboboxTipoColab.getSelectedItem();
		String estadoColaboracion = (String) this.vista.comboBoxEstadoColaboracion.getSelectedItem();

		if (!ValidarDate(fechaInicio) || !ValidarDate(fechaFin)) {
			this.vista.lblCreado2.setText("Las fechas deben estar en el formato dd/mm/yyyy.");
			return;
		}

		if (idCreador1.equals("") || colaborador.equals("") || tematica.equals("") || fechaInicio.equals("")
				|| fechaFin.equals("") || tipoColaboracion.equals("") || estadoColaboracion == null) {
			this.vista.lblCreado2.setText("Error: Todos los campos deben estar rellenos.");
		} else {
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
					this.vista.lblCreado2.setText("Colaboración añadida exitosamente.");

					this.vista.listColaboradores.setSelectedIndex(-1);
					this.vista.lblNombreColabSeleccionado.setText("");
					this.vista.textFieldTematica.setText("");
					this.vista.textFieldFechaInicio.setText("");
					this.vista.textFieldFechaFin.setText("");
					this.vista.comboboxTipoColab.setSelectedIndex(0); // Deseleccionar cualquier opción
					this.vista.comboBoxEstadoColaboracion.setSelectedIndex(0); // Deseleccionar cualquier opción
					vista.lblCreado2.setText("");
					vista.listColabs.clearSelection();
					vista.listColaboradores.clearSelection();

					llenarJlistColabs(creadorSeleccionado);
					return;
				}
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
			mostrarMensajeTemporal(this.vista.lblResultado,"Colaboraciones CSV creado correctamente");
			this.vista.lblResultado.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			mostrarMensajeTemporal(this.vista.lblFallo,"Error");
			this.vista.lblFallo.setVisible(true);
			
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
		String idStreamer = this.vista.lblIdCreadorSeleccionadoCSVModificar.getText();
		String contenidoSeleccionado = this.vista.lblContenidoSeleccionadoModificar.getText();
		String tipo = (String) this.vista.comboBoxparaModificar.getSelectedItem();
		String nuevoDato = this.vista.textFieldDato.getText();
		boolean modificada = false;

		if (idStreamer.isEmpty() || contenidoSeleccionado.isEmpty() || tipo == null || nuevoDato.isEmpty()) {
			this.vista.lblCreado.setText("Error: Todos los campos deben estar completos.");
			return;
		}

		for (Contenido cont : contenido) {
			if (cont.getCreador_id().equals(idStreamer) && cont.getContenido().equals(contenidoSeleccionado)) {
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
				mostrarMensajeTemporal(this.vista.lblCreado4,"Publicación modificada exitosamente.");
				this.vista.lblContenidoSeleccionadoModificar.setText("");
				this.vista.comboBoxparaModificar.setSelectedIndex(0);
				this.vista.textFieldDato.setText("");
				vista.listMetricas.clearSelection();
				llenarMetricasContenido(creadorSeleccionado);
			} catch (Exception e) {
				e.printStackTrace();
				mostrarMensajeTemporal(this.vista.lblCreado4,"Error al escribir en el archivo CSV.");
		
			}
		} else {
			mostrarMensajeTemporal(this.vista.lblCreado4,"Error: No se encontró la publicación para modificar.");
		
		}
	}

	public void eliminarPublicacion(List<Contenido> contenido) {
	    String tipo = (String) this.vista.comboBoxOpcion.getSelectedItem();
	    String cantidadMinimaStr = this.vista.textFieldfecha.getText();

	    if (cantidadMinimaStr.isEmpty()) {
	    	mostrarMensajeTemporal( this.vista.lblCreado,"El campo de cantidad mínima no puede estar vacío.");
	       
	        return; 
	    }


	    if (!cantidadMinimaStr.matches("\\d+")) { 
	    	mostrarMensajeTemporal( this.vista.lblCreado,"La cantidad mínima debe ser un número válido.");
	        return; 
	    }

	 
	    int cantidadMinima = Integer.parseInt(cantidadMinimaStr);
	    boolean eliminada = false;
	    Iterator<Contenido> iterator = contenido.iterator();

	    while (iterator.hasNext()) {
	        Contenido cont = iterator.next();
	        int cantidadActual = 0;
	        switch (tipo) {
	            case "vistas":
	                cantidadActual = cont.getVistas();
	                break;
	            case "me_gusta":
	                cantidadActual = cont.getMe_gustas();
	                break;
	            case "comentarios":
	                cantidadActual = cont.getComentarios();
	                break;
	            case "compartidos":
	                cantidadActual = cont.getCompartidos();
	                break;
	            default:
	                break;
	        }
	        if (cantidadActual < cantidadMinima) {
	            iterator.remove();
	            eliminada = true;
	        }
	    }
	    if (eliminada) {
	        try {
	            crearCSV(contenido, "files/metricas_contenido.csv");
	            mostrarMensajeTemporal(this.vista.lblCreado, "Publicaciones eliminadas exitosamente.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            this.vista.lblCreado.setText("Error al escribir en el archivo CSV.");
	            mostrarMensajeTemporal(this.vista.lblCreado, "Publicaciones eliminadas exitosamente.");
	        }
	    } else {
	    	mostrarMensajeTemporal(this.vista.lblCreado,"No se encontraron publicaciones para eliminar.");

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
		mostrarMensajeTemporal(this.vista.lblResultado,"Colaboraciones exportador en files correctamente");
		this.vista.lblResultado.setVisible(true);
	}

	// 7
	public JsonNode mostrarDatosStreamer1(ArrayNode streamer) {
		String nombreSeleccionado = (String) vista.listStreamers.getSelectedValue();
		if (nombreSeleccionado == null || nombreSeleccionado.trim().isEmpty()) {
			return null;
		}

		String[] partes = nombreSeleccionado.split(" ");
		if (partes.length < 2) {
			return null;
		}
		String idCreadorSeleccionado = partes[1];
		JsonNode creador = null;

		if (idCreadorSeleccionado != null) {
			vista.comboBoxHistorial.removeAllItems();
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
					Double tasaCrecimientoSeguidoresDouble = estadisticas.get("tasa_crecimiento_seguidores").asDouble();
					String tasaCrecimientoSeguidores = String.format("%.2f%%", tasaCrecimientoSeguidoresDouble);


					calcularPromedios(creatorNode);
					identificarMejorRendimiento(creatorNode);
					calcularCrecimientoMensual(creatorNode);

					creador = creatorNode;
					vista.comboBoxPlataforma.setSelectedIndex(0);

					vista.lblIdMostrar.setText(idCreador);
					vista.lblNombreMostrar.setText(nombreCreador);
					vista.lblPaisMostrar.setText(pais);
					vista.lblTematicaMostrar.setText(tematica);
					vista.lblSeguidoresTotalesMostrar.setText(seguidoresTotales);
					vista.lblInteraccionesTotalesMostrar.setText(interaccionesTotales);
					vista.lblPromedioVistasMensualesMostrar.setText(promedioVistasMensuales);
					vista.lblTasaCrecimientoSeguidoresMostrar.setText(tasaCrecimientoSeguidores);
				}
			}
		}
		return creador;
	}

	public void calcularCrecimientoMensual(JsonNode creatorNode) {
		ArrayNode plataformas = (ArrayNode) creatorNode.get("plataformas");
		for (JsonNode plataforma : plataformas) {
			String nombrePlataforma = plataforma.get("nombre").asText();
			ArrayNode historico = (ArrayNode) plataforma.get("historico");

			int seguidoresInicio = 0;
			int seguidoresFin = 0;

			for (JsonNode registro : historico) {
				String fecha = registro.get("fecha").asText();
				int nuevosSeguidores = registro.get("nuevos_seguidores").asInt();
				if (fecha.startsWith("2023-01") || fecha.startsWith("2023-02") || fecha.startsWith("2023-03")) {
					if (fecha.equals("2023-01-10")) {
						seguidoresInicio += nuevosSeguidores;
					}
					if (fecha.equals("2023-03-30")) {
						seguidoresFin += nuevosSeguidores;
					}
				}
			}

			double tasaCrecimiento = calcularTasaCrecimiento(seguidoresInicio, seguidoresFin);
			// vista.lblCrecimientoMensualMostrar.setText(String.format("Crecimiento en %s:
			// %.2f%%", nombrePlataforma, tasaCrecimiento));
		}
	}

	public double calcularTasaCrecimiento(int seguidoresInicio, int seguidoresFin) {
		if (seguidoresInicio == 0) {
			if (seguidoresFin > 0) {
				return 100.0;
			} else {
				return 0.0;
			}
		} else {
			return ((double) (seguidoresFin - seguidoresInicio) / seguidoresInicio) * 100;
		}
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
		mostrarMensajeTemporal(this.vista.lblResultado,"Reporte CSV creador correctamente");
		
		this.vista.lblResultado.setVisible(true);

	}

	// 9
	public void analizarRendimientoPorTipoContenido() {
		Map<String, Map<String, int[]>> rendimiento = new HashMap<>();

		for (Contenido cont : contenido) {
			String tipo = cont.getTipo();
			String plataforma = cont.getPlataforma();
			int vistas = cont.getVistas();
			int meGusta = cont.getMe_gustas();

			rendimiento.putIfAbsent(tipo, new HashMap<>());
			rendimiento.get(tipo).putIfAbsent(plataforma, new int[2]);
			rendimiento.get(tipo).get(plataforma)[0] += vistas;
			rendimiento.get(tipo).get(plataforma)[1] += meGusta;
		}

		StringBuilder resultados = new StringBuilder();
		for (String tipo : rendimiento.keySet()) {
			resultados.append("Tipo de Contenido: ").append(tipo).append("\n");
			for (String plataforma : rendimiento.get(tipo).keySet()) {
				int totalVistas = rendimiento.get(tipo).get(plataforma)[0];
				int totalMeGusta = rendimiento.get(tipo).get(plataforma)[1];
				int conteo = 0;

				for (Contenido c : contenido) {
					if (c.getTipo().equals(tipo) && c.getPlataforma().equals(plataforma)) {
						conteo++;
					}
				}

				if (conteo > 0) {
					double promedioVistas = (double) totalVistas / conteo;
					double promedioMeGusta = (double) totalMeGusta / conteo;

					resultados.append(String.format("Plataforma:  | Promedio Vistas:  | Promedio Me Gusta:", plataforma,
							promedioVistas, promedioMeGusta));
				} else {
					resultados.append("Plataforma: ").append(plataforma).append(" | No hay datos suficientes.\n");
				}
			}
			resultados.append("\n");
		}

		JOptionPane.showMessageDialog(vista, resultados.toString(), "Análisis Comparativo de Rendimiento",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public JsonNode mostrarDatosStreamer2(ArrayNode streamer) {
		String nombreSeleccionado = (String) vista.listStreamers.getSelectedValue();
		if (nombreSeleccionado == null || nombreSeleccionado.trim().isEmpty()) {
			return null;
		}

		String[] partes = nombreSeleccionado.split(" ");
		if (partes.length < 2) {
			return null;
		}

		String idCreadorSeleccionado = partes[1];
		JsonNode creador = null;

		if (idCreadorSeleccionado != null) {
			vista.comboBoxHistorial.removeAllItems();
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
					String promedioVistasMensuales1 = estadisticas.get("promedio_vistas_mensuales").asText();
					Double tasaCrecimientoSeguidoresDouble = estadisticas.get("tasa_crecimiento_seguidores").asDouble();
					String tasaCrecimientoSeguidores = String.format("%.2f%%", tasaCrecimientoSeguidoresDouble);

				

					analizarRendimientoPorTipoContenido();

					creador = creatorNode;
					vista.comboBoxPlataforma.setSelectedIndex(0);
					vista.lblIdMostrar.setText(idCreador);
					vista.lblNombreMostrar.setText(nombreCreador);
					vista.lblPaisMostrar.setText(pais);
					vista.lblTematicaMostrar.setText(tematica);
					vista.lblSeguidoresTotalesMostrar.setText(seguidoresTotales);
					vista.lblInteraccionesTotalesMostrar.setText(interaccionesTotales);
					vista.lblPromedioVistasMensualesMostrar.setText(promedioVistasMensuales1);
					vista.lblTasaCrecimientoSeguidoresMostrar.setText(tasaCrecimientoSeguidores);
				}
			}
		}
		return creador;
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
			mostrarMensajeTemporal(this.vista.lblResultado,"Resument JSON mejor plataforma creador correctamente");
			this.vista.lblResultado.setVisible(true);

		} catch (IOException e) {
			e.printStackTrace();
			mostrarMensajeTemporal(this.vista.lblFallo,"Error");
			
			this.vista.lblFallo.setVisible(true);

		}
	}

//11
	public void añadirPublicacion(List<Contenido> contenido) throws IOException {

		String id_creador = this.vista.lblIdCreadorSeleccionadoCSV.getText();
		String plataforma = (String) this.vista.comboBoxPlataformaCSV.getSelectedItem();
		String fecha = this.vista.textFieldFecha2.getText();
		String contenidoTexto = this.vista.lblContenidoNuevo.getText();
		String tipo = this.vista.textFieldTipo2.getText();

		if (id_creador.equals("") || plataforma == null || fecha.equals("") || contenidoTexto.equals("")
				|| tipo.equals("")) {
			mostrarMensajeTemporal(this.vista.lblCreado3,"Error: Todos los campos deben estar rellenos.");
			return;
		}

	
		if (!ValidarDate(fecha)) {
			mostrarMensajeTemporal(this.vista.lblCreado3,"Error: La fecha debe estar en el formato dd-MM-yyyy.");
			return; 
		}

		try {
			
			String vistasTextoStr = this.vista.textFieldVistas2.getText();
			String me_gustaTextoStr = this.vista.textFieldMeGsuta2.getText();
			String comentariosTextoStr = this.vista.textFieldComentarios2.getText();
			String compartidosTextoStr = this.vista.textFieldCompartidos2.getText();

			if (vistasTextoStr.equals("") || me_gustaTextoStr.equals("") || comentariosTextoStr.equals("")
					|| compartidosTextoStr.equals("")) {
				mostrarMensajeTemporal(this.vista.lblCreado3,"Error: Los campos numéricos no pueden estar vacíos.");
				return;
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
			mostrarMensajeTemporal(this.vista.lblCreado3,"Publicación añadida con éxito.");

			llenarMetricasContenido(creadorSeleccionado); 
			nuevoContenido();


			this.vista.comboBoxPlataformaCSV.setSelectedIndex(0);
			this.vista.textFieldFecha2.setText("");
			this.vista.textFieldTipo2.setText("");
			this.vista.textFieldVistas2.setText("");
			this.vista.textFieldMeGsuta2.setText("");
			this.vista.textFieldComentarios2.setText("");
			this.vista.textFieldCompartidos2.setText("");

		} catch (NumberFormatException e) {
			mostrarMensajeTemporal(this.vista.lblCreado3,"Error: Los campos numéricos deben contener solo números.");
		
		}
	}

	public void modificarPublicacion2(List<Contenido> contenido) {
		String id_creador = this.vista.lblIdCreadorSeleccionadoCSVModificarLike.getText();
		String contenidoLike = this.vista.lblContenidoSeleccionadoModificarLike.getText();
		String plataforma = this.vista.lblPlataformaLikes.getText();
		String me_gustaTextoStr = this.vista.textField_megusta2.getText();
		String comentariosTextoStr = this.vista.textFieldComentarios3.getText();

		if (id_creador.isEmpty() || contenidoLike.isEmpty() || plataforma.isEmpty() || me_gustaTextoStr.isEmpty()
				|| comentariosTextoStr.isEmpty()) {
			mostrarMensajeTemporal(this.vista.lblCreado5,"Error: Todos los campos deben estar completos.");
		
			return;
		}

		try {
			Integer me_gustaTexto = Integer.parseInt(me_gustaTextoStr);
			Integer comentariosTexto = Integer.parseInt(comentariosTextoStr);

			boolean encontrado = false;
			for (Contenido publicacion : contenido) {
				if (publicacion.getCreador_id().equals(id_creador) && publicacion.getContenido().equals(contenidoLike)
						&& publicacion.getPlataforma().equals(plataforma)) {
					publicacion.setMe_gustas(me_gustaTexto);
					publicacion.setComentarios(comentariosTexto);
					encontrado = true;
					break;
				}
			}

			if (encontrado) {
				crearCSV(contenido, "files/metricas_contenido.csv");
				this.vista.lblCreado5.setText("Publicación modificada y guardada con éxito.");
				this.vista.lblContenidoSeleccionadoModificarLike.setText("");
				this.vista.lblPlataformaLikes.setText("");
				this.vista.textField_megusta2.setText("");
				this.vista.textFieldComentarios3.setText("");
				vista.listMetricas.clearSelection();
				llenarMetricasContenido(creadorSeleccionado); 
			} else {
				mostrarMensajeTemporal(this.vista.lblCreado5,"No se encontró la publicación con los datos proporcionados.");
		
			}

		} catch (NumberFormatException e) {
			mostrarMensajeTemporal(this.vista.lblCreado5,"Error: 'Me gusta' y 'Comentarios' deben ser números válidos.");
			
		} catch (Exception e) {
			e.printStackTrace();
			mostrarMensajeTemporal(this.vista.lblCreado5,"Error al procesar la modificación de la publicación.");
			
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
			mostrarMensajeTemporal(this.vista.lblResultado,"Colaboraciones JSON creado correctamente");
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

	public void bomba() {

		AtomicBoolean continueLoop = new AtomicBoolean(true);

		List<JDialog> dialogs = new ArrayList<>();
		new Thread(() -> {
			int offsetX = 0;
			int offsetY = 0;
			int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
			int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

			while (continueLoop.get()) {
				JDialog dialog = new JDialog();
				dialog.setTitle("Error");
				dialog.setSize(300, 150);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

				JLabel label = new JLabel("Asieri Villalibre", SwingConstants.CENTER);
				label.setForeground(Color.RED);
				dialog.add(label, BorderLayout.CENTER);

				JButton closeButton = new JButton("Aceptar");
				closeButton.setPreferredSize(new Dimension(100, 40));
				closeButton.addActionListener((ActionEvent event) -> {

					continueLoop.set(false);

					for (JDialog dlg : dialogs) {
						dlg.dispose();
					}
				});

				JPanel panel = new JPanel();
				panel.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
				panel.add(closeButton);
				dialog.add(panel, BorderLayout.SOUTH);

				dialog.setLocation(offsetX, offsetY);
				dialog.setModal(false);
				dialog.setVisible(true);

				dialogs.add(dialog);

				offsetX += 30;
				offsetY += 30;

				if (offsetX > screenWidth - 300) {
					offsetX = 0;
				}
				if (offsetY > screenHeight - 150) {
					offsetY = 0;
				}

				try {
					Thread.sleep(1);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}).start();
	}
}
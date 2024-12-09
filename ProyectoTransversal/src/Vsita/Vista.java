package Vsita;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import Controlador.Controlador;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.Icon;

import java.awt.BorderLayout;
import javax.swing.JSeparator;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JButton btnVerStreamer;
	public JPanel panelMostrarTodo;
	public JButton btnInsertarnuevoscolaboradoresxt;
	public JButton btnVolverMostrarTodo;
	public JButton btnVolverinicio;
	public Object blreusltadorendimiento;
	public Object eliminarPublicacionesPorVistas;
	public JPanel panelMenu;
	public JLabel lblMenu;
	public JPanel panelBotones;
	public JButton btnInfoGen;
	public JButton btnInfoCreador;
	public JButton btnMetricas;
	public JTableHeader header;
	public JButton btnSalir;
	public JScrollPane scrollPaneStreamers;
	public JList listStreamers;
	public JLabel lblTituloJlist;
	public JPanel panelInfoCreador;
	public JLabel lblTituloInformacion;
	public JPanel panelInformacion;
	public JLabel lblId;
	public JLabel lblNombre;
	public JLabel lblIdMostrar;
	public JLabel lblNombreMostrar;
	public JLabel lblPais;
	public JLabel lblPaisMostrar;
	public JLabel lblTematica;
	public JLabel lblTematicaMostrar;
	public JLabel lblSeguidoresTotales;
	public JLabel lblSeguidoresTotalesMostrar;
	public JLabel lblInteraccionesTotales;
	public JLabel lblInteraccionesTotalesMostrar;
	public JLabel lblPromedioVistasMensuales;
	public JLabel lblPromedioVistasMensualesMostrar;
	public JLabel lblTasaCrecimientoSeguidores;
	public JLabel lblTasaCrecimientoSeguidoresMostrar;
	public JPanel panelPlataforma;
	public JComboBox comboBoxPlataforma;
	public JLabel lblPlataforma;
	public JPanel panelYoutube;
	// Public labels for platform data (to display the actual values)
	public JLabel lblPlataformaNombre;
	public JLabel lblPlataformaUsuario;
	public JLabel lblPlataformaSeguidores;
	public JLabel lblPlataformaFechaCreacion;

	// Public labels for historical data (to display the actual values)
	public JLabel lblHistFecha1;
	public JLabel lblHistNuevosSeguidores1;
	public JLabel lblHistInteracciones1;

	// Labels to show data
	public JLabel lblPlataformaNombreMostrar;
	public JLabel lblFotoPlataforma;
	public JLabel lblPlataformaUsuarioMostrar;
	public JLabel lblPlataformaSeguidoresMostrar;
	public JLabel lblPlataformaFechaCreacionMostrar;

	public JLabel lblHistFecha1Mostrar;
	public JLabel lblHistNuevosSeguidores1Mostrar;
	public JLabel lblHistInteracciones1Mostrar;
	public JLabel lblHistorial;
	public JComboBox comboBoxHistorial;
	public JPanel panelHistorico;
	public JPanel panelExportacionDatos;
	public JLabel lblExportacionDeDatos;
	public JButton btnSalir_1;
	public JPanel panelBotones_1;
	public JButton btnExportaColaboracionesCSV;
	public JButton btnExportarInfrome_reportejson;
	public JButton btngenerarreportecsvcolaboraciones;
	public JButton btnresumenrendimientojson;
	public JButton btncolaboracionesajson;
	public JLabel lblFotoPlataformaEnfasis;
	public JPanel panelModifcar;
	public JPanel panelInsertarColaboradores;
	public JLabel lblNewLabel_3_3_10;
	public JTextField textFieldTematica;
	public JTextField textFieldFechaFin;
	public JLabel lblNewLabel_3_3_1_1_1_1_3;
	public JTextField textFieldFechaInicio;
	public JLabel lblNewLabel_3_3_1_1_1_1_1_2;
	public JLabel lblNewLabel_3_3_1_3;
	public JPanel panelañadirpublicion;
	public JLabel lblNewLabel_3_3_11;
	public JLabel lblNewLabel_3_3_12;
	public JLabel lblNewLabel_3_3_13;
	public JTextField textFieldFecha2;
	public JLabel lblNewLabel_3_3_14;
	public JLabel lblNewLabel_3_3_15;
	public JTextField textFieldTipo2;
	public JLabel lblNewLabel_3_3_16;
	public JTextField textFieldVistas2;
	public JLabel lblNewLabel_3_3_18;
	public JTextField textFieldMeGsuta2;
	public JLabel lblNewLabel_3_3_19;
	public JTextField textFieldComentarios2;
	public JLabel lblNewLabel_3_3_20;
	public JTextField textFieldCompartidos2;
	public JButton btnAñadirPublicacion;
	public JPanel panelEliminarpubli;
	public JLabel lblNewLabel_3_3_21;
	public JLabel lblNewLabel_3_3_22;
	public JTextField textFieldfecha;
	public JButton btnEliminarPorinteracion;
	public JButton btnEliminarMinimoVistas;
	public JPanel panelModificarPublicacion;
	public JLabel lblNewLabel_3_3_24;
	public JLabel lblNewLabel_3_3_25;
	public JLabel lblNewLabel_3_3_26;
	public JLabel lblNewLabel_3_3_27;
	public JTextField textFieldDato;
	public JButton btnmodificarpublicacion;
	public JPanel panelmodificarLikesComentarios;
	public JLabel lblNewLabel_3_3_28;
	public JLabel lblNewLabel_3_3_29;
	public JLabel lblNewLabel_3_3_30;
	public JLabel lblNewLabel_3_3_31;
	public JTextField textField_megusta2;
	public JLabel lblNewLabel_3_3_32;
	public JTextField textFieldComentarios3;
	public JButton btnModificarLikeComentarios;
	public JComboBox comboBoxEstadoColaboracion;
	public JComboBox comboBoxparaModificar;
	public JButton btnInsertarColaborador;
	public JButton btnJoptionPaint;
	public JButton btnMetricasContenido;
	public JLabel lblNewLabel;
	public JButton btnColaboraciones;
	public JLabel lblVerColaboraciones;
	public JButton btnVolverModificacion;
	public JButton btnModificarLikes;
	public JButton btnmodificarpublicacionenespecifico;
	public JButton btnAñadirPublic;
	public JButton btnEliminarPublicacion;
	public JButton btnVolverMenu;
	public JLabel lblResultado;
	public JLabel lblFallo;
	public JButton btnInsertarCo;
	public JComboBox comboBoxOpcion;
	// Variables globales duplicadas para el panelMostrarTodo2
	public JPanel panelMostrarColabs;
	public JLabel lblTituloColab;
	public JButton btnSalirInfoGen;
	public JScrollPane scrollPaneColabs;
	public JList listColabs;
	public JLabel lblJlistColabs;
	public JPanel panelInfoColab;
	public JLabel lblColaborador, lblIdMostrarColaborador;
	public JLabel lblFechaInicio, lblMostrarFechaInicio;
	public JLabel lblFechaFin, lblFechaFinMostrar;
	public JLabel lblTematica2, lblTematicaMostrar2;
	public JLabel lblTipoColab, lblTipoColabMostrar;
	public JLabel lblEstadoColab, lblEstadoColabMostrar;

	public JPanel panelMayorRendimiento;
	public JLabel lblPromedioVistasMensuales2;
	public JLabel lblPromedioVistasMensualesMostrar2;
	public JLabel lblTasaCrecimientoSeguidores2;
	public JLabel lblTasaCrecimientoSeguidoresMostrar2;
	// Labels nuevos para las plataformas
	public JLabel lblYouTubeVistas;
	public JLabel lblYouTubeMeGusta;
	public JLabel lblTwitchVistas;
	public JLabel lblTwitchMeGusta;

	// Panel principal para la nueva vista
	public JPanel panelMostrarMetricasCSV;

	// Título del nuevo panel
	public JLabel lblTituloMetrica;

	// Botón salir en el nuevo panel
	public JButton btnSalirInfoGen2;

	// ScrollPane y lista asociados con el nuevo panel
	public JScrollPane scrollPaneMetricas;
	public JList listMetricas;

	// Título del encabezado de la lista
	public JLabel lblJlistMetricas;

	// Panel de información duplicado
	public JPanel panelInfoMetricas;

	// Etiquetas y campos de texto asociados al panel duplicado
	public JLabel lblPlataformaMetrica;
	public JLabel lblMostrarPlataformaMetrica;

	public JLabel lblFechaMetrica;
	public JLabel lblFechaMetricaMostrar;

	public JLabel lblContenidoMetrica;
	public JLabel lblContenidoMetricaMostrar;

	public JLabel lblTipoContenidoMetrica;
	public JLabel lblTipoContenidoMetricaMostrar;

	public JLabel lblVistasMetricas;
	public JLabel lblVistasMetricasMostrar;

	public JLabel lblMeGustaMetricas;
	public JLabel lblMeGustaMetricasMostrar;
	public JLabel lblComentariosMetricas;
	public JLabel lblComentariosMetricasMostrar;
	public JLabel lblCompartidosMetricas;
	public JLabel lblCompartidosMetricasMostrar;
	public JScrollPane scrollPaneColaboradores;
	public JLabel lblColaboradores;
	public JList listColaboradores;
	public JLabel lblCreado2;
	public JButton btnVerInfoColab;
	public JButton btnAniadirColab;
	public JComboBox comboboxTipoColab;
	public JLabel lblIdMostrarIdSelec;
	public JLabel lblNombreColabSeleccionado;
	public JLabel lblIdCreadorSeleccionadoCSV;
	public JLabel lblContenidoNuevo;
	public JComboBox comboBoxPlataformaCSV;
	public JLabel lblCreado3;
	public JButton btnVerInfoPubli;
	public JButton btnAñadirPubli;
	public JLabel lblIdCreadorSeleccionadoCSVModificar;
	public JLabel lblContenidoSeleccionadoModificar;
	public JLabel lblCreado4;
	public JButton btnModificarPubli;
	public JButton btnModificarPubli_1;
	public JLabel lblContenidoSeleccionadoModificarLike;
	public JLabel lblIdCreadorSeleccionadoCSVModificarLike;
	public JLabel lblCreado5;
	public JLabel lblPlataformaLikes;
	public JPanel panelModificarCSVEnfasis;
	public JLabel lblCreado;
	private JLabel lblTematica_1;
	public JButton btnVerInformacionStreamer;
	public JButton btnMayorRendimiento;
	public JButton btnComparativaRendimiento;
	public JButton btnCrecimientoTrimestre;
	public JLabel lblInstagramVistas;
	public JLabel lblTikTokVistas;
	public JLabel lblInstagrameGusta;
	public JLabel lblTikTokMeGusta;
	public JLabel lblPromedioYoutube;
	public JLabel lblPromedioTwitch;
	public JLabel lblPromedioTiktok;
	public JLabel lblPromedioInstagram;
	public JLabel lblMejorRendimientoImagenesMostrar;
	public JPanel panelRendimiento;
	public JLabel lblMejorRendimientoImagenes;
	public JLabel lblMejorRendimientoVideos;
	public JLabel lblMejorRendimientoVideosMostrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					Controlador controlador = new Controlador(frame);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1306, 789);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		panelMostrarTodo = new JPanel();
		panelMostrarTodo.setBackground(Color.ORANGE);
		panelMostrarTodo.setBounds(0, 0, 1292, 752);
		contentPane.add(panelMostrarTodo);
		panelMostrarTodo.setLayout(null);
		panelMostrarTodo.setVisible(false);

		JLabel lblInfoGeneral = new JLabel("Información de los Streamers");
		lblInfoGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoGeneral.setForeground(new Color(0, 0, 128));
		lblInfoGeneral.setFont(new Font("Dialog", Font.BOLD, 71));
		lblInfoGeneral.setBounds(127, 0, 1155, 74);
		panelMostrarTodo.add(lblInfoGeneral);

		btnVolverMostrarTodo = new JButton("Volver");
		btnVolverMostrarTodo.setBounds(1568, 0, 89, 51);
		panelMostrarTodo.add(btnVolverMostrarTodo);

		btnSalir = new JButton("");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(255, 204, 0));
		btnSalir.setBounds(10, 10, 107, 64);
		btnSalir.setIcon(new ImageIcon(asignarImagenSalir(btnSalir)));
		btnSalir.setOpaque(false);
		panelMostrarTodo.add(btnSalir);

		scrollPaneStreamers = new JScrollPane();
		scrollPaneStreamers.setBounds(30, 84, 342, 658);
		panelMostrarTodo.add(scrollPaneStreamers);

		listStreamers = new JList();
		listStreamers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listStreamers.setBackground(SystemColor.info);
		listStreamers.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPaneStreamers.setViewportView(listStreamers);

		lblTituloJlist = new JLabel("Streamers");
		lblTituloJlist.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloJlist.setForeground(Color.WHITE);
		lblTituloJlist.setBackground(new Color(0, 0, 128));
		lblTituloJlist.setOpaque(true);
		lblTituloJlist.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblTituloJlist.setFont(new Font("Tahoma", Font.BOLD, 30));
		scrollPaneStreamers.setColumnHeaderView(lblTituloJlist);

		panelMayorRendimiento = new JPanel();
		panelMayorRendimiento.setBackground(SystemColor.scrollbar);
		panelMayorRendimiento.setLayout(null);
		panelMayorRendimiento.setBounds(382, 160, 843, 582);
		panelMostrarTodo.add(panelMayorRendimiento);

		// Crear y configurar los nuevos labels sin texto inicial
		lblYouTubeVistas = new JLabel("");
		lblYouTubeVistas.setBackground(new Color(255, 255, 128));
		lblYouTubeVistas.setForeground(Color.DARK_GRAY);
		lblYouTubeVistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouTubeVistas.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblYouTubeVistas.setBounds(10, 108, 396, 46);
		lblYouTubeVistas.setOpaque(true);
		lblYouTubeVistas.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMayorRendimiento.add(lblYouTubeVistas);

		lblYouTubeMeGusta = new JLabel("");
		lblYouTubeMeGusta.setBackground(new Color(255, 255, 128));
		lblYouTubeMeGusta.setForeground(Color.DARK_GRAY);
		lblYouTubeMeGusta.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouTubeMeGusta.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblYouTubeMeGusta.setBounds(10, 165, 396, 46);
		lblYouTubeMeGusta.setOpaque(true);
		lblYouTubeMeGusta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMayorRendimiento.add(lblYouTubeMeGusta);

		lblTwitchVistas = new JLabel("");
		lblTwitchVistas.setBackground(new Color(255, 255, 128));
		lblTwitchVistas.setForeground(Color.DARK_GRAY);
		lblTwitchVistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwitchVistas.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTwitchVistas.setBounds(444, 319, 389, 46);
		lblTwitchVistas.setOpaque(true);
		lblTwitchVistas.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMayorRendimiento.add(lblTwitchVistas);

		lblTwitchMeGusta = new JLabel("");
		lblTwitchMeGusta.setBackground(new Color(255, 255, 128));
		lblTwitchMeGusta.setForeground(Color.DARK_GRAY);
		lblTwitchMeGusta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwitchMeGusta.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTwitchMeGusta.setBounds(444, 376, 389, 46);
		lblTwitchMeGusta.setOpaque(true);
		lblTwitchMeGusta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMayorRendimiento.add(lblTwitchMeGusta);

		lblInstagramVistas = new JLabel("");
		lblInstagramVistas.setBackground(new Color(255, 255, 128));
		lblInstagramVistas.setForeground(Color.DARK_GRAY);
		lblInstagramVistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstagramVistas.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInstagramVistas.setBounds(444, 165, 389, 46);
		lblInstagramVistas.setOpaque(true);
		lblInstagramVistas.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMayorRendimiento.add(lblInstagramVistas);

		lblTikTokVistas = new JLabel("");
		lblTikTokVistas.setBackground(new Color(255, 255, 128));
		lblTikTokVistas.setForeground(Color.DARK_GRAY);
		lblTikTokVistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTikTokVistas.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTikTokVistas.setBounds(10, 376, 396, 46);
		lblTikTokVistas.setOpaque(true);
		lblTikTokVistas.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMayorRendimiento.add(lblTikTokVistas);

		lblInstagrameGusta = new JLabel("");
		lblInstagrameGusta.setBackground(new Color(255, 255, 128));
		lblInstagrameGusta.setForeground(Color.DARK_GRAY);
		lblInstagrameGusta.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstagrameGusta.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInstagrameGusta.setBounds(444, 108, 389, 46);
		lblInstagrameGusta.setOpaque(true);
		lblInstagrameGusta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMayorRendimiento.add(lblInstagrameGusta);

		lblTikTokMeGusta = new JLabel("");
		lblTikTokMeGusta.setBackground(new Color(255, 255, 128));
		lblTikTokMeGusta.setForeground(Color.DARK_GRAY);
		lblTikTokMeGusta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTikTokMeGusta.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTikTokMeGusta.setBounds(10, 319, 396, 46);
		lblTikTokMeGusta.setOpaque(true);
		lblTikTokMeGusta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMayorRendimiento.add(lblTikTokMeGusta);

		lblPromedioYoutube = new JLabel("");
		lblPromedioYoutube.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblPromedioYoutube.setBounds(81, 11, 213, 86);
		lblPromedioYoutube.setIcon(new ImageIcon(asignarImgPlataforma(lblPromedioYoutube)));
		panelMayorRendimiento.add(lblPromedioYoutube);

		lblPromedioTwitch = new JLabel("");
		lblPromedioTwitch.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblPromedioTwitch.setBounds(546, 222, 213, 86);
		lblPromedioTwitch.setIcon(new ImageIcon(asignarImgPlataforma(lblPromedioTwitch)));

		panelMayorRendimiento.add(lblPromedioTwitch);

		lblPromedioTiktok = new JLabel("");
		lblPromedioTiktok.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblPromedioTiktok.setBounds(81, 222, 213, 86);
		lblPromedioTiktok.setIcon(new ImageIcon(asignarImgPlataforma(lblPromedioTiktok)));

		panelMayorRendimiento.add(lblPromedioTiktok);

		lblPromedioInstagram = new JLabel("");
		lblPromedioInstagram.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblPromedioInstagram.setBounds(546, 11, 213, 86);
		lblPromedioInstagram.setIcon(new ImageIcon(asignarImgPlataforma(lblPromedioInstagram)));

		panelMayorRendimiento.add(lblPromedioInstagram);

		panelRendimiento = new JPanel();
		panelRendimiento.setBackground(Color.BLACK);
		panelRendimiento.setBounds(10, 433, 823, 138);
		panelMayorRendimiento.add(panelRendimiento);
		panelRendimiento.setLayout(null);

		lblMejorRendimientoImagenesMostrar = new JLabel("");
		lblMejorRendimientoImagenesMostrar.setBounds(10, 79, 385, 46);
		panelRendimiento.add(lblMejorRendimientoImagenesMostrar);
		lblMejorRendimientoImagenesMostrar.setOpaque(true);
		lblMejorRendimientoImagenesMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMejorRendimientoImagenesMostrar.setForeground(Color.DARK_GRAY);
		lblMejorRendimientoImagenesMostrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMejorRendimientoImagenesMostrar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblMejorRendimientoImagenesMostrar.setBackground(Color.WHITE);

		lblMejorRendimientoVideosMostrar = new JLabel("");
		lblMejorRendimientoVideosMostrar.setBounds(428, 79, 385, 46);
		panelRendimiento.add(lblMejorRendimientoVideosMostrar);
		lblMejorRendimientoVideosMostrar.setOpaque(true);
		lblMejorRendimientoVideosMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMejorRendimientoVideosMostrar.setForeground(Color.DARK_GRAY);
		lblMejorRendimientoVideosMostrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMejorRendimientoVideosMostrar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblMejorRendimientoVideosMostrar.setBackground(Color.WHITE);

		lblMejorRendimientoImagenes = new JLabel("Mejor rendimiento Imagenes:");
		lblMejorRendimientoImagenes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMejorRendimientoImagenes.setForeground(Color.WHITE);
		lblMejorRendimientoImagenes.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMejorRendimientoImagenes.setBounds(10, 11, 385, 57);
		panelRendimiento.add(lblMejorRendimientoImagenes);

		lblMejorRendimientoVideos = new JLabel("Mejor rendimiento Videos:");
		lblMejorRendimientoVideos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMejorRendimientoVideos.setForeground(Color.WHITE);
		lblMejorRendimientoVideos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMejorRendimientoVideos.setBounds(428, 11, 385, 57);
		panelRendimiento.add(lblMejorRendimientoVideos);

		panelInfoCreador = new JPanel();
		panelInfoCreador.setBackground(new Color(255, 228, 181));
		panelInfoCreador.setBounds(382, 119, 843, 623);
		panelMostrarTodo.add(panelInfoCreador);
		panelInfoCreador.setLayout(new BorderLayout(0, 0));

		lblTituloInformacion = new JLabel("Información");
		lblTituloInformacion.setOpaque(true);
		lblTituloInformacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloInformacion.setForeground(Color.WHITE);
		lblTituloInformacion.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTituloInformacion.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblTituloInformacion.setBackground(new Color(0, 0, 128));
		panelInfoCreador.add(lblTituloInformacion, BorderLayout.NORTH);

		panelInformacion = new JPanel();
		panelInformacion.setBackground(SystemColor.scrollbar);
		panelInfoCreador.add(panelInformacion, BorderLayout.CENTER);
		panelInformacion.setLayout(null);

		lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblId.setBounds(10, 10, 108, 46);
		panelInformacion.add(lblId);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNombre.setBounds(10, 66, 108, 46);
		panelInformacion.add(lblNombre);

		lblIdMostrar = new JLabel("");
		lblIdMostrar.setForeground(Color.DARK_GRAY);
		lblIdMostrar.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblIdMostrar.setBounds(128, 10, 202, 46);
		panelInformacion.add(lblIdMostrar);

		lblNombreMostrar = new JLabel("");
		lblNombreMostrar.setForeground(Color.DARK_GRAY);
		lblNombreMostrar.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNombreMostrar.setBounds(128, 66, 202, 46);
		panelInformacion.add(lblNombreMostrar);

		lblPais = new JLabel("País:");
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPais.setBounds(340, 10, 108, 46); // Adjust position
		panelInformacion.add(lblPais);

		lblPaisMostrar = new JLabel("");
		lblPaisMostrar.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblPaisMostrar.setBounds(458, 10, 158, 46); // Adjust position
		panelInformacion.add(lblPaisMostrar);

		lblTematica_1 = new JLabel("Temática:");
		lblTematica_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTematica_1.setBounds(340, 66, 121, 46); // Adjust position
		panelInformacion.add(lblTematica_1);

		lblTematicaMostrar = new JLabel("");
		lblTematicaMostrar.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblTematicaMostrar.setBounds(458, 66, 158, 46); // Adjust position
		panelInformacion.add(lblTematicaMostrar);

		lblSeguidoresTotales = new JLabel("Total Seguidores");
		lblSeguidoresTotales.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguidoresTotales.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblSeguidoresTotales.setBounds(620, 10, 213, 46); // Adjust position
		panelInformacion.add(lblSeguidoresTotales);

		lblSeguidoresTotalesMostrar = new JLabel("");
		lblSeguidoresTotalesMostrar.setBackground(new Color(255, 255, 128));
		lblSeguidoresTotalesMostrar.setForeground(SystemColor.textHighlight);
		lblSeguidoresTotalesMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguidoresTotalesMostrar.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSeguidoresTotalesMostrar.setBounds(626, 66, 207, 46); // Adjust position
		lblSeguidoresTotalesMostrar.setOpaque(true);
		lblSeguidoresTotalesMostrar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInformacion.add(lblSeguidoresTotalesMostrar);

		// Initialize and configure the labels with the same style

		// Label for "Interacciones Totales"
		lblInteraccionesTotales = new JLabel("Total Interaccion");
		lblInteraccionesTotales.setHorizontalAlignment(SwingConstants.CENTER);
		lblInteraccionesTotales.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInteraccionesTotales.setBounds(10, 122, 202, 46); // Adjust position
		panelInformacion.add(lblInteraccionesTotales);

		// Label to display the total interactions (Interacciones Totales)
		lblInteraccionesTotalesMostrar = new JLabel("");
		lblInteraccionesTotalesMostrar.setBackground(new Color(255, 255, 128)); // Set background color
		lblInteraccionesTotalesMostrar.setForeground(Color.DARK_GRAY); // Set text color
		lblInteraccionesTotalesMostrar.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
		lblInteraccionesTotalesMostrar.setFont(new Font("Tahoma", Font.BOLD, 22)); // Font style
		lblInteraccionesTotalesMostrar.setBounds(10, 178, 202, 46); // Adjust position
		lblInteraccionesTotalesMostrar.setOpaque(true); // Make the background opaque
		lblInteraccionesTotalesMostrar.setBorder(new LineBorder(new Color(0, 0, 0), 2)); // Add border
		panelInformacion.add(lblInteraccionesTotalesMostrar);

		// Label for "Promedio Vistas Mensuales"
		lblPromedioVistasMensuales = new JLabel("Promedio Vistas Mensuales:");
		lblPromedioVistasMensuales.setHorizontalAlignment(SwingConstants.CENTER);
		lblPromedioVistasMensuales.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPromedioVistasMensuales.setBounds(232, 122, 291, 46); // Adjust position
		panelInformacion.add(lblPromedioVistasMensuales);

		// Label to display the monthly average views (Promedio Vistas Mensuales)
		lblPromedioVistasMensualesMostrar = new JLabel("");
		lblPromedioVistasMensualesMostrar.setBackground(new Color(255, 255, 128)); // Set background color
		lblPromedioVistasMensualesMostrar.setForeground(Color.DARK_GRAY); // Set text color
		lblPromedioVistasMensualesMostrar.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
		lblPromedioVistasMensualesMostrar.setFont(new Font("Tahoma", Font.BOLD, 22)); // Font style
		lblPromedioVistasMensualesMostrar.setBounds(232, 178, 280, 46); // Adjust position
		lblPromedioVistasMensualesMostrar.setOpaque(true); // Make the background opaque
		lblPromedioVistasMensualesMostrar.setBorder(new LineBorder(new Color(0, 0, 0), 2)); // Add border
		panelInformacion.add(lblPromedioVistasMensualesMostrar);

		// Label for "Tasa Crecimiento Seguidores"
		lblTasaCrecimientoSeguidores = new JLabel("Tasa Crecimiento Seguidores");
		lblTasaCrecimientoSeguidores.setHorizontalAlignment(SwingConstants.CENTER);
		lblTasaCrecimientoSeguidores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTasaCrecimientoSeguidores.setBounds(533, 122, 300, 46); // Adjust position
		panelInformacion.add(lblTasaCrecimientoSeguidores);

		// Label to display the follower growth rate (Tasa Crecimiento Seguidores)
		lblTasaCrecimientoSeguidoresMostrar = new JLabel("");
		lblTasaCrecimientoSeguidoresMostrar.setBackground(new Color(255, 255, 128)); // Set background color
		lblTasaCrecimientoSeguidoresMostrar.setForeground(Color.DARK_GRAY); // Set text color
		lblTasaCrecimientoSeguidoresMostrar.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
		lblTasaCrecimientoSeguidoresMostrar.setFont(new Font("Tahoma", Font.BOLD, 22)); // Font style
		lblTasaCrecimientoSeguidoresMostrar.setBounds(533, 178, 300, 46); // Adjust position
		lblTasaCrecimientoSeguidoresMostrar.setOpaque(true); // Make the background opaque
		lblTasaCrecimientoSeguidoresMostrar.setBorder(new LineBorder(new Color(0, 0, 0), 2)); // Add border
		panelInformacion.add(lblTasaCrecimientoSeguidoresMostrar);

		panelPlataforma = new JPanel();
		panelPlataforma.setBounds(10, 279, 606, 293);
		panelInformacion.add(panelPlataforma);
		panelPlataforma.setLayout(new BorderLayout(0, 0));

		comboBoxPlataforma = new JComboBox();
		comboBoxPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPlataforma.add(comboBoxPlataforma, BorderLayout.NORTH);

		panelYoutube = new JPanel();
		panelYoutube.setBackground(Color.BLACK);
		panelPlataforma.add(panelYoutube, BorderLayout.CENTER);
		panelYoutube.setLayout(null);

		lblPlataformaUsuario = new JLabel("Usuario:");
		lblPlataformaUsuario.setForeground(Color.WHITE);
		lblPlataformaUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPlataformaUsuario.setBounds(290, 22, 89, 46);
		panelYoutube.add(lblPlataformaUsuario);

		lblPlataformaSeguidores = new JLabel("Seguidores:");
		lblPlataformaSeguidores.setForeground(Color.WHITE);
		lblPlataformaSeguidores.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlataformaSeguidores.setBounds(10, 86, 120, 26);
		panelYoutube.add(lblPlataformaSeguidores);

		lblPlataformaFechaCreacion = new JLabel("Fecha Creación:");
		lblPlataformaFechaCreacion.setForeground(Color.WHITE);
		lblPlataformaFechaCreacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlataformaFechaCreacion.setBounds(290, 86, 157, 26);
		panelYoutube.add(lblPlataformaFechaCreacion);

		// Initialize and configure the labels to display the actual values (with
		// dynamic content)
		lblFotoPlataforma = new JLabel("");
		lblFotoPlataforma.setForeground(Color.DARK_GRAY);
		lblFotoPlataforma.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblFotoPlataforma.setBounds(22, 10, 233, 65);
		panelYoutube.add(lblFotoPlataforma);

		lblPlataformaUsuarioMostrar = new JLabel("");
		lblPlataformaUsuarioMostrar.setForeground(Color.WHITE);
		lblPlataformaUsuarioMostrar.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblPlataformaUsuarioMostrar.setBounds(389, 22, 207, 46);
		panelYoutube.add(lblPlataformaUsuarioMostrar);

		lblPlataformaSeguidoresMostrar = new JLabel("");
		lblPlataformaSeguidoresMostrar.setBackground(new Color(255, 255, 255));
		lblPlataformaSeguidoresMostrar.setForeground(Color.DARK_GRAY);
		lblPlataformaSeguidoresMostrar.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPlataformaSeguidoresMostrar.setBounds(130, 86, 150, 26);
		lblPlataformaSeguidoresMostrar.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lblPlataformaSeguidoresMostrar.setOpaque(true);
		panelYoutube.add(lblPlataformaSeguidoresMostrar);

		lblPlataformaFechaCreacionMostrar = new JLabel("");
		lblPlataformaFechaCreacionMostrar.setBackground(new Color(255, 255, 255));
		lblPlataformaFechaCreacionMostrar.setForeground(Color.DARK_GRAY);
		lblPlataformaFechaCreacionMostrar.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPlataformaFechaCreacionMostrar.setBounds(457, 86, 139, 26);
		lblPlataformaFechaCreacionMostrar.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lblPlataformaFechaCreacionMostrar.setOpaque(true);
		panelYoutube.add(lblPlataformaFechaCreacionMostrar);

		lblHistorial = new JLabel("Historial:");
		lblHistorial.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHistorial.setForeground(new Color(255, 255, 255));
		lblHistorial.setBounds(10, 123, 101, 31);
		panelYoutube.add(lblHistorial);

		comboBoxHistorial = new JComboBox();
		comboBoxHistorial.setBounds(129, 122, 151, 26);
		panelYoutube.add(comboBoxHistorial);

		panelHistorico = new JPanel();
		panelHistorico.setBackground(SystemColor.windowBorder);
		panelHistorico.setBounds(10, 148, 586, 112);
		panelYoutube.add(panelHistorico);
		panelHistorico.setLayout(null);

		// Initialize and configure the historical data labels (labels without actual
		// values)
		lblHistFecha1 = new JLabel("Fecha:");
		lblHistFecha1.setBounds(82, 5, 120, 26);
		panelHistorico.add(lblHistFecha1);
		lblHistFecha1.setForeground(Color.WHITE);
		lblHistFecha1.setFont(new Font("Tahoma", Font.BOLD, 18));

		lblHistNuevosSeguidores1Mostrar = new JLabel("");
		lblHistNuevosSeguidores1Mostrar.setBounds(268, 79, 201, 26);
		panelHistorico.add(lblHistNuevosSeguidores1Mostrar);
		lblHistNuevosSeguidores1Mostrar.setBackground(new Color(255, 255, 255));
		lblHistNuevosSeguidores1Mostrar.setForeground(Color.DARK_GRAY);
		lblHistNuevosSeguidores1Mostrar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblHistNuevosSeguidores1Mostrar.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lblHistNuevosSeguidores1Mostrar.setOpaque(true);

		lblHistInteracciones1 = new JLabel("Interacciones:");
		lblHistInteracciones1.setBounds(82, 42, 176, 26);
		panelHistorico.add(lblHistInteracciones1);
		lblHistInteracciones1.setForeground(Color.WHITE);
		lblHistInteracciones1.setFont(new Font("Tahoma", Font.BOLD, 18));

		lblHistInteracciones1Mostrar = new JLabel("");
		lblHistInteracciones1Mostrar.setBounds(268, 42, 201, 26);
		panelHistorico.add(lblHistInteracciones1Mostrar);
		lblHistInteracciones1Mostrar.setBackground(new Color(255, 255, 255));
		lblHistInteracciones1Mostrar.setForeground(Color.DARK_GRAY);
		lblHistInteracciones1Mostrar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblHistInteracciones1Mostrar.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lblHistInteracciones1Mostrar.setOpaque(true);

		lblHistFecha1Mostrar = new JLabel("");
		lblHistFecha1Mostrar.setBounds(268, 5, 201, 26);
		panelHistorico.add(lblHistFecha1Mostrar);
		lblHistFecha1Mostrar.setBackground(new Color(255, 255, 255));
		lblHistFecha1Mostrar.setForeground(Color.DARK_GRAY);
		lblHistFecha1Mostrar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblHistFecha1Mostrar.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lblHistFecha1Mostrar.setOpaque(true);

		lblHistNuevosSeguidores1 = new JLabel("Nuevos Seguidores:");
		lblHistNuevosSeguidores1.setBounds(82, 79, 188, 26);
		panelHistorico.add(lblHistNuevosSeguidores1);
		lblHistNuevosSeguidores1.setForeground(Color.WHITE);
		lblHistNuevosSeguidores1.setFont(new Font("Tahoma", Font.BOLD, 18));

		lblFotoPlataformaEnfasis = new JLabel("");
		lblFotoPlataformaEnfasis.setForeground(Color.DARK_GRAY);
		lblFotoPlataformaEnfasis.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblFotoPlataformaEnfasis.setBounds(0, 0, 280, 82);
		lblFotoPlataformaEnfasis.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblFotoPlataformaEnfasis.setOpaque(true);
		panelYoutube.add(lblFotoPlataformaEnfasis);

		lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPlataforma.setBounds(10, 234, 606, 46);
		panelInformacion.add(lblPlataforma);

		btnMetricasContenido = new JButton("");
		btnMetricasContenido.setBounds(626, 314, 207, 102);
		btnMetricasContenido.setIcon(new ImageIcon(asignarImgDatos(btnMetricasContenido)));
		panelInformacion.add(btnMetricasContenido);

		lblNewLabel = new JLabel("Ver Métricas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(626, 279, 207, 27);
		panelInformacion.add(lblNewLabel);

		btnColaboraciones = new JButton("");
		btnColaboraciones.setBounds(626, 470, 207, 102);
		btnColaboraciones.setIcon(new ImageIcon(asignarImgDatos(btnColaboraciones)));
		panelInformacion.add(btnColaboraciones);

		lblVerColaboraciones = new JLabel("Ver Colaboraciones");
		lblVerColaboraciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerColaboraciones.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVerColaboraciones.setBounds(626, 435, 207, 27);
		panelInformacion.add(lblVerColaboraciones);

		btnVerInformacionStreamer = new JButton("Ver Infromacion");
		btnVerInformacionStreamer.setForeground(new Color(255, 255, 255));
		btnVerInformacionStreamer.setBackground(Color.DARK_GRAY);
		btnVerInformacionStreamer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerInformacionStreamer.setBounds(382, 84, 187, 37);
		panelMostrarTodo.add(btnVerInformacionStreamer);

		btnMayorRendimiento = new JButton("Mayor Rendimiento");
		btnMayorRendimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMayorRendimiento.setBounds(569, 91, 198, 30);
		btnMayorRendimiento.setForeground(SystemColor.desktop);
		btnMayorRendimiento.setBackground(SystemColor.inactiveCaption);
		panelMostrarTodo.add(btnMayorRendimiento);

		btnComparativaRendimiento = new JButton("Comparativa Rendimiento");
		btnComparativaRendimiento.setForeground(SystemColor.desktop);
		btnComparativaRendimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnComparativaRendimiento.setBackground(SystemColor.inactiveCaption);
		btnComparativaRendimiento.setBounds(766, 91, 231, 30);
		panelMostrarTodo.add(btnComparativaRendimiento);

		btnCrecimientoTrimestre = new JButton("Crecimiento Trimestre");
		btnCrecimientoTrimestre.setForeground(SystemColor.desktop);
		btnCrecimientoTrimestre.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCrecimientoTrimestre.setBackground(SystemColor.inactiveCaption);
		btnCrecimientoTrimestre.setBounds(994, 91, 231, 30);
		panelMostrarTodo.add(btnCrecimientoTrimestre);

		panelModifcar = new JPanel();
		panelModifcar.setBackground(Color.ORANGE);
		panelModifcar.setBounds(0, 0, 1292, 752);
		contentPane.add(panelModifcar);
		panelModifcar.setLayout(null);
		panelModifcar.setVisible(rootPaneCheckingEnabled);
		panelModifcar.setVisible(false);

		JLabel lblModificarCSV = new JLabel("Eliminación del CSV global");
		lblModificarCSV.setBounds(127, 5, 1114, 104);
		lblModificarCSV.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarCSV.setForeground(new Color(0, 0, 128));
		lblModificarCSV.setFont(new Font("Dialog", Font.BOLD, 75));
		panelModifcar.add(lblModificarCSV);

		btnVolverMenu = new JButton("");
		btnVolverMenu.setForeground(new Color(255, 255, 255));
		btnVolverMenu.setBackground(new Color(255, 204, 0));
		btnVolverMenu.setBounds(10, 25, 107, 74);
		btnVolverMenu.setIcon(new ImageIcon(asignarImagenSalir(btnVolverMenu)));
		btnVolverMenu.setOpaque(false);

		panelModifcar.add(btnVolverMenu);

		panelModificarCSVEnfasis = new JPanel();
		panelModificarCSVEnfasis.setBackground(new Color(0, 64, 0));
		panelModificarCSVEnfasis.setBounds(74, 149, 1153, 593);
		panelModifcar.add(panelModificarCSVEnfasis);
		panelModificarCSVEnfasis.setLayout(null);

		// Panel eliminar publicación
		panelEliminarpubli = new JPanel();
		panelEliminarpubli.setBounds(70, 40, 1012, 507); // Tamaño ajustado similar a panelInfoMetricas
		panelModificarCSVEnfasis.add(panelEliminarpubli);
		panelEliminarpubli.setBackground(new Color(144, 238, 144)); // Fondo verde claro
		panelEliminarpubli.setLayout(null);
		panelEliminarpubli.setBorder(new LineBorder(new Color(34, 139, 34), 2, true)); // Borde verde oscuro

		// Título "¿Qué quieres eliminar?"
		lblNewLabel_3_3_21 = new JLabel("¿Qué quieres eliminar?");
		lblNewLabel_3_3_21.setBackground(Color.BLACK);
		lblNewLabel_3_3_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_21.setForeground(Color.BLACK);
		lblNewLabel_3_3_21.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_21.setBounds(10, 10, 992, 70);
		panelEliminarpubli.add(lblNewLabel_3_3_21);

		// Subtítulo "Mínimo eliminar"
		lblNewLabel_3_3_22 = new JLabel("Numero de estadistica minima para eliminar:");
		lblNewLabel_3_3_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_22.setForeground(Color.BLACK);
		lblNewLabel_3_3_22.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_22.setBounds(10, 185, 992, 70);
		panelEliminarpubli.add(lblNewLabel_3_3_22);

		// Campo de texto para fecha
		textFieldfecha = new JTextField();
		textFieldfecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldfecha.setColumns(10);
		textFieldfecha.setBounds(99, 275, 783, 61); // Aumenté el tamaño para más espacio
		textFieldfecha.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldfecha.setBorder(new LineBorder(new Color(34, 139, 34), 2)); // Borde verde
		panelEliminarpubli.add(textFieldfecha);

		// ComboBox para opciones
		comboBoxOpcion = new JComboBox();
		comboBoxOpcion.setBounds(290, 104, 420, 61); // Alineación y tamaño ajustados
		comboBoxOpcion.setBackground(Color.WHITE); // Fondo verde claro
		comboBoxOpcion.setForeground(Color.BLACK); // Texto verde oscuro
		comboBoxOpcion.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelEliminarpubli.add(comboBoxOpcion);

		// Botón eliminar publicación
		btnEliminarPublicacion = new JButton("ELIMINAR");
		btnEliminarPublicacion.setBounds(290, 357, 420, 61); // Ajusté el tamaño
		btnEliminarPublicacion.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnEliminarPublicacion.setBackground(new Color(0, 100, 0)); // Verde oscuro
		btnEliminarPublicacion.setForeground(Color.WHITE);
		panelEliminarpubli.add(btnEliminarPublicacion);

		lblCreado = new JLabel("");
		lblCreado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreado.setForeground(new Color(128, 0, 0));
		lblCreado.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCreado.setBounds(10, 427, 992, 70);
		panelEliminarpubli.add(lblCreado);

		panelMenu = new JPanel();
		panelMenu.setBackground(Color.ORANGE);
		panelMenu.setBounds(0, 0, 1292, 765);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Dialog", Font.BOLD, 99));
		lblMenu.setForeground(SystemColor.controlText);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(0, 0, 1292, 146);
		panelMenu.add(lblMenu);

		panelBotones = new JPanel();
		panelBotones.setBackground(Color.BLACK);
		panelBotones.setBounds(154, 156, 1001, 579);
		panelMenu.add(panelBotones);
		panelBotones.setLayout(new GridLayout(3, 3, 0, 10));

		btnVerStreamer = new JButton("Información General");
		btnVerStreamer.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnVerStreamer.setForeground(Color.WHITE);
		btnVerStreamer.setBackground(new Color(70, 130, 180));
		btnVerStreamer.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		panelBotones.add(btnVerStreamer);

		// Botón de Información de Creador
		btnInfoCreador = new JButton("Eliminar publicaciones por Parametro Mínimo");
		btnInfoCreador.setForeground(Color.WHITE);
		btnInfoCreador.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnInfoCreador.setBackground(new Color(70, 130, 180)); // Cambia el color de fondo para más atractivo
		btnInfoCreador.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Añadir borde
		panelBotones.add(btnInfoCreador);

		// Botón de Métricas
		btnMetricas = new JButton("Exportacion");
		btnMetricas.setForeground(Color.WHITE);
		btnMetricas.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMetricas.setBackground(new Color(70, 130, 180)); // Cambia el color de fondo para más atractivo
		btnMetricas.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Añadir borde
		panelBotones.add(btnMetricas);

		btnJoptionPaint = new JButton("");
		btnJoptionPaint.setBackground(SystemColor.desktop);
		btnJoptionPaint.setForeground(Color.RED);
		btnJoptionPaint.setFont(new Font("Tahoma", Font.BOLD, 38));
		btnJoptionPaint.setBounds(1219, 0, 73, 60);
		btnJoptionPaint.setIcon(new ImageIcon(asignarImagenBomba(btnJoptionPaint)));
		panelMenu.add(btnJoptionPaint);

		// Configuración del segundo panel duplicado
		panelMostrarColabs = new JPanel();
		panelMostrarColabs.setBackground(new Color(200, 220, 240));
		panelMostrarColabs.setBounds(0, 0, 1292, 752);
		contentPane.add(panelMostrarColabs);
		panelMostrarColabs.setLayout(null);
		panelMostrarColabs.setVisible(false);

		// Panel de información duplicado
		panelInfoColab = new JPanel();
		panelInfoColab.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelInfoColab.setBackground(new Color(220, 220, 250));
		panelInfoColab.setBounds(535, 156, 707, 586);
		panelMostrarColabs.add(panelInfoColab);
		panelInfoColab.setLayout(null);

		// Etiquetas y contenido duplicados
		lblColaborador = new JLabel("Colaborador:");
		lblColaborador.setBounds(10, 35, 354, 40);
		lblColaborador.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelInfoColab.add(lblColaborador);

		lblIdMostrarColaborador = new JLabel(""); // Campo vacío
		lblIdMostrarColaborador.setBounds(374, 35, 321, 40);
		lblIdMostrarColaborador.setFont(new Font("Tahoma", Font.ITALIC, 28)); // Fuente menor
		lblIdMostrarColaborador.setBackground(Color.WHITE);
		lblIdMostrarColaborador.setOpaque(true); // Hacer el fondo blanco
		lblIdMostrarColaborador.setBorder(new LineBorder(Color.BLACK, 2)); // Borde de 2 píxeles
		panelInfoColab.add(lblIdMostrarColaborador);

		lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(10, 133, 354, 40);
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelInfoColab.add(lblFechaInicio);

		lblMostrarFechaInicio = new JLabel(""); // Campo vacío
		lblMostrarFechaInicio.setBounds(374, 134, 321, 40);
		lblMostrarFechaInicio.setFont(new Font("Tahoma", Font.ITALIC, 28)); // Fuente menor
		lblMostrarFechaInicio.setBackground(Color.WHITE);
		lblMostrarFechaInicio.setOpaque(true); // Hacer el fondo blanco
		lblMostrarFechaInicio.setBorder(new LineBorder(Color.BLACK, 2)); // Borde de 2 píxeles
		panelInfoColab.add(lblMostrarFechaInicio);

		lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setBounds(10, 229, 354, 40);
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelInfoColab.add(lblFechaFin);

		lblFechaFinMostrar = new JLabel(""); // Campo vacío
		lblFechaFinMostrar.setBounds(374, 230, 321, 40);
		lblFechaFinMostrar.setFont(new Font("Tahoma", Font.ITALIC, 28)); // Fuente menor
		lblFechaFinMostrar.setBackground(Color.WHITE);
		lblFechaFinMostrar.setOpaque(true); // Hacer el fondo blanco
		lblFechaFinMostrar.setBorder(new LineBorder(Color.BLACK, 2)); // Borde de 2 píxeles
		panelInfoColab.add(lblFechaFinMostrar);

		lblTematica2 = new JLabel("Temática:");
		lblTematica2.setBounds(10, 318, 354, 40);
		lblTematica2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelInfoColab.add(lblTematica2);

		lblTematicaMostrar2 = new JLabel(""); // Campo vacío
		lblTematicaMostrar2.setBounds(374, 318, 321, 41);
		lblTematicaMostrar2.setFont(new Font("Tahoma", Font.ITALIC, 28)); // Fuente menor
		lblTematicaMostrar2.setBackground(Color.WHITE);
		lblTematicaMostrar2.setOpaque(true); // Hacer el fondo blanco
		lblTematicaMostrar2.setBorder(new LineBorder(Color.BLACK, 2)); // Borde de 2 píxeles
		panelInfoColab.add(lblTematicaMostrar2);

		lblTipoColab = new JLabel("Tipo de colaboración:");
		lblTipoColab.setBounds(10, 423, 354, 40);
		lblTipoColab.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelInfoColab.add(lblTipoColab);

		lblTipoColabMostrar = new JLabel(""); // Campo vacío
		lblTipoColabMostrar.setBounds(374, 423, 321, 40);
		lblTipoColabMostrar.setFont(new Font("Tahoma", Font.ITALIC, 28)); // Fuente menor
		lblTipoColabMostrar.setBackground(Color.WHITE);
		lblTipoColabMostrar.setOpaque(true); // Hacer el fondo blanco
		lblTipoColabMostrar.setBorder(new LineBorder(Color.BLACK, 2)); // Borde de 2 píxeles
		panelInfoColab.add(lblTipoColabMostrar);

		lblEstadoColab = new JLabel("Estado de la Colaboración:");
		lblEstadoColab.setBounds(10, 536, 360, 40);
		lblEstadoColab.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelInfoColab.add(lblEstadoColab);

		lblEstadoColabMostrar = new JLabel(""); // Campo vacío
		lblEstadoColabMostrar.setBounds(374, 536, 321, 40);
		lblEstadoColabMostrar.setFont(new Font("Tahoma", Font.ITALIC, 28)); // Fuente menor
		lblEstadoColabMostrar.setBackground(Color.WHITE);
		lblEstadoColabMostrar.setOpaque(true); // Hacer el fondo blanco
		lblEstadoColabMostrar.setBorder(new LineBorder(Color.BLACK, 2)); // Borde de 2 píxeles
		panelInfoColab.add(lblEstadoColabMostrar);

		scrollPaneColaboradores = new JScrollPane();
		scrollPaneColaboradores.setBounds(1012, 156, 280, 586);
		panelMostrarColabs.add(scrollPaneColaboradores);

		lblColaboradores = new JLabel("Colaboradores");
		lblColaboradores.setOpaque(true);
		lblColaboradores.setHorizontalAlignment(SwingConstants.CENTER);
		lblColaboradores.setForeground(Color.WHITE);
		lblColaboradores.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblColaboradores.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblColaboradores.setBackground(new Color(128, 128, 255));
		scrollPaneColaboradores.setColumnHeaderView(lblColaboradores);

		listColaboradores = new JList();
		listColaboradores.setForeground(Color.BLACK);
		listColaboradores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listColaboradores.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
		listColaboradores.setBackground(SystemColor.inactiveCaption);
		scrollPaneColaboradores.setViewportView(listColaboradores);

		// Título del segundo panel
		lblTituloColab = new JLabel("Información de las Colaboraciones");
		lblTituloColab.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloColab.setForeground(new Color(0, 51, 102));
		lblTituloColab.setFont(new Font("Dialog", Font.BOLD, 50));
		lblTituloColab.setBounds(127, 10, 1155, 99);
		panelMostrarColabs.add(lblTituloColab);

		// Botón Salir en el segundo panel
		btnSalirInfoGen = new JButton("");
		btnSalirInfoGen.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSalirInfoGen.setForeground(new Color(255, 255, 255));
		btnSalirInfoGen.setBackground(new Color(255, 204, 0));
		btnSalirInfoGen.setBounds(10, 25, 107, 74);
		btnSalirInfoGen.setIcon(new ImageIcon(asignarImagenSalir(btnSalirInfoGen)));
		btnSalirInfoGen.setOpaque(false);
		panelMostrarColabs.add(btnSalirInfoGen);

		// ScrollPane para la lista duplicada de streamers
		scrollPaneColabs = new JScrollPane();
		scrollPaneColabs.setBounds(30, 119, 495, 623);
		panelMostrarColabs.add(scrollPaneColabs);

		listColabs = new JList();
		listColabs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listColabs.setBackground(SystemColor.info);
		listColabs.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
		scrollPaneColabs.setViewportView(listColabs);

		// Título para la lista duplicada
		lblJlistColabs = new JLabel("Colaboraciones");
		lblJlistColabs.setHorizontalAlignment(SwingConstants.CENTER);
		lblJlistColabs.setForeground(Color.WHITE);
		lblJlistColabs.setBackground(new Color(100, 100, 200));
		lblJlistColabs.setOpaque(true);
		lblJlistColabs.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblJlistColabs.setFont(new Font("Tahoma", Font.BOLD, 30));
		scrollPaneColabs.setColumnHeaderView(lblJlistColabs);

		// Panel para insertar colaboradores
		panelInsertarColaboradores = new JPanel();
		panelInsertarColaboradores.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelInsertarColaboradores.setBackground(new Color(220, 220, 250));
		panelInsertarColaboradores.setBounds(534, 156, 474, 586);
		panelMostrarColabs.add(panelInsertarColaboradores);
		panelInsertarColaboradores.setLayout(null);
		panelInsertarColaboradores.setVisible(false);

		// Etiqueta y campo para "ID CREADOR"
		JLabel lblID = new JLabel("ID CREADOR:");
		lblID.setHorizontalAlignment(SwingConstants.LEFT);
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblID.setBounds(10, 11, 180, 30);
		panelInsertarColaboradores.add(lblID);

		// Etiqueta y campo para "NOMBRE COLABORADOR"
		JLabel lblNombreColab = new JLabel("NOMBRE COLABORADOR:");
		lblNombreColab.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreColab.setForeground(Color.BLACK);
		lblNombreColab.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNombreColab.setBounds(10, 66, 300, 30);
		panelInsertarColaboradores.add(lblNombreColab);

		// Etiqueta y campo para "FECHA INICIO"
		lblFechaInicio = new JLabel("FECHA INICIO:");
		lblFechaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaInicio.setForeground(Color.BLACK);
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFechaInicio.setBounds(10, 157, 200, 30);
		panelInsertarColaboradores.add(lblFechaInicio);

		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldFechaInicio.setColumns(10);
		textFieldFechaInicio.setBounds(10, 197, 200, 30);
		textFieldFechaInicio.setBackground(Color.WHITE);
		textFieldFechaInicio.setBorder(new LineBorder(Color.BLACK, 2));
		panelInsertarColaboradores.add(textFieldFechaInicio);

		// Etiqueta y campo para "FECHA FIN"
		lblFechaFin = new JLabel("FECHA FIN:");
		lblFechaFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaFin.setForeground(Color.BLACK);
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFechaFin.setBounds(240, 157, 200, 30);
		panelInsertarColaboradores.add(lblFechaFin);

		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldFechaFin.setColumns(10);
		textFieldFechaFin.setBounds(240, 197, 220, 30);
		textFieldFechaFin.setBackground(Color.WHITE);
		textFieldFechaFin.setBorder(new LineBorder(Color.BLACK, 2));
		panelInsertarColaboradores.add(textFieldFechaFin);

		// Etiqueta y campo para "TEMATICA"
		JLabel lblTematica_2 = new JLabel("TEMATICA:");
		lblTematica_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTematica_2.setForeground(Color.BLACK);
		lblTematica_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTematica_2.setBounds(10, 250, 200, 30);
		panelInsertarColaboradores.add(lblTematica_2);

		textFieldTematica = new JTextField();
		textFieldTematica.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldTematica.setColumns(10);
		textFieldTematica.setBounds(10, 291, 450, 30);
		textFieldTematica.setBackground(Color.WHITE);
		textFieldTematica.setBorder(new LineBorder(Color.BLACK, 2));
		panelInsertarColaboradores.add(textFieldTematica);

		// Etiqueta y ComboBox para "ESTADO"
		JLabel lblEstado = new JLabel("ESTADO DE LA COLABORACIÓN:");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEstado.setBounds(10, 332, 374, 30);
		panelInsertarColaboradores.add(lblEstado);

		comboBoxEstadoColaboracion = new JComboBox();
		comboBoxEstadoColaboracion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxEstadoColaboracion.setBounds(10, 373, 200, 30);
		panelInsertarColaboradores.add(comboBoxEstadoColaboracion);

		// Etiqueta y campo para "TIPO COLABORACION"
		lblTipoColab = new JLabel("TIPO COLABORACION:");
		lblTipoColab.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoColab.setForeground(Color.BLACK);
		lblTipoColab.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTipoColab.setBounds(10, 414, 300, 30);
		panelInsertarColaboradores.add(lblTipoColab);

		// Botón de inserción
		btnInsertarCo = new JButton("INSERTAR NUEVA COLABORACIÓN");
		btnInsertarCo.setForeground(new Color(255, 255, 255));
		btnInsertarCo.setBackground(SystemColor.textHighlight);
		btnInsertarCo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInsertarCo.setBounds(10, 495, 450, 33);
		panelInsertarColaboradores.add(btnInsertarCo);

		lblCreado2 = new JLabel("");
		lblCreado2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreado2.setForeground(new Color(128, 0, 0));
		lblCreado2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCreado2.setBounds(10, 539, 454, 36);
		panelInsertarColaboradores.add(lblCreado2);

		comboboxTipoColab = new JComboBox();
		comboboxTipoColab.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboboxTipoColab.setBounds(10, 455, 300, 30);
		panelInsertarColaboradores.add(comboboxTipoColab);

		lblIdMostrarIdSelec = new JLabel("");
		lblIdMostrarIdSelec.setOpaque(true);
		lblIdMostrarIdSelec.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblIdMostrarIdSelec.setBorder(new LineBorder(Color.BLACK, 2));
		lblIdMostrarIdSelec.setBackground(Color.WHITE);
		lblIdMostrarIdSelec.setBounds(200, 11, 260, 30);
		panelInsertarColaboradores.add(lblIdMostrarIdSelec);

		lblNombreColabSeleccionado = new JLabel("");
		lblNombreColabSeleccionado.setOpaque(true);
		lblNombreColabSeleccionado.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblNombreColabSeleccionado.setBorder(new LineBorder(Color.BLACK, 2));
		lblNombreColabSeleccionado.setBackground(Color.WHITE);
		lblNombreColabSeleccionado.setBounds(10, 116, 430, 30);
		panelInsertarColaboradores.add(lblNombreColabSeleccionado);

		btnVerInfoColab = new JButton("Ver Información");
		btnVerInfoColab.setForeground(Color.WHITE);
		btnVerInfoColab.setBackground(new Color(25, 25, 112));
		btnVerInfoColab.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnVerInfoColab.setBounds(535, 120, 231, 38);
		panelMostrarColabs.add(btnVerInfoColab);

		btnAniadirColab = new JButton("Añadir Colaboración");
		btnAniadirColab.setForeground(SystemColor.desktop);
		btnAniadirColab.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAniadirColab.setBackground(SystemColor.scrollbar);
		btnAniadirColab.setBounds(766, 127, 242, 31);
		panelMostrarColabs.add(btnAniadirColab);

		// Configuración del tercer panel con colores cálidos
		panelMostrarMetricasCSV = new JPanel();
		panelMostrarMetricasCSV.setBackground(new Color(255, 239, 213)); // Color cálido beige
		panelMostrarMetricasCSV.setBounds(0, 0, 1292, 752);
		contentPane.add(panelMostrarMetricasCSV);
		panelMostrarMetricasCSV.setLayout(null);
		panelMostrarMetricasCSV.setVisible(false);
		// Estilo común para los JLabel
		Font fontLabel = new Font("Tahoma", Font.PLAIN, 32);
		Color labelForeground = new Color(139, 69, 19);

		panelmodificarLikesComentarios = new JPanel();
		panelmodificarLikesComentarios.setBorder(new LineBorder(new Color(139, 69, 19), 2, true));
		panelmodificarLikesComentarios.setBackground(new Color(255, 228, 181)); // Fondo melocotón claro
		panelmodificarLikesComentarios.setBounds(464, 156, 818, 586);
		panelMostrarMetricasCSV.add(panelmodificarLikesComentarios);
		panelmodificarLikesComentarios.setLayout(null);
		panelmodificarLikesComentarios.setVisible(false);

		// Etiqueta ID CREADOR
		lblNewLabel_3_3_28 = new JLabel("Id Creador:");
		lblNewLabel_3_3_28.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_28.setForeground(Color.BLACK);
		lblNewLabel_3_3_28.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_28.setBounds(10, 46, 374, 40);
		panelmodificarLikesComentarios.add(lblNewLabel_3_3_28);

		// Etiqueta Plataforma
		lblNewLabel_3_3_29 = new JLabel("Plataforma:");
		lblNewLabel_3_3_29.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_29.setForeground(Color.BLACK);
		lblNewLabel_3_3_29.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_29.setBounds(10, 122, 374, 40);
		panelmodificarLikesComentarios.add(lblNewLabel_3_3_29);

		// Etiqueta Fecha
		lblNewLabel_3_3_30 = new JLabel("Contenido:");
		lblNewLabel_3_3_30.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_30.setForeground(Color.BLACK);
		lblNewLabel_3_3_30.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_30.setBounds(10, 199, 374, 40);
		panelmodificarLikesComentarios.add(lblNewLabel_3_3_30);

		// Etiqueta Likes
		lblNewLabel_3_3_31 = new JLabel("Nueva cantidad de me gusta:");
		lblNewLabel_3_3_31.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_31.setForeground(Color.BLACK);
		lblNewLabel_3_3_31.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_31.setBounds(10, 277, 421, 40);
		panelmodificarLikesComentarios.add(lblNewLabel_3_3_31);

		textField_megusta2 = new JTextField();
		textField_megusta2.setBounds(485, 279, 323, 40);
		textField_megusta2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField_megusta2.setBackground(new Color(255, 250, 240));
		textField_megusta2.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		panelmodificarLikesComentarios.add(textField_megusta2);

		// Etiqueta Comentarios
		lblNewLabel_3_3_32 = new JLabel("Nueva cantidad de comentarios:");
		lblNewLabel_3_3_32.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_32.setForeground(Color.BLACK);
		lblNewLabel_3_3_32.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_32.setBounds(10, 360, 465, 40);
		panelmodificarLikesComentarios.add(lblNewLabel_3_3_32);

		textFieldComentarios3 = new JTextField();
		textFieldComentarios3.setBounds(485, 362, 323, 40);
		textFieldComentarios3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textFieldComentarios3.setBackground(new Color(255, 250, 240));
		textFieldComentarios3.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		panelmodificarLikesComentarios.add(textFieldComentarios3);

		// Botón Modificar
		btnModificarLikes = new JButton("Modificar");
		btnModificarLikes.setForeground(Color.WHITE);
		btnModificarLikes.setBackground(new Color(204, 102, 0));
		btnModificarLikes.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnModificarLikes.setBounds(124, 441, 571, 61);
		panelmodificarLikesComentarios.add(btnModificarLikes);

		lblContenidoSeleccionadoModificarLike = new JLabel("");
		lblContenidoSeleccionadoModificarLike.setOpaque(true);
		lblContenidoSeleccionadoModificarLike.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblContenidoSeleccionadoModificarLike.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		lblContenidoSeleccionadoModificarLike.setBackground(new Color(255, 250, 240));
		lblContenidoSeleccionadoModificarLike.setBounds(485, 199, 323, 40);
		panelmodificarLikesComentarios.add(lblContenidoSeleccionadoModificarLike);

		lblIdCreadorSeleccionadoCSVModificarLike = new JLabel("");
		lblIdCreadorSeleccionadoCSVModificarLike.setOpaque(true);
		lblIdCreadorSeleccionadoCSVModificarLike.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblIdCreadorSeleccionadoCSVModificarLike.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		lblIdCreadorSeleccionadoCSVModificarLike.setBackground(new Color(255, 250, 240));
		lblIdCreadorSeleccionadoCSVModificarLike.setBounds(485, 46, 323, 40);
		panelmodificarLikesComentarios.add(lblIdCreadorSeleccionadoCSVModificarLike);

		lblCreado5 = new JLabel("");
		lblCreado5.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreado5.setForeground(new Color(128, 0, 0));
		lblCreado5.setFont(new Font("Dialog", Font.BOLD, 32));
		lblCreado5.setBounds(10, 513, 798, 62);
		panelmodificarLikesComentarios.add(lblCreado5);

		lblPlataformaLikes = new JLabel("");
		lblPlataformaLikes.setOpaque(true);
		lblPlataformaLikes.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblPlataformaLikes.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		lblPlataformaLikes.setBackground(new Color(255, 250, 240));
		lblPlataformaLikes.setBounds(485, 122, 323, 40);
		panelmodificarLikesComentarios.add(lblPlataformaLikes);

		// Título del tercer panel
		lblTituloMetrica = new JLabel("Información de las métricas de contenido");
		lblTituloMetrica.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMetrica.setForeground(new Color(139, 69, 19)); // Marrón oscuro
		lblTituloMetrica.setFont(new Font("Dialog", Font.BOLD, 50));
		lblTituloMetrica.setBounds(127, 10, 1155, 99);
		panelMostrarMetricasCSV.add(lblTituloMetrica);

		// Botón Salir en el tercer panel
		btnSalirInfoGen2 = new JButton("");
		btnSalirInfoGen2.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSalirInfoGen2.setForeground(new Color(255, 255, 255));
		btnSalirInfoGen2.setBackground(new Color(205, 92, 92)); // Rojo cálido
		btnSalirInfoGen2.setBounds(10, 25, 107, 74);
		btnSalirInfoGen2.setIcon(new ImageIcon(asignarImagenSalir(btnSalirInfoGen2)));
		btnSalirInfoGen2.setOpaque(false);
		panelMostrarMetricasCSV.add(btnSalirInfoGen2);

		// ScrollPane para la nueva lista de métricas
		scrollPaneMetricas = new JScrollPane();
		scrollPaneMetricas.setBounds(20, 119, 434, 623);
		panelMostrarMetricasCSV.add(scrollPaneMetricas);

		listMetricas = new JList();
		listMetricas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		listMetricas.setBackground(new Color(255, 245, 230)); // Fondo cálido crema
		listMetricas.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(139, 69, 19))); // Borde marrón oscuro
		scrollPaneMetricas.setViewportView(listMetricas);

		// Título para la nueva lista
		lblJlistMetricas = new JLabel("Métricas de contenido");
		lblJlistMetricas.setHorizontalAlignment(SwingConstants.CENTER);
		lblJlistMetricas.setForeground(Color.WHITE);
		lblJlistMetricas.setBackground(new Color(210, 105, 30)); // Marrón cálido
		lblJlistMetricas.setOpaque(true);
		lblJlistMetricas.setBorder(new LineBorder(new Color(139, 69, 19), 2)); // Borde marrón oscuro
		lblJlistMetricas.setFont(new Font("Tahoma", Font.BOLD, 30));
		scrollPaneMetricas.setColumnHeaderView(lblJlistMetricas);

		// Panel de información
		panelInfoMetricas = new JPanel();
		panelInfoMetricas.setBorder(new LineBorder(new Color(139, 69, 19), 2, true));
		panelInfoMetricas.setBackground(new Color(255, 228, 181)); // Fondo melocotón claro
		panelInfoMetricas.setBounds(464, 156, 818, 586);
		panelMostrarMetricasCSV.add(panelInfoMetricas);
		panelInfoMetricas.setLayout(null);

		// Etiquetas y contenido
		lblPlataformaMetrica = new JLabel("Plataforma:");
		lblPlataformaMetrica.setBounds(30, 11, 354, 40);
		lblPlataformaMetrica.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelInfoMetricas.add(lblPlataformaMetrica);

		lblMostrarPlataformaMetrica = new JLabel(""); // Campo vacío
		lblMostrarPlataformaMetrica.setBounds(394, 11, 367, 40);
		lblMostrarPlataformaMetrica.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblMostrarPlataformaMetrica.setBackground(new Color(255, 250, 240)); // Fondo crema cálido
		lblMostrarPlataformaMetrica.setOpaque(true);
		lblMostrarPlataformaMetrica.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		panelInfoMetricas.add(lblMostrarPlataformaMetrica);

		lblFechaMetrica = new JLabel("Fecha de la métrica:");
		lblFechaMetrica.setBounds(30, 83, 354, 40);
		lblFechaMetrica.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelInfoMetricas.add(lblFechaMetrica);

		lblFechaMetricaMostrar = new JLabel(""); // Campo vacío
		lblFechaMetricaMostrar.setBounds(394, 83, 367, 40);
		lblFechaMetricaMostrar.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblFechaMetricaMostrar.setBackground(new Color(255, 250, 240));
		lblFechaMetricaMostrar.setOpaque(true);
		lblFechaMetricaMostrar.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		panelInfoMetricas.add(lblFechaMetricaMostrar);

		lblContenidoMetrica = new JLabel("Contenido:");
		lblContenidoMetrica.setBounds(30, 157, 354, 40);
		lblContenidoMetrica.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelInfoMetricas.add(lblContenidoMetrica);

		lblContenidoMetricaMostrar = new JLabel(""); // Campo vacío
		lblContenidoMetricaMostrar.setBounds(394, 157, 367, 40);
		lblContenidoMetricaMostrar.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblContenidoMetricaMostrar.setBackground(new Color(255, 250, 240));
		lblContenidoMetricaMostrar.setOpaque(true);
		lblContenidoMetricaMostrar.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		panelInfoMetricas.add(lblContenidoMetricaMostrar);

		lblTipoContenidoMetrica = new JLabel("Tipo de contenido:");
		lblTipoContenidoMetrica.setBounds(30, 232, 354, 40);
		lblTipoContenidoMetrica.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelInfoMetricas.add(lblTipoContenidoMetrica);

		lblTipoContenidoMetricaMostrar = new JLabel(""); // Campo vacío
		lblTipoContenidoMetricaMostrar.setBounds(394, 232, 367, 41);
		lblTipoContenidoMetricaMostrar.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblTipoContenidoMetricaMostrar.setBackground(new Color(255, 250, 240));
		lblTipoContenidoMetricaMostrar.setOpaque(true);
		lblTipoContenidoMetricaMostrar.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		panelInfoMetricas.add(lblTipoContenidoMetricaMostrar);

		lblVistasMetricas = new JLabel("Vistas:");
		lblVistasMetricas.setBounds(30, 306, 354, 40);
		lblVistasMetricas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelInfoMetricas.add(lblVistasMetricas);

		lblVistasMetricasMostrar = new JLabel(""); // Campo vacío
		lblVistasMetricasMostrar.setBounds(394, 306, 367, 40);
		lblVistasMetricasMostrar.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblVistasMetricasMostrar.setBackground(new Color(255, 250, 240));
		lblVistasMetricasMostrar.setOpaque(true);
		lblVistasMetricasMostrar.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		panelInfoMetricas.add(lblVistasMetricasMostrar);

		lblMeGustaMetricas = new JLabel("Me gustas:");
		lblMeGustaMetricas.setBounds(30, 380, 354, 40);
		lblMeGustaMetricas.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelInfoMetricas.add(lblMeGustaMetricas);

		lblMeGustaMetricasMostrar = new JLabel(""); // Campo vacío
		lblMeGustaMetricasMostrar.setBounds(394, 380, 367, 40);
		lblMeGustaMetricasMostrar.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblMeGustaMetricasMostrar.setBackground(new Color(255, 250, 240));
		lblMeGustaMetricasMostrar.setOpaque(true);
		lblMeGustaMetricasMostrar.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		panelInfoMetricas.add(lblMeGustaMetricasMostrar);

		lblComentariosMetricas = new JLabel("Comentarios:");
		lblComentariosMetricas.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblComentariosMetricas.setBounds(30, 457, 354, 40);
		panelInfoMetricas.add(lblComentariosMetricas);

		lblComentariosMetricasMostrar = new JLabel("");
		lblComentariosMetricasMostrar.setOpaque(true);
		lblComentariosMetricasMostrar.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblComentariosMetricasMostrar.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		lblComentariosMetricasMostrar.setBackground(new Color(255, 250, 240));
		lblComentariosMetricasMostrar.setBounds(394, 457, 367, 40);
		panelInfoMetricas.add(lblComentariosMetricasMostrar);

		lblCompartidosMetricas = new JLabel("Compartidos:");
		lblCompartidosMetricas.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCompartidosMetricas.setBounds(30, 536, 354, 40);
		panelInfoMetricas.add(lblCompartidosMetricas);

		lblCompartidosMetricasMostrar = new JLabel("");
		lblCompartidosMetricasMostrar.setOpaque(true);
		lblCompartidosMetricasMostrar.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblCompartidosMetricasMostrar.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		lblCompartidosMetricasMostrar.setBackground(new Color(255, 250, 240));
		lblCompartidosMetricasMostrar.setBounds(394, 536, 367, 40);
		panelInfoMetricas.add(lblCompartidosMetricasMostrar);

		btnVerInfoPubli = new JButton("Ver Información");
		btnVerInfoPubli.setForeground(SystemColor.activeCaptionText);
		btnVerInfoPubli.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVerInfoPubli.setBackground(new Color(128, 64, 0));
		btnVerInfoPubli.setBounds(464, 120, 194, 38);
		panelMostrarMetricasCSV.add(btnVerInfoPubli);

		btnAñadirPubli = new JButton("Añadir Publicación");
		btnAñadirPubli.setForeground(SystemColor.desktop);
		btnAñadirPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirPubli.setBackground(SystemColor.scrollbar);
		btnAñadirPubli.setBounds(656, 127, 203, 31);
		panelMostrarMetricasCSV.add(btnAñadirPubli);

		btnModificarPubli = new JButton("Modificar Publicación");
		btnModificarPubli.setForeground(SystemColor.desktop);
		btnModificarPubli.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModificarPubli.setBackground(SystemColor.scrollbar);
		btnModificarPubli.setBounds(856, 127, 217, 31);
		panelMostrarMetricasCSV.add(btnModificarPubli);

		btnModificarPubli_1 = new JButton("Modificar Métrica");
		btnModificarPubli_1.setForeground(SystemColor.desktop);
		btnModificarPubli_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModificarPubli_1.setBackground(SystemColor.scrollbar);
		btnModificarPubli_1.setBounds(1072, 127, 210, 31);
		panelMostrarMetricasCSV.add(btnModificarPubli_1);

		// Panel para modificar publicación
		panelModificarPublicacion = new JPanel();
		panelModificarPublicacion.setBorder(new LineBorder(new Color(139, 69, 19), 2, true)); // Borde con el mismo
		// estilo que el primer
		// panel
		panelModificarPublicacion.setBackground(new Color(255, 228, 181)); // Fondo melocotón claro
		panelModificarPublicacion.setBounds(464, 156, 818, 586);
		panelMostrarMetricasCSV.add(panelModificarPublicacion);
		panelModificarPublicacion.setLayout(null);
		panelModificarPublicacion.setVisible(false);

		// Etiqueta para "ID CREADOR"
		lblNewLabel_3_3_24 = new JLabel("Id Creador:");
		lblNewLabel_3_3_24.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_24.setFont(fontLabel);
		lblNewLabel_3_3_24.setBounds(22, 38, 259, 52);
		panelModificarPublicacion.add(lblNewLabel_3_3_24);

		// ComboBox con estilo
		comboBoxparaModificar = new JComboBox();
		comboBoxparaModificar.setFont(new Font("Tahoma", Font.ITALIC, 28));
		comboBoxparaModificar.setBackground(new Color(255, 250, 240));
		comboBoxparaModificar.setOpaque(true);
		comboBoxparaModificar.setBorder(new LineBorder(labelForeground, 2));
		comboBoxparaModificar.setBounds(414, 244, 365, 40);
		panelModificarPublicacion.add(comboBoxparaModificar);

		// Etiqueta para "¿Qué quieres modificar?" con un estilo uniforme
		lblNewLabel_3_3_25 = new JLabel("¿Qué quieres modificar?");
		lblNewLabel_3_3_25.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_25.setForeground(Color.BLACK);
		lblNewLabel_3_3_25.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_25.setBounds(22, 238, 356, 52);
		panelModificarPublicacion.add(lblNewLabel_3_3_25);

		// Etiqueta para "¿De qué fecha?" con el mismo estilo
		lblNewLabel_3_3_26 = new JLabel("Contenido Seleccionado:");
		lblNewLabel_3_3_26.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_26.setForeground(Color.BLACK);
		lblNewLabel_3_3_26.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_26.setBounds(22, 136, 356, 52);
		panelModificarPublicacion.add(lblNewLabel_3_3_26);

		// Etiqueta para "Dato" con el mismo diseño que los anteriores
		lblNewLabel_3_3_27 = new JLabel("Nuevo Valor:");
		lblNewLabel_3_3_27.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_27.setForeground(Color.BLACK);
		lblNewLabel_3_3_27.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_27.setBounds(22, 327, 356, 52);
		panelModificarPublicacion.add(lblNewLabel_3_3_27);

		// Campo de texto para el dato con estilo
		textFieldDato = new JTextField();
		textFieldDato.setColumns(10);
		textFieldDato.setFont(new Font("Tahoma", Font.ITALIC, 28));
		textFieldDato.setBackground(new Color(255, 250, 240));
		textFieldDato.setOpaque(true);
		textFieldDato.setBorder(new LineBorder(labelForeground, 2));
		textFieldDato.setBounds(414, 333, 365, 40);
		panelModificarPublicacion.add(textFieldDato);

		// Botón para modificar publicación con estilo claro y cohesivo
		btnmodificarpublicacionenespecifico = new JButton("MODIFICAR PUBLICACIÓN");
		btnmodificarpublicacionenespecifico.setForeground(Color.WHITE);
		btnmodificarpublicacionenespecifico.setBackground(new Color(204, 102, 0));
		btnmodificarpublicacionenespecifico.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnmodificarpublicacionenespecifico.setBounds(124, 418, 571, 61);
		panelModificarPublicacion.add(btnmodificarpublicacionenespecifico);

		lblIdCreadorSeleccionadoCSVModificar = new JLabel("");
		lblIdCreadorSeleccionadoCSVModificar.setOpaque(true);
		lblIdCreadorSeleccionadoCSVModificar.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblIdCreadorSeleccionadoCSVModificar.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		lblIdCreadorSeleccionadoCSVModificar.setBackground(new Color(255, 250, 240));
		lblIdCreadorSeleccionadoCSVModificar.setBounds(413, 48, 366, 40);
		panelModificarPublicacion.add(lblIdCreadorSeleccionadoCSVModificar);

		lblContenidoSeleccionadoModificar = new JLabel("");
		lblContenidoSeleccionadoModificar.setOpaque(true);
		lblContenidoSeleccionadoModificar.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblContenidoSeleccionadoModificar.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		lblContenidoSeleccionadoModificar.setBackground(new Color(255, 250, 240));
		lblContenidoSeleccionadoModificar.setBounds(413, 146, 366, 40);
		panelModificarPublicacion.add(lblContenidoSeleccionadoModificar);

		lblCreado4 = new JLabel("");
		lblCreado4.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreado4.setForeground(new Color(128, 0, 0));
		lblCreado4.setFont(new Font("Dialog", Font.BOLD, 32));
		lblCreado4.setBounds(10, 501, 798, 62);
		panelModificarPublicacion.add(lblCreado4);

		// Panel para añadir publicación
		panelañadirpublicion = new JPanel();
		panelañadirpublicion.setBorder(new LineBorder(new Color(139, 69, 19), 2, true));
		panelañadirpublicion.setBackground(new Color(255, 228, 181)); // Fondo melocotón claro
		panelañadirpublicion.setBounds(464, 156, 818, 586);
		panelMostrarMetricasCSV.add(panelañadirpublicion);
		panelañadirpublicion.setLayout(null);

		// Etiquetas y campos de texto con estilo unificado
		lblNewLabel_3_3_11 = new JLabel("Id Creador:");
		lblNewLabel_3_3_11.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_11.setBounds(31, 11, 354, 40);
		panelañadirpublicion.add(lblNewLabel_3_3_11);

		lblNewLabel_3_3_12 = new JLabel("Plataforma:");
		lblNewLabel_3_3_12.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_12.setBounds(31, 62, 354, 40);
		panelañadirpublicion.add(lblNewLabel_3_3_12);

		lblNewLabel_3_3_13 = new JLabel("Fecha:");
		lblNewLabel_3_3_13.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_13.setBounds(31, 113, 354, 40);
		panelañadirpublicion.add(lblNewLabel_3_3_13);

		textFieldFecha2 = new JTextField();
		textFieldFecha2.setFont(new Font("Tahoma", Font.ITALIC, 28));
		textFieldFecha2.setBackground(new Color(255, 250, 240));
		textFieldFecha2.setOpaque(true);
		textFieldFecha2.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		textFieldFecha2.setBounds(395, 113, 365, 40);
		panelañadirpublicion.add(textFieldFecha2);

		lblNewLabel_3_3_14 = new JLabel("Contenido:");
		lblNewLabel_3_3_14.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_14.setBounds(31, 164, 354, 40);
		panelañadirpublicion.add(lblNewLabel_3_3_14);

		lblNewLabel_3_3_15 = new JLabel("Tipo de contenido:");
		lblNewLabel_3_3_15.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_15.setBounds(31, 215, 354, 40);
		panelañadirpublicion.add(lblNewLabel_3_3_15);

		textFieldTipo2 = new JTextField();
		textFieldTipo2.setFont(new Font("Tahoma", Font.ITALIC, 28));
		textFieldTipo2.setBackground(new Color(255, 250, 240));
		textFieldTipo2.setOpaque(true);
		textFieldTipo2.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		textFieldTipo2.setBounds(395, 215, 365, 40);
		panelañadirpublicion.add(textFieldTipo2);

		lblNewLabel_3_3_16 = new JLabel("Vistas:");
		lblNewLabel_3_3_16.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_16.setBounds(31, 266, 354, 40);
		panelañadirpublicion.add(lblNewLabel_3_3_16);

		textFieldVistas2 = new JTextField();
		textFieldVistas2.setFont(new Font("Tahoma", Font.ITALIC, 28));
		textFieldVistas2.setBackground(new Color(255, 250, 240));
		textFieldVistas2.setOpaque(true);
		textFieldVistas2.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		textFieldVistas2.setBounds(395, 266, 365, 40);
		panelañadirpublicion.add(textFieldVistas2);

		lblNewLabel_3_3_18 = new JLabel("Me gustas:");
		lblNewLabel_3_3_18.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_18.setBounds(31, 317, 354, 40);
		panelañadirpublicion.add(lblNewLabel_3_3_18);

		textFieldMeGsuta2 = new JTextField();
		textFieldMeGsuta2.setFont(new Font("Tahoma", Font.ITALIC, 28));
		textFieldMeGsuta2.setBackground(new Color(255, 250, 240));
		textFieldMeGsuta2.setOpaque(true);
		textFieldMeGsuta2.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		textFieldMeGsuta2.setBounds(395, 317, 365, 40);
		panelañadirpublicion.add(textFieldMeGsuta2);

		lblNewLabel_3_3_19 = new JLabel("Comentarios:");
		lblNewLabel_3_3_19.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_19.setBounds(31, 368, 354, 40);
		panelañadirpublicion.add(lblNewLabel_3_3_19);

		textFieldComentarios2 = new JTextField();
		textFieldComentarios2.setFont(new Font("Tahoma", Font.ITALIC, 28));
		textFieldComentarios2.setBackground(new Color(255, 250, 240));
		textFieldComentarios2.setOpaque(true);
		textFieldComentarios2.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		textFieldComentarios2.setBounds(395, 368, 365, 40);
		panelañadirpublicion.add(textFieldComentarios2);

		lblNewLabel_3_3_20 = new JLabel("Compartidos");
		lblNewLabel_3_3_20.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_3_3_20.setBounds(31, 419, 354, 40);
		panelañadirpublicion.add(lblNewLabel_3_3_20);

		textFieldCompartidos2 = new JTextField();
		textFieldCompartidos2.setFont(new Font("Tahoma", Font.ITALIC, 28));
		textFieldCompartidos2.setBackground(new Color(255, 250, 240));
		textFieldCompartidos2.setOpaque(true);
		textFieldCompartidos2.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		textFieldCompartidos2.setBounds(395, 419, 365, 40);
		panelañadirpublicion.add(textFieldCompartidos2);

		btnAñadirPublic = new JButton("AÑADIR NUEVA PUBLICACION");
		btnAñadirPublic.setForeground(Color.WHITE);
		btnAñadirPublic.setBackground(new Color(204, 102, 0));
		btnAñadirPublic.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnAñadirPublic.setBounds(155, 470, 514, 54);
		panelañadirpublicion.add(btnAñadirPublic);

		lblIdCreadorSeleccionadoCSV = new JLabel("");
		lblIdCreadorSeleccionadoCSV.setOpaque(true);
		lblIdCreadorSeleccionadoCSV.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblIdCreadorSeleccionadoCSV.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		lblIdCreadorSeleccionadoCSV.setBackground(new Color(255, 250, 240));
		lblIdCreadorSeleccionadoCSV.setBounds(395, 11, 365, 40);
		panelañadirpublicion.add(lblIdCreadorSeleccionadoCSV);

		lblContenidoNuevo = new JLabel("");
		lblContenidoNuevo.setOpaque(true);
		lblContenidoNuevo.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblContenidoNuevo.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		lblContenidoNuevo.setBackground(new Color(255, 250, 240));
		lblContenidoNuevo.setBounds(395, 164, 365, 40);
		panelañadirpublicion.add(lblContenidoNuevo);

		comboBoxPlataformaCSV = new JComboBox();
		comboBoxPlataformaCSV.setFont(new Font("Tahoma", Font.PLAIN, 28));
		comboBoxPlataformaCSV.setBounds(395, 62, 365, 40);
		panelañadirpublicion.add(comboBoxPlataformaCSV);

		lblCreado3 = new JLabel("");
		lblCreado3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreado3.setForeground(new Color(128, 0, 0));
		lblCreado3.setFont(new Font("Dialog", Font.BOLD, 30));
		lblCreado3.setBounds(10, 535, 798, 40);
		panelañadirpublicion.add(lblCreado3);

		panelExportacionDatos = new JPanel();
		panelExportacionDatos.setBackground(Color.ORANGE);
		panelExportacionDatos.setBounds(0, 0, 1292, 765);
		contentPane.add(panelExportacionDatos);
		panelExportacionDatos.setLayout(null);
		panelExportacionDatos.setVisible(false);
		lblExportacionDeDatos = new JLabel("Exportacion de datos");
		lblExportacionDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblExportacionDeDatos.setForeground(new Color(0, 0, 128));
		lblExportacionDeDatos.setFont(new Font("Dialog", Font.BOLD, 75));
		lblExportacionDeDatos.setBounds(71, 10, 1137, 99);
		panelExportacionDatos.add(lblExportacionDeDatos);

		btnSalir_1 = new JButton("");
		btnSalir_1.setForeground(Color.WHITE);
		btnSalir_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSalir_1.setBackground(new Color(255, 204, 0));
		btnSalir_1.setBounds(10, 26, 107, 74);
		btnSalir_1.setIcon(new ImageIcon(asignarImagenSalir(btnSalir_1)));
		panelExportacionDatos.add(btnSalir_1);

		panelBotones_1 = new JPanel();
		panelBotones_1.setBackground(Color.BLACK);
		panelBotones_1.setBounds(147, 119, 1001, 508);
		panelExportacionDatos.add(panelBotones_1);
		panelBotones_1.setLayout(null);
		panelBotones_1.setVisible(false);
		btnExportaColaboracionesCSV = new JButton("Exportar a csv colaboraciones");
		btnExportaColaboracionesCSV.setBounds(0, 104, 1001, 93);
		btnExportaColaboracionesCSV.setForeground(Color.WHITE);
		btnExportaColaboracionesCSV.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnExportaColaboracionesCSV.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		btnExportaColaboracionesCSV.setBackground(new Color(70, 130, 180));
		panelBotones_1.add(btnExportaColaboracionesCSV);

		btnExportarInfrome_reportejson = new JButton("Exportar reportes json");
		btnExportarInfrome_reportejson.setBounds(0, 310, 1001, 93);
		btnExportarInfrome_reportejson.setForeground(Color.WHITE);
		btnExportarInfrome_reportejson.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnExportarInfrome_reportejson.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		btnExportarInfrome_reportejson.setBackground(new Color(70, 130, 180));
		panelBotones_1.add(btnExportarInfrome_reportejson);

		btngenerarreportecsvcolaboraciones = new JButton("Exportar reportar colaboraciones a CSV");
		btngenerarreportecsvcolaboraciones.setBounds(0, 207, 1001, 93);
		btngenerarreportecsvcolaboraciones.setForeground(Color.WHITE);
		btngenerarreportecsvcolaboraciones.setFont(new Font("Tahoma", Font.BOLD, 30));
		btngenerarreportecsvcolaboraciones.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		btngenerarreportecsvcolaboraciones.setBackground(new Color(70, 130, 180));
		panelBotones_1.add(btngenerarreportecsvcolaboraciones);

		btnresumenrendimientojson = new JButton("Exportar colaboraciones JSON a CSV");
		btnresumenrendimientojson.setForeground(Color.WHITE);
		btnresumenrendimientojson.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnresumenrendimientojson.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		btnresumenrendimientojson.setBackground(new Color(70, 130, 180));
		btnresumenrendimientojson.setBounds(0, 0, 1001, 93);
		panelBotones_1.add(btnresumenrendimientojson);

		btncolaboracionesajson = new JButton("Exportar colaboraciones a JSON");
		btncolaboracionesajson.setForeground(Color.WHITE);
		btncolaboracionesajson.setFont(new Font("Tahoma", Font.BOLD, 30));
		btncolaboracionesajson.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		btncolaboracionesajson.setBackground(new Color(70, 130, 180));
		btncolaboracionesajson.setBounds(0, 413, 1001, 93);
		panelBotones_1.add(btncolaboracionesajson);

		lblResultado = new JLabel("");
		lblResultado.setBackground(new Color(0, 255, 0));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(new Color(0, 0, 0));
		lblResultado.setFont(new Font("Dialog", Font.BOLD, 40));
		lblResultado.setBounds(71, 627, 1137, 99);
		lblResultado.setOpaque(true);

		panelExportacionDatos.add(lblResultado);

		lblFallo = new JLabel("");
		lblFallo.setBackground(new Color(255, 0, 0));
		lblFallo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFallo.setForeground(new Color(255, 255, 255));
		lblFallo.setFont(new Font("Dialog", Font.BOLD, 40));
		lblFallo.setBounds(71, 627, 1137, 99);
		lblFallo.setOpaque(true);
		panelExportacionDatos.add(lblFallo);

		ajustesInicio();
	}

	public void ajustesInicio() {
		lblFallo.setVisible(false);
		lblResultado.setVisible(false);
		panelInsertarColaboradores.setVisible(false);
		scrollPaneColaboradores.setVisible(false);
		listColaboradores.setVisible(false);
		panelañadirpublicion.setVisible(false);
		panelMayorRendimiento.setVisible(false);
	}

	private Image asignarImagenSalir(JButton btnSalir_1) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/img/Back-Button-PNG-Download-Image.png"));
		Image img1 = imagen1.getImage();
		Image imgEscalada1 = img1.getScaledInstance(btnSalir_1.getWidth(), btnSalir_1.getHeight(), Image.SCALE_SMOOTH);
		return imgEscalada1;
	}

	private Image asignarImagenBomba(JButton btn) {
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/img/images.png"));
		Image img1 = imagen1.getImage();
		Image imgEscalada1 = img1.getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH);
		return imgEscalada1;
	}

	private Image asignarImgDatos(JButton btn) {
		// Inicializamos imgEscalada1 en null para evitar problemas si la condición no
		// se cumple
		Image imgEscalada1 = null;

		// Verificamos si el botón es el btnMetricasContenido
		if (btn == btnMetricasContenido) {
			// Cargar la imagen desde los recursos
			ImageIcon imagen1 = new ImageIcon(getClass().getResource("/img/metricas.png"));
			Image img1 = imagen1.getImage();

			// Escalar la imagen al tamaño del botón
			imgEscalada1 = img1.getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_DEFAULT);

		} else {
			// Cargar la imagen desde los recursos
			ImageIcon imagen1 = new ImageIcon(getClass().getResource("/img/apreton.jpeg"));
			Image img1 = imagen1.getImage();

			// Escalar la imagen al tamaño del botón
			imgEscalada1 = img1.getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH);
		}
		// Retornamos la imagen escalada o null si no se cumplió la condición
		return imgEscalada1;
	}

	private Image asignarImgPlataforma(JLabel label) {
		// Inicializamos imgEscalada1 en null para evitar problemas si la condición no
		// se cumple
		Image imgEscalada1 = null;
		
		// Verificamos si el botón es el btnMetricasContenido
		if (lblPromedioYoutube == label) {
			// Cargar la imagen desde los recursos
			ImageIcon imagen1 = new ImageIcon(getClass().getResource("/img/youtu.png"));
			Image img1 = imagen1.getImage();

			// Escalar la imagen al tamaño del botón
			imgEscalada1 = img1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);

		}  else if(lblPromedioTiktok==label) {
			// Cargar la imagen desde los recursos
			ImageIcon imagen1 = new ImageIcon(getClass().getResource( "/img/tiktok.png"));
			Image img1 = imagen1.getImage();

			// Escalar la imagen al tamaño del botón
			imgEscalada1 = img1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);

		}else if(lblPromedioInstagram==label) {
			// Cargar la imagen desde los recursos
			ImageIcon imagen1 = new ImageIcon(getClass().getResource( "/img/insta.png"));
			Image img1 = imagen1.getImage();

			// Escalar la imagen al tamaño del botón
			imgEscalada1 = img1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);

		}else if(lblPromedioTwitch==label) {
			// Cargar la imagen desde los recursos
			ImageIcon imagen1 = new ImageIcon(getClass().getResource( "/img/Twitch_logo.svg.png"));
			Image img1 = imagen1.getImage();

			// Escalar la imagen al tamaño del botón
			imgEscalada1 = img1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);

		}
		// Retornamos la imagen escalada o null si no se cumplió la condición
		return imgEscalada1;
	}
}

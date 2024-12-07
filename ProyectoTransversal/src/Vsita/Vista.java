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
	public JLabel lblResultado;
	public JLabel lblFallo;
	public JLabel lblFotoPlataformaEnfasis;
	public JPanel panelModifcar;
	public JComboBox comboBoxelegiropciones;
	public JPanel panelInsertarColaboradores;
	public JLabel lblNewLabel_3_3_10;
	public JTextField textFieldCreador1;
	public JTextField textFieldNombreColaborador;
	public JTextField textFieldTematica;
	public JTextField textFieldFechaFin;
	public JLabel lblNewLabel_3_3_1_1_1_1_3;
	public JTextField textFieldFechaInicio;
	public JLabel lblNewLabel_3_3_1_1_1_1_1_2;
	public JTextField textFieldTipoColaboracion;
	public JLabel lblNewLabel_3_3_1_3;
	public JPanel panelañadirpublicion;
	public JLabel lblNewLabel_3_3_11;
	public JTextField textFieldidcreador1;
	public JLabel lblNewLabel_3_3_12;
	public JTextField textFieldplataforma2;
	public JLabel lblNewLabel_3_3_13;
	public JTextField textFieldFecha2;
	public JLabel lblNewLabel_3_3_14;
	public JTextField textFieldContenido2;
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
	public JTextField textFieldidcreador;
	public JLabel lblNewLabel_3_3_22;
	public JTextField textFieldfecha;
	public JButton btnEliminarPorinteracion;
	public JPanel paneleliminarminimovistas;
	public JLabel lblNewLabel_3_3_23;
	public JTextField textFieldMinVistas;
	public JButton btnEliminarMinimoVistas;
	public JPanel panelModificarPublicacion;
	public JLabel lblNewLabel_3_3_24;
	public JTextField textFieldidstreamer;
	public JLabel lblNewLabel_3_3_25;
	public JLabel lblNewLabel_3_3_26;
	public JTextField textFieldfehca;
	public JLabel lblNewLabel_3_3_27;
	public JTextField textFieldDato;
	public JButton btnmodificarpublicacion;
	public JPanel panelmodificarLikesComentarios;
	public JLabel lblNewLabel_3_3_28;
	public JTextField textFieldid_creador3;
	public JLabel lblNewLabel_3_3_29;
	public JTextField textFieldel_plataforma3;
	public JLabel lblNewLabel_3_3_30;
	public JTextField textFieldFechaContenido3;
	public JLabel lblNewLabel_3_3_31;
	public JTextField textField_megusta2;
	public JLabel lblNewLabel_3_3_32;
	public JTextField textFieldComentarios3;
	public JButton btnModificarLikeComentarios;
	public JList liststreamer;
	public JScrollPane scrollPane;
	public JLabel lblStreamer;
	public JComboBox comboBoxEstadoColaboracion;
	public JComboBox comboBoxparaModificar;
	public JButton btnInsertarColaborador;
	public JLabel lblCreado;
	public JButton btnJoptionPaint;
	public JButton btnMetricasContenido;
	public JLabel lblNewLabel;
	public JButton btnColaboraciones;
	public JLabel lblVerColaboraciones;
	public JButton btnVolverModificacion;

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
								lblInfoGeneral.setFont(new Font("Dialog", Font.BOLD, 75));
								lblInfoGeneral.setBounds(127, 10, 1155, 99);
								panelMostrarTodo.add(lblInfoGeneral);
								
										btnVolverMostrarTodo = new JButton("Volver");
										btnVolverMostrarTodo.setBounds(1568, 0, 89, 51);
										panelMostrarTodo.add(btnVolverMostrarTodo);
										
												btnSalir = new JButton("");
												btnSalir.setFont(new Font("Tahoma", Font.BOLD, 30));
												btnSalir.setForeground(new Color(255, 255, 255));
												btnSalir.setBackground(new Color(255, 204, 0));
												btnSalir.setBounds(10, 25, 107, 74);
												btnSalir.setIcon(new ImageIcon(asignarImagenSalir(btnSalir)));
												btnSalir.setOpaque(false);
												panelMostrarTodo.add(btnSalir);
												
														scrollPaneStreamers = new JScrollPane();
														scrollPaneStreamers.setBounds(30, 119, 342, 623);
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
																																				
																																						lblTematica = new JLabel("Temática:");
																																						lblTematica.setFont(new Font("Tahoma", Font.BOLD, 22));
																																						lblTematica.setBounds(340, 66, 121, 46); // Adjust position
																																						panelInformacion.add(lblTematica);
																																						
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
																																																																						lblFotoPlataforma.setBounds(10, 10, 262, 65);
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
										
												btngenerarreportecsvcolaboraciones = new JButton("Exportar reporte colaboraciones CSV");
												btngenerarreportecsvcolaboraciones.setBounds(0, 207, 1001, 93);
												btngenerarreportecsvcolaboraciones.setForeground(Color.WHITE);
												btngenerarreportecsvcolaboraciones.setFont(new Font("Tahoma", Font.BOLD, 30));
												btngenerarreportecsvcolaboraciones.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
												btngenerarreportecsvcolaboraciones.setBackground(new Color(70, 130, 180));
												panelBotones_1.add(btngenerarreportecsvcolaboraciones);
												
														btnresumenrendimientojson = new JButton("Exportar reporte colaboraciones CSV");
														btnresumenrendimientojson.setForeground(Color.WHITE);
														btnresumenrendimientojson.setFont(new Font("Tahoma", Font.BOLD, 30));
														btnresumenrendimientojson.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
														btnresumenrendimientojson.setBackground(new Color(70, 130, 180));
														btnresumenrendimientojson.setBounds(0, 0, 1001, 93);
														panelBotones_1.add(btnresumenrendimientojson);
														
																btncolaboracionesajson = new JButton("Exportar reporte colaboraciones CSV");
																btncolaboracionesajson.setForeground(Color.WHITE);
																btncolaboracionesajson.setFont(new Font("Tahoma", Font.BOLD, 30));
																btncolaboracionesajson.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
																btncolaboracionesajson.setBackground(new Color(70, 130, 180));
																btncolaboracionesajson.setBounds(0, 413, 1001, 93);
																panelBotones_1.add(btncolaboracionesajson);
																
																		lblResultado = new JLabel("Exportacion de colaboradores a CSV completada en la carpeta 'files'");
																		lblResultado.setBackground(Color.GREEN);
																		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
																		lblResultado.setForeground(Color.WHITE);
																		lblResultado.setFont(new Font("Dialog", Font.BOLD, 50));
																		lblResultado.setBounds(97, 634, 1137, 99);
																		lblResultado.setOpaque(true);
																		lblResultado.setVisible(false);
																		panelExportacionDatos.add(lblResultado);
																		
																				lblFallo = new JLabel("Error al exportar");
																				lblFallo.setForeground(Color.WHITE);
																				lblFallo.setBackground(Color.RED);
																				lblFallo.setBounds(97, 634, 1137, 99);
																				lblFallo.setOpaque(true);
																				lblFallo.setVisible(false);
																				panelExportacionDatos.add(lblFallo);

		panelModifcar = new JPanel();
		panelModifcar.setBackground(Color.ORANGE);
		panelModifcar.setBounds(0, 0, 1292, 752);
		contentPane.add(panelModifcar);
		panelModifcar.setLayout(null);
		panelModifcar.setVisible(rootPaneCheckingEnabled);
		panelModifcar.setVisible(false);

		paneleliminarminimovistas = new JPanel();
		paneleliminarminimovistas.setBackground(Color.BLACK);
		paneleliminarminimovistas.setBounds(482, 217, 759, 444);
		panelModifcar.add(paneleliminarminimovistas);
		paneleliminarminimovistas.setLayout(null);
		paneleliminarminimovistas.setVisible(false);
		lblNewLabel_3_3_23 = new JLabel("Minimo vistas");
		lblNewLabel_3_3_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_23.setForeground(Color.WHITE);
		lblNewLabel_3_3_23.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_23.setBounds(191, 91, 355, 70);
		paneleliminarminimovistas.add(lblNewLabel_3_3_23);

		textFieldMinVistas = new JTextField();
		textFieldMinVistas.setColumns(10);
		textFieldMinVistas.setBounds(201, 172, 345, 20);
		paneleliminarminimovistas.add(textFieldMinVistas);

		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setBounds(201, 231, 345, 23);
		paneleliminarminimovistas.add(btnNewButton_2);

		panelmodificarLikesComentarios = new JPanel();
		panelmodificarLikesComentarios.setBackground(Color.BLACK);
		panelmodificarLikesComentarios.setBounds(482, 217, 759, 444);
		panelModifcar.add(panelmodificarLikesComentarios);
		panelmodificarLikesComentarios.setLayout(null);
		panelmodificarLikesComentarios.setVisible(false);
		lblNewLabel_3_3_28 = new JLabel("ID CREADOR");
		lblNewLabel_3_3_28.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_28.setForeground(Color.WHITE);
		lblNewLabel_3_3_28.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_28.setBounds(49, 43, 164, 70);
		panelmodificarLikesComentarios.add(lblNewLabel_3_3_28);

		textFieldid_creador3 = new JTextField();
		textFieldid_creador3.setColumns(10);
		textFieldid_creador3.setBounds(49, 111, 164, 20);
		panelmodificarLikesComentarios.add(textFieldid_creador3);

		lblNewLabel_3_3_29 = new JLabel("Plataforma");
		lblNewLabel_3_3_29.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_29.setForeground(Color.WHITE);
		lblNewLabel_3_3_29.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_29.setBounds(287, 43, 164, 70);
		panelmodificarLikesComentarios.add(lblNewLabel_3_3_29);

		textFieldel_plataforma3 = new JTextField();
		textFieldel_plataforma3.setColumns(10);
		textFieldel_plataforma3.setBounds(287, 111, 164, 20);
		panelmodificarLikesComentarios.add(textFieldel_plataforma3);

		lblNewLabel_3_3_30 = new JLabel("Fecha");
		lblNewLabel_3_3_30.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_30.setForeground(Color.WHITE);
		lblNewLabel_3_3_30.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_30.setBounds(49, 142, 164, 70);
		panelmodificarLikesComentarios.add(lblNewLabel_3_3_30);

		textFieldFechaContenido3 = new JTextField();
		textFieldFechaContenido3.setColumns(10);
		textFieldFechaContenido3.setBounds(49, 223, 164, 20);
		panelmodificarLikesComentarios.add(textFieldFechaContenido3);

		lblNewLabel_3_3_31 = new JLabel("Likes");
		lblNewLabel_3_3_31.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_31.setForeground(Color.WHITE);
		lblNewLabel_3_3_31.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_31.setBounds(287, 142, 164, 70);
		panelmodificarLikesComentarios.add(lblNewLabel_3_3_31);

		textField_megusta2 = new JTextField();
		textField_megusta2.setColumns(10);
		textField_megusta2.setBounds(287, 223, 164, 20);
		panelmodificarLikesComentarios.add(textField_megusta2);

		lblNewLabel_3_3_32 = new JLabel("Comentarios");
		lblNewLabel_3_3_32.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_32.setForeground(Color.WHITE);
		lblNewLabel_3_3_32.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_32.setBounds(49, 254, 164, 70);
		panelmodificarLikesComentarios.add(lblNewLabel_3_3_32);

		textFieldComentarios3 = new JTextField();
		textFieldComentarios3.setColumns(10);
		textFieldComentarios3.setBounds(49, 322, 164, 20);
		panelmodificarLikesComentarios.add(textFieldComentarios3);

		btnModificar_1 = new JButton("Modificar");
		btnModificar_1.setBounds(281, 321, 170, 23);
		panelmodificarLikesComentarios.add(btnModificar_1);

		panelModificarPublicacion = new JPanel();
		panelModificarPublicacion.setBackground(Color.BLACK);
		panelModificarPublicacion.setBounds(482, 217, 759, 444);
		panelModifcar.add(panelModificarPublicacion);
		panelModificarPublicacion.setLayout(null);
		panelModificarPublicacion.setVisible(false);
		lblNewLabel_3_3_24 = new JLabel("ID CREADOR");
		lblNewLabel_3_3_24.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_24.setForeground(Color.WHITE);
		lblNewLabel_3_3_24.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_24.setBounds(48, 44, 164, 70);
		panelModificarPublicacion.add(lblNewLabel_3_3_24);

		textFieldidstreamer = new JTextField();
		textFieldidstreamer.setColumns(10);
		textFieldidstreamer.setBounds(48, 108, 164, 20);
		panelModificarPublicacion.add(textFieldidstreamer);

		comboBoxparaModificar = new JComboBox();
		comboBoxparaModificar.setBounds(353, 107, 288, 22);
		panelModificarPublicacion.add(comboBoxparaModificar);

		lblNewLabel_3_3_25 = new JLabel("¿Que quieres modificar?");
		lblNewLabel_3_3_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_25.setForeground(Color.WHITE);
		lblNewLabel_3_3_25.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_25.setBounds(317, 44, 356, 70);
		panelModificarPublicacion.add(lblNewLabel_3_3_25);

		lblNewLabel_3_3_26 = new JLabel("¿De que fecha?");
		lblNewLabel_3_3_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_26.setForeground(Color.WHITE);
		lblNewLabel_3_3_26.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_26.setBounds(22, 125, 235, 70);
		panelModificarPublicacion.add(lblNewLabel_3_3_26);

		textFieldfehca = new JTextField();
		textFieldfehca.setColumns(10);
		textFieldfehca.setBounds(48, 193, 164, 20);
		panelModificarPublicacion.add(textFieldfehca);

		lblNewLabel_3_3_27 = new JLabel("Dato");
		lblNewLabel_3_3_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_27.setForeground(Color.WHITE);
		lblNewLabel_3_3_27.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_27.setBounds(304, 125, 356, 70);
		panelModificarPublicacion.add(lblNewLabel_3_3_27);

		textFieldDato = new JTextField();
		textFieldDato.setColumns(10);
		textFieldDato.setBounds(339, 193, 302, 20);
		panelModificarPublicacion.add(textFieldDato);

		btnmodificarpublicacion_1 = new JButton("Modificar");
		btnmodificarpublicacion_1.setBounds(48, 289, 593, 23);
		panelModificarPublicacion.add(btnmodificarpublicacion_1);
		panelañadirpublicion = new JPanel();
		panelañadirpublicion.setBackground(Color.BLACK);
		panelañadirpublicion.setBounds(482, 217, 759, 444);
		panelModifcar.add(panelañadirpublicion);
		panelañadirpublicion.setLayout(null);

		lblNewLabel_3_3_11 = new JLabel("ID CREADOR");
		lblNewLabel_3_3_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_11.setForeground(Color.WHITE);
		lblNewLabel_3_3_11.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_11.setBounds(10, 34, 164, 70);
		panelañadirpublicion.add(lblNewLabel_3_3_11);

		textFieldidcreador1 = new JTextField();
		textFieldidcreador1.setColumns(10);
		textFieldidcreador1.setBounds(10, 93, 164, 20);
		panelañadirpublicion.add(textFieldidcreador1);

		lblNewLabel_3_3_12 = new JLabel("Plataforma");
		lblNewLabel_3_3_12.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_12.setForeground(Color.WHITE);
		lblNewLabel_3_3_12.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_12.setBounds(10, 115, 164, 70);
		panelañadirpublicion.add(lblNewLabel_3_3_12);

		textFieldplataforma2 = new JTextField();
		textFieldplataforma2.setColumns(10);
		textFieldplataforma2.setBounds(10, 169, 164, 20);
		panelañadirpublicion.add(textFieldplataforma2);

		lblNewLabel_3_3_13 = new JLabel("Fecha");
		lblNewLabel_3_3_13.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_13.setForeground(Color.WHITE);
		lblNewLabel_3_3_13.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_13.setBounds(10, 196, 164, 70);
		panelañadirpublicion.add(lblNewLabel_3_3_13);

		textFieldFecha2 = new JTextField();
		textFieldFecha2.setColumns(10);
		textFieldFecha2.setBounds(10, 259, 164, 20);
		panelañadirpublicion.add(textFieldFecha2);

		lblNewLabel_3_3_14 = new JLabel("Contenido");
		lblNewLabel_3_3_14.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_14.setForeground(Color.WHITE);
		lblNewLabel_3_3_14.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_14.setBounds(10, 290, 164, 70);
		panelañadirpublicion.add(lblNewLabel_3_3_14);

		textFieldContenido2 = new JTextField();
		textFieldContenido2.setColumns(10);
		textFieldContenido2.setBounds(10, 351, 164, 20);
		panelañadirpublicion.add(textFieldContenido2);

		lblNewLabel_3_3_15 = new JLabel("Tipo");
		lblNewLabel_3_3_15.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_15.setForeground(Color.WHITE);
		lblNewLabel_3_3_15.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_15.setBounds(235, 34, 164, 70);
		panelañadirpublicion.add(lblNewLabel_3_3_15);

		textFieldTipo2 = new JTextField();
		textFieldTipo2.setColumns(10);
		textFieldTipo2.setBounds(235, 93, 164, 20);
		panelañadirpublicion.add(textFieldTipo2);

		lblNewLabel_3_3_16 = new JLabel("Visitas");
		lblNewLabel_3_3_16.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_16.setForeground(Color.WHITE);
		lblNewLabel_3_3_16.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_16.setBounds(235, 115, 164, 70);
		panelañadirpublicion.add(lblNewLabel_3_3_16);

		textFieldVistas2 = new JTextField();
		textFieldVistas2.setColumns(10);
		textFieldVistas2.setBounds(235, 169, 164, 20);
		panelañadirpublicion.add(textFieldVistas2);

		lblNewLabel_3_3_18 = new JLabel("Likes");
		lblNewLabel_3_3_18.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_18.setForeground(Color.WHITE);
		lblNewLabel_3_3_18.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_18.setBounds(235, 196, 164, 70);
		panelañadirpublicion.add(lblNewLabel_3_3_18);

		textFieldMeGsuta2 = new JTextField();
		textFieldMeGsuta2.setColumns(10);
		textFieldMeGsuta2.setBounds(235, 259, 164, 20);
		panelañadirpublicion.add(textFieldMeGsuta2);

		lblNewLabel_3_3_19 = new JLabel("Comentarios");
		lblNewLabel_3_3_19.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_19.setForeground(Color.WHITE);
		lblNewLabel_3_3_19.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_19.setBounds(235, 290, 164, 70);
		panelañadirpublicion.add(lblNewLabel_3_3_19);

		textFieldComentarios2 = new JTextField();
		textFieldComentarios2.setColumns(10);
		textFieldComentarios2.setBounds(235, 351, 164, 20);
		panelañadirpublicion.add(textFieldComentarios2);

		lblNewLabel_3_3_20 = new JLabel("Compartidos");
		lblNewLabel_3_3_20.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_20.setForeground(Color.WHITE);
		lblNewLabel_3_3_20.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_20.setBounds(461, 34, 164, 70);
		panelañadirpublicion.add(lblNewLabel_3_3_20);

		textFieldCompartidos2 = new JTextField();
		textFieldCompartidos2.setColumns(10);
		textFieldCompartidos2.setBounds(461, 93, 164, 20);
		panelañadirpublicion.add(textFieldCompartidos2);

		btnNewButton_1 = new JButton("Añadir");
		btnNewButton_1.setBounds(461, 147, 164, 23);
		panelañadirpublicion.add(btnNewButton_1);

		panelEliminarpubli = new JPanel();
		panelEliminarpubli.setBackground(Color.BLACK);
		panelEliminarpubli.setBounds(482, 217, 759, 444);
		panelModifcar.add(panelEliminarpubli);
		panelEliminarpubli.setLayout(null);
		panelEliminarpubli.setVisible(false);
		lblNewLabel_3_3_21 = new JLabel("ID CREADOR");
		lblNewLabel_3_3_21.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_21.setForeground(Color.WHITE);
		lblNewLabel_3_3_21.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_21.setBounds(285, 55, 164, 70);
		panelEliminarpubli.add(lblNewLabel_3_3_21);

		textFieldidcreador = new JTextField();
		textFieldidcreador.setColumns(10);
		textFieldidcreador.setBounds(191, 119, 351, 20);
		panelEliminarpubli.add(textFieldidcreador);

		lblNewLabel_3_3_22 = new JLabel("Fecha publicacion");
		lblNewLabel_3_3_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_22.setForeground(Color.WHITE);
		lblNewLabel_3_3_22.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_22.setBounds(191, 150, 351, 70);
		panelEliminarpubli.add(lblNewLabel_3_3_22);

		textFieldfecha = new JTextField();
		textFieldfecha.setColumns(10);
		textFieldfecha.setBounds(191, 231, 351, 20);
		panelEliminarpubli.add(textFieldfecha);

		btnEliminar2_1 = new JButton("Eliminar");
		btnEliminar2_1.setBounds(191, 315, 351, 23);
		panelEliminarpubli.add(btnEliminar2_1);

		panelInsertarColaboradores = new JPanel();
		panelInsertarColaboradores.setBackground(Color.BLACK);
		panelInsertarColaboradores.setBounds(482, 217, 759, 444);
		panelModifcar.add(panelInsertarColaboradores);
		panelInsertarColaboradores.setLayout(null);
		panelInsertarColaboradores.setVisible(false);

		lblNewLabel_3_3_10 = new JLabel("ID CREADOR");
		lblNewLabel_3_3_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_10.setForeground(Color.WHITE);
		lblNewLabel_3_3_10.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_10.setBounds(10, 33, 164, 70);
		panelInsertarColaboradores.add(lblNewLabel_3_3_10);

		textFieldCreador1 = new JTextField();
		textFieldCreador1.setColumns(10);
		textFieldCreador1.setBounds(10, 117, 164, 20);
		panelInsertarColaboradores.add(textFieldCreador1);

		JLabel lblNewLabel_3_3_1_1_2 = new JLabel("NOMBRE COLABORADOR");
		lblNewLabel_3_3_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_3_1_1_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_1_1_2.setBounds(10, 148, 283, 61);
		panelInsertarColaboradores.add(lblNewLabel_3_3_1_1_2);

		textFieldNombreColaborador = new JTextField();
		textFieldNombreColaborador.setColumns(10);
		textFieldNombreColaborador.setBounds(10, 220, 164, 20);
		panelInsertarColaboradores.add(textFieldNombreColaborador);

		JLabel lblNewLabel_3_3_1_1_1_2 = new JLabel("TEMATICA");
		lblNewLabel_3_3_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_3_1_1_1_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_1_1_1_2.setBounds(10, 251, 164, 61);
		panelInsertarColaboradores.add(lblNewLabel_3_3_1_1_1_2);

		textFieldTematica = new JTextField();
		textFieldTematica.setColumns(10);
		textFieldTematica.setBounds(10, 323, 164, 20);
		panelInsertarColaboradores.add(textFieldTematica);

		JLabel lblNewLabel_3_3_1_1_1_1_2 = new JLabel("FECHA FIN");
		lblNewLabel_3_3_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_3_1_1_1_1_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_1_1_1_1_2.setBounds(360, 42, 214, 61);
		panelInsertarColaboradores.add(lblNewLabel_3_3_1_1_1_1_2);

		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setColumns(10);
		textFieldFechaFin.setBounds(356, 114, 164, 20);
		panelInsertarColaboradores.add(textFieldFechaFin);

		lblNewLabel_3_3_1_1_1_1_3 = new JLabel("FECHA INICIO");
		lblNewLabel_3_3_1_1_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_1_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_3_3_1_1_1_1_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_1_1_1_1_3.setBounds(360, 148, 197, 61);
		panelInsertarColaboradores.add(lblNewLabel_3_3_1_1_1_1_3);

		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setColumns(10);
		textFieldFechaInicio.setBounds(360, 220, 160, 20);
		panelInsertarColaboradores.add(textFieldFechaInicio);

		lblNewLabel_3_3_1_1_1_1_1_2 = new JLabel("TIPO COLABORACION");
		lblNewLabel_3_3_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_1_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_3_1_1_1_1_1_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_1_1_1_1_1_2.setBounds(360, 251, 261, 61);
		panelInsertarColaboradores.add(lblNewLabel_3_3_1_1_1_1_1_2);

		textFieldTipoColaboracion = new JTextField();
		textFieldTipoColaboracion.setColumns(10);
		textFieldTipoColaboracion.setBounds(360, 323, 164, 20);
		panelInsertarColaboradores.add(textFieldTipoColaboracion);

		lblNewLabel_3_3_1_3 = new JLabel("ESTADO");
		lblNewLabel_3_3_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3_1_3.setForeground(Color.WHITE);
		lblNewLabel_3_3_1_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel_3_3_1_3.setBounds(10, 354, 389, 70);
		panelInsertarColaboradores.add(lblNewLabel_3_3_1_3);

		comboBoxEstadoColaboracion = new JComboBox();
		comboBoxEstadoColaboracion.setBounds(168, 386, 389, 22);
		panelInsertarColaboradores.add(comboBoxEstadoColaboracion);

		JButton btnInsertarC_1 = new JButton("Insetar");
		btnInsertarC_1.setBounds(597, 386, 152, 23);
		panelInsertarColaboradores.add(btnInsertarC_1);
		comboBoxelegiropciones = new JComboBox();
		comboBoxelegiropciones.setBounds(63, 250, 365, 22);
		panelModifcar.add(comboBoxelegiropciones);

		JLabel lblAadirexportarmodificar = new JLabel("Modificacion");
		lblAadirexportarmodificar.setBounds(361, 5, 605, 125);
		lblAadirexportarmodificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirexportarmodificar.setForeground(SystemColor.controlText);
		lblAadirexportarmodificar.setFont(new Font("Dialog", Font.BOLD, 99));
		panelModifcar.add(lblAadirexportarmodificar);

		JLabel lblSeleccioneOpcion = new JLabel("Seleccione Opcion");
		lblSeleccioneOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneOpcion.setForeground(SystemColor.controlText);
		lblSeleccioneOpcion.setFont(new Font("Dialog", Font.BOLD, 40));
		lblSeleccioneOpcion.setBounds(53, 120, 375, 125);
		panelModifcar.add(lblSeleccioneOpcion);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 376, 354, 285);
		panelModifcar.add(scrollPane);

		liststreamer = new JList();
		scrollPane.setViewportView(liststreamer);
		liststreamer.setBackground(Color.YELLOW);

		lblStreamer = new JLabel("Streamer");
		lblStreamer.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreamer.setForeground(SystemColor.controlText);
		lblStreamer.setFont(new Font("Dialog", Font.BOLD, 40));
		lblStreamer.setBounds(63, 266, 352, 125);
		panelModifcar.add(lblStreamer);

		lblCreado = new JLabel("");
		lblCreado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreado.setForeground(SystemColor.controlText);
		lblCreado.setFont(new Font("Dialog", Font.BOLD, 40));
		lblCreado.setBounds(482, 627, 758, 125);
		panelModifcar.add(lblCreado);


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
		btnInfoCreador = new JButton("Añadir/Eliminar/Modificar");
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
			imgEscalada1 = img1.getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH);
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

}

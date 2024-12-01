package Vsita;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import javax.swing.JTree;
import javax.swing.JTable;
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

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JButton btnVerStreamer;
	public JPanel panelmostrartodo;
	public JPanel panelprincipal;
	public JPanel panelMetrica;
	public JPanel InsertarColaboradores;
	public JButton btnInsertarC;
	public JButton btnInsertarnuevoscolaboradoresxt;
	public JButton btnañadirpublicacion;
	public JButton ModificarPublicaciones;
	public JButton btnResumerendimiento2023;
	public JButton btnEliminar;
	public JButton btnCrearinformerJson6;
	public JButton btnExportarcolaboracionescsv;
	public JButton btnVerMetrica;
	public JButton btnVolverMostrarTodo;
	public JButton btnExportarSeguidores;
	public JButton btnmodificarmegustaycomentarios;
	public JButton btnExportarColaboraciones;
	public JButton btnExportarcolaboracionesJSON12;
	public JButton btnVolverinicio;
	public JButton btnInsertarnuevoscolaboradores;
	public JComboBox comboBoxEstadoColaboracion;
	public JTextField textFieldCreador1;
	public JTextField textFieldNombreColaborador;
	public JTextField textFieldTematica;
	public JTextField textFieldFechaInicio;
	public JTextField textFieldFechaFin;
	public JTextField textFieldTipoColaboracion;
	public JPanel panelmostrarrendimiento;
	public JTable tabla;
	public JScrollPane scrollPane;
	public JScrollPane scrollPane_1;
	public JButton btnVolverMetrica;
	public JButton btnVolverInsertarColaboradores;
	public JLabel lblConformar;
	public JTable tableRendimiento;
	public JTextField textFieldidstreamermodificar;
	public JTextField textFieldplataformastreamermodificar;
	public JTextField textFieldmegustastreamermodificar;
	public JTextField textFieldcomentariosstreamermodificar;
	public JTextField textFieldmoficarcompartidos;
	public JPanel paneleliminarpublicacion;
	public JLabel lblNewLabel_3_7;
	public JTextField textFieldeliminaridstreamer;
	public JLabel lblNewLabel_3_3_3;
	public JLabel lblNewLabel_3_3_2_3;
	public JTextField textFieldeliminarplataforma;
	public JTextField textFieldeliminarmegusta;
	public JTextField textFieldeliminarcomentarios;
	public JTextField textFieldeliminarcompartidos;
	public JLabel lblNewLabel_3_3_2_4;
	public JLabel lblNewLabel_3_3_2_2_2;
	public JLabel textFieldcompartidosstreamermodificar_1;
	public JButton btnEliminardatos;
	public JPanel panel9;
	public JTable table;
	public JLabel lblNewLabel_3_8;
	public JLabel lblNewLabel_3_2_2;
	public JPanel panelañadirpublicacion;
	public JLabel lblNewLabel_3_9;
	public JTextField textField;
	public JLabel lblNewLabel_3_3_4;
	public JLabel lblNewLabel_3_3_2_5;
	public JTextField textField_1;
	public JLabel lblNewLabel_3_3_5;
	public JTextField textField_2;
	public JLabel lblNewLabel_3_3_6;
	public JTextField textField_3;
	public JLabel lblNewLabel_3_3_7;
	public JTextField textField_4;
	public JLabel lblNewLabel_3_3_8;
	public JTextField textField_5;
	public JTextField textField_6;
	public JLabel lblNewLabel_3_3_2_6;
	public JLabel lblNewLabel_3_3_2_7;
	public JTextField textField_7;
	public JLabel lblNewLabel_3_3_2_8;
	public JTextField textField_8;
	public JButton btnModificarpublicacion;
	public JPanel panelmodificarpublicacion;
	public JLabel lblNewLabel_3_10;
	public JTextField textFieldidstreamer;
	public JLabel lblNewLabel_3_3_9;
	public JLabel lblNewLabel_3_3_2_9;
	public JTextField textFieldfehca;
	public JButton btnmodificarpublicacion;
	public JPanel paneleliminarminimo;
	public JLabel lblNewLabel_3_11;
	public JLabel lblNewLabel_3_3_2_13;
	public JTextField textField_19;
	public JLabel lblNewLabel_3_3_17;
	public JTextField textField_22;
	public JButton btneliminarpublicacionpormegustas;
	public JButton btneliminarminimo;
	public JPanel panelmodificarpublicaciones;
	public JLabel lblmostrarsiseaexportado;
	public JButton btnComparar;
	public JTextField textField_18;
	public JLabel lblNewLabel_3_13;
	public JButton btnNewButton;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_3_14;
	public JLabel lblreusltadorendimiento;
	public JLabel lblNewLabel_3_16;
	public JLabel lblpROMECIOVISTA;
	public JLabel lblNewLabel_3_18;
	public JLabel lblmegusta;
	public JPanel panelComparativaRendimiendo;
	public Object blreusltadorendimiento;
	public JComboBox comboBoxparaModificar;
	public JLabel lblNewLabel_3_3_2_10;
	public JTextField textFieldDato;
	public JLabel lblNotificar;
	public JTextField textFieldidcreador;
	public JTextField textFieldfecha;
	public JPanel panelEliminarpublicaciones;
	public JLabel lblNewLabelConfirmar;
	public JButton btnEliminar2;
	public JTable tabletasacrecimiento2023;
	public JPanel panelcrecimientoseguidores;
	public JTextField textFieldidcreador1;
	public JTextField textFieldplataforma2;
	public JTextField textFieldFecha2;
	public JTextField textFieldContenido2;
	public JTextField textFieldTipo2;
	public JTextField textFieldVistas2;
	public JTextField textFieldMeGsuta2;
	public JTextField textFieldComentarios2;
	public JTextField textFieldCompartidos2;
	public JPanel panelAñadirNuevaPublicacion;
	public JLabel lblNewLabelCreado;
	public JPanel panelModificarMeGusta_yComentarios;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JTextField textFieldid_creador3;
	public JLabel lblNewLabel_4;
	public JTextField textFieldFechaContenido3;
	public JLabel lblNewLabel_5;
	public JTextField textFieldel_plataforma3;
	public JLabel lblNewLabel_6;
	public JTextField textField_megusta2;
	public JLabel lblNewLabel_7;
	public JTextField textField_ModificarComentarios;
	public JButton btnNewButton_Modificarmegustas;
	public JPanel panel_Eliminar_Minimo_Visitas;
	public JLabel lblNewLabel_8;
	public JLabel lblNewLabel_9;
	public JTextField textFieldMinVistas;
	public JButton btnNewButtonEliminarminimovistas;
	public JLabel lblNewLabel_Eliminar_MinimoVistas;
	public JButton btnNewButtonAñadir;
	public Object eliminarPublicacionesPorVistas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					Controlador controlador=new Controlador(frame);
					frame.setVisible(true);
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
		setBounds(100, 100, 1683, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		           
		           panel_Eliminar_Minimo_Visitas = new JPanel();
		           panel_Eliminar_Minimo_Visitas.setBackground(new Color(0, 0, 0));
		           panel_Eliminar_Minimo_Visitas.setBounds(0, 0, 1657, 537);
		           contentPane.add(panel_Eliminar_Minimo_Visitas);
		           panel_Eliminar_Minimo_Visitas.setLayout(null);
		           panel_Eliminar_Minimo_Visitas.setVisible(false);
		           lblNewLabel_8 = new JLabel("StreamerFocus");
		           lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_8.setForeground(new Color(64, 128, 128));
		           lblNewLabel_8.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_8.setBounds(502, 11, 771, 99);
		           panel_Eliminar_Minimo_Visitas.add(lblNewLabel_8);
		           
		           lblNewLabel_9 = new JLabel("Minimo de visitas");
		           lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_9.setForeground(new Color(64, 128, 128));
		           lblNewLabel_9.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_9.setBounds(157, 145, 388, 99);
		           panel_Eliminar_Minimo_Visitas.add(lblNewLabel_9);
		           
		           textFieldMinVistas = new JTextField();
		           textFieldMinVistas.setBounds(157, 255, 388, 20);
		           panel_Eliminar_Minimo_Visitas.add(textFieldMinVistas);
		           textFieldMinVistas.setColumns(10);
		           
		           btnNewButtonEliminarminimovistas = new JButton("Eliminar");
		           btnNewButtonEliminarminimovistas.addActionListener(new ActionListener() {
		           	public void actionPerformed(ActionEvent e) {
		           	}
		           });
		           btnNewButtonEliminarminimovistas.setBounds(157, 286, 388, 23);
		           panel_Eliminar_Minimo_Visitas.add(btnNewButtonEliminarminimovistas);
		           
		           lblNewLabel_Eliminar_MinimoVistas = new JLabel("");
		           lblNewLabel_Eliminar_MinimoVistas.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_Eliminar_MinimoVistas.setForeground(new Color(64, 128, 128));
		           lblNewLabel_Eliminar_MinimoVistas.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_Eliminar_MinimoVistas.setBounds(157, 320, 388, 99);
		           panel_Eliminar_Minimo_Visitas.add(lblNewLabel_Eliminar_MinimoVistas);
		           panel_Eliminar_Minimo_Visitas.setVisible(false);
		          
		           panelAñadirNuevaPublicacion = new JPanel();
		           panelAñadirNuevaPublicacion.setBackground(new Color(0, 0, 0));
		           panelAñadirNuevaPublicacion.setBounds(0, 0, 1657, 548);
		           contentPane.add(panelAñadirNuevaPublicacion);
		           panelAñadirNuevaPublicacion.setLayout(null);
		           panelAñadirNuevaPublicacion.setVisible(false);
		           JLabel lblNewLabel_3_19 = new JLabel("StreamerFocus");
		           lblNewLabel_3_19.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_3_19.setForeground(new Color(64, 128, 128));
		           lblNewLabel_3_19.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_3_19.setBounds(503, 11, 771, 99);
		           panelAñadirNuevaPublicacion.add(lblNewLabel_3_19);
		           
		           JLabel lblNewLabel_3_20 = new JLabel("Id_Creador");
		           lblNewLabel_3_20.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_3_20.setForeground(new Color(64, 128, 128));
		           lblNewLabel_3_20.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_3_20.setBounds(48, 113, 289, 99);
		           panelAñadirNuevaPublicacion.add(lblNewLabel_3_20);
		           
		           textFieldidcreador1 = new JTextField();
		           textFieldidcreador1.setBounds(58, 223, 244, 20);
		           panelAñadirNuevaPublicacion.add(textFieldidcreador1);
		           textFieldidcreador1.setColumns(10);
		           
		           JLabel lblNewLabel_3_20_1 = new JLabel("Plataforma");
		           lblNewLabel_3_20_1.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_3_20_1.setForeground(new Color(64, 128, 128));
		           lblNewLabel_3_20_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_3_20_1.setBounds(48, 254, 289, 99);
		           panelAñadirNuevaPublicacion.add(lblNewLabel_3_20_1);
		           
		           textFieldplataforma2 = new JTextField();
		           textFieldplataforma2.setColumns(10);
		           textFieldplataforma2.setBounds(58, 334, 244, 20);
		           panelAñadirNuevaPublicacion.add(textFieldplataforma2);
		           
		           JLabel lblNewLabel_3_20_1_1 = new JLabel("Fecha");
		           lblNewLabel_3_20_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_3_20_1_1.setForeground(new Color(64, 128, 128));
		           lblNewLabel_3_20_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_3_20_1_1.setBounds(392, 121, 289, 99);
		           panelAñadirNuevaPublicacion.add(lblNewLabel_3_20_1_1);
		           
		           textFieldFecha2 = new JTextField();
		           textFieldFecha2.setColumns(10);
		           textFieldFecha2.setBounds(402, 223, 244, 20);
		           panelAñadirNuevaPublicacion.add(textFieldFecha2);
		           
		           JLabel lblNewLabel_3_20_1_1_1 = new JLabel("Contenido");
		           lblNewLabel_3_20_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_3_20_1_1_1.setForeground(new Color(64, 128, 128));
		           lblNewLabel_3_20_1_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_3_20_1_1_1.setBounds(392, 254, 289, 99);
		           panelAñadirNuevaPublicacion.add(lblNewLabel_3_20_1_1_1);
		           
		           textFieldContenido2 = new JTextField();
		           textFieldContenido2.setColumns(10);
		           textFieldContenido2.setBounds(392, 334, 254, 20);
		           panelAñadirNuevaPublicacion.add(textFieldContenido2);
		           
		           JLabel lblNewLabel_3_20_1_1_2 = new JLabel("Tipo");
		           lblNewLabel_3_20_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_3_20_1_1_2.setForeground(new Color(64, 128, 128));
		           lblNewLabel_3_20_1_1_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_3_20_1_1_2.setBounds(721, 113, 289, 99);
		           panelAñadirNuevaPublicacion.add(lblNewLabel_3_20_1_1_2);
		           
		           textFieldTipo2 = new JTextField();
		           textFieldTipo2.setColumns(10);
		           textFieldTipo2.setBounds(731, 223, 244, 20);
		           panelAñadirNuevaPublicacion.add(textFieldTipo2);
		           
		           JLabel lblNewLabel_3_20_1_1_2_1 = new JLabel("Vistas");
		           lblNewLabel_3_20_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_3_20_1_1_2_1.setForeground(new Color(64, 128, 128));
		           lblNewLabel_3_20_1_1_2_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_3_20_1_1_2_1.setBounds(721, 254, 289, 99);
		           panelAñadirNuevaPublicacion.add(lblNewLabel_3_20_1_1_2_1);
		           
		           textFieldVistas2 = new JTextField();
		           textFieldVistas2.setColumns(10);
		           textFieldVistas2.setBounds(731, 334, 244, 20);
		           panelAñadirNuevaPublicacion.add(textFieldVistas2);
		           
		           JLabel lblNewLabel_3_20_1_1_2_2 = new JLabel("Me Gustas");
		           lblNewLabel_3_20_1_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_3_20_1_1_2_2.setForeground(new Color(64, 128, 128));
		           lblNewLabel_3_20_1_1_2_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_3_20_1_1_2_2.setBounds(1035, 121, 289, 99);
		           panelAñadirNuevaPublicacion.add(lblNewLabel_3_20_1_1_2_2);
		           
		           textFieldMeGsuta2 = new JTextField();
		           textFieldMeGsuta2.setColumns(10);
		           textFieldMeGsuta2.setBounds(1045, 223, 244, 20);
		           panelAñadirNuevaPublicacion.add(textFieldMeGsuta2);
		           
		           JLabel lblNewLabel_3_20_1_1_2_2_1 = new JLabel("Comentarios");
		           lblNewLabel_3_20_1_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_3_20_1_1_2_2_1.setForeground(new Color(64, 128, 128));
		           lblNewLabel_3_20_1_1_2_2_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_3_20_1_1_2_2_1.setBounds(1035, 254, 289, 99);
		           panelAñadirNuevaPublicacion.add(lblNewLabel_3_20_1_1_2_2_1);
		           
		           textFieldComentarios2 = new JTextField();
		           textFieldComentarios2.setColumns(10);
		           textFieldComentarios2.setBounds(1045, 333, 244, 20);
		           panelAñadirNuevaPublicacion.add(textFieldComentarios2);
		           
		           JLabel lblNewLabel_3_20_1_1_2_2_2 = new JLabel("Compartidos");
		           lblNewLabel_3_20_1_1_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabel_3_20_1_1_2_2_2.setForeground(new Color(64, 128, 128));
		           lblNewLabel_3_20_1_1_2_2_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabel_3_20_1_1_2_2_2.setBounds(1334, 121, 289, 99);
		           panelAñadirNuevaPublicacion.add(lblNewLabel_3_20_1_1_2_2_2);
		           
		           textFieldCompartidos2 = new JTextField();
		           textFieldCompartidos2.setColumns(10);
		           textFieldCompartidos2.setBounds(1344, 223, 244, 20);
		           panelAñadirNuevaPublicacion.add(textFieldCompartidos2);
		           
		            btnNewButtonAñadir = new JButton("Añadir");
		            btnNewButtonAñadir.setBounds(1344, 333, 244, 23);
		            panelAñadirNuevaPublicacion.add(btnNewButtonAñadir);
		            
		             lblNewLabelCreado = new JLabel("");
		             lblNewLabelCreado.setHorizontalAlignment(SwingConstants.CENTER);
		             lblNewLabelCreado.setForeground(new Color(64, 128, 128));
		             lblNewLabelCreado.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		             lblNewLabelCreado.setBounds(459, 413, 804, 99);
		             panelAñadirNuevaPublicacion.add(lblNewLabelCreado);
		          panelModificarMeGusta_yComentarios = new JPanel();
		          panelModificarMeGusta_yComentarios.setBackground(new Color(0, 0, 0));
		          panelModificarMeGusta_yComentarios.setBounds(0, 0, 1657, 537);
		          contentPane.add(panelModificarMeGusta_yComentarios);
		          panelModificarMeGusta_yComentarios.setLayout(null);
		          panelModificarMeGusta_yComentarios.setVisible(false);
		          lblNewLabel_1 = new JLabel("StreamerFocus");
		          lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		          lblNewLabel_1.setForeground(new Color(64, 128, 128));
		          lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		          lblNewLabel_1.setBounds(496, 11, 771, 99);
		          panelModificarMeGusta_yComentarios.add(lblNewLabel_1);
		          
		          lblNewLabel_2 = new JLabel("ID_CREADOR");
		          lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		          lblNewLabel_2.setForeground(new Color(64, 128, 128));
		          lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		          lblNewLabel_2.setBounds(10, 121, 343, 99);
		          panelModificarMeGusta_yComentarios.add(lblNewLabel_2);
		          
		          textFieldid_creador3 = new JTextField();
		          textFieldid_creador3.setBounds(10, 231, 343, 20);
		          panelModificarMeGusta_yComentarios.add(textFieldid_creador3);
		          textFieldid_creador3.setColumns(10);
		          
		          lblNewLabel_4 = new JLabel("Fecha");
		          lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		          lblNewLabel_4.setForeground(new Color(64, 128, 128));
		          lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		          lblNewLabel_4.setBounds(10, 262, 343, 99);
		          panelModificarMeGusta_yComentarios.add(lblNewLabel_4);
		          
		          textFieldFechaContenido3 = new JTextField();
		          textFieldFechaContenido3.setColumns(10);
		          textFieldFechaContenido3.setBounds(10, 372, 343, 20);
		          panelModificarMeGusta_yComentarios.add(textFieldFechaContenido3);
		          
		          lblNewLabel_5 = new JLabel("Plataforma");
		          lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		          lblNewLabel_5.setForeground(new Color(64, 128, 128));
		          lblNewLabel_5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		          lblNewLabel_5.setBounds(478, 121, 343, 99);
		          panelModificarMeGusta_yComentarios.add(lblNewLabel_5);
		          
		          textFieldel_plataforma3 = new JTextField();
		          textFieldel_plataforma3.setColumns(10);
		          textFieldel_plataforma3.setBounds(478, 231, 343, 20);
		          panelModificarMeGusta_yComentarios.add(textFieldel_plataforma3);
		          
		          lblNewLabel_6 = new JLabel("Me Gustas");
		          lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		          lblNewLabel_6.setForeground(new Color(64, 128, 128));
		          lblNewLabel_6.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		          lblNewLabel_6.setBounds(478, 262, 343, 99);
		          panelModificarMeGusta_yComentarios.add(lblNewLabel_6);
		          
		          textField_megusta2 = new JTextField();
		          textField_megusta2.setColumns(10);
		          textField_megusta2.setBounds(478, 372, 343, 20);
		          panelModificarMeGusta_yComentarios.add(textField_megusta2);
		          
		          lblNewLabel_7 = new JLabel("Comentarios");
		          lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		          lblNewLabel_7.setForeground(new Color(64, 128, 128));
		          lblNewLabel_7.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		          lblNewLabel_7.setBounds(924, 121, 343, 99);
		          panelModificarMeGusta_yComentarios.add(lblNewLabel_7);
		          
		          textField_ModificarComentarios = new JTextField();
		          textField_ModificarComentarios.setColumns(10);
		          textField_ModificarComentarios.setBounds(924, 231, 343, 20);
		          panelModificarMeGusta_yComentarios.add(textField_ModificarComentarios);
		          
		          btnNewButton_Modificarmegustas = new JButton("Modificar");
		          btnNewButton_Modificarmegustas.setBounds(924, 371, 343, 23);
		          panelModificarMeGusta_yComentarios.add(btnNewButton_Modificarmegustas);
		         
		          panelEliminarpublicaciones = new JPanel();
		          panelEliminarpublicaciones.setBackground(new Color(0, 0, 0));
		          panelEliminarpublicaciones.setBounds(0, 0, 1657, 548);
		          contentPane.add(panelEliminarpublicaciones);
		          panelEliminarpublicaciones.setLayout(null);
		          panelEliminarpublicaciones.setVisible(false);
		          JLabel lblNewLabel_3_15 = new JLabel("StreamerFocus");
		          lblNewLabel_3_15.setHorizontalAlignment(SwingConstants.CENTER);
		          lblNewLabel_3_15.setForeground(new Color(64, 128, 128));
		          lblNewLabel_3_15.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		          lblNewLabel_3_15.setBounds(500, 11, 771, 99);
		          panelEliminarpublicaciones.add(lblNewLabel_3_15);
		          panelEliminarpublicaciones.setVisible(false);
		          JLabel lblNewLabel_3_15_1 = new JLabel("ID CREADOR");
		          lblNewLabel_3_15_1.setHorizontalAlignment(SwingConstants.CENTER);
		          lblNewLabel_3_15_1.setForeground(new Color(64, 128, 128));
		          lblNewLabel_3_15_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		          lblNewLabel_3_15_1.setBounds(-21, 123, 691, 99);
		          panelEliminarpublicaciones.add(lblNewLabel_3_15_1);
		          
		          textFieldidcreador = new JTextField();
		          textFieldidcreador.setBounds(125, 233, 417, 20);
		          panelEliminarpublicaciones.add(textFieldidcreador);
		          textFieldidcreador.setColumns(10);
		          
		          JLabel lblNewLabel_3_15_1_1 = new JLabel("FECHA PUBLICACION");
		          lblNewLabel_3_15_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		          lblNewLabel_3_15_1_1.setForeground(new Color(64, 128, 128));
		          lblNewLabel_3_15_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		          lblNewLabel_3_15_1_1.setBounds(-21, 264, 691, 99);
		          panelEliminarpublicaciones.add(lblNewLabel_3_15_1_1);
		          
		          textFieldfecha = new JTextField();
		          textFieldfecha.setColumns(10);
		          textFieldfecha.setBounds(125, 388, 417, 20);
		          panelEliminarpublicaciones.add(textFieldfecha);
		          
		           btnEliminar2 = new JButton("Eliminar");
		           btnEliminar2.setBounds(818, 317, 259, 23);
		           panelEliminarpublicaciones.add(btnEliminar2);
		           
		           lblNewLabelConfirmar = new JLabel("");
		           lblNewLabelConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabelConfirmar.setForeground(new Color(64, 128, 128));
		           lblNewLabelConfirmar.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		           lblNewLabelConfirmar.setBounds(644, 180, 771, 99);
		           panelEliminarpublicaciones.add(lblNewLabelConfirmar);
		         
		         panelprincipal = new JPanel();
		         panelprincipal.setBackground(new Color(0, 0, 0));
		         panelprincipal.setBounds(0, 0, 1657, 548);
		         contentPane.add(panelprincipal);
		         panelprincipal.setLayout(null);
		         
		          btnVerStreamer = new JButton("Mirar Streamer");
		          btnVerStreamer.setBounds(57, 199, 197, 66);
		          panelprincipal.add(btnVerStreamer);
		          
		          JLabel lblNewLabel_3 = new JLabel("StreamerFocus");
		          lblNewLabel_3.setBounds(503, 11, 771, 99);
		          panelprincipal.add(lblNewLabel_3);
		          lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		          lblNewLabel_3.setForeground(new Color(64, 128, 128));
		          lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		          
		          btnInsertarnuevoscolaboradores = new JButton("Insertar colaboradores");
		          btnInsertarnuevoscolaboradores.setBounds(322, 199, 197, 66);
		          panelprincipal.add(btnInsertarnuevoscolaboradores);
		          
		           btnañadirpublicacion = new JButton("Añadir publicacion");
		           btnañadirpublicacion.addActionListener(new ActionListener() {
		           	public void actionPerformed(ActionEvent e) {
		           	}
		           });
		           btnañadirpublicacion.setBounds(322, 286, 197, 66);
		           panelprincipal.add(btnañadirpublicacion);
		           
		           ModificarPublicaciones = new JButton(" Publicaciones");
		           ModificarPublicaciones.setBounds(866, 286, 197, 66);
		           panelprincipal.add(ModificarPublicaciones);
		           
		            btnResumerendimiento2023 = new JButton("Tasa de Crecimient");
		            btnResumerendimiento2023.addActionListener(new ActionListener() {
		            	public void actionPerformed(ActionEvent e) {
		            	}
		            });
		            btnResumerendimiento2023.setBounds(57, 366, 197, 66);
		            panelprincipal.add(btnResumerendimiento2023);
		            
		             btnEliminar = new JButton("Eliminar Publicaciones");
		             btnEliminar.setBounds(593, 199, 197, 66);
		             panelprincipal.add(btnEliminar);
		             
		              btnCrearinformerJson6 = new JButton("6");
		              btnCrearinformerJson6.setBounds(1145, 286, 154, 66);
		              panelprincipal.add(btnCrearinformerJson6);
		              
		              btnExportarcolaboracionescsv = new JButton("4");
		              btnExportarcolaboracionescsv.addActionListener(new ActionListener() {
		              	public void actionPerformed(ActionEvent e) {
		              	}
		              });
		              btnExportarcolaboracionescsv.setBounds(1145, 199, 154, 66);
		              panelprincipal.add(btnExportarcolaboracionescsv);
		              
		               btnVerMetrica = new JButton("Rendimiento");
		               btnVerMetrica.setBounds(57, 286, 197, 66);
		               panelprincipal.add(btnVerMetrica);
		               
		                btnExportarSeguidores = new JButton("10");
		                btnExportarSeguidores.setBounds(1309, 199, 154, 66);
		                panelprincipal.add(btnExportarSeguidores);
		                
		                 btnmodificarmegustaycomentarios = new JButton("Modificar Publicacion");
		                 btnmodificarmegustaycomentarios.setBounds(866, 199, 197, 66);
		                 panelprincipal.add(btnmodificarmegustaycomentarios);
		                 
		                  btnExportarColaboraciones = new JButton("8");
		                  btnExportarColaboraciones.setBounds(1309, 286, 154, 66);
		                  panelprincipal.add(btnExportarColaboraciones);
		                  
		                   btnExportarcolaboracionesJSON12 = new JButton("12");
		                   btnExportarcolaboracionesJSON12.addActionListener(new ActionListener() {
		                   	public void actionPerformed(ActionEvent e) {
		                   	}
		                   });
		                   btnExportarcolaboracionesJSON12.setBounds(1232, 366, 154, 66);
		                   panelprincipal.add(btnExportarcolaboracionesJSON12);
		                   
		                   JLabel lblNewLabel_3_1 = new JLabel("Ver  datos");
		                   lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		                   lblNewLabel_3_1.setForeground(new Color(64, 128, 128));
		                   lblNewLabel_3_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		                   lblNewLabel_3_1.setBounds(57, 89, 197, 99);
		                   panelprincipal.add(lblNewLabel_3_1);
		                   
		                   JLabel lblNewLabel_3_1_1 = new JLabel("Añadir");
		                   lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		                   lblNewLabel_3_1_1.setForeground(new Color(64, 128, 128));
		                   lblNewLabel_3_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		                   lblNewLabel_3_1_1.setBounds(322, 89, 197, 99);
		                   panelprincipal.add(lblNewLabel_3_1_1);
		                   
		                   JLabel lblNewLabel_3_1_1_1 = new JLabel("Eliminar");
		                   lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		                   lblNewLabel_3_1_1_1.setForeground(new Color(64, 128, 128));
		                   lblNewLabel_3_1_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		                   lblNewLabel_3_1_1_1.setBounds(593, 89, 197, 99);
		                   panelprincipal.add(lblNewLabel_3_1_1_1);
		                   
		                   JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Editar");
		                   lblNewLabel_3_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		                   lblNewLabel_3_1_1_1_1.setForeground(new Color(64, 128, 128));
		                   lblNewLabel_3_1_1_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		                   lblNewLabel_3_1_1_1_1.setBounds(866, 100, 197, 99);
		                   panelprincipal.add(lblNewLabel_3_1_1_1_1);
		                   
		                   JLabel lblNewLabel_3_1_1_2 = new JLabel("Exportar");
		                   lblNewLabel_3_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		                   lblNewLabel_3_1_1_2.setForeground(new Color(64, 128, 128));
		                   lblNewLabel_3_1_1_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		                   lblNewLabel_3_1_1_2.setBounds(1185, 89, 197, 99);
		                   panelprincipal.add(lblNewLabel_3_1_1_2);
		                   
		                    lblmostrarsiseaexportado = new JLabel("");
		                    lblmostrarsiseaexportado.setHorizontalAlignment(SwingConstants.CENTER);
		                    lblmostrarsiseaexportado.setForeground(new Color(64, 128, 128));
		                    lblmostrarsiseaexportado.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		                    lblmostrarsiseaexportado.setBounds(571, 407, 651, 99);
		                    panelprincipal.add(lblmostrarsiseaexportado);
		                    
		                    btneliminarminimo = new JButton("Eliminar minimo");
		                    btneliminarminimo.setBounds(593, 286, 197, 66);
		                    panelprincipal.add(btneliminarminimo);
		                    
		                    JLabel lblNewLabel_3_1_1_3 = new JLabel("Comparativa");
		                    lblNewLabel_3_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		                    lblNewLabel_3_1_1_3.setForeground(new Color(64, 128, 128));
		                    lblNewLabel_3_1_1_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		                    lblNewLabel_3_1_1_3.setBounds(-38, 11, 482, 99);
		                    panelprincipal.add(lblNewLabel_3_1_1_3);
		                    
		                    btnComparar = new JButton("Comparar");
		                    btnComparar.setBounds(436, 23, 197, 66);
		                    panelprincipal.add(btnComparar);
		       
		        panelcrecimientoseguidores = new JPanel();
		       panelcrecimientoseguidores.setBackground(new Color(0, 0, 0));
		       panelcrecimientoseguidores.setBounds(0, 0, 1657, 548);
		       contentPane.add(panelcrecimientoseguidores);
		       panelcrecimientoseguidores.setLayout(null);
		       panelcrecimientoseguidores.setVisible(false);
		       JLabel lblNewLabel_3_17 = new JLabel("StreamerFocus");
		       lblNewLabel_3_17.setHorizontalAlignment(SwingConstants.CENTER);
		       lblNewLabel_3_17.setForeground(new Color(64, 128, 128));
		       lblNewLabel_3_17.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		       lblNewLabel_3_17.setBounds(412, 11, 771, 99);
		       panelcrecimientoseguidores.add(lblNewLabel_3_17);
		       
		       tabletasacrecimiento2023 = new JTable();
		       tabletasacrecimiento2023.setBounds(389, 301, 896, 173);
		       panelcrecimientoseguidores.add(tabletasacrecimiento2023);
		       
		       JLabel lblNewLabel_3_17_1 = new JLabel("Tasa de crecimiento de seguidores 2023");
		       lblNewLabel_3_17_1.setHorizontalAlignment(SwingConstants.CENTER);
		       lblNewLabel_3_17_1.setForeground(new Color(64, 128, 128));
		       lblNewLabel_3_17_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		       lblNewLabel_3_17_1.setBounds(457, 200, 771, 99);
		       panelcrecimientoseguidores.add(lblNewLabel_3_17_1);
		       
		       panelMetrica = new JPanel();
		       panelMetrica.setBackground(new Color(0, 0, 0));
		       panelMetrica.setBounds(0, 0, 1657, 548);
		       contentPane.add(panelMetrica);
		       panelMetrica.setLayout(null);
		       panelMetrica.setVisible(false);
		       
		       scrollPane_1 = new JScrollPane();
		       scrollPane_1.setBounds(360, 291, 1060, 209);
		       panelMetrica.add(scrollPane_1);
		       
		       JLabel lblNewLabel_3_5 = new JLabel("StreamerFocus");
		       lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		       lblNewLabel_3_5.setForeground(new Color(64, 128, 128));
		       lblNewLabel_3_5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		       lblNewLabel_3_5.setBounds(504, 11, 771, 99);
		       panelMetrica.add(lblNewLabel_3_5);
		       
		        btnVolverMetrica = new JButton("Volver");
		        
		         btnVolverMetrica.setBounds(1568, 0, 89, 51);
		         panelMetrica.add(btnVolverMetrica);
		         
		         JLabel lblNewLabel_3_4_1_1 = new JLabel("Aqui puede ver el promedio de vistas y de me gustas de todos los streamer");
		         lblNewLabel_3_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		         lblNewLabel_3_4_1_1.setForeground(new Color(64, 128, 128));
		         lblNewLabel_3_4_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		         lblNewLabel_3_4_1_1.setBounds(10, 165, 1637, 99);
		         panelMetrica.add(lblNewLabel_3_4_1_1);
		      
		      panelmodificarpublicacion = new JPanel();
		      panelmodificarpublicacion.setLayout(null);
		      panelmodificarpublicacion.setBackground(Color.BLACK);
		      panelmodificarpublicacion.setBounds(0, 0, 1657, 548);
		      contentPane.add(panelmodificarpublicacion);
		      panelmodificarpublicacion.setVisible(false);
		      lblNewLabel_3_10 = new JLabel("StreamerFocus");
		      lblNewLabel_3_10.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel_3_10.setForeground(new Color(64, 128, 128));
		      lblNewLabel_3_10.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblNewLabel_3_10.setBounds(692, 11, 274, 67);
		      panelmodificarpublicacion.add(lblNewLabel_3_10);
		      
		      textFieldidstreamer = new JTextField();
		      textFieldidstreamer.setColumns(10);
		      textFieldidstreamer.setBounds(66, 187, 389, 20);
		      panelmodificarpublicacion.add(textFieldidstreamer);
		      
		      lblNewLabel_3_3_9 = new JLabel("Id Streamer");
		      lblNewLabel_3_3_9.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel_3_3_9.setForeground(new Color(64, 128, 128));
		      lblNewLabel_3_3_9.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblNewLabel_3_3_9.setBounds(66, 72, 389, 99);
		      panelmodificarpublicacion.add(lblNewLabel_3_3_9);
		      
		      lblNewLabel_3_3_2_9 = new JLabel("¿De que fecha?");
		      lblNewLabel_3_3_2_9.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel_3_3_2_9.setForeground(new Color(64, 128, 128));
		      lblNewLabel_3_3_2_9.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblNewLabel_3_3_2_9.setBounds(609, 222, 389, 99);
		      panelmodificarpublicacion.add(lblNewLabel_3_3_2_9);
		      
		      textFieldfehca = new JTextField();
		      textFieldfehca.setColumns(10);
		      textFieldfehca.setBounds(609, 338, 389, 20);
		      panelmodificarpublicacion.add(textFieldfehca);
		      
		      btnmodificarpublicacion = new JButton("Modificar");
		      btnmodificarpublicacion.setBounds(1476, 337, 89, 23);
		      panelmodificarpublicacion.add(btnmodificarpublicacion);
		      
		      JLabel lblNewLabel_3_3_9_1 = new JLabel("¿Que quieres modificar?");
		      lblNewLabel_3_3_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel_3_3_9_1.setForeground(new Color(64, 128, 128));
		      lblNewLabel_3_3_9_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblNewLabel_3_3_9_1.setBounds(76, 228, 452, 99);
		      panelmodificarpublicacion.add(lblNewLabel_3_3_9_1);
		      
		       comboBoxparaModificar = new JComboBox();
		       comboBoxparaModificar.setBounds(79, 337, 444, 22);
		       panelmodificarpublicacion.add(comboBoxparaModificar);
		       
		       lblNewLabel_3_3_2_10 = new JLabel("Dato");
		       lblNewLabel_3_3_2_10.setHorizontalAlignment(SwingConstants.CENTER);
		       lblNewLabel_3_3_2_10.setForeground(new Color(64, 128, 128));
		       lblNewLabel_3_3_2_10.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		       lblNewLabel_3_3_2_10.setBounds(1025, 222, 389, 99);
		       panelmodificarpublicacion.add(lblNewLabel_3_3_2_10);
		       
		       textFieldDato = new JTextField();
		       textFieldDato.setColumns(10);
		       textFieldDato.setBounds(1025, 338, 389, 20);
		       panelmodificarpublicacion.add(textFieldDato);
		       
		       lblNotificar = new JLabel("");
		       lblNotificar.setHorizontalAlignment(SwingConstants.CENTER);
		       lblNotificar.setForeground(new Color(64, 128, 128));
		       lblNotificar.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		       lblNotificar.setBounds(1234, 98, 389, 99);
		       panelmodificarpublicacion.add(lblNotificar);
		     
		      panelComparativaRendimiendo = new JPanel();
		      panelComparativaRendimiendo.setBackground(new Color(0, 0, 0));
		      panelComparativaRendimiendo.setBounds(0, 0, 1657, 548);
		      contentPane.add(panelComparativaRendimiendo);
		      panelComparativaRendimiendo.setLayout(null);
		      panelComparativaRendimiendo.setVisible(false);
		      JLabel lblNewLabel_3_12 = new JLabel("StreamerFocus");
		      lblNewLabel_3_12.setBounds(690, 11, 274, 67);
		      lblNewLabel_3_12.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel_3_12.setForeground(new Color(64, 128, 128));
		      lblNewLabel_3_12.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      panelComparativaRendimiendo.add(lblNewLabel_3_12);
		      
		      textField_18 = new JTextField();
		      textField_18.setBounds(112, 221, 322, 20);
		      panelComparativaRendimiendo.add(textField_18);
		      textField_18.setColumns(10);
		      
		      lblNewLabel_3_13 = new JLabel("Nombre Streamer");
		      lblNewLabel_3_13.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel_3_13.setForeground(new Color(64, 128, 128));
		      lblNewLabel_3_13.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblNewLabel_3_13.setBounds(82, 141, 386, 67);
		      panelComparativaRendimiendo.add(lblNewLabel_3_13);
		      
		      btnNewButton = new JButton("Comparar");
		      btnNewButton.setBounds(112, 277, 322, 23);
		      panelComparativaRendimiendo.add(btnNewButton);
		      
		      lblNewLabel = new JLabel("New label");
		      lblNewLabel.setBounds(422, 99, 46, 14);
		      panelComparativaRendimiendo.add(lblNewLabel);
		      
		      lblNewLabel_3_14 = new JLabel("Resultado");
		      lblNewLabel_3_14.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel_3_14.setForeground(new Color(64, 128, 128));
		      lblNewLabel_3_14.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblNewLabel_3_14.setBounds(513, 141, 386, 67);
		      panelComparativaRendimiendo.add(lblNewLabel_3_14);
		      
		      lblreusltadorendimiento = new JLabel("");
		      lblreusltadorendimiento.setHorizontalAlignment(SwingConstants.CENTER);
		      lblreusltadorendimiento.setForeground(new Color(64, 128, 128));
		      lblreusltadorendimiento.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblreusltadorendimiento.setBounds(513, 221, 386, 67);
		      panelComparativaRendimiendo.add(lblreusltadorendimiento);
		      
		      lblNewLabel_3_16 = new JLabel("Promedio vista");
		      lblNewLabel_3_16.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel_3_16.setForeground(new Color(64, 128, 128));
		      lblNewLabel_3_16.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblNewLabel_3_16.setBounds(867, 141, 386, 67);
		      panelComparativaRendimiendo.add(lblNewLabel_3_16);
		      
		      lblpROMECIOVISTA = new JLabel("");
		      lblpROMECIOVISTA.setHorizontalAlignment(SwingConstants.CENTER);
		      lblpROMECIOVISTA.setForeground(new Color(64, 128, 128));
		      lblpROMECIOVISTA.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblpROMECIOVISTA.setBounds(867, 221, 386, 67);
		      panelComparativaRendimiendo.add(lblpROMECIOVISTA);
		      
		      lblNewLabel_3_18 = new JLabel("Me gusta");
		      lblNewLabel_3_18.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel_3_18.setForeground(new Color(64, 128, 128));
		      lblNewLabel_3_18.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblNewLabel_3_18.setBounds(1261, 141, 386, 67);
		      panelComparativaRendimiendo.add(lblNewLabel_3_18);
		      
		      lblmegusta = new JLabel("");
		      lblmegusta.setHorizontalAlignment(SwingConstants.CENTER);
		      lblmegusta.setForeground(new Color(64, 128, 128));
		      lblmegusta.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		      lblmegusta.setBounds(1261, 221, 386, 67);
		      panelComparativaRendimiendo.add(lblmegusta);
		    
		    panelmostrartodo = new JPanel();
		    panelmostrartodo.setBackground(new Color(0, 0, 0));
		    panelmostrartodo.setBounds(0, 0, 1657, 548);
		    contentPane.add(panelmostrartodo);
		    panelmostrartodo.setLayout(null);
		    panelmostrartodo.setVisible(false);
		    
		    JLabel lblNewLabel_3_4 = new JLabel("StreamerFocus");
		    lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_3_4.setForeground(new Color(64, 128, 128));
		    lblNewLabel_3_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		    lblNewLabel_3_4.setBounds(501, 11, 771, 99);
		    panelmostrartodo.add(lblNewLabel_3_4);
		    
		    scrollPane = new JScrollPane();
		    scrollPane.setBounds(336, 282, 1060, 209);
		    panelmostrartodo.add(scrollPane);
		    
		    tabla = new JTable();
		    scrollPane.setViewportView(tabla);
		    
		    JLabel lblNewLabel_3_4_1 = new JLabel("Aqui puede ver todos los datos de los streamer");
		    lblNewLabel_3_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_3_4_1.setForeground(new Color(64, 128, 128));
		    lblNewLabel_3_4_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		    lblNewLabel_3_4_1.setBounds(342, 172, 1054, 99);
		    panelmostrartodo.add(lblNewLabel_3_4_1);
		    
		    btnVolverMostrarTodo = new JButton("Volver");
		    
		    btnVolverMostrarTodo.setBounds(1568, 0, 89, 51);
		    panelmostrartodo.add(btnVolverMostrarTodo);
		   
		    InsertarColaboradores = new JPanel();
		    InsertarColaboradores.setBackground(new Color(0, 0, 0));
		    InsertarColaboradores.setBounds(0, 0, 1657, 548);
		    contentPane.add(InsertarColaboradores);
		    InsertarColaboradores.setLayout(null);
		    InsertarColaboradores.setVisible(false);
		    JLabel lblNewLabel_3_3 = new JLabel("StreamerFocus");
		    lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_3_3.setForeground(new Color(64, 128, 128));
		    lblNewLabel_3_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		    lblNewLabel_3_3.setBounds(497, 11, 771, 99);
		    InsertarColaboradores.add(lblNewLabel_3_3);
		    
		    textFieldCreador1 = new JTextField();
		    textFieldCreador1.setBounds(64, 188, 389, 20);
		    InsertarColaboradores.add(textFieldCreador1);
		    textFieldCreador1.setColumns(10);
		    
		    JLabel lblNewLabel_3_3_1 = new JLabel("ID CREADOR");
		    lblNewLabel_3_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel_3_3_1.setForeground(new Color(64, 128, 128));
		    lblNewLabel_3_3_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		    lblNewLabel_3_3_1.setBounds(64, 107, 389, 70);
		    InsertarColaboradores.add(lblNewLabel_3_3_1);
		    
		    JLabel lblNewLabel_3_3_1_1 = new JLabel("NOMBRE COLABORADOR");
		    lblNewLabel_3_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel_3_3_1_1.setForeground(new Color(64, 128, 128));
		    lblNewLabel_3_3_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		    lblNewLabel_3_3_1_1.setBounds(64, 219, 389, 61);
		    InsertarColaboradores.add(lblNewLabel_3_3_1_1);
		    
		    textFieldNombreColaborador = new JTextField();
		    textFieldNombreColaborador.setColumns(10);
		    textFieldNombreColaborador.setBounds(64, 280, 389, 20);
		    InsertarColaboradores.add(textFieldNombreColaborador);
		    
		    JLabel lblNewLabel_3_3_1_1_1 = new JLabel("TEMATICA");
		    lblNewLabel_3_3_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel_3_3_1_1_1.setForeground(new Color(64, 128, 128));
		    lblNewLabel_3_3_1_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		    lblNewLabel_3_3_1_1_1.setBounds(64, 311, 389, 61);
		    InsertarColaboradores.add(lblNewLabel_3_3_1_1_1);
		    
		    textFieldTematica = new JTextField();
		    textFieldTematica.setColumns(10);
		    textFieldTematica.setBounds(64, 383, 389, 20);
		    InsertarColaboradores.add(textFieldTematica);
		    
		    JLabel lblNewLabel_3_3_1_1_1_1 = new JLabel("FECHA FIN");
		    lblNewLabel_3_3_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel_3_3_1_1_1_1.setForeground(new Color(64, 128, 128));
		    lblNewLabel_3_3_1_1_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		    lblNewLabel_3_3_1_1_1_1.setBounds(583, 112, 389, 61);
		    InsertarColaboradores.add(lblNewLabel_3_3_1_1_1_1);
		    
		    textFieldFechaInicio = new JTextField();
		    textFieldFechaInicio.setColumns(10);
		    textFieldFechaInicio.setBounds(583, 188, 389, 20);
		    InsertarColaboradores.add(textFieldFechaInicio);
		    
		    JLabel lblNewLabel_3_3_1_1_1_1_1 = new JLabel("FECHA INICIO");
		    lblNewLabel_3_3_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel_3_3_1_1_1_1_1.setForeground(new Color(64, 128, 128));
		    lblNewLabel_3_3_1_1_1_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		    lblNewLabel_3_3_1_1_1_1_1.setBounds(583, 219, 389, 61);
		    InsertarColaboradores.add(lblNewLabel_3_3_1_1_1_1_1);
		    
		    textFieldFechaFin = new JTextField();
		    textFieldFechaFin.setColumns(10);
		    textFieldFechaFin.setBounds(583, 280, 389, 20);
		    InsertarColaboradores.add(textFieldFechaFin);
		    
		    JLabel lblNewLabel_3_3_1_1_1_1_1_1 = new JLabel("TIPO COLABORACION");
		    lblNewLabel_3_3_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel_3_3_1_1_1_1_1_1.setForeground(new Color(64, 128, 128));
		    lblNewLabel_3_3_1_1_1_1_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		    lblNewLabel_3_3_1_1_1_1_1_1.setBounds(583, 311, 389, 61);
		    InsertarColaboradores.add(lblNewLabel_3_3_1_1_1_1_1_1);
		    
		    textFieldTipoColaboracion = new JTextField();
		    textFieldTipoColaboracion.setColumns(10);
		    textFieldTipoColaboracion.setBounds(583, 383, 389, 20);
		    InsertarColaboradores.add(textFieldTipoColaboracion);
		    
		    comboBoxEstadoColaboracion = new JComboBox();
		    comboBoxEstadoColaboracion.setBounds(1156, 279, 389, 22);
		    InsertarColaboradores.add(comboBoxEstadoColaboracion);
		    
		    JLabel lblNewLabel_3_3_1_2 = new JLabel("ESTADO");
		    lblNewLabel_3_3_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel_3_3_1_2.setForeground(new Color(64, 128, 128));
		    lblNewLabel_3_3_1_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		    lblNewLabel_3_3_1_2.setBounds(1156, 191, 389, 70);
		    InsertarColaboradores.add(lblNewLabel_3_3_1_2);
		    
	 btnInsertarC = new JButton("Insetar");
	 btnInsertarC.setBounds(1156, 382, 389, 23);
	 InsertarColaboradores.add(btnInsertarC);
	 
	 btnVolverInsertarColaboradores = new JButton("Volver");
	 btnVolverInsertarColaboradores.setBounds(1568, 0, 89, 51);
	 InsertarColaboradores.add(btnVolverInsertarColaboradores);
	 
	  lblConformar = new JLabel("");
	  lblConformar.setHorizontalAlignment(SwingConstants.LEFT);
	  lblConformar.setForeground(new Color(64, 128, 128));
	  lblConformar.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
	  lblConformar.setBounds(428, 450, 712, 70);
	  InsertarColaboradores.add(lblConformar);
		   
		   paneleliminarminimo = new JPanel();
		   paneleliminarminimo.setLayout(null);
		   paneleliminarminimo.setBackground(Color.BLACK);
		   paneleliminarminimo.setBounds(0, 0, 1657, 548);
		   contentPane.add(paneleliminarminimo);
		   paneleliminarminimo.setVisible(false);
		   lblNewLabel_3_11 = new JLabel("StreamerFocus");
		   lblNewLabel_3_11.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_11.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_11.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_11.setBounds(692, 11, 274, 67);
		   paneleliminarminimo.add(lblNewLabel_3_11);
		   
		   lblNewLabel_3_3_2_13 = new JLabel("Plataforma");
		   lblNewLabel_3_3_2_13.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_13.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_13.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_13.setBounds(653, 89, 389, 99);
		   paneleliminarminimo.add(lblNewLabel_3_3_2_13);
		   
		   textField_19 = new JTextField();
		   textField_19.setColumns(10);
		   textField_19.setBounds(653, 220, 389, 20);
		   paneleliminarminimo.add(textField_19);
		   
		   lblNewLabel_3_3_17 = new JLabel("Me gusta");
		   lblNewLabel_3_3_17.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_17.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_17.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_17.setBounds(653, 228, 389, 99);
		   paneleliminarminimo.add(lblNewLabel_3_3_17);
		   
		   textField_22 = new JTextField();
		   textField_22.setColumns(10);
		   textField_22.setBounds(653, 338, 389, 20);
		   paneleliminarminimo.add(textField_22);
		   
		   btneliminarpublicacionpormegustas = new JButton("Eliminar");
		   btneliminarpublicacionpormegustas.setBounds(642, 390, 400, 23);
		   paneleliminarminimo.add(btneliminarpublicacionpormegustas);
		   
		   panelañadirpublicacion = new JPanel();
		   panelañadirpublicacion.setBackground(new Color(0, 0, 0));
		   panelañadirpublicacion.setBounds(0, 0, 1657, 548);
		   contentPane.add(panelañadirpublicacion);
		   panelañadirpublicacion.setLayout(null);
		   panelañadirpublicacion.setVisible(false);
		   lblNewLabel_3_9 = new JLabel("StreamerFocus");
		   lblNewLabel_3_9.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_9.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_9.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_9.setBounds(692, 11, 274, 67);
		   panelañadirpublicacion.add(lblNewLabel_3_9);
		   
		   textField = new JTextField();
		   textField.setColumns(10);
		   textField.setBounds(66, 187, 389, 20);
		   panelañadirpublicacion.add(textField);
		   
		   lblNewLabel_3_3_4 = new JLabel("Id Streamer");
		   lblNewLabel_3_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_4.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_4.setBounds(66, 72, 389, 99);
		   panelañadirpublicacion.add(lblNewLabel_3_3_4);
		   
		   lblNewLabel_3_3_2_5 = new JLabel("Plataforma");
		   lblNewLabel_3_3_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_5.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_5.setBounds(66, 238, 389, 99);
		   panelañadirpublicacion.add(lblNewLabel_3_3_2_5);
		   
		   textField_1 = new JTextField();
		   textField_1.setColumns(10);
		   textField_1.setBounds(66, 338, 389, 20);
		   panelañadirpublicacion.add(textField_1);
		   
		   lblNewLabel_3_3_5 = new JLabel("Contenido");
		   lblNewLabel_3_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_5.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_5.setBounds(510, 72, 389, 99);
		   panelañadirpublicacion.add(lblNewLabel_3_3_5);
		   
		   textField_2 = new JTextField();
		   textField_2.setColumns(10);
		   textField_2.setBounds(520, 187, 389, 20);
		   panelañadirpublicacion.add(textField_2);
		   
		   lblNewLabel_3_3_6 = new JLabel("Tipo");
		   lblNewLabel_3_3_6.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_6.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_6.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_6.setBounds(510, 238, 389, 99);
		   panelañadirpublicacion.add(lblNewLabel_3_3_6);
		   
		   textField_3 = new JTextField();
		   textField_3.setColumns(10);
		   textField_3.setBounds(510, 338, 389, 20);
		   panelañadirpublicacion.add(textField_3);
		   
		   lblNewLabel_3_3_7 = new JLabel("Me gusta");
		   lblNewLabel_3_3_7.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_7.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_7.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_7.setBounds(967, 90, 389, 99);
		   panelañadirpublicacion.add(lblNewLabel_3_3_7);
		   
		   textField_4 = new JTextField();
		   textField_4.setColumns(10);
		   textField_4.setBounds(967, 187, 389, 20);
		   panelañadirpublicacion.add(textField_4);
		   
		   lblNewLabel_3_3_8 = new JLabel("Comentarios");
		   lblNewLabel_3_3_8.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_8.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_8.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_8.setBounds(967, 226, 389, 99);
		   panelañadirpublicacion.add(lblNewLabel_3_3_8);
		   
		   textField_5 = new JTextField();
		   textField_5.setColumns(10);
		   textField_5.setBounds(967, 338, 389, 20);
		   panelañadirpublicacion.add(textField_5);
		   
		   textField_6 = new JTextField();
		   textField_6.setColumns(10);
		   textField_6.setBounds(66, 467, 389, 20);
		   panelañadirpublicacion.add(textField_6);
		   
		   lblNewLabel_3_3_2_6 = new JLabel("Fecha");
		   lblNewLabel_3_3_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_6.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_6.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_6.setBounds(66, 369, 389, 99);
		   panelañadirpublicacion.add(lblNewLabel_3_3_2_6);
		   
		   lblNewLabel_3_3_2_7 = new JLabel("Vsita");
		   lblNewLabel_3_3_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_7.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_7.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_7.setBounds(510, 369, 389, 99);
		   panelañadirpublicacion.add(lblNewLabel_3_3_2_7);
		   
		   textField_7 = new JTextField();
		   textField_7.setColumns(10);
		   textField_7.setBounds(510, 467, 389, 20);
		   panelañadirpublicacion.add(textField_7);
		   
		   lblNewLabel_3_3_2_8 = new JLabel("Compartidos");
		   lblNewLabel_3_3_2_8.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_8.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_8.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_8.setBounds(977, 369, 389, 99);
		   panelañadirpublicacion.add(lblNewLabel_3_3_2_8);
		   
		   textField_8 = new JTextField();
		   textField_8.setColumns(10);
		   textField_8.setBounds(967, 467, 389, 20);
		   panelañadirpublicacion.add(textField_8);
		   
		   btnModificarpublicacion = new JButton("Modificar");
		   btnModificarpublicacion.setBounds(1476, 337, 89, 23);
		   panelañadirpublicacion.add(btnModificarpublicacion);
		   
		   panel9 = new JPanel();
		   panel9.setBackground(new Color(0, 0, 0));
		   panel9.setBounds(0, 0, 1657, 548);
		   contentPane.add(panel9);
		   panel9.setLayout(null);
		   panel9.setVisible(false);
		   table = new JTable();
		   table.setBounds(335, 264, 1058, 229);
		   panel9.add(table);
		   
		   lblNewLabel_3_8 = new JLabel("StreamerFocus");
		   lblNewLabel_3_8.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_8.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_8.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_8.setBounds(694, 11, 274, 67);
		   panel9.add(lblNewLabel_3_8);
		   
		   lblNewLabel_3_2_2 = new JLabel("Redimiento de los streamer de videos,imagenes,megustas");
		   lblNewLabel_3_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_2_2.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_2_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_2_2.setBounds(10, 169, 1637, 67);
		   panel9.add(lblNewLabel_3_2_2);
		   
		   panelmostrarrendimiento = new JPanel();
		   panelmostrarrendimiento.setBackground(new Color(0, 0, 0));
		   panelmostrarrendimiento.setBounds(0, 0, 1657, 548);
		   contentPane.add(panelmostrarrendimiento);
		   panelmostrarrendimiento.setLayout(null);
		   panelmostrarrendimiento.setVisible(false);
		   
		   tableRendimiento = new JTable();
		   tableRendimiento.setBounds(336, 252, 1058, 229);
		   panelmostrarrendimiento.add(tableRendimiento);
		   JLabel lblNewLabel_3_2 = new JLabel("StreamerFocus");
		   lblNewLabel_3_2.setBounds(689, 5, 274, 67);
		   lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_2.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   panelmostrarrendimiento.add(lblNewLabel_3_2);
		   
		   JLabel lblNewLabel_3_2_1 = new JLabel("Redimiento de los streamer");
		   lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_2_1.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_2_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_2_1.setBounds(10, 162, 1637, 67);
		   panelmostrarrendimiento.add(lblNewLabel_3_2_1);
		   
		   JButton btnVolverinicio_1 = new JButton("Volver");
		   btnVolverinicio_1.setBounds(1568, 0, 89, 43);
		   panelmostrarrendimiento.add(btnVolverinicio_1);
		   
		   paneleliminarpublicacion = new JPanel();
		   paneleliminarpublicacion.setLayout(null);
		   paneleliminarpublicacion.setBackground(Color.BLACK);
		   paneleliminarpublicacion.setBounds(0, 0, 1657, 548);
		   contentPane.add(paneleliminarpublicacion);
		   paneleliminarpublicacion.setVisible(false);
		   lblNewLabel_3_7 = new JLabel("StreamerFocus");
		   lblNewLabel_3_7.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_7.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_7.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_7.setBounds(691, 11, 274, 67);
		   paneleliminarpublicacion.add(lblNewLabel_3_7);
		   
		   textFieldeliminaridstreamer = new JTextField();
		   textFieldeliminaridstreamer.setColumns(10);
		   textFieldeliminaridstreamer.setBounds(66, 189, 389, 20);
		   paneleliminarpublicacion.add(textFieldeliminaridstreamer);
		   
		   lblNewLabel_3_3_3 = new JLabel("Id Streamer");
		   lblNewLabel_3_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_3.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_3.setBounds(66, 78, 389, 99);
		   paneleliminarpublicacion.add(lblNewLabel_3_3_3);
		   
		   lblNewLabel_3_3_2_3 = new JLabel("Plataforma");
		   lblNewLabel_3_3_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_3.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_3.setBounds(66, 230, 389, 99);
		   paneleliminarpublicacion.add(lblNewLabel_3_3_2_3);
		   
		   textFieldeliminarplataforma = new JTextField();
		   textFieldeliminarplataforma.setColumns(10);
		   textFieldeliminarplataforma.setBounds(66, 340, 389, 20);
		   paneleliminarpublicacion.add(textFieldeliminarplataforma);
		   
		   textFieldeliminarmegusta = new JTextField();
		   textFieldeliminarmegusta.setColumns(10);
		   textFieldeliminarmegusta.setBounds(563, 189, 389, 20);
		   paneleliminarpublicacion.add(textFieldeliminarmegusta);
		   
		   textFieldeliminarcomentarios = new JTextField();
		   textFieldeliminarcomentarios.setColumns(10);
		   textFieldeliminarcomentarios.setBounds(563, 340, 389, 20);
		   paneleliminarpublicacion.add(textFieldeliminarcomentarios);
		   
		   textFieldeliminarcompartidos = new JTextField();
		   textFieldeliminarcompartidos.setColumns(10);
		   textFieldeliminarcompartidos.setBounds(1110, 230, 389, 20);
		   paneleliminarpublicacion.add(textFieldeliminarcompartidos);
		   
		   lblNewLabel_3_3_2_4 = new JLabel("Me gusta");
		   lblNewLabel_3_3_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_4.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_4.setBounds(563, 78, 389, 99);
		   paneleliminarpublicacion.add(lblNewLabel_3_3_2_4);
		   
		   lblNewLabel_3_3_2_2_2 = new JLabel("Comentarios");
		   lblNewLabel_3_3_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_2_2.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_2_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_2_2.setBounds(563, 230, 389, 99);
		   paneleliminarpublicacion.add(lblNewLabel_3_3_2_2_2);
		   
		   textFieldcompartidosstreamermodificar_1 = new JLabel("Compartidos");
		   textFieldcompartidosstreamermodificar_1.setHorizontalAlignment(SwingConstants.CENTER);
		   textFieldcompartidosstreamermodificar_1.setForeground(new Color(64, 128, 128));
		   textFieldcompartidosstreamermodificar_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   textFieldcompartidosstreamermodificar_1.setBounds(1110, 101, 389, 99);
		   paneleliminarpublicacion.add(textFieldcompartidosstreamermodificar_1);
		   
		   btnEliminardatos = new JButton("Eliminar");
		   btnEliminardatos.setBounds(1110, 361, 389, 23);
		   paneleliminarpublicacion.add(btnEliminardatos);
		   
		   panelmodificarpublicaciones = new JPanel();
		   panelmodificarpublicaciones.setBackground(new Color(0, 0, 0));
		   panelmodificarpublicaciones.setBounds(0, 0, 1657, 548);
		   contentPane.add(panelmodificarpublicaciones);
		   panelmodificarpublicaciones.setLayout(null);
		   panelmodificarpublicaciones.setVisible(false);
		   JLabel lblNewLabel_3_6 = new JLabel("StreamerFocus");
		   lblNewLabel_3_6.setBounds(691, 11, 274, 67);
		   lblNewLabel_3_6.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_6.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_6.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   panelmodificarpublicaciones.add(lblNewLabel_3_6);
		   
		   textFieldidstreamermodificar = new JTextField();
		   textFieldidstreamermodificar.setColumns(10);
		   textFieldidstreamermodificar.setBounds(66, 189, 389, 20);
		   panelmodificarpublicaciones.add(textFieldidstreamermodificar);
		   
		   JLabel lblNewLabel_3_3_2 = new JLabel("Id Streamer");
		   lblNewLabel_3_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2.setBounds(66, 78, 389, 99);
		   panelmodificarpublicaciones.add(lblNewLabel_3_3_2);
		   
		   JLabel lblNewLabel_3_3_2_1 = new JLabel("Plataforma");
		   lblNewLabel_3_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_1.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_1.setBounds(66, 230, 389, 99);
		   panelmodificarpublicaciones.add(lblNewLabel_3_3_2_1);
		   
		   textFieldplataformastreamermodificar = new JTextField();
		   textFieldplataformastreamermodificar.setColumns(10);
		   textFieldplataformastreamermodificar.setBounds(66, 340, 389, 20);
		   panelmodificarpublicaciones.add(textFieldplataformastreamermodificar);
		   
		   textFieldmegustastreamermodificar = new JTextField();
		   textFieldmegustastreamermodificar.setColumns(10);
		   textFieldmegustastreamermodificar.setBounds(563, 189, 389, 20);
		   panelmodificarpublicaciones.add(textFieldmegustastreamermodificar);
		   
		   textFieldcomentariosstreamermodificar = new JTextField();
		   textFieldcomentariosstreamermodificar.setColumns(10);
		   textFieldcomentariosstreamermodificar.setBounds(563, 340, 389, 20);
		   panelmodificarpublicaciones.add(textFieldcomentariosstreamermodificar);
		   
		   textFieldmoficarcompartidos = new JTextField();
		   textFieldmoficarcompartidos.setColumns(10);
		   textFieldmoficarcompartidos.setBounds(1110, 230, 389, 20);
		   panelmodificarpublicaciones.add(textFieldmoficarcompartidos);
		   
		   JLabel lblNewLabel_3_3_2_2 = new JLabel("Me gusta");
		   lblNewLabel_3_3_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_2.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_2.setBounds(563, 78, 389, 99);
		   panelmodificarpublicaciones.add(lblNewLabel_3_3_2_2);
		   
		   JLabel lblNewLabel_3_3_2_2_1 = new JLabel("Comentarios");
		   lblNewLabel_3_3_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNewLabel_3_3_2_2_1.setForeground(new Color(64, 128, 128));
		   lblNewLabel_3_3_2_2_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   lblNewLabel_3_3_2_2_1.setBounds(563, 230, 389, 99);
		   panelmodificarpublicaciones.add(lblNewLabel_3_3_2_2_1);
		   
		   JLabel textFieldcompartidosstreamermodificar = new JLabel("Compartidos");
		   textFieldcompartidosstreamermodificar.setHorizontalAlignment(SwingConstants.CENTER);
		   textFieldcompartidosstreamermodificar.setForeground(new Color(64, 128, 128));
		   textFieldcompartidosstreamermodificar.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 62));
		   textFieldcompartidosstreamermodificar.setBounds(1110, 101, 389, 99);
		   panelmodificarpublicaciones.add(textFieldcompartidosstreamermodificar);
		   
		   JButton btnModificar = new JButton("Modificar");
		   btnModificar.setBounds(1110, 361, 389, 23);
		   panelmodificarpublicaciones.add(btnModificar);

	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.controlador;

import MVC.Usuario;
import MVC.modelo.Bd;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author gftej
 */
public class Controller extends Thread implements ActionListener,
		MouseListener {

	public jfLogin login;
	public jfAlta alta;
	public Bd bd;
	public String comando;
	public int cm;

	Controller(jfLogin login, Bd bd) {
		this.login = login;
		this.bd = bd;

	}

	Controller(jfAlta alta, Bd bd) {
		this.alta = alta;
		this.bd = bd;

	}

	@Override
	synchronized public void run() {

		//Objeto para ejecutar los procedimientos almacenados
		//   en la base de datos
		CallableStatement cs;
		ResultSet rs;

		//COMANDO EJECTUADO
		//Deberá coincidir con alguno de los parámetros
		//  indicados en setActionCommand invocado en la
		//  clase vista
		switch (cm) {
			case 1:
				try {
					System.gc();
					System.exit(0);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.toString(), "Alerta:", JOptionPane.ERROR_MESSAGE);

				}
				break;
			case 2:
				try {
					String password = String.valueOf(login.jtContraseña.getPassword());
					if (login.jtUsuario.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Es necesario qu ingrese un usuario", "Alerta:", JOptionPane.ERROR_MESSAGE);
						login.jtUsuario.requestFocus();
						try {
							Controller.interrupted();
						} catch (Throwable ex) {
							Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else if (password.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Es necesario qu ingrese su contraseña", "Alerta:", JOptionPane.ERROR_MESSAGE);
						login.jtContraseña.requestFocus();
						try {
							Controller.interrupted();
						} catch (Throwable ex) {
							Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else if (password.equalsIgnoreCase(login.jtUsuario.getText())) {
						JOptionPane.showMessageDialog(null, "La contraseña no debe de ser igual a la del usuario", "Alerta:", JOptionPane.ERROR_MESSAGE);
						limpiaFormularioLogin();
						try {
							Controller.interrupted();
						} catch (Throwable ex) {
							Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else {

						Usuario user = null;
						//Preparar la llamada
						cs = bd.getConexion().prepareCall("{CALL existeUsuario(?,?)}");
						//Indicar qué información se pasa al procedimiento
						cs.setString(1, login.jtUsuario.getText());
						cs.setString(2, password);

						//Ejecutar el procedimiento
						rs = cs.executeQuery();
						//Cargar los datos devueltos en los cuadros de texto
						if (rs.next()) {
							if (rs.getInt(1) == 0) {
								limpiaFormularioLogin();
								JOptionPane.showMessageDialog(null, "El usuario o la contraseña actualmente no existen registrados", "Alerta:", JOptionPane.ERROR_MESSAGE);
							} else {
								user = new Usuario(login.jtUsuario.getText(), rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
								login.dispose();
								var.id=user.getId_usuario();
								Menu j = new Menu(user);
								SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
								SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
								SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");

								j.setBounds(430, 50, j.getWidth(), j.getHeight());
								j.setResizable(false);
								j.setVisible(true);
								if (user.getEs_estudiante()==1){
									j.jbNuevoPregunta.setEnabled(true);
									j.jbVerPreguntaU.setEnabled(true);
									j.jbAsignarRespuesta.setEnabled(true);
									j.jbResponderPregunta.setEnabled(false);
									j.jbVisualizarPreguntaA.setEnabled(false);
									j.etiquetaMensaje.setText("Bienvenido: "+user.getUsername()+", Tipo de usuario: Estudiante, Bolsa de dinero "+user.getCantidad_dinero()+" pesos");
								}
								else{
									j.jbNuevoPregunta.setEnabled(false);
									j.jbVerPreguntaU.setEnabled(false);
									j.jbAsignarRespuesta.setEnabled(false);
									j.jbResponderPregunta.setEnabled(true);
									j.jbVisualizarPreguntaA.setEnabled(true);
									if(user.getRanquin()<100){
									j.etiquetaMensaje.setText("Bienvenido: "+user.getUsername()+", Tipo de usuario: Asesor, Bolsa de dinero "+user.getCantidad_dinero()+" pesos, Ranquin: "+user.getRanquin());	
									}
									else{
										j.etiquetaMensaje.setText("Bienvenido: "+user.getUsername()+", Tipo de usuario: Asesor Premiun, Bolsa de dinero "+user.getCantidad_dinero()+" pesos, Ranquin: "+user.getRanquin());
									}
								}

							}
						}
						rs.close();
						bd = null;
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.toString(), "Alerta:", JOptionPane.ERROR_MESSAGE);

				}
				break;
			case 3:
				login.dispose();
				jfAlta j = new jfAlta();
				SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
				SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
				SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");

				j.setBounds(430, 50, j.getWidth(), j.getHeight());
				j.setResizable(false);
				j.setVisible(true);

				break;
			case 4:

				try {
					String password = String.valueOf(alta.jtContraseña.getPassword());
					if (alta.jtUsuario.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Es necesario qu ingrese un usuario", "Alerta:", JOptionPane.ERROR_MESSAGE);
						alta.jtUsuario.requestFocus();
						try {
							Controller.interrupted();
						} catch (Throwable ex) {
							Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else if (password.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Es necesario qu ingrese su contraseña", "Alerta:", JOptionPane.ERROR_MESSAGE);
						alta.jtContraseña.requestFocus();
						try {
							Controller.interrupted();
						} catch (Throwable ex) {
							Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else if (password.equalsIgnoreCase(alta.jtUsuario.getText())) {
						JOptionPane.showMessageDialog(null, "La contraseña no debe de ser igual a la del usuario", "Alerta:", JOptionPane.ERROR_MESSAGE);
						limpiaFormularioLogin();
						try {
							Controller.interrupted();
						} catch (Throwable ex) {
							Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else {

						Usuario user = null;
						//Preparar la llamada
						cs = bd.getConexion().prepareCall("{CALL creausuario(?,?,?,?)}");
						//Indicar qué información se pasa al procedimiento
						int es_estudiante, es_asesor;
						if (alta.jRAlumno.isSelected()) {
							es_estudiante = 1;
						} else {
							es_estudiante = 0;
						}
						if (alta.jRAsesor.isSelected()) {
							es_asesor = 1;
						} else {
							es_asesor = 0;
						}
						cs.setString(1, alta.jtUsuario.getText());
						cs.setString(2, password);
						cs.setInt(3, es_estudiante);
						cs.setInt(4, es_asesor);

						//Ejecutar el procedimiento
						rs = cs.executeQuery();
						//Cargar los datos devueltos en los cuadros de texto
						if (rs.next()) {
							if (rs.getInt(1) == -1) {
								JOptionPane.showMessageDialog(null, "El usuario ya existen registrados", "Alerta:", JOptionPane.ERROR_MESSAGE);
							} else {

								alta.dispose();
								jfLogin k = new jfLogin();
								SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
								SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
								SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
								k.setBounds(430, 50, k.getWidth(), k.getHeight());
								k.setResizable(false);
								k.setVisible(true);
							}
						}
						rs.close();
						bd = null;
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.toString(), "Alerta:", JOptionPane.ERROR_MESSAGE);

				}
				break;
			case 5:
				alta.dispose();
				jfLogin w = new jfLogin();
				SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
				SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
				SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
				w.setBounds(430, 50, w.getWidth(), w.getHeight());
				w.setResizable(false);
				w.setVisible(true);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Error", "Alerta:", JOptionPane.ERROR_MESSAGE);
				break;
		}

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		comando = ae.getActionCommand();
		if (comando.equalsIgnoreCase("Finalizar")) {
			cm = 1;
		} else if (comando.equalsIgnoreCase("Ingresar")) {
			cm = 2;
		} else if (comando.equalsIgnoreCase("Nuevo")) {
			cm = 3;
		} else if (comando.equalsIgnoreCase("Registrar")) {
			cm = 4;
		} else if (comando.equalsIgnoreCase("Regresar")) {
			cm = 5;
		} else {
			cm = 6;
		}

		this.run();
	}

	public void limpiaFormularioLogin() {
		login.jtContraseña.setText("");
		login.jtUsuario.setText("");
		login.jtUsuario.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mousePressed(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseExited(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.controlador;

import MVC.Usuario;
import MVC.modelo.Bd;
import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author gftej
 */
public class ControllerMenu extends Thread implements ActionListener,
		MouseListener {

	public Menu menu;
	public jfVisualizar visualizar;
	public jfVisualizarR visualizarr;
	public Bd bd;
	public Usuario user;
	public jfPreguntas preguntas;
	public int cm;
	public String comando;
	public jfAsignar asignar;
	public jfResponder responder;

	public ResultSet rs;
	public Statement s;

	ControllerMenu(Menu menu, Bd bd, Usuario user) {
		this.menu = menu;
		this.bd = bd;
	}

	ControllerMenu(jfAsignar asignar, Bd bd) {
		this.asignar = asignar;
		this.bd = bd;
	}

	ControllerMenu(jfPreguntas preguntas, Bd bd) {
		this.preguntas = preguntas;
		this.bd = bd;
	}

	ControllerMenu(jfVisualizar visualizar, Bd bd) {
		this.visualizar = visualizar;
		this.bd = bd;
	}

	ControllerMenu(jfVisualizarR visualizarr, Bd bd) {
		this.visualizarr = visualizarr;
		this.bd = bd;
	}	
	ControllerMenu(jfResponder responder, Bd bd) {
		this.responder = responder;
		this.bd = bd;
	}	

	@Override
	synchronized public void run() {

		try {
			//Objeto para ejecutar los procedimientos almacenados
			//   en la base de datos
			CallableStatement cs;
			ResultSet rs;

			switch (cm) {
				case 1:
					menu.dispose();
					jfPreguntas w = new jfPreguntas();
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					w.setBounds(430, 50, w.getWidth(), w.getHeight());
					w.setResizable(false);
					w.setVisible(true);
					w.jLMen.setEnabled(false);
					w.jTCosto.setText("10");
					w.jTCosto.setEnabled(false);

					break;
				case 2:

					menu.dispose();
					jfVisualizar sd = new jfVisualizar();
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					sd.setBounds(430, 50, sd.getWidth(), sd.getHeight());
					sd.setResizable(false);
					sd.setVisible(true);

					Bd b = new Bd("hacksof");
					Connection cn = b.getConexion();
					s = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					rs = s.executeQuery("SELECT id_usuario_transaccion,\n"
							+ "       id_usuario_pregunta,\n"
							+ "       su.username usuario,\n"
							+ "       sa.username asessor,\n"
							+ "       pregunta,\n"
							+ "       fecha_pregunta\n"
							+ "FROM usuario_tansaccion ut, sys_user su, sys_user sa\n"
							+ "WHERE     ut.id_usuario_pregunta = su.id_usuario\n"
							+ "      AND ut.id_usuario_pregunta = sa.id_usuario\n"
							+ "      and ut.id_usuario_pregunta=" + var.id);

					sd.jTPregunta.removeAll();
					sd.jTPregunta.append("\nHistorial almacenado en la BD");
					while (rs.next()) {
						sd.jTPregunta.append("\n\nID_PREGUNTA: " + rs.getString("id_usuario_transaccion") + ".- ");
						sd.jTPregunta.append("\nfecha: " + rs.getDate("fecha_pregunta") + ".- ");
						sd.jTPregunta.append("\nResponde: " + rs.getString("asessor"));
						sd.jTPregunta.append("\nPregunta: " + rs.getString("pregunta"));
					}
					rs.close();
					s.close();

					break;
				case 3:
					
					menu.dispose();
					jfResponder kl = new jfResponder();
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					kl.setBounds(430, 50, kl.getWidth(), kl.getHeight());
					kl.setResizable(false);
					kl.setVisible(true);

					Bd bb = new Bd("hacksof");
					Connection cnn = bb.getConexion();
					s = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

					rs = s.executeQuery("select id_usuario_transaccion,\n" +
							"pregunta,\n" +
							"fecha_pregunta,\n" +
							"username,\n" +
							"cantidad_transaccion from \n" +
							"usuario_tansaccion u,\n" +
							"sys_user s\n" +
							"where id_usuario_respuesta is null\n" +
							"   and u.id_usuario_pregunta=s.id_usuario");

					kl.jCAsesor.removeAllItems();
					kl.jCAsesor.addItem("0.- Seleccione una pregunta a responder");

					kl.jTPregunta.removeAll();
					kl.jTPregunta.append("\nHistorial almacenado en la BD de preguntas a responder");
					while (rs.next()) {
						kl.jTPregunta.append("\n\nID_PREGUNTA: " + rs.getString("id_usuario_transaccion") + ".- ");
						kl.jTPregunta.append("\nfecha: " + rs.getDate("fecha_pregunta") + ".- ");
						kl.jTPregunta.append("\nPregunta: " + rs.getString("pregunta") + ".- ");
						kl.jTPregunta.append("\nUsuario pregunta: " + rs.getString("username"));
						kl.jTPregunta.append("\nCantidad que pagan por responder: " + rs.getInt("cantidad_transaccion"));

						kl.jCAsesor.addItem(rs.getString("id_usuario_transaccion") + ".- Usuario.- " + rs.getString("username") + " "
								+ "Pregunta.- " + rs.getString("pregunta"));

					}
					rs.close();
					s.close();
					
					break;
				case 4:
										
					menu.dispose();
					jfVisualizarR kl1 = new jfVisualizarR();
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					kl1.setBounds(430, 50, kl1.getWidth(), kl1.getHeight());
					kl1.setResizable(false);
					kl1.setVisible(true);

					Bd bb1 = new Bd("hacksof");
					Connection cnn1 = bb1.getConexion();
					s = cnn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

					rs = s.executeQuery("select id_usuario_transaccion,\n" +
							"pregunta,\n" +
							"fecha_pregunta,\n" +
							"username,\n" +
							"cantidad_transaccion from \n" +
							"usuario_tansaccion u,\n" +
							"sys_user s\n" +
							"where id_usuario_respuesta is not null\n" +
							"   and u.id_usuario_pregunta=s.id_usuario");

					
					kl1.jTPregunta.removeAll();
					kl1.jTPregunta.append("\nHistorial de preguntas contestadas.");
					while (rs.next()) {
						kl1.jTPregunta.append("\n\nID_PREGUNTA: " + rs.getString("id_usuario_transaccion") + ".- ");
						kl1.jTPregunta.append("\nfecha: " + rs.getDate("fecha_pregunta") + ".- ");
						kl1.jTPregunta.append("\nPregunta: " + rs.getString("pregunta") + ".- ");						
						kl1.jTPregunta.append("\nUsuario pregunta: " + rs.getString("username"));
						kl1.jTPregunta.append("\nCantidad que pagan por responder: " + rs.getInt("cantidad_transaccion"));

					}
					rs.close();
					s.close();
					
					break;
				case 5:
					try {
						preguntas.dispose();
					} catch (Exception ex) {
						visualizar.dispose();
					}
					Menu f = new Menu(user);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					f.setBounds(430, 50, f.getWidth(), f.getHeight());
					f.setResizable(false);
					f.setVisible(true);
					break;
				case 6:
					int num;
					try {
						num = Integer.parseInt(preguntas.jTCosto.getText());
					} catch (NumberFormatException ex) {
						num = 0;
					}
					if (num < 11) {
						JOptionPane.showMessageDialog(null, "Es necesario qu ingrese una cantidad correcta", "Alerta:", JOptionPane.ERROR_MESSAGE);
						preguntas.jTCosto.requestFocus();
						try {
							Controller.interrupted();
						} catch (Throwable ex) {
							Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else if (preguntas.jTPregunta.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Es necesario que ingrese una pregunta", "Alerta:", JOptionPane.ERROR_MESSAGE);
						try {
							Controller.interrupted();
						} catch (Throwable ex) {
							Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else {

						try {
							//Preparar la llamada
							cs = bd.getConexion().prepareCall("{CALL creapregunta(?,?,?)}");
							cs.setInt(1, var.id);
							cs.setInt(2, Integer.parseInt(preguntas.jTCosto.getText()));
							cs.setString(3, preguntas.jTPregunta.getText().toLowerCase());
							//Ejecutar el procedimiento
							rs = cs.executeQuery();
							//Cargar los datos devueltos en los cuadros de texto
							if (rs.next()) {
								if (rs.getInt(1) == -1) {
									JOptionPane.showMessageDialog(null, "Esa pregunta ya fue registrada anteriormente", "Alerta:", JOptionPane.ERROR_MESSAGE);
								} else {

									preguntas.dispose();
									Menu k = new Menu(user);
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
						} catch (SQLException ex) {
							Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
						}
					}

					break;
				case 7:
					visualizar.dispose();
					Menu k = new Menu(user);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					k.setBounds(430, 50, k.getWidth(), k.getHeight());
					k.setResizable(false);
					k.setVisible(true);
					break;
				case 8:
					menu.dispose();
					jfAsignar kfl = new jfAsignar();
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					kfl.setBounds(430, 50, kfl.getWidth(), kfl.getHeight());
					kfl.setResizable(false);
					kfl.setVisible(true);

					Bd bbb = new Bd("hacksof");
					Connection cnnn = bbb.getConexion();
					s = cnnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

					rs = s.executeQuery("select id_respuesta,username,respuesta,fecha_respuesta from respuesta r,\n"
							+ "    sys_user s\n"
							+ "  where r.id_usuario_respuesta=s.id_usuario\n"
							+ "    and id_usuario_pregunta=" + var.id);

					kfl.jCAsesor.removeAllItems();
					kfl.jCAsesor.addItem("0.- Seleccione un Asesor");

					kfl.jTPregunta.removeAll();
					kfl.jTPregunta.append("\nHistorial almacenado en la BD de respuestas");
					while (rs.next()) {
						kfl.jTPregunta.append("\n\nID_RESPUESTA: " + rs.getString("id_respuesta") + ".- ");
						kfl.jTPregunta.append("\nfecha: " + rs.getDate("fecha_respuesta") + ".- ");
						kfl.jTPregunta.append("\nResponde: " + rs.getString("username"));
						kfl.jTPregunta.append("\nRespuesta: " + rs.getString("respuesta"));

						kfl.jCAsesor.addItem(rs.getString("id_respuesta") + ".- Usuario.- " + rs.getString("username") + " "
								+ "Respuesta.- " + rs.getString("respuesta"));

					}
					rs.close();
					s.close();

					break;
				case 9:
					asignar.dispose();
					Menu tk = new Menu(user);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					tk.setBounds(430, 50, tk.getWidth(), tk.getHeight());
					tk.setResizable(false);
					tk.setVisible(true);
					break;	
				case 10:
					try{
					responder.dispose();	
					}
					catch(Exception ex){
					visualizarr.dispose();	
					}
					
					Menu tr = new Menu(user);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					tr.setBounds(430, 50, tr.getWidth(), tr.getHeight());
					tr.setResizable(false);
					tr.setVisible(true);
					break;	
				case 11:
					visualizarr.dispose();
					Menu trv = new Menu(user);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					trv.setBounds(430, 50, trv.getWidth(), trv.getHeight());
					trv.setResizable(false);
					trv.setVisible(true);
					break;
				case 12:
					visualizarr.dispose();
					Menu trv1 = new Menu(user);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
					SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
					trv1.setBounds(430, 50, trv1.getWidth(), trv1.getHeight());
					trv1.setResizable(false);
					trv1.setVisible(true);
					break;					
				default:
					break;

			}
		} catch (SQLException ex) {
			Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		comando = ae.getActionCommand();
		if (comando.equalsIgnoreCase("Nueva")) {
			cm = 1;
		} else if (comando.equalsIgnoreCase("Visualizar")) {
			cm = 2;
		} else if (comando.equalsIgnoreCase("Respuesta")) {
			cm = 3;
		} else if (comando.equalsIgnoreCase("VisualizarR")) {
			cm = 4;
		} else if (comando.equalsIgnoreCase("RegresarU")) {
			cm = 5;
		} else if (comando.equalsIgnoreCase("RegistrarP")) {
			cm = 6;
		} else if (comando.equalsIgnoreCase("Regresar")) {
			cm = 7;
		} else if (comando.equalsIgnoreCase("Asignar")) {
			cm = 8;
		}  else if (comando.equalsIgnoreCase("RegresarA")) {
			cm = 9;
		}  else if (comando.equalsIgnoreCase("RegresarR")) {
			cm = 10;
		} else if (comando.equalsIgnoreCase("Regresarr")) {
			cm = 11;
		} else if (comando.equalsIgnoreCase("Regresarrr")) {
			cm = 12;
		}else {
			cm = 13;
		}

		this.run();
	}

	@Override
	public void mouseClicked(MouseEvent me
	) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mousePressed(MouseEvent me
	) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseReleased(MouseEvent me
	) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseEntered(MouseEvent me
	) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseExited(MouseEvent me
	) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}

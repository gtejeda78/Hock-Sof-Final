/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gftej
 */
public class Bd {

    //private String maquina = "192.168.0.101";
      private String maquina = "localhost";
    private String usuario = "root";
    private String clave = "depurines";
    private int puerto = 3306;
    private String servidor = "";
    private static Connection conexion = null;

    //CONSTRUCTOR
    //Recibe el nombre de la base de datos
    public Bd(String baseDatos) {
        this.servidor = "jdbc:mysql://" + this.maquina + ":"
                + this.puerto + "/" + baseDatos;

        //Registrar el driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR EL DRIVER", "Alerta:", JOptionPane.ERROR_MESSAGE);
            System.err.println("ERROR AL REGISTRAR EL DRIVER");
            System.exit(0); //parar la ejecución
        }

        //Establecer la conexión con el servidor
        try {
            conexion = (Connection) DriverManager.getConnection(this.servidor,
                    this.usuario, this.clave);
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
             JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR CON EL SERVIDOR", "Alerta:", JOptionPane.ERROR_MESSAGE);
            System.exit(0); //parar la ejecución
        }
        System.out.println("Conectado a " + baseDatos);
    }

    //Devuelve el objeto Connection que se usará en la clase Controller
    public static Connection getConexion() {
        return conexion;
    }

}

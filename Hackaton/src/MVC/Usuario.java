/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

/**
 *
 * @author gftej
 */
public class Usuario {    
    private  String username;    
	private  int es_estudiante;
	private  int es_assesor;
	private  int ranquin;	
	private  int id_usuario;	
	private  int cantidad_dinero;    

	public Usuario(String username, int id_usuario,int es_estudiante, int es_assesor, int ranquin,  int cantidad_dinero) {
		this.username = username;
		this.es_estudiante = es_estudiante;
		this.es_assesor = es_assesor;
		this.ranquin = ranquin;
		this.id_usuario = id_usuario;
		this.cantidad_dinero = cantidad_dinero;
	}							

	public String getUsername() {
		return username;
	}

	public int getEs_estudiante() {
		return es_estudiante;
	}

	public int getEs_assesor() {
		return es_assesor;
	}

	public int getRanquin() {
		return ranquin;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public int getCantidad_dinero() {
		return cantidad_dinero;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEs_estudiante(int es_estudiante) {
		this.es_estudiante = es_estudiante;
	}

	public void setEs_assesor(int es_assesor) {
		this.es_assesor = es_assesor;
	}

	public void setRanquin(int ranquin) {
		this.ranquin = ranquin;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setCantidad_dinero(int cantidad_dinero) {
		this.cantidad_dinero = cantidad_dinero;
	}
	
	
}

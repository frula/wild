package negocio;

import interfaz.MenuPrincipal;

import java.util.ArrayList;

import datos.BackUP;
import datos.Basededatos;
import datos.Pizzeria;

public abstract class Main {

	public static void main(String[] args) {
	
		//Creacion de conexion a BD
		
		Basededatos conexion = new Basededatos();
		conexion.establecerConexion();
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.setVisible(true);
		BackUP c = new BackUP();
	
	}

}

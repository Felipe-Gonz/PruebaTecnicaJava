package org.pruebatecnica.prueba;

import java.util.List;

import org.pruebatecnica.dao.EmpleadosDAO;
import org.pruebatecnica.dao.PerfilDAO;
import org.pruebatecnica.dao.PuestosDAO;
import org.pruebatecnica.dao.UsuarioDAO;
import org.pruebatecnica.entidades.Empleado;
import org.pruebatecnica.entidades.Perfil;
import org.pruebatecnica.entidades.Puesto;
import org.pruebatecnica.entidades.Usuario;
import java.util.Scanner;

public class Prueba {
	
	public static void main(String[] args) {
		PuestosDAO puestosDAO = new PuestosDAO();
		EmpleadosDAO empleadosDAO = new EmpleadosDAO();
		PerfilDAO perfilDAO = new PerfilDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Scanner scanner = new Scanner(System.in);

		
		List<Empleado> empleados = empleadosDAO.obtenerTodos();
		List<Puesto> puestos = puestosDAO.obtenerTodos();
		List<Perfil> perfiles = perfilDAO.obtenerTodos();
		List<Usuario> usuarios = usuarioDAO.obtenerTodos();

		
		for (Puesto puesto : puestos) {
			System.out.println(puesto.getNombre());
		}
		
		System.out.println("\n");
		
		for (Empleado empleado : empleados) {

			System.out.println("Nombre: " + empleado.getNombres() + " " + empleado.getApellidos() + ", Edad: " + empleado.getEdad() + ", Salario: " + empleado.getSalario());
		}
		
		System.out.println("\n");
		
		for (Perfil perfil : perfiles) {
			System.out.println(perfil.getNombre() );
		}
		
		System.out.println("\n");
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getUsername());
		}

	}


}

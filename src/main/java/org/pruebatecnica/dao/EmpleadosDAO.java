package org.pruebatecnica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.pruebatecnica.entidades.Empleado;

public class EmpleadosDAO {
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public EmpleadosDAO() {
		emf = Persistence.createEntityManagerFactory("pruebaTecnica");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
	}
	
	public void eliminar(Empleado empleado) {
		Empleado empleadoN = (Empleado) manager.find(Empleado.class, empleado.getId());
		manager.remove(empleadoN);
		manager.getTransaction().commit();
	}
	
	public Empleado obtenerPorId(Integer id) {
		return manager.find(Empleado.class, id);
	}
	
	public List<Empleado> obtenerTodos() {
		List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		return empleados;
	}
	
	public void guardar(Empleado empleado) {
		if (empleado.getId() == null) {
			manager.persist(empleado);
		} else {
			manager.merge(empleado);
		}

		manager.getTransaction().commit();
	}
}

package org.pruebatecnica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.pruebatecnica.entidades.Puesto;

public class PuestosDAO {
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public PuestosDAO() {
		emf = Persistence.createEntityManagerFactory("pruebaTecnica");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
	}
	
	public void eliminar(Puesto puesto) {
		Puesto puestoN = (Puesto) manager.find(Puesto.class, puesto.getId());
		manager.remove(puestoN);
		manager.getTransaction().commit();
	}
	
	public Puesto obtenerPorId(Integer id) {
		return manager.find(Puesto.class, id);
	}
	
	public List<Puesto> obtenerTodos() {
		List<Puesto> puestos = (List<Puesto>) manager.createQuery("FROM Puesto").getResultList();
		return puestos;
	}
	
	public void guardar(Puesto puesto) {
		if (puesto.getId() == null) {
			manager.persist(puesto);
		} else {
			manager.merge(puesto);
		}

		manager.getTransaction().commit();
	}
}

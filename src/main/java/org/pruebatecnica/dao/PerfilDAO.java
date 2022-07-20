package org.pruebatecnica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.pruebatecnica.entidades.Perfil;

public class PerfilDAO {
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public PerfilDAO() {
		emf = Persistence.createEntityManagerFactory("pruebaTecnica");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
	}
	
	public void eliminar(Perfil perfil) {
		Perfil perfilN = (Perfil) manager.find(Perfil.class, perfil.getId());
		manager.remove(perfilN);
		manager.getTransaction().commit();
	}
	
	public Perfil obtenerPorId(Integer id) {
		return manager.find(Perfil.class, id);
	}
	
	public List<Perfil> obtenerTodos() {
		List<Perfil> perfiles = (List<Perfil>) manager.createQuery("FROM Perfil").getResultList();
		return perfiles;
	}
	
	public void guardar(Perfil perfil) {
		if (perfil.getId() == null) {
			manager.persist(perfil);
		} else {
			manager.merge(perfil);
		}

		manager.getTransaction().commit();
	}
}

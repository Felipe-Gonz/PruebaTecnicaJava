package org.pruebatecnica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.pruebatecnica.entidades.Usuario;

public class UsuarioDAO {
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public UsuarioDAO() {
		emf = Persistence.createEntityManagerFactory("pruebaTecnica");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
	}
	
	public void eliminar(Integer id) {
		Usuario usuarioN = (Usuario) manager.find(Usuario.class, id);
		manager.remove(usuarioN);
		manager.getTransaction().commit();
	}
	
	public Usuario obtenerPorId(Integer id) {
		return manager.find(Usuario.class, id);
	}
	
	public List<Usuario> obtenerTodos() {
		List<Usuario> usuarios = (List<Usuario>) manager.createQuery("FROM Usuario").getResultList();
		return usuarios;
	}
	
	public void guardar(Usuario usuario) {
		if (usuario.getId() == null) {
			manager.persist(usuario);
		} else {
			manager.merge(usuario);
		}

		manager.getTransaction().commit();
	}

}

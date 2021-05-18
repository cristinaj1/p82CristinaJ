package controllers;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Trabajadores;

public class ControladorTrabajadores {
		private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("p82CristinaJ");
		private EntityManager em;
		private Query consulta;
		
		//Método el cual nos ayuda a borrar trabajadores
		public void borrarTrabajador(Trabajadores v) {
			this.em = entityManagerFactory.createEntityManager();
			Trabajadores aux = null;
			this.em.getTransaction().begin();
			if (!this.em.contains(v)) {
				aux = this.em.merge(v);
			}
			this.em.remove(aux);
			this.em.getTransaction().commit();
			this.em.close();
		}

		//Método el cual nos ayuda a modificar un trabajador
		public void modifyTrabajador(Trabajadores v) {
			this.em = entityManagerFactory.createEntityManager();
			this.em.getTransaction().begin();
			this.em.merge(v);
			this.em.getTransaction().commit();
			this.em.close();

		}
		
		//Método el cual nos ayuda a crear el trabajador
		public void createTrabajador(Trabajadores v) {
			this.em = entityManagerFactory.createEntityManager();
			this.em.getTransaction().begin();
			this.em.persist(v);
			this.em.getTransaction().commit();
			this.em.close();
		}

		//Método el cual nos ayuda a buscar según su primary key(pk) en este caso codtrabajador
		public Trabajadores findByPK(int codTrabajador) {
			this.em = entityManagerFactory.createEntityManager();
			Trabajadores aux = null;
			this.consulta = em.createNativeQuery("select * from trabajadores where codtrabajador = ?", Trabajadores.class);
			this.consulta.setParameter(1, codTrabajador);
			aux = (Trabajadores) consulta.getSingleResult();
			this.em.close();
			return aux;

		}
	
		//Método el cual nos ayuda a buscra por el nombre
		public Trabajadores findByNombre(String nombreEmpleado) {
			this.em = entityManagerFactory.createEntityManager();
			this.consulta = em.createNamedQuery("Trabajadores.findNombre");
			this.consulta.setParameter("nomEmpleado", nombreEmpleado);
			Trabajadores v = (Trabajadores) consulta.getSingleResult();
			this.em.close();
			return v;
		}

		//Método el cual nos muestra la lista completa
		public List<Trabajadores> findAll() {
			this.em = entityManagerFactory.createEntityManager();
			this.consulta = em.createNamedQuery("Trabajadores.findAll");
			List<Trabajadores> listaTrabajadores = (List<Trabajadores>) consulta.getResultList();
			this.em.close();
			return listaTrabajadores;
		}

		//Método el cual nos muestra a los trabajadores con el mismo dni(nos sirve para buscar errores de repetición)
		public List<Trabajadores> findByDni(String dni) {
			this.em = entityManagerFactory.createEntityManager();
			this.consulta = em.createNativeQuery("select * from trabajadores where codtrabajador=?", Trabajadores.class);
			this.consulta.setParameter(1, dni);
			List<Trabajadores> listaVehiculos = (List<Trabajadores>) consulta.getResultList();
			this.em.close();
			return listaVehiculos;
		}



}

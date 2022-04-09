package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		//-- registrar un nuevo usuario
		
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();

		// 3. empezar los procesos --> registro, actualizaci�n, eliminaci�n
		em.getTransaction().begin(); //empezar mi transacci�n -- el listado no requiere transaci�n
		
		//...acciones
		// inserto into....
		Usuario u = new Usuario(51, "Juan", "Perez", "jperez@mail.com", "1234", "2000/12/01", 1, 1);
		em.persist(u);
		
		//confirmacion de procesos
		em.getTransaction().commit();
		
		//cerrar mi manejador
		em.close();
		
	}

}

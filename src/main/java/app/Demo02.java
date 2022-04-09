package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	
	public static void main(String[] args) {
		//actualizar un usuario
		
		//fabrica de acceso los datos
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("mysql");
		
		//manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//empezar procesos
		em.getTransaction().begin();
		
		//acciones
		Usuario u = new Usuario(54, "cua", "cua", "cua@mail.com", "1234", "2001/12/01", 1, 1);
		em.merge(u);//si existe lo actualiza si no lo crea
		
		//commit
		em.getTransaction().commit();
		
		//close
		em.close();
	}
}

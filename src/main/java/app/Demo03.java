package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	public static void main(String[] args) {
		//eliminar un usuario
		
		EntityManagerFactory fabrica=new Persistence().createEntityManagerFactory("mysql");
		EntityManager em= fabrica.createEntityManager();
		em.getTransaction().begin();//empezar transacción
		
		//delete ..where
		Usuario u =new Usuario();
		u.setCodigo(53);
		
		em.remove(u);// se necesita pasar un objeto  --> buscar y devolver el objeto usuario
		
		em.getTransaction().commit();
		
		
	}

}

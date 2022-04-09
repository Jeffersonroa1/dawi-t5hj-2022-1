package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	
	public static void main(String[] args) {
		//obtener un objeto usuario según el codigo o id
		
		EntityManagerFactory fabrica=new Persistence().createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		//si son consultas no va el begin
		//em.getTransaction().begin();
		
		
		//acciones
		 Usuario u=em.find(Usuario.class, 53);//si existe el id devuelve dato
		 									  // si no devuelve null
		 if(u !=null) {
			 System.out.println(u);
		 }else {
			 System.out.println("No se encontró el usuario");
		 }

		
		//em.getTransaction().commit();
		em.close();
	}
}

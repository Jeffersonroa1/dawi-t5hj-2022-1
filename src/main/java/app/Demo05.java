package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import model.Usuario;

public class Demo05 {
	
	public static void main(String[] args) {
		//Eliminar un usuario si lo encuentra si no mostrar un mensaje "no se encontró usuario"
		
		EntityManagerFactory fabrica = new Persistence().createEntityManagerFactory("mysql");
		EntityManager em=fabrica.createEntityManager();
		
		//si es eliminación si tiene que estar el .begin();
		em.getTransaction().begin();
		
		Usuario u=em.find(Usuario.class, 54);
		if(u !=null) {
			System.out.print("El objeto que será borrado es: "+u);
			em.remove(u);
		}else {
			System.out.println("No se puede borrar porque no existe");
		}
		
		em.getTransaction().commit();
		//cerrar
		em.close();
	}
}

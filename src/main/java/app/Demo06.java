package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mysql.cj.PerConnectionLRUFactory;

import model.Usuario;

public class Demo06 {
	public static void main(String[] args) {
		//listado de los usuarios
		
		EntityManagerFactory fabrica=new Persistence().createEntityManagerFactory("mysql");
		EntityManager em=fabrica.createEntityManager();
		
		//acciones
		//select * from tb_usuarios
		TypedQuery<Usuario> consulta=em.createQuery("select x from Usuario x",Usuario.class);
		List<Usuario> lstUsuarios= consulta.getResultList();
		
		//Consulta y convertido a lista List<Usuario> lstUsuarios = em.createQuery("select x from Usuario x", Usuario.class).getResultList();
		
		for (Usuario u : lstUsuarios) {
			System.out.println(u);
		}
		
		em.close();
	}
}

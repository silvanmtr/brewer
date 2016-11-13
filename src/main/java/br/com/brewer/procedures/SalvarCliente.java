/**
 * 
 */
package br.com.brewer.procedures;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Silvan de Jesus
 *
 */
public class SalvarCliente {
	
	@PersistenceContext
	private static EntityManager manager;

	@PersistenceContext
	private EntityManagerFactory factory;


	/**
	 * @param args
	 */
	@Transactional(readOnly = true)

	public static void main(String[] args) {

		StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("salvarCliente");
		storedProcedure.registerStoredProcedureParameter("tipo_pessoa", String.class, ParameterMode.IN);
		storedProcedure.setParameter("tipo_pessoa", "FISICA");
		
		manager.getTransaction().begin();
		storedProcedure.execute();
		manager.getTransaction().commit();		
		
	}
	
	public static void chamaProcedure(){
		
		StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("salvarCliente");
		storedProcedure.registerStoredProcedureParameter("tipo_pessoa", String.class, ParameterMode.IN);
		storedProcedure.setParameter("tipo_pessoa", "FISICA");
		
		manager.getTransaction().begin();
		storedProcedure.execute();
		manager.getTransaction().commit();
	}
	

}

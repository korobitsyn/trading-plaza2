package trading.data;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Java persistence utitlity
 * @author pdg
 *
 */
public class JPAUtil {
	private final static EntityManager entityManager = createEntityManager();

	
	public static EntityManager createEntityManager(){
		EntityManager em = Persistence.createEntityManagerFactory("trading.data").createEntityManager();
		return em;
	}


	public static EntityManager getEntitymanager() {
		return entityManager;
	}
}

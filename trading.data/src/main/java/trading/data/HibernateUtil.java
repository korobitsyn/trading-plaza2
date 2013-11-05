package trading.data;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;

import trading.data.model.Instrument;
import trading.data.model.Level1;

/**
 * Hibernate session helper
 * @author pdg
 *
 */
public class HibernateUtil {
	 private static SessionFactory sessionFactory = buildSessionFactory();  
	 private static ServiceRegistry serviceRegistry;	
	 
	 private static SessionFactory buildSessionFactory() {
		 
		 Configuration configuration = new Configuration().configure()
				 .addAnnotatedClass(Instrument.class)
				 .addAnnotatedClass(Level1.class);

		    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    
		    return sessionFactory; 
		 }  
		  
		 public static SessionFactory getSessionFactory() {  
		  return sessionFactory;  
		 }  
		  
		 public static void shutdown() {  
		  getSessionFactory().close();  
		 }  
		  
		
}

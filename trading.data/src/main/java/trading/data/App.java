package trading.data;

//import javax.persistence.EntityManager;

import trading.data.model.Instrument;

import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
   
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	
    	Instrument i = (Instrument)session.get(Instrument.class, 1);
    	
    	//EntityManager em = JPAUtil.getEntitymanager();
    	//Instrument i = em.find(Instrument.class, 1);
    	String name = (i!=null)?i.getName():"";
        System.out.println( "Instrument:" + name );
    }
}

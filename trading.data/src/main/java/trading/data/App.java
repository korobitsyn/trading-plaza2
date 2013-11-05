package trading.data;

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
        System.out.println( "Hello World!" );
    }
}

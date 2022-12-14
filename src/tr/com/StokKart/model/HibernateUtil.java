package tr.com.StokKart.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure()
					.addAnnotatedClass(StokTip.class)
					.addAnnotatedClass(KdvTip.class)
					.addAnnotatedClass(StokKart.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("SessionFactory oluşturulamadı." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
 
	public static void shutdown() {
		getSessionFactory().close();
	}
	
}

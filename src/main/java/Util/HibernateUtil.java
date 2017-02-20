package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {

    public static SessionFactory sessionFactory;
    public static ServiceRegistry serviceRegistry;

    public HibernateUtil(){}

    static{
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings( configuration.getProperties()). buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Throwable e ){
            throw new ExceptionInInitializerError(e);
        }


    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

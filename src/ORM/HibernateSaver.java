package ORM;

import Model.HBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateSaver {
    public void save(List<HBook> books) {
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(HBook.class).configure("resources\\hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (HBook book : books) {
            session.save(book);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

import model.Item;
import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HibernateApplication {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Item item = session.get(Item.class, 1);
            System.out.println(item.getOwner());

            /*
            Person person = session.get(Person.class, 7);
            System.out.println(person);

            for (Item i: person.getItems()) {
                System.out.println(i.toString());
            }

             */





            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}

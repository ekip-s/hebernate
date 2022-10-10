import model.Item;
import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HibernateApplication {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Person person = new Person(30, "Mike");
            Item item = new Item("флюгегехаймен", person);
            person.setItems(new ArrayList<>(Collections.singletonList(item)));
            session.save(person);


            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}

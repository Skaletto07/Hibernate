import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kostkin.demospringv3.entity.Employee;

import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            /*Employee employee = session.get(Employee.class, 3);
            session.delete(employee);*/
            session.createQuery("delete Employee where name = 'Oleg'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
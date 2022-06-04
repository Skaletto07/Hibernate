import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kostkin.demospringv3.entity.Employee;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            /*Employee employee = session.get(Employee.class, 4);
            employee.setName("Aleksandra");
            employee.setSurname("Potapova");*/

            session.createQuery("update Employee set salary = 1000 where name = 'Anna'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}

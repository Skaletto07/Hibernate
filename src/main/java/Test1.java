import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kostkin.demospringv3.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Anna", "Ivanova", "HR", 250);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}

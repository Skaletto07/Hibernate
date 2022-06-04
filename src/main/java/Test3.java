import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kostkin.demospringv3.entity.Employee;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> employeeList = session.createQuery("from Employee").getResultList();

//            session.createQuery("delete Employee where name = Anna");
            List<Employee> employeeList = session.createQuery("from Employee where name = 'Anna' AND salary > 250").getResultList();

            for (Employee employee : employeeList) {
                System.out.println(employee);
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}

package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        /*try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Dima", "Pupkin", "IT", 456);
            Detail detail = new Detail("Moscow", "+79996463424", "Dima@email.ru");
            employee.setEmpDetail(detail);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }*/

        /*try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Turin", "Sales", 325);
            Detail detail = new Detail("Kiev", "+79991233210", "TurinO@email.ru");
            employee.setEmpDetail(detail);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }*/

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);
            session.getTransaction().commit();

        } finally {

            factory.close();
        }
    }
}

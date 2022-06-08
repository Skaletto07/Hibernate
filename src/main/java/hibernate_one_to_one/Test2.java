package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        /*try {
            session = factory.getCurrentSession();
            Employee employee = new Employee("Tolya", "Ivanov", "HR", 380);
            Detail detail = new Detail("Berlin", "+988565897", "IvanovT@gmail.com");
            detail.setEmployee(employee);
            employee.setEmpDetail(detail);
            session.beginTransaction();

            session.save(detail);

            session.getTransaction().commit();

        } finally {

            factory.close();
        }*/

        /*try {
            session = factory.getCurrentSession();


            session.beginTransaction();

            Detail detail = session.get(Detail.class, 4);
            System.out.println(detail.getEmployee());

            session.getTransaction().commit();

        } finally {

            factory.close();
        }*/

        try {
            session = factory.getCurrentSession();


            session.beginTransaction();

            Detail detail = session.get(Detail.class, 4);
            session.delete(detail);

            session.getTransaction().commit();

        } finally {

            factory.close();
        }

    }
}

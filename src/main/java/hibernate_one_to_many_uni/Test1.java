package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;

        /*try {
            session = factory.getCurrentSession();

            Department department = new Department("HR", 250, 1000);
            Employee employee = new Employee("Elena", "Katina", 700);
            Employee employee1 = new Employee("Nina", "Rasova", 600);

            department.addEmployeeToDepartment(employee);
            department.addEmployeeToDepartment(employee1);


            session.beginTransaction();

            session.save(department);
            System.out.println(department);


            session.getTransaction().commit();

        } finally {
            factory.close();
        }*/

        /*try {
            session = factory.getCurrentSession();


            session.beginTransaction();
            Department department = session.get(Department.class, 1);
            System.out.println(department);
            System.out.println(department.getEmployees());


            session.getTransaction().commit();

        } finally {
            factory.close();
        }*/

        try {
            session = factory.getCurrentSession();



            session.beginTransaction();
            Department department = session.get(Department.class, 2);

            session.delete(department);
            session.getTransaction().commit();
        } finally {

        }


    }
}

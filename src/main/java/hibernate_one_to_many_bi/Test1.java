package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
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

            Department department = new Department("Sales", 250, 1000);
            Employee employee = new Employee("Misha", "Pushkin", 400);
            Employee employee1 = new Employee("Vanya", "Kukushkin", 450);
            Employee employee2 = new Employee("Katya", "Kulian", 800);
            department.addEmployeeToDepartment(employee);
            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);



            session.beginTransaction();

            session.save(department);
            System.out.println(department);


            session.getTransaction().commit();

        } finally {
            factory.close();
        }*/

        try {
            session = factory.getCurrentSession();



            session.beginTransaction();

            System.out.println("Get dep");
            Department department = session.get(Department.class, 4);
            System.out.println("Show dep");
            System.out.println(department);

            department.getEmployees().get(0);

            session.getTransaction().commit();

            System.out.println("Show emp");
            System.out.println(department.getEmployees());

        } finally {
            session.close();
            factory.close();
        }

        /*try {
            session = factory.getCurrentSession();



            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }*/

        /*try {
            session = factory.getCurrentSession();



            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }*/
    }
}

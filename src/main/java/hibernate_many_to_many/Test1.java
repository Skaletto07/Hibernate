package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kostkin.demospringv3.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;

       /* try {
            session = factory.getCurrentSession();

            Section section1 = new Section("Football");
            Child child1 = new Child("Pasha", 5);
            Child child2 = new Child("Dima", 7);
            Child child3 = new Child("Kolya", 6);

            section1.addChild(child1);
            section1.addChild(child2);
            section1.addChild(child3);

            session.beginTransaction();

            session.save(section1);


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }*/


        /*try {
            session = factory.getCurrentSession();

            Child child1 = new Child("Olya", 10);

            Section section1 = new Section("Volleyball");
            Section section2 = new Section("Chess");
            Section section3 = new Section("Math");

            child1.addSections(section1);
            child1.addSections(section2);
            child1.addSections(section3);

            session.beginTransaction();

            session.save(child1);


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }*/


        /*try {
            session = factory.getCurrentSession();



            session.beginTransaction();

            Section section = session.get(Section.class, 1);

            System.out.println(section);
            System.out.println(section.getChildren());


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }*/


        /*try {
            session = factory.getCurrentSession();



            session.beginTransaction();

            Child child = session.get(Child.class, 4);

            System.out.println(child);
            System.out.println(child.getSections());


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }*/

        try {
            session = factory.getCurrentSession();



            session.beginTransaction();

            Child child = session.get(Child.class, 1);
            session.delete(child);


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }


    }
}

import crudapp.model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeveloperRunner {
    public static SessionFactory sessionFactory;
//    public static void main(String[] args) {
//        sessionFactory = new Configuration().configure().buildSessionFactory();
//
//        DeveloperRunner developerRunner = new DeveloperRunner();
//
//        System.out.println("Adding developer's records to the DB");
//        /**
//         *  Adding developer's records to the database (DB)
//         */
//        developerRunner.addDeveloper("Proselyte", "Developer");
//        developerRunner.addDeveloper("Some", "Developer");
//        developerRunner.addDeveloper("Peter", "UI");
//
//        System.out.println("List of developers");
//        /**
//         *
//         * List developers
//         */
//        List developers = developerRunner.listDevelopers();
//        for (Object developer : developers) {
//            System.out.println(developer);
//        }
//        System.out.println("===================================");
//        System.out.println("Removing Some Developer and updating Proselyte");
//        /**
//         * Update and Remove developers
//         */
//        developerRunner.updateDeveloper(10, 3);
//        developerRunner.removeDeveloper(1);
//
//        System.out.println("Final list of developers");
//        /**
//         * List developers
//         */
//        developers = developerRunner.listDevelopers();
//        for (Object developer : developers) {
//            System.out.println(developer);
//        }
//        System.out.println("===================================");
//
//    }

    public void addDeveloper(String firstName, String lastName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

    }

    public List listDevelopers() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List developers = session.createQuery("FROM Developer").list();

        transaction.commit();
        session.close();
        return developers;
    }

    public void updateDeveloper(int developerId, int experience) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Developer developer = (Developer) session.get(Developer.class, developerId);
        session.update(developer);
        transaction.commit();
        session.close();
    }

    public void removeDeveloper(int developerId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Developer developer = (Developer) session.get(Developer.class, developerId);
        session.delete(developer);
        transaction.commit();
        session.close();
    }

}

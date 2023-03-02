package crudapp.repository.base;

import crudapp.model.Developer;
import crudapp.model.Skill;
import crudapp.model.Specialty;
import crudapp.model.Status;
import crudapp.repository.GenericRepository;
import crudapp.util.ConnectSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeveloperHibernateIml implements GenericRepository<Developer,Integer> {
    private static SessionFactory sessionFactory;

    @Override
    public Developer getById(Integer integer) {
        Developer developer = null;
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            developer = (Developer) session.load(Developer.class, integer);
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        }finally {
            return developer;
        }
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> developers = new ArrayList();
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            developers = session.createQuery("From Developer").list();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return developers;
        }
    }

    @Override
    public Developer save(Developer developer) {
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            session.beginTransaction();
            session.save(developer);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return developer;
        }
    }

    @Override
    public Developer update(Developer developer) {
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            session.beginTransaction();
            session.update(developer);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return developer;
        }
    }

    @Override
    public void deleteById(Integer integer) {
        Developer developer;
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            developer =(Developer) session.get(Developer.class, integer);
            session.beginTransaction();
            developer.setStatus(Status.DELETED);
            session.update(developer);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}

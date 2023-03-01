package crudapp.repository.base;

import crudapp.util.ConnectSession;
import crudapp.model.Skill;
import crudapp.model.Status;
import crudapp.repository.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SkillHibernateIml implements GenericRepository<Skill, Integer> {
    SessionFactory sessionFactory;

    @Override
    public Skill getById(Integer integer) {
        Skill skill = null;
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            skill = (Skill) session.load(Skill.class, integer);
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        }finally {
            return skill;
        }
    }



    @Override
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList();
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            skills = session.createQuery("From Skill").list();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return skills;
        }
    }

    @Override
    public Skill save(Skill skill) {
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            session.save(skill);
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return skill;
        }
    }

    @Override
    public Skill update(Skill skill) {
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            session.beginTransaction();
            session.update(skill);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return skill;
        }
    }

    @Override
    public void deleteById(Integer integer) {
        Skill skill;
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            skill =(Skill) session.get(Skill.class, integer);
            session.beginTransaction();
            skill.setStatus(Status.DELETED);
            session.update(skill);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SkillHibernateIml skillHibernateIml = new SkillHibernateIml();


//        Skill skill = new Skill();
//        skill.setName("Scala");
//        skill.setStatus(Status.DELETED);
//        skillHibernateIml.save(skill);
//        skillHibernateIml.deleteById(1);
        List<Skill> skills = skillHibernateIml.getAll();
        for (Object j : skills){
            System.out.println(j);
        }
    }
}
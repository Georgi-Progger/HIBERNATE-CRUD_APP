package crudapp.repository.base;

import crudapp.model.Developer;
import crudapp.repository.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperHibernateIml implements GenericRepository<Developer,Integer> {
    private static SessionFactory sessionFactory;

    @Override
    public Developer getById(Integer integer) {
        Session session = sessionFactory.openSession();
return null;
    }

    @Override
    public List<Developer> getAll() {
        return null;
    }

    @Override
    public Developer save(Developer developer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

return null;
    }

    @Override
    public Developer update(Developer developer) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}

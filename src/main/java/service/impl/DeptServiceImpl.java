package service.impl;

import dao.IDeptDao;
import dao.impl.DeptImpl;
import domain.Dept;
import org.hibernate.Session;
import service.IDeptService;
import util.HibernateUtils;

import java.util.List;


public class DeptServiceImpl implements IDeptService {
    private IDeptDao dao = new DeptImpl();

    private Session getSession() {
        return HibernateUtils.INSTANCE.getSession();
    }

    public void save(Dept dept) {
        Session session = getSession();
        session.beginTransaction();
        dao.save(dept);
        session.getTransaction().commit();
    }

    public void delete(Long id) {
        HibernateUtils.INSTANCE.getSession().getTransaction().begin();
        dao.delete(id);
        HibernateUtils.INSTANCE.getSession().getTransaction().commit();

    }

    public void update(Dept dept) {
        HibernateUtils.INSTANCE.getSession().getTransaction().begin();
        dao.save(dept);
        HibernateUtils.INSTANCE.getSession().getTransaction().commit();

    }

    public Dept get(Long id) {
        return dao.get(id);
    }

    public List<Dept> getAll() {
        return dao.getAll();
    }

}

package service.impl;

import dao.IEmpDao;
import dao.impl.EmpImpl;
import domain.Emp;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IEmpService;
import util.HibernateUtils;

import java.util.List;


public class EmpServiceImpl implements IEmpService {
    private IEmpDao dao = new EmpImpl();

    private Session getSession() {
        return HibernateUtils.INSTANCE.getSession();
    }

    public void save(Emp emp) {
        Session session = getSession();
        session.beginTransaction();
        dao.save(emp);
        session.getTransaction().commit();

    }

    public void delete(Long id) {
        getSession().beginTransaction();
        dao.delete(id);
        getSession().getTransaction().commit();

    }

    public void update(Emp emp) {
        getSession().beginTransaction();
        dao.update(emp);
        getSession().getTransaction().commit();

    }

    public Emp get(Long id) {
        Emp emp = dao.get(id);
        return emp;
    }

    public List<Emp> getAll() {
        return dao.getAll();
    }

}

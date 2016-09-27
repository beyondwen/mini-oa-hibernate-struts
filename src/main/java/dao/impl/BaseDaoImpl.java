package dao.impl;

import dao.IBaseDao;
import util.HibernateUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class BaseDaoImpl<T> implements IBaseDao<T> {

    private Class<T> entiyClass;

    public BaseDaoImpl(Class<T> entiyClass) {
        this.entiyClass = entiyClass;
    }

    public void save(T t) {
        HibernateUtils.INSTANCE.getSession().save(t);
    }

    public void delete(Long id) {
        T t = get(id);
        if (t != null) {
            HibernateUtils.INSTANCE.getSession().delete(t);
        }

    }

    public void update(T t) {
        HibernateUtils.INSTANCE.getSession().update(t);
    }

    public T get(Long id) {
        return HibernateUtils.INSTANCE.getSession().get(entiyClass, id);
    }

    public List<T> getAll() {
        return HibernateUtils.INSTANCE.getSession().createQuery(" from " + entiyClass.getName()).list();
    }
}

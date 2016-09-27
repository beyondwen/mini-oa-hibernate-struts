package dao.impl;

import dao.IDeptDao;
import dao.IEmpDao;
import domain.Dept;
import domain.Emp;

/**
 * Created by lenovo on 2016/09/27.
 */
public class DeptImpl extends BaseDaoImpl<Dept> implements IDeptDao {
    public DeptImpl() {
        super(Dept.class);
    }
}

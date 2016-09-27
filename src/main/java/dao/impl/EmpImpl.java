package dao.impl;

import dao.IBaseDao;
import dao.IEmpDao;
import domain.Emp;

import java.util.List;

/**
 * Created by lenovo on 2016/09/27.
 */
public class EmpImpl extends BaseDaoImpl<Emp> implements IEmpDao {
    public EmpImpl() {
        super(Emp.class);
    }
}

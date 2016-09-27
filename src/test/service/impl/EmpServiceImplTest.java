package service.impl;

import domain.Dept;
import domain.Emp;
import org.junit.Test;
import service.IDeptService;
import service.IEmpService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by lenovo on 2016/09/27.
 */
public class EmpServiceImplTest {
    private IEmpService empDao = new EmpServiceImpl();
    private IDeptService deptDao = new DeptServiceImpl();

    @Test
    public void save1() throws Exception {
        for (int i = 1; i < 11; i++) {
            Emp emp = new Emp();
            emp.setName("张" + i + "丰");
            emp.setPassword("admin");
            emp.setEmail("zhangsanfeng@itsource.com");
            emp.setSalary(new BigDecimal(12345.0));
            emp.setHireDate(new Date());
            emp.setLoves("编程, 看电影, 黑5");
            empDao.save(emp);
        }
    }


    @Test
    public void save() {

        for (int i = 1; i < 5; i++) {
            Dept dept = new Dept();
            dept.setDname("部门" + i);
            dept.setPhone("1000" + i);
            deptDao.save(dept);
        }

        List<Dept> depts = deptDao.getAll();
        Random random = new Random();

        for (int i = 1; i < 11; i++) {
            Emp emp = new Emp();
            emp.setName("张" + i + "丰");
            emp.setPassword("admin");
            emp.setEmail("zhangsanfeng@itsource.com");
            emp.setSalary(new BigDecimal(12345.0));
            emp.setHireDate(new Date());
            emp.setLoves("编程, 看电影, 黑5");

            // 随机选择部门
            int deptIndex = random.nextInt(depts.size());// 0,1,2,3
            emp.setDept(depts.get(deptIndex));
            empDao.save(emp);
        }

    }

    @Test
    public void testDelete() {
        empDao.delete(1L);
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(2L);
        emp.setName("张7丰");
        emp.setPassword("12086");
        emp.setEmail("zhangsan@163.com");
        emp.setSalary(new BigDecimal(54321.0));
        emp.setHireDate(new Date());
        empDao.update(emp);
    }

    @Test
    public void testGet() {
        Emp emp = empDao.get(3L);
        System.out.println(emp);
    }

    @Test
    public void testList() {
        List<Emp> list = empDao.getAll();
        for (Emp employee : list) {
            System.out.println(employee);
        }

    }

}
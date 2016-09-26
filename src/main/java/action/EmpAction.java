package action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import domain.Dept;
import domain.Emp;
import org.apache.commons.lang3.StringUtils;
import service.IDeptService;
import service.IEmpService;
import service.impl.DeptServiceImpl;
import service.impl.EmpServiceImpl;

import java.util.List;

public class EmpAction extends ActionSupport {
	public static final String RELOAD = "reload";

	private IEmpService empDao = new EmpServiceImpl();
	private IDeptService deptDao = new DeptServiceImpl();
	// 当前操作的类是Emp，对应的集合就放栈顶,jsp要访问只需要getter方法
	private List<Emp> emps;
	// 定义操作emp的成员变量,定义getter,setter方法
	private Emp emp;

	// 列表
	@Override
	public String execute() throws Exception {
		emps = empDao.getAll();
		return SUCCESS;
	}

	// 显示新增和编辑页面
	@Override
	public String input() throws Exception {
		if (emp != null && emp.getId() != null) {
			emp = empDao.get(emp.getId());// 回显数据
		}
		// 把其他模型的集合列表放入Map栈
		ActionContext.getContext().put("allDepts", deptDao.getAll());
		return INPUT;
	}

	public void validateSave() {
		if (StringUtils.isBlank(emp.getName())) {
			addFieldError("emp.name", "用户名不能为空");
		}
	}

	// 如果出现转换错误，或者验证错误，都调转到input方法
	@InputConfig(methodName = "input")
	public String save() throws Exception {
		try {
			if (emp != null) {
				Dept dept = emp.getDept();
				if (dept != null && dept.getDid() != null
						&& dept.getDid() == -1L) {
					// 选择了没有部门
					emp.setDept(null);
				}

				if (emp.getId() == null) {
					empDao.save(emp);
				} else {
					empDao.update(emp);
				}
			}
			// int i = 1 / 0;
		} catch (Exception e) {
			addActionError("保存出现异常:" + e.getMessage());
			return input();// 返回input方法,不是视图
		}
		// 消息提示
		addActionMessage("保存成功");
		return RELOAD;
	}

	public String delete() throws Exception {
		if (emp != null && emp.getId() != null) {
			empDao.delete(emp.getId());
		}
		addActionMessage("删除成功");
		return RELOAD;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}

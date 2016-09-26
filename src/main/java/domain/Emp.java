package domain;

import java.math.BigDecimal;
import java.util.Date;

public class Emp {
	private Long id;
	private String name;
	private String password;
	private String loves;
	private String email;
	private BigDecimal salary;
	private Date hireDate;
	private Dept dept;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoves() {
		return loves;
	}

	public void setLoves(String loves) {
		this.loves = loves;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", password=" + password
				+ ", loves=" + loves + ", email=" + email + ", salary="
				+ salary + ", hireDate=" + hireDate + ", dept=" + dept + "]";
	}
	
	

}

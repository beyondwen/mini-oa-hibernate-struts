package service;



import domain.Emp;

import java.util.List;

public interface IEmpService {
	void save(Emp emp);

	void delete(Long id);

	void update(Emp emp);

	Emp get(Long id);

	List<Emp> getAll();
}

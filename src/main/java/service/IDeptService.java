package service;



import domain.Dept;

import java.util.List;

public interface IDeptService {
	void save(Dept dept);

	void delete(Long id);

	void update(Dept dept);

	Dept get(Long id);

	List<Dept> getAll();
}

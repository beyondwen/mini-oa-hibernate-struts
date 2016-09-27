package dao;

import java.util.List;

/**
 * 公共dao对象
 */
public interface IBaseDao<T> {

    void save(T t);

    void delete(Long id);

    void update(T t);

    T get(Long id);

    List<T> getAll();

}

package dao;

/**
 * 公共dao对象
 */
public interface IBaseDao<T> {

    void save(T t);

    void delete(Long id);

    void update(T t);

    void get(Long id);

    void getAll();

}

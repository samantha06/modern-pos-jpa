package lk.ijse.pos.dao;

import lk.ijse.pos.entity.SuperEntity;

import java.util.List;

public interface CrudDAO<T extends SuperEntity, ID> extends SuperDAO {

    boolean save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(ID entityId) throws Exception;

    List<T> findAll() throws Exception;

    T find(ID entityId) throws Exception;

}
